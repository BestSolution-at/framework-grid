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

import at.bestsolution.framework.grid.XGrid.Selection;
import at.bestsolution.framework.grid.func.CellDataFunction;
import at.bestsolution.framework.grid.func.CellValueMatcherFunction;

/**
 * Utility methods
 *
 * @since 1.0
 */
public class Util {
	static class EmptySelection<R, O> implements Selection<R, O> {

		@Override
		public @Nullable O getFirst() {
			return null;
		}

		@SuppressWarnings("null")
		@Override
		public @NonNull List<@NonNull O> asList() {
			return Collections.emptyList();
		}

		@Override
		public boolean isEmpty() {
			return true;
		}

		@Override
		public <C> @NonNull Selection<R, XGridCell<R, C>> asCellSelection() {
			return new EmptySelection<>();
		}
	}

	/**
	 * @param <R>
	 *            the row type
	 * @return an empty selection
	 */
	public static <R> @NonNull Selection<R, R> emptySelection() {
		return new EmptySelection<>();
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
		return new CellDataFunction<R, C, @Nullable D>() {

			@Override
			public @Nullable D apply(R row, C cellValue) {
				return null;
			}
		};
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
		return new CellDataFunction<R, C, @Nullable CharSequence>() {

			@Override
			public @Nullable CharSequence apply(R row, C cellValue) {
				return cellValue == null ? null : cellValue.toString();
			}
		};
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
		return new CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull O>() {
			@Override
			public boolean apply(@NonNull R row, @Nullable C cellValue, @NonNull O filterData) {
				if (cellValue == null) {
					return false;
				}
				return filterData.toString().equals(cellValue.toString());
			}
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
	public static <R, C, O, D> @NonNull CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull O> defaultSubstringMatcher(
			@NonNull Property<@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence>> textFunctionProperty) {
		return new CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull O>() {
			@Override
			public boolean apply(@NonNull R row, @Nullable C cellValue, @NonNull O filterData) {
				if (cellValue == null) {
					return filterData.toString().isEmpty();
				}
				CharSequence cellStringValue = textFunctionProperty.get().apply(row, cellValue);
				if (cellStringValue == null) {
					return filterData.toString().isEmpty();
				}
				return cellStringValue.toString().toLowerCase().contains(filterData.toString().toLowerCase());
			}
		};
	}

	/**
	 * @param <O>
	 *            the list element type
	 * @return supplier of empty list
	 */
	public static <O> @NonNull Supplier<@NonNull List<@NonNull O>> emptyListSupplier() {
		return new Supplier<@NonNull List<@NonNull O>>() {

			@SuppressWarnings("null")
			@Override
			public @NonNull List<@NonNull O> get() {
				return Collections.<@NonNull O> emptyList();
			}
		};
	}

	/**
	 * @param <O>
	 *            the value type
	 * @return to string representation of value
	 */
	public static <O> @NonNull Function<@NonNull O, @Nullable CharSequence> defaultToStringFunction() {
		return new Function<@NonNull O, @Nullable CharSequence>() {
			@Override
			public CharSequence apply(@NonNull O t) {
				return t.toString();
			}
		};
	}
}
