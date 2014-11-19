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
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;

import at.bestsolution.framework.grid.ColumnComparator;
import at.bestsolution.framework.grid.Grid;
import at.bestsolution.framework.grid.GridColumn;
import at.bestsolution.framework.grid.GridContentProvider;
import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.Property.ChangeListener;
import at.bestsolution.framework.grid.Util;
import at.bestsolution.framework.grid.func.CellDataFunction;
import at.bestsolution.framework.grid.func.CellValueMatcherFunction;
import at.bestsolution.framework.grid.swt.internal.SimpleProperty;

/**
 * SWT column implementation
 *
 * @param <R>
 *            row type
 * @param <C>
 *            cell value type
 */
public class SWTGridColumn<@NonNull R, @Nullable C> implements GridColumn<R, C> {
	private final @NonNull Property<@Nullable String> labelProperty = new SimpleProperty<>(
			null);
	private final @NonNull Property<@Nullable URI> iconProperty = new SimpleProperty<>(
			null);
	private final @NonNull Property<@Nullable Integer> maxWidthProperty = new SimpleProperty<>(
			null);
	private final @NonNull Property<@Nullable Integer> minWidthProperty = new SimpleProperty<>(
			null);
	@SuppressWarnings("null")
	private final @NonNull Property<@NonNull Boolean> autoWidthProperty = new SimpleProperty<>(
			Boolean.FALSE);
	private final @NonNull Property<@NonNull Function<@NonNull R, @Nullable C>> cellValueFunctionProperty;
	private final @NonNull Property<@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence>> textFunctionProperty = new SimpleProperty<>(
			Util.defaultToStringCellDataFunction());
	private final @NonNull Property<@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable URI>> iconFunctionProperty = new SimpleProperty<>(
			Util.nullCellDataFunction());
	@SuppressWarnings(value = "all")
	private final @NonNull Property<@NonNull AutoFilterType> autoFilterTypeProperty = new SimpleProperty<>(
			AutoFilterType.NONE);
	private final @NonNull Property<@NonNull Alignment> alignmentProperty = new SimpleProperty<>(
			Alignment.LEFT);
	private final @NonNull Property<@NonNull CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull Object>> autoFilterMatcherProperty = new SimpleProperty<>(
			Util.defaultToStringMatcher());
	private final @NonNull Property<@NonNull Supplier<@NonNull List<@NonNull Object>>> autoFilterDataSupplierProperty = new SimpleProperty<>(
			Util.emptyListSupplier());
	private final @NonNull Property<Function<@NonNull Object, @Nullable CharSequence>> autoFilterTextFunctionProperty = new SimpleProperty<>(
			Util.defaultToStringFunction());
	private final @NonNull Property<@Nullable ColumnComparator<@NonNull R, @Nullable C>> sorterProperty = new SimpleProperty<>(
			null);
	private final @NonNull Property<@NonNull Integer> indexProperty;

	private final @NonNull SWTGridTable<R> grid;
	org.eclipse.nebula.widgets.grid.GridColumn nebulaColumn;

	/**
	 * Create a new column
	 *
	 * @param cellValueFunction
	 *            the value function
	 */
	SWTGridColumn(@NonNull SWTGridTable<R> grid,
			@NonNull Function<@NonNull R, @Nullable C> cellValueFunction) {
		this.cellValueFunctionProperty = new SimpleProperty<>(cellValueFunction);
		this.grid = grid;
		this.indexProperty = new SimpleProperty<@NonNull Integer>(new Integer(
				grid.getColumns().size()));

		nebulaColumn = new org.eclipse.nebula.widgets.grid.GridColumn(
				grid.getNebulaGrid(), SWT.NONE);
		registerPropertyListeners();
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
		return autoFilterMatcherProperty;
	}

	@Override
	public @NonNull Property<@NonNull Supplier<@NonNull List<@NonNull Object>>> autoFilterDataSupplierProperty() {
		return autoFilterDataSupplierProperty;
	}

	@Override
	public @NonNull Property<Function<@NonNull Object, @Nullable CharSequence>> autoFilterTextFunctionProperty() {
		return autoFilterTextFunctionProperty;
	}

	@Override
	public @NonNull Property<@Nullable ColumnComparator<@NonNull R, @Nullable C>> sorterProperty() {
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
	public @NonNull Grid<R, GridContentProvider<R>> getGrid() {
		return grid;
	}

	/**
	 * 
	 */
	@SuppressWarnings("null")
	private void registerPropertyListeners() {
		alignmentProperty.addChangeListener(new ChangeListener<Alignment>() {
			@Override
			public void valueChanged(Property<Alignment> property,
					Alignment oldValue, Alignment newValue) {
				switch (newValue) {
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
					throw new UnsupportedOperationException(
							"unknown alignment type: " + newValue); //$NON-NLS-1$
				}
			}
		});
		labelProperty.addChangeListener(new ChangeListener<String>() {
			@Override
			public void valueChanged(Property<String> property,
					String oldValue, String newValue) {
				nebulaColumn.setText(newValue);
			}
		});
		autoWidthProperty.addChangeListener(new ChangeListener<Boolean>() {
			@Override
			public void valueChanged(Property<Boolean> property,
					Boolean oldValue, Boolean newValue) {
				// TODO
			}
		});
		minWidthProperty.addChangeListener(new ChangeListener<Integer>() {
			@Override
			public void valueChanged(Property<Integer> property,
					Integer oldValue, Integer newValue) {
				if (newValue != null) {
					if (newValue.intValue() < 0) {
						throw new IllegalArgumentException(
								"min width must be a non-negative number"); //$NON-NLS-1$
					}
					nebulaColumn.setMinimumWidth(newValue.intValue());
					checkWidth();
				}
			}
		});
		maxWidthProperty.addChangeListener(new ChangeListener<Integer>() {
			@Override
			public void valueChanged(Property<Integer> property,
					Integer oldValue, Integer newValue) {
				// TODO set max width
				checkWidth();
			}
		});
	}

	void checkWidth() {
		@Nullable
		Integer minWidth = minWidthProperty.get();
		@Nullable
		Integer maxWidth = maxWidthProperty.get();
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
	// TODO find a better solution for this
	public void fillGridItem(GridItem item, @NonNull R element) {
		C value = cellValueFunctionProperty().get().apply(element);
		if (value != null) {
			if (value instanceof Boolean) {
				item.setChecked(indexProperty().get().intValue(),
						((Boolean) value).booleanValue());
			} else {
				CharSequence textValue = textFunctionProperty.get().apply(
						element, value);
				if (textValue != null) {
					item.setText(indexProperty().get().intValue(),
							textValue.toString());
				} else {
					item.setText(indexProperty().get().intValue(), ""); //$NON-NLS-1$
				}
			}
		} else {
			item.setText(indexProperty().get().intValue(), ""); //$NON-NLS-1$
		}
	}
}
