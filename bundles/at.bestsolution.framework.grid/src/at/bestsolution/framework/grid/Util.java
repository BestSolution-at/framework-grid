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
package at.bestsolution.framework.grid;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.func.CellDataFunction;
import at.bestsolution.framework.grid.func.CellValueMatcherFunction;

/**
 * Utility methods
 *
 * @since 1.0
 */
public class Util {
	static class EmptySelection<R> implements XSelection<R> {

		@Override
		public @Nullable R getFirst() {
			return null;
		}

		@SuppressWarnings("null")
		@Override
		public @NonNull List<@NonNull R> asList() {
			return Collections.emptyList();
		}

		@Override
		public boolean isEmpty() {
			return true;
		}

		@SuppressWarnings("null")
		@Override
		public @NonNull List<@NonNull XGridCellMetaData<R>> getCellMetaData() {
			return Collections.emptyList();
		}

		@Override
		public List<XGridRowMetaData<R>> getRowMetaData() {
			return Collections.emptyList();
		}
	}

	static class EmptyCellSelection<R> implements XCellSelection<R> {

		@Override
		public @Nullable R getFirst() {
			return null;
		}

		@SuppressWarnings("null")
		@Override
		public @NonNull List<@NonNull R> asList() {
			return Collections.emptyList();
		}

		@Override
		public boolean isEmpty() {
			return true;
		}

		@SuppressWarnings("null")
		@Override
		public @NonNull List<@NonNull XGridCellMetaData<R>> getCellMetaData() {
			return Collections.emptyList();
		}

		@Override
		public <C> List<XGridCell<R, C>> getCells() {
			return Collections.emptyList();
		}

		@Override
		public List<XGridRowMetaData<R>> getRowMetaData() {
			return Collections.emptyList();
		}
	}

	/**
	 * @param <R>
	 *            the row type
	 * @return an empty selection
	 */
	public static <R> @NonNull XSelection<R> emptySelection() {
		return new EmptySelection<>();
	}

	/**
	 * @param <R>
	 *            the row type
	 * @return an empty cell selection
	 */
	public static <R> @NonNull XCellSelection<R> emptyCellSelection() {
		return new EmptyCellSelection<>();
	}

	/**
	 * @param <R>
	 *            the row type
	 * @param <C>
	 *            the cell type
	 * @param <D>
	 *            the expected return type
	 * @return cell data function who always return null
	 */
	public static <R, C, D> @NonNull CellDataFunction<R, C, @Nullable D> nullCellDataFunction() {
		return (row, cellValue) -> null;
	}

	/**
	 * @param <R>
	 *            the row type
	 * @param <C>
	 *            the cell type
	 * @return cell data function who returns the toString value of the cell
	 *         value or <code>null</code>
	 */
	public static <R, C> @NonNull CellDataFunction<R, C, @Nullable CharSequence> defaultToStringCellDataFunction() {
		return (row, cellValue) -> cellValue == null ? null : cellValue.toString();
	}

	/**
	 * @param <R>
	 *            the row type
	 * @param <C>
	 *            the cell type
	 * @param <O>
	 *            the filter value type
	 * @return matcher function which compares the string value
	 */
	public static <R, C, O> @NonNull CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull O> defaultToStringMatcher() {
		return (row, cellValue, filterData) -> {
			if (cellValue == null) {
				return false;
			}
			return filterData.toString().equals(cellValue.toString());
		};
	}

	/**
	 * @param <R>
	 *            the row type
	 * @param <C>
	 *            the cell type
	 * @param <O>
	 *            the filter value type
	 * @param textFunctionProperty
	 *            the columns textValueFunction property
	 * @return matcher function which checks whether the filter value is a
	 *         substring of the cell value
	 */
	public static <R, C, O> @NonNull CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull O> defaultSubstringMatcher(
			@NonNull Property<@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence>> textFunctionProperty) {
		return (row, cellValue, filterData) -> {
			if (cellValue == null) {
				return filterData.toString().isEmpty();
			}
			CharSequence cellStringValue = textFunctionProperty.get().apply(row, cellValue);
			if (cellStringValue == null) {
				return filterData.toString().isEmpty();
			}
			return cellStringValue.toString().toLowerCase().contains(filterData.toString().toLowerCase());
		};
	}

	/**
	 * @param <R>
	 *            the row type
	 * @param <C>
	 *            the cell type
	 * @param <O>
	 *            the filter value type
	 * @return matcher function which always matches. Use this for "All".
	 */
	public static <R, C, O> @NonNull CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull O> defaultTrueMatcher() {
		return (row, cellValue, filterData) -> true;
	}

	/**
	 * @param <R>
	 *            the row type
	 * @param <C>
	 *            the cell type
	 * @param <O>
	 *            the filter value type
	 * @param textFunctionProperty
	 *            the columns textValueFunction property
	 * @return matcher function which matches for null or empty
	 *         {@link String#toString()} values
	 */
	public static <R, C, O> @NonNull CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull O> defaultEmptyMatcher(
			@NonNull Property<@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence>> textFunctionProperty) {
		return (row, cellValue, filterData) -> {
			CharSequence cellStringValue = textFunctionProperty.get().apply(row, cellValue);
			if (cellStringValue == null || cellStringValue.length() == 0) {
				return true;
			}
			return false;
		};
	}

	/**
	 * @param <R>
	 *            the row type
	 * @param <C>
	 *            the cell type
	 * @param <O>
	 *            the filter value type
	 * @param textFunctionProperty
	 *            the columns textValueFunction property
	 * @return matcher function which matches for not null and not empty
	 *         {@link String#toString()} values
	 */
	public static <R, C, O> @NonNull CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull O> defaultNotEmptyMatcher(
			@NonNull Property<@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence>> textFunctionProperty) {
		return new CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull O>() {
			private CellValueMatcherFunction<R, @Nullable C, O> inverseMatcher = defaultEmptyMatcher(textFunctionProperty);

			@Override
			public boolean apply(@NonNull R row, @Nullable C cellValue, @NonNull O filterData) {
				return !inverseMatcher.apply(row, cellValue, filterData);
			}
		};
	}

	/**
	 * @param <O>
	 *            the list element type
	 * @return supplier of empty list
	 */
	@SuppressWarnings("null")
	public static <O> @NonNull Supplier<@NonNull List<@NonNull O>> emptyListSupplier() {
		return () -> Collections.<@NonNull O> emptyList();
	}

	/**
	 * @param <O>
	 *            the value type
	 * @return to string representation of value
	 */
	public static <O> @NonNull Function<@NonNull O, @Nullable CharSequence> defaultToStringFunction() {
		return t -> t.toString();
	}

	/**
	 * @return a default {@link ElementComparer} which uses default
	 *         implementations of {@link #equals(Object)} and
	 *         {@link #hashCode()}
	 */
	public static <R> @NonNull ElementComparer<R> defaultElementComparer() {
		return new ElementComparer<R>() {
			@Override
			public boolean equals(@NonNull R a, @NonNull Object b) {
				return a.equals(b);
			}

			@Override
			public int hashCode(@NonNull R element) {
				return element.hashCode();
			}
		};
	}
}
