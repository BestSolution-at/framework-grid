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
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;

import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.XGrid.Selection;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.XGridContentProvider;
import at.bestsolution.framework.grid.XGridContentProvider.ContentChangeType;
import at.bestsolution.framework.grid.swt.SWTGridColumn;
import at.bestsolution.framework.grid.swt.SWTGridTable;

/**
 * @param <R>
 *            content type
 */
public class SWTGridContentHandler<R> {
	private final Map<@NonNull R, @Nullable GridItem> dataByR = new IdentityHashMap<>();
	private final Map<@NonNull GridItem, @NonNull R> dataByCol = new IdentityHashMap<>();
	private final @NonNull Grid nebulaGrid;
	private final @NonNull SWTGridTable<R> grid;
	private final @NonNull Property<@Nullable Comparator<@NonNull R>> defaultSortProperty = new SimpleProperty<>(null);
	private final @NonNull Property<@Nullable SWTGridColumn<R, ?>> sortColumnProperty = new SimpleProperty<>(null);
	private @Nullable XGridContentProvider<R> contentProvider;

	/**
	 * @param grid
	 *            grid
	 * @param nebulaGrid
	 */
	public SWTGridContentHandler(@NonNull SWTGridTable<R> grid, @NonNull Grid nebulaGrid) {
		this.grid = grid;
		this.nebulaGrid = nebulaGrid;

		registerPropertyListeners();
	}

	/**
	 * 
	 */
	private void registerPropertyListeners() {
		defaultSortProperty.addChangeListener((property, oldValue, newValue) -> resetContent(contentProvider, contentProvider));
		sortColumnProperty.addChangeListener((property, oldValue, newValue) -> resetContent(contentProvider, contentProvider));
		grid.contentProviderProperty().addChangeListener((property, oldValue, newValue) -> resetContent(oldValue, newValue));
	}

	/**
	 * 
	 * @param newContentProvider
	 *            the new content provider
	 */
	private synchronized void resetContent(@Nullable XGridContentProvider<R> oldContentProvider,
			@Nullable XGridContentProvider<R> newContentProvider) {
		// cleanup
		if (oldContentProvider != null) {
			oldContentProvider.addChangeListener(this::handleContentChange);
		}
		contentProvider = newContentProvider;

		Selection<@Nullable R, @Nullable R> previousSelection = grid.selectionProperty().get();
		dataByR.clear();
		dataByCol.clear();
		nebulaGrid.disposeAllItems();
		List<@NonNull R> items = new ArrayList<>();

		if (newContentProvider != null) {
			newContentProvider.addChangeListener(this::handleContentChange);
			for (int i = 0; i < newContentProvider.size(); i++) {
				items.add(newContentProvider.getElementAt(i));
			}
		}
		@Nullable
		SWTGridColumn<R, ?> column = sortColumnProperty.get();
		if (column != null) {
			switch (column.sortingProperty().get()) {
			case UP:
				Collections.sort(items, column.sorterProperty().get());
				break;
			case DOWN:
				@Nullable
				Comparator<@NonNull R> originComparator = column.sorterProperty().get();
				if (originComparator != null) {
					Collections.sort(items, originComparator.reversed());
				}
				break;
			default:
			}

		} else if (defaultSortProperty.get() != null) {
			Collections.sort(items, defaultSortProperty.get());
		}
		insertItems(items);
		// TODO this may lack in performance
		filter();
		// restore selection
		grid.selectionProperty().set(previousSelection);
	}

	private void handleContentChange(@NonNull ContentChangeType type, @NonNull List<@NonNull R> values) {
		switch (type) {
		case ADD:
			insertItems(values);
			break;
		case REMOVE:
			removeItems(values);
			break;
		default:
			break;
		}
	}

	private void insertItems(@NonNull List<@NonNull R> items) {
		grid.getNebulaGrid().setRedraw(false);
		try {
			for (@NonNull
			R element : items) {
				final GridItem item = new GridItem(nebulaGrid, SWT.NONE);
				dataByR.put(element, item);
				dataByCol.put(item, element);
				for (XGridColumn<@NonNull R, @Nullable ?> col : grid.getColumns()) {
					col.requestUpdate(element);
				}
			}
		} finally {
			grid.getNebulaGrid().setRedraw(true);
		}
	}

	private void removeItems(@NonNull List<@NonNull R> items) {
		grid.getNebulaGrid().setRedraw(false);
		try {
			for (@NonNull
			R element : items) {
				GridItem item = dataByR.get(element);
				if (item != null) {
					item.dispose();
					dataByR.put(element, null);
					dataByCol.remove(item);
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
		return dataByCol.get(item);
	}

	/**
	 * @param r
	 *            row value
	 * @return corresponding GridItem
	 */
	public @Nullable GridItem get(@NonNull R r) {
		return dataByR.get(r);
	}

	/**
	 * @return the defaultSortProperty
	 */
	public @NonNull Property<@Nullable Comparator<@NonNull R>> getDefaultSortProperty() {
		return defaultSortProperty;
	}

	/**
	 * @return the sortProperty
	 */
	public Property<@Nullable SWTGridColumn<R, ?>> sortColumnProperty() {
		return sortColumnProperty;
	}

	/**
	 * update item visibility by checking current filter settings
	 */
	public void filter() {
		final List<@NonNull R> elementsToAdd = new ArrayList<>();
		for (R element : dataByR.keySet()) {
			GridItem item = dataByR.get(element);
			boolean visible = true;
			for (@NonNull
			XGridColumn<@NonNull R, @Nullable ?> xcol : grid.getColumns()) {
				SWTGridColumn<R, ?> col = (SWTGridColumn<R, ?>) xcol;
				visible = col.matchesColumnFilter(element);
				if (!visible) {
					break;
				}
			}
			if (visible) {
				if (item == null) {
					elementsToAdd.add(element);
				}
			} else {
				if (item != null) {
					item.dispose();
					dataByR.put(element, null);
					dataByCol.remove(item);
				}
			}
		}
		insertItems(elementsToAdd);
	}

	/**
	 * @return list of visible elements
	 */
	public @NonNull List<@NonNull R> getVisibleElements() {
		return new ArrayList<>(dataByCol.values());
	}
}
