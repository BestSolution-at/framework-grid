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

import at.bestsolution.framework.grid.ColumnComparator;
import at.bestsolution.framework.grid.GridColumn;
import at.bestsolution.framework.grid.Property;
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
public class SWTGridColumn<R, C> implements GridColumn<R, C> {
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
	private final @NonNull Property<@NonNull CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull Object>> autoFilterMatcherProperty = new SimpleProperty<>(
			Util.defaultToStringMatcher());
	private final @NonNull Property<@NonNull Supplier<@NonNull List<@NonNull Object>>> autoFilterDataSupplierProperty = new SimpleProperty<>(
			Util.emptyListSupplier());
	private final @NonNull Property<Function<@NonNull Object, @Nullable CharSequence>> autoFilterTextFunctionProperty = new SimpleProperty<>(
			Util.defaultToStringFunction());
	private final @NonNull Property<@Nullable ColumnComparator<@NonNull R, @Nullable C>> sorterProperty = new SimpleProperty<>(
			null);

	private SWTGridTable<R> grid;

	/**
	 * Create a new column
	 *
	 * @param cellValueFunction
	 *            the value function
	 */
	SWTGridColumn(SWTGridTable<R> grid,@NonNull Function<@NonNull R, @Nullable C> cellValueFunction) {
		this.cellValueFunctionProperty = new SimpleProperty<>(cellValueFunction);
		this.grid = grid;
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
	public @NonNull Property<@Nullable Integer> maxWidth() {
		return maxWidthProperty;
	}

	@Override
	public @NonNull Property<@Nullable Integer> minWidth() {
		return minWidthProperty;
	}

	@Override
	public @NonNull Property<@NonNull Boolean> autoWidth() {
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

}
