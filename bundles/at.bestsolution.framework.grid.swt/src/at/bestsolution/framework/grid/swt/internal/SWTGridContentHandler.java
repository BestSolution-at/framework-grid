/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,
 * http://www.BestSolution.at
 *
 * This file is part of framework-grid which was developed with funding
 * from DI Christoph Hermann - InformationsTechnologie Beratung Hermann
 * /Austria.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package at.bestsolution.framework.grid.swt.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;

import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.Property.ChangeListener;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.XGridContentProvider;
import at.bestsolution.framework.grid.XGridContentProvider.ContentChangeListener;
import at.bestsolution.framework.grid.XGridContentProvider.ContentChangeType;
import at.bestsolution.framework.grid.XSelection;
import at.bestsolution.framework.grid.swt.SWTGridColumn;
import at.bestsolution.framework.grid.swt.SWTGridTable;

/**
 * @param <R>
 *            content type
 */
public class SWTGridContentHandler<R> {
	private final List<@NonNull Wrapper<R>> data = new ArrayList<@NonNull Wrapper<R>>();
	private final Map<@NonNull Integer, @Nullable GridItem> dataMapByR = new HashMap<>();
	private final Map<@NonNull GridItem, @NonNull Wrapper<R>> dataMapByCol = new HashMap<>();

	private final @NonNull SWTGridTable<R> grid;

	private final @NonNull Property<@Nullable Comparator<@NonNull R>> defaultSortProperty = new SimpleProperty<>(null);
	private final @NonNull Property<@Nullable SWTGridColumn<R, ?>> sortColumnProperty = new SimpleProperty<>(null);

	private @Nullable XGridContentProvider<R> contentProvider;
	private final @NonNull ChangeListener<@Nullable Comparator<@NonNull R>> defaultSortChangeListener = this::handleDefaultSortChanged;
	private final @NonNull ChangeListener<@Nullable SWTGridColumn<R, ?>> sortColumnChangeListener = this::handleSortColumnChanged;
	private final @NonNull ContentChangeListener<R> contentChangeListener = this::handleContentChange;
	private final @NonNull ChangeListener<@Nullable XGridContentProvider<R>> contentProviderChangeListener = this::handleContentProviderChanged;

	/**
	 * @param grid
	 *            grid
	 */
	public SWTGridContentHandler(@NonNull SWTGridTable<R> grid) {
		this.grid = grid;
		registerPropertyListeners();
	}

	/**
	 * 
	 */
	private void registerPropertyListeners() {
		defaultSortProperty.addChangeListener(defaultSortChangeListener);
		sortColumnProperty.addChangeListener(sortColumnChangeListener);
		grid.contentProviderProperty().addChangeListener(contentProviderChangeListener);
	}

	private void handleDefaultSortChanged(Property<@Nullable Comparator<@NonNull R>> property, @Nullable Comparator<@NonNull R> oldValue,
			@Nullable Comparator<@NonNull R> newValue) {
		resetContent(contentProvider);
	}

	private void handleSortColumnChanged(Property<@Nullable SWTGridColumn<R, ?>> property, @Nullable SWTGridColumn<R, ?> oldValue,
			@Nullable SWTGridColumn<R, ?> newValue) {
		resetContent(contentProvider);
	}

	private void handleContentProviderChanged(Property<@Nullable XGridContentProvider<R>> property,
			@Nullable XGridContentProvider<R> oldValue, @Nullable XGridContentProvider<R> newValue) {
		resetContent(newValue);
	}

	/**
	 * reset content
	 */
	public void resetContent() {
		resetContent(contentProvider);
	}

	/**
	 * 
	 * @param newContentProvider
	 *            the new content provider
	 */
	private void resetContent(@Nullable XGridContentProvider<R> newContentProvider) {
		if (contentProvider != newContentProvider) {
			@Nullable
			XGridContentProvider<R> oldContentProvider = contentProvider;
			if (oldContentProvider != null) {
				oldContentProvider.removeChangeListener(contentChangeListener);
			}
			contentProvider = newContentProvider;
			if (newContentProvider != null) {
				newContentProvider.addChangeListener(contentChangeListener);
			}
		}
		XSelection<@NonNull R> previousSelection = grid.selectionProperty().get();
		clearData();
		grid.getNebulaGrid().disposeAllItems();
		if (newContentProvider != null) {
			insertData(newContentProvider);
			createGridItems();
			for (R element : previousSelection.asList()) {
				List<GridItem> gridItems = new ArrayList<GridItem>();
				GridItem griditem = get(element);
				if (griditem != null) {
					gridItems.add(griditem);
				}
				// restore selection
				grid.getNebulaGrid().setSelection(gridItems.toArray(new GridItem[gridItems.size()]));
			}
		}
	}

	private Comparator<@NonNull Wrapper<R>> getComparator() {
		@Nullable
		SWTGridColumn<R, ?> column = sortColumnProperty.get();
		Comparator<@NonNull R> comp = null;
		if (column != null) {
			switch (column.sortingProperty().get()) {
			case UP:
				comp = column.sorterProperty().get();
				break;
			case DOWN:
				@Nullable
				Comparator<@NonNull R> originComparator = column.sorterProperty().get();
				if (originComparator != null) {
					comp = originComparator.reversed();
				}
				break;
			default:
				comp = defaultSortProperty.get();
			}

		} else if (defaultSortProperty.get() != null) {
			comp = defaultSortProperty.get();
		}
		if (comp != null) {
			final Comparator<@NonNull R> rComparator = comp;
			return (o1, o2) -> rComparator.compare(o1.get(), o2.get());
		}
		return null;
	}

	private void insertData(XGridContentProvider<R> newContentProvider) {
		for (int i = 0; i < newContentProvider.size(); i++) {
			data.add(new Wrapper<R>(newContentProvider.getElementAt(i)));
		}
		Comparator<@NonNull Wrapper<R>> comparator = getComparator();
		if (comparator != null) {
			data.sort(comparator);
		}
	}

	private void clearData() {
		data.clear();
		dataMapByR.clear();
		dataMapByCol.clear();
	}

	private void handleContentChange(@NonNull ContentChangeType type, @NonNull List<@NonNull R> values) {
		switch (type) {
		case ADD:
		case REMOVE:
			resetContent(contentProvider);
			break;
		default:
			break;
		}
	}

	/**
	 * create a {@link GridItem} for each row where no {@link GridItem} exist an
	 * which is not excluded by current filter settings
	 */
	private void createGridItems() {
		grid.getNebulaGrid().setRedraw(false);
		try {
			for (@NonNull
			Wrapper<R> element : data) {
				if (dataMapByR.get(element) == null) {
					boolean visible = true;
					for (@NonNull
					XGridColumn<@NonNull R, @Nullable ?> xcol : grid.getColumns()) {
						SWTGridColumn<R, ?> col = (SWTGridColumn<R, ?>) xcol;
						visible = col.matchesColumnFilter(element.get());
						if (!visible) {
							break;
						}
					}
					if (visible) {
						final GridItem item = new GridItem(grid.getNebulaGrid(), SWT.NONE);
						dataMapByR.put(new Integer(element.hashCode()), item);
						dataMapByCol.put(item, element);
						for (XGridColumn<@NonNull R, @Nullable ?> col : grid.getColumns()) {
							col.requestUpdate(element.get());
						}
					}
				}
			}
		} finally {
			grid.getNebulaGrid().setRedraw(true);
		}
	}

	/**
	 * @param item
	 *            grid item
	 * @return corresponding row value
	 */
	public R get(@NonNull GridItem item) {
		return dataMapByCol.get(item).get();
	}

	/**
	 * @param r
	 *            row value
	 * @return corresponding GridItem
	 */
	public @Nullable GridItem get(@NonNull R r) {
		return dataMapByR.get(new Integer(new Wrapper<>(r).hashCode()));
	}

	/**
	 * @return the defaultSortProperty
	 */
	public @NonNull Property<@Nullable Comparator<@NonNull R>> defaultSortProperty() {
		return defaultSortProperty;
	}

	/**
	 * @return the sortProperty
	 */
	public Property<@Nullable SWTGridColumn<R, ?>> sortColumnProperty() {
		return sortColumnProperty;
	}

	/**
	 * @return list of visible elements
	 */
	@SuppressWarnings("null")
	public @NonNull List<@NonNull R> getVisibleElements() {
		return dataMapByCol.values().stream().map((x) -> x.get()).collect(Collectors.<@NonNull R> toList());
	}

	/**
	 * @param allRows
	 *            export all elements if <code>true</code>, otherwise exclude
	 *            filtered items
	 * @return export data
	 */
	@SuppressWarnings("null")
	public @NonNull Object[][] getData(boolean allRows) {
		if (allRows) {
			return getData(data);
		} else {
			List<@NonNull Wrapper<R>> unFilteredElements = new ArrayList<>();
			for (Wrapper<R> w : data) {
				if (get(w.get()) != null) {
					unFilteredElements.add(w);
				}
			}
			return getData(unFilteredElements);
		}
	}

	private Object[][] getData(List<@NonNull Wrapper<R>> rows) {
		Object[][] exportData = new Object[dataMapByR.size()][grid.getColumns().size()];
		int rowIndex = 0;
		for (Wrapper<R> element : rows) {
			int colIndex = 0;
			for (XGridColumn<R, ?> column : grid.getColumns()) {
				exportData[rowIndex][colIndex] = column.getExportValue(element.get());
				colIndex++;
			}
			rowIndex++;
		}
		return exportData;
	}

	/**
	 * dispose content handler.
	 * <p>
	 * remove listeners & do necessary cleanup
	 * </p>
	 */
	public void dispose() {
		defaultSortProperty.removeChangeListener(defaultSortChangeListener);
		sortColumnProperty.removeChangeListener(sortColumnChangeListener);
		@Nullable
		XGridContentProvider<R> cp = contentProvider;
		if (cp != null) {
			cp.removeChangeListener(contentChangeListener);
		}
		grid.contentProviderProperty().removeChangeListener(contentProviderChangeListener);
	}

	/**
	 * 
	 * @author martin
	 *
	 * @param <O>
	 */
	private static class Wrapper<@NonNull O> {
		private final @NonNull O object;

		public Wrapper(@NonNull O object) {
			this.object = object;
		}

		public O get() {
			return object;
		}

		@Override
		public int hashCode() {
			return object.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			return object.equals(obj);
		}
	}
}
