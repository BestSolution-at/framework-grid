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
package at.bestsolution.framework.grid.swt;

import java.net.URI;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import at.bestsolution.framework.grid.DefaultExportValueFunction;
import at.bestsolution.framework.grid.DefaultSortComparator;
import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.Util;
import at.bestsolution.framework.grid.XGrid;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.XGridContentProvider;
import at.bestsolution.framework.grid.XGridMetaData;
import at.bestsolution.framework.grid.func.AutoFilterEntry;
import at.bestsolution.framework.grid.func.CellDataFunction;
import at.bestsolution.framework.grid.func.CellValueMatcherFunction;
import at.bestsolution.framework.grid.func.DisposableCellDataFunction;
import at.bestsolution.framework.grid.func.ExportValueFunction;
import at.bestsolution.framework.grid.func.MetaDataFunction;
import at.bestsolution.framework.grid.swt.internal.SWTColumnFilter;
import at.bestsolution.framework.grid.swt.internal.SWTComboColumnFilter;
import at.bestsolution.framework.grid.swt.internal.SWTGridContentHandler;
import at.bestsolution.framework.grid.swt.internal.SWTTextColumnFilter;
import at.bestsolution.framework.grid.swt.internal.SimpleProperty;

/**
 * SWT column implementation
 *
 * @param <R>
 *            row type
 * @param <C>
 *            cell value type
 */
public class SWTGridColumn<@NonNull R, @Nullable C> implements XGridColumn<R, C> {
	private final @NonNull Property<@Nullable URI> iconProperty = new SimpleProperty<>(null);
	private final @NonNull Property<@Nullable Integer> maxWidthProperty = new SimpleProperty<>(null);
	private final @NonNull Property<@Nullable Integer> minWidthProperty = new SimpleProperty<>(null);
	@SuppressWarnings("null")
	private final @NonNull Property<@NonNull Boolean> autoWidthProperty = new SimpleProperty<>(Boolean.FALSE);
	private final @NonNull Property<@NonNull Function<@NonNull R, @Nullable C>> cellValueFunctionProperty;
	private final @NonNull Property<@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence>> textFunctionProperty = new SimpleProperty<>(
			Util.defaultToStringCellDataFunction());
	private final @NonNull Property<@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable URI>> iconFunctionProperty = new SimpleProperty<>(
			Util.nullCellDataFunction());
	@SuppressWarnings(value = "all")
	private final @NonNull Property<@NonNull AutoFilterType> autoFilterTypeProperty = new SimpleProperty<>(AutoFilterType.NONE);
	private final @NonNull Property<@NonNull Alignment> alignmentProperty = new SimpleProperty<>(Alignment.LEFT);
	private final @NonNull Property<@NonNull CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull Object>> autoFilterMatcherFunctionProperty = new SimpleProperty<>(
			Util.defaultToStringMatcher());
	private final @NonNull Property<@NonNull Supplier<@NonNull List<@NonNull AutoFilterEntry<@NonNull R, @Nullable C, @NonNull Object>>>> autoFilterDataSupplierProperty = new SimpleProperty<>(
			Util.emptyListSupplier());
	private final @NonNull Property<@Nullable CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence>> autoFilterTextFunctionProperty = new SimpleProperty<>(
			null);
	private final @NonNull Property<@Nullable Comparator<@NonNull R>> sorterProperty = new SimpleProperty<>(
			new DefaultSortComparator<R, C>(this));
	private final @NonNull Property<@NonNull Integer> indexProperty;
	private final @NonNull Property<@Nullable String> labelProperty = new SimpleProperty<>(null);
	private final @NonNull Property<@NonNull Sorting> sortingProperty = new SimpleProperty<>(Sorting.NONE);
	private final @NonNull Property<@NonNull SortingBehavior> sortingBehaviorProperty = new SimpleProperty<>(SortingBehavior.UP_DOWN);

	private final @NonNull SWTGridTable<R> grid;
	private final @NonNull Property<@NonNull String> autoFilterFreeTextProperty = new SimpleProperty<>(""); //$NON-NLS-1$
	private final @NonNull Property<@NonNull ExportValueFunction<@NonNull R, @Nullable C>> exportValueFunctionProperty = new SimpleProperty<>(
			new DefaultExportValueFunction<R, C>(this));
	private @NonNull Property<@NonNull String> notPresentableValuePresentationProperty = new SimpleProperty<>("#N/A"); //$NON-NLS-1$
	private final @NonNull MetaDataFunction<@NonNull R, @Nullable C> DEFAULT_META = new MetaDataFunction<R, C>() {
		@SuppressWarnings("null")
		@Override
		public @NonNull List<@NonNull XGridMetaData> getMetaData(R rowValue, C cellValue) {
			return Collections.emptyList();
		}
	};
	private final @NonNull Property<@NonNull MetaDataFunction<@NonNull R, @Nullable C>> metaDataFunctionProperty = new SimpleProperty<>(
			(MetaDataFunction<R, C>) DEFAULT_META);

	GridColumn nebulaColumn;
	@Nullable
	SWTColumnFilter<R, C> columnFilter = null;

	/**
	 * Create a new column
	 *
	 * @param cellValueFunction
	 *            the value function
	 */
	SWTGridColumn(@NonNull SWTGridTable<R> grid, @NonNull Function<@NonNull R, @Nullable C> cellValueFunction) {
		this.cellValueFunctionProperty = new SimpleProperty<>(cellValueFunction);
		this.grid = grid;
		this.indexProperty = new SimpleProperty<@NonNull Integer>(new Integer(grid.getColumns().size()));

		nebulaColumn = new GridColumn(grid.getNebulaGrid(), SWT.NONE);

		registerListeners();
		registerPropertyListeners();
	}

	private void registerListeners() {
		nebulaColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				switch (sortingProperty().get()) {
				case UP:
					sortingProperty().set(Sorting.DOWN);
					break;
				case DOWN:
					switch (sortingBehaviorProperty().get()) {
					case UP_DOWN_DEFAULT:
						sortingProperty().set(Sorting.NONE);
						break;
					case UP_DOWN:
					default:
						sortingProperty().set(Sorting.UP);
					}
					break;
				default:
					sortingProperty().set(Sorting.UP);
				}
			}
		});
		nebulaColumn.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				checkWidth();
			}
		});
	}

	/**
	 * @return the autoFilterFreeTextProperty
	 */
	public Property<String> autoFilterFreeTextProperty() {
		return autoFilterFreeTextProperty;
	}

	@Override
	public @NonNull Property<@Nullable String> labelProperty() {
		return labelProperty;
	}

	@Override
	public @NonNull Property<@Nullable URI> iconProperty() {
		return iconProperty;
	}

	@Override
	public @NonNull Property<@Nullable Integer> maxWidthProperty() {
		return maxWidthProperty;
	}

	@Override
	public @NonNull Property<@Nullable Integer> minWidthProperty() {
		return minWidthProperty;
	}

	@Override
	public @NonNull Property<@NonNull Boolean> autoWidthProperty() {
		return autoWidthProperty;
	}

	@Override
	public @NonNull Property<@NonNull Function<@NonNull R, @Nullable C>> cellValueFunctionProperty() {
		return cellValueFunctionProperty;
	}

	@Override
	public @NonNull Property<@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence>> textFunctionProperty() {
		return textFunctionProperty;
	}

	@Override
	public @NonNull Property<@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable URI>> iconFunctionProperty() {
		return iconFunctionProperty;
	}

	@Override
	public @NonNull Property<@NonNull AutoFilterType> autoFilterTypeProperty() {
		return autoFilterTypeProperty;
	}

	@Override
	public @NonNull Property<@NonNull CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull Object>> autoFilterMatcherFunctionProperty() {
		return autoFilterMatcherFunctionProperty;
	}

	@Override
	public @NonNull Property<@NonNull Supplier<@NonNull List<@NonNull AutoFilterEntry<@NonNull R, @Nullable C, @NonNull Object>>>> autoFilterDataSupplierProperty() {
		return autoFilterDataSupplierProperty;
	}

	@Override
	public @NonNull Property<@Nullable CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence>> autoFilterTextFunctionProperty() {
		return autoFilterTextFunctionProperty;
	}

	@Override
	public @NonNull Property<@Nullable Comparator<@NonNull R>> sorterProperty() {
		return sorterProperty;
	}

	@Override
	public @NonNull Property<@NonNull Alignment> alignmentProperty() {
		return alignmentProperty;
	}

	@Override
	public @NonNull Property<@NonNull Integer> indexProperty() {
		return indexProperty;
	}

	@Override
	public @NonNull Property<XGridColumn.@NonNull Sorting> sortingProperty() {
		return sortingProperty;
	}

	@Override
	public @NonNull Property<XGridColumn.@NonNull SortingBehavior> sortingBehaviorProperty() {
		return sortingBehaviorProperty;
	}

	@Override
	public @NonNull Property<@NonNull ExportValueFunction<@NonNull R, @Nullable C>> exportValueFunctionProperty() {
		return exportValueFunctionProperty;
	}

	@Override
	public @NonNull XGrid<R, XGridContentProvider<R>> getGrid() {
		return grid;
	}

	/**
	 * @return nebula grid column
	 */
	public GridColumn getNebulaColumn() {
		return nebulaColumn;
	}

	/**
	 * @return the content handler
	 */
	public @NonNull SWTGridContentHandler<@NonNull R> getContentHandler() {
		return grid.getContentHandler();
	}

	private void registerPropertyListeners() {
		labelProperty.addChangeListener((property, oldValue, newValue) -> nebulaColumn.setText(newValue));
		alignmentProperty.addChangeListener((property, oldValue, newValue) -> applyAlignment(newValue));
		autoWidthProperty.addChangeListener((property, oldValue, newValue) -> applyAutoWidth(newValue));
		minWidthProperty.addChangeListener((property, oldValue, newValue) -> applyMinWidth(newValue));
		maxWidthProperty.addChangeListener((property, oldValue, newValue) -> applyMaxWidth(newValue));
		textFunctionProperty.addChangeListener((property, oldValue, newValue) -> requestUpdate());
		cellValueFunctionProperty.addChangeListener((property, oldValue, newValue) -> requestUpdate());
		sortingProperty.addChangeListener((property, oldValue, newValue) -> applySorting(property, oldValue, newValue));
		autoFilterTypeProperty.addChangeListener((property, oldValue, newValue) -> applyFilterType(oldValue, newValue));
		autoFilterFreeTextProperty.addChangeListener((property, oldValue, newValue) -> grid.getContentHandler().resetContent());
	}

	private void applyAutoWidth(@NonNull Boolean autoWidth) {
		checkWidth();
	}

	private void applyMaxWidth(Integer maxWidth) {
		checkWidth();
	}

	private void applyFilterType(AutoFilterType oldFilterType, AutoFilterType newFilterType) {
		if (oldFilterType != newFilterType) {
			switch (newFilterType) {
			case DROPDOWN:
				columnFilter = new SWTComboColumnFilter<R, C>(SWTGridColumn.this);
				break;
			case TEXT:
				columnFilter = new SWTTextColumnFilter<R, C>(SWTGridColumn.this);
				break;
			default:
				nebulaColumn.setHeaderControl(null);
			}
		}
	}

	private void applySorting(Property<XGridColumn.Sorting> property, at.bestsolution.framework.grid.XGridColumn.Sorting oldValue,
			at.bestsolution.framework.grid.XGridColumn.Sorting newValue) {
		switch (newValue) {
		case UP:
			nebulaColumn.setSort(SWT.UP);
			break;
		case DOWN:
			nebulaColumn.setSort(SWT.DOWN);
			break;
		default:
			nebulaColumn.setSort(SWT.NONE);
		}
		@Nullable
		SWTGridColumn<@NonNull R, ?> currentSortColumn = grid.getContentHandler().sortColumnProperty().get();
		// reset sorting state on previous sorted other column
		if (currentSortColumn != null && currentSortColumn != this) {
			currentSortColumn.sortingProperty.set(Sorting.NONE);
		}
		grid.getContentHandler().sortColumnProperty().set(this);
	}

	void checkWidth() {
		boolean autoWidth = false;
		if (autoWidthProperty.get().booleanValue()) {
			autoWidth = true;
		} else {
			for (@NonNull
			XGridColumn<@NonNull R, @Nullable ?> col : grid.getColumns()) {
				if (col.autoWidthProperty().get().booleanValue()) {
					autoWidth = true;
					break;
				}
			}
		}
		nebulaColumn.getParent().setAutoWidth(autoWidth);

		@Nullable
		Integer minWidth = minWidthProperty.get();
		@Nullable
		Integer maxWidth = maxWidthProperty.get();
		if (maxWidth != null && nebulaColumn.getWidth() > maxWidth.intValue()) {
			nebulaColumn.setWidth(maxWidth.intValue());
		}
		if (minWidth != null && maxWidth != null && minWidth.equals(maxWidth)) {
			nebulaColumn.setWidth(minWidth.intValue());
		}
	}

	/**
	 * @param item
	 *            grid item
	 * @param element
	 *            row element
	 */
	private void fillGridItem(@NonNull GridItem item, @NonNull R element) {
		C value = cellValueFunctionProperty().get().apply(element);
		if (value != null) {
			if (value instanceof Boolean) {
				item.setChecked(indexProperty().get().intValue(), ((Boolean) value).booleanValue());
			} else {
				CharSequence textValue = textFunctionProperty.get().apply(element, value);
				if (textValue != null) {
					item.setText(indexProperty().get().intValue(), textValue.toString());
				} else {
					item.setText(indexProperty().get().intValue(), ""); //$NON-NLS-1$
				}
			}
		} else {
			item.setText(indexProperty().get().intValue(), ""); //$NON-NLS-1$
		}
	}

	@Override
	public void requestUpdate() {
		for (GridItem item : nebulaColumn.getParent().getItems()) {
			if (item != null) {
				fillGridItem(item, grid.getContentHandler().get(item));
			}
		}
	}

	@Override
	public void requestUpdate(@NonNull R element) {
		@Nullable
		GridItem item = grid.getContentHandler().get(element);
		if (item != null) {
			fillGridItem(item, element);
		}
	}

	@Override
	public void dispose() {
		grid.columns.remove(this);
		if (getContentHandler().sortColumnProperty().get() == this) {
			getContentHandler().sortColumnProperty().set(null);
		}
		@Nullable
		SWTColumnFilter<@NonNull R, @Nullable C> colFilter = columnFilter;
		if (colFilter != null) {
			colFilter.dispose();
		}
		nebulaColumn.dispose();
		alignmentProperty.dispose();
		autoFilterDataSupplierProperty.dispose();
		autoFilterMatcherFunctionProperty.dispose();
		@Nullable
		CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence> autoFilterTextFunction = autoFilterTextFunctionProperty.get();
		if (autoFilterTextFunction instanceof DisposableCellDataFunction) {
			((DisposableCellDataFunction<?, ?, ?>) autoFilterTextFunction).dispose();
		}
		autoFilterTextFunctionProperty.dispose();
		autoFilterTypeProperty.dispose();
		autoWidthProperty.dispose();
		cellValueFunctionProperty.dispose();
		iconFunctionProperty.dispose();
		iconProperty.dispose();
		indexProperty.dispose();
		maxWidthProperty.dispose();
		minWidthProperty.dispose();
		sorterProperty.dispose();
		labelProperty.dispose();
		sortingProperty.dispose();
		if (textFunctionProperty.get() instanceof DisposableCellDataFunction) {
			((DisposableCellDataFunction<?, ?, ?>) textFunctionProperty.get()).dispose();
		}
		textFunctionProperty.dispose();
		autoFilterFreeTextProperty.dispose();
		exportValueFunctionProperty.dispose();
	}

	/**
	 * @param element
	 *            the element
	 * @return <code>true</code> if the given element matches,
	 *         <code>false</code> otherwise
	 */
	public boolean matchesColumnFilter(R element) {
		SWTColumnFilter<@NonNull R, @Nullable C> filter = columnFilter;
		if (filter != null) {
			return filter.matches(element);
		}
		return true;
	}

	private void applyMinWidth(Integer minWidth) {
		int min = 0;
		if (minWidth != null) {
			if (minWidth.intValue() < 0) {
				throw new IllegalArgumentException("min width must be a non-negative number"); //$NON-NLS-1$
			}
			min = minWidth.intValue();
		}
		nebulaColumn.setMinimumWidth(min);
		checkWidth();
	}

	private void applyAlignment(Alignment alignment) {
		switch (alignment) {
		case LEFT:
			nebulaColumn.setAlignment(SWT.LEFT);
			break;
		case CENTER:
			nebulaColumn.setAlignment(SWT.CENTER);
			break;
		case RIGHT:
			nebulaColumn.setAlignment(SWT.RIGHT);
			break;
		default:
			throw new UnsupportedOperationException("unknown alignment type: " + alignment); //$NON-NLS-1$
		}
	}

	@Override
	public Object getExportValue(@NonNull R element) {
		return exportValueFunctionProperty().get().apply(element, cellValueFunctionProperty().get().apply(element));
	}

	@NonNull
	public Property<@NonNull MetaDataFunction<@NonNull R, @Nullable C>> metaDataFunctionProperty() {
		return metaDataFunctionProperty;
	}

	@Override
	public @NonNull Property<@NonNull String> notPresentableValuePresentationProperty() {
		return notPresentableValuePresentationProperty;
	}
}
