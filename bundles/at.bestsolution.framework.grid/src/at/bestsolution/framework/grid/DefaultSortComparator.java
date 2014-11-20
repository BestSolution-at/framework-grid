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
package at.bestsolution.framework.grid.emf;

import java.util.Comparator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.XGridColumn;

/**
 * Default comparator implementation for column sorting which compares by cell
 * text value
 *
 * @param <R>
 *            row type
 * @param <C>
 *            cell type
 */
public class DefaultSortComparator<@NonNull R, C> implements Comparator<R> {
	private final @NonNull XGridColumn<@NonNull R, C> column;

	/**
	 * @param column
	 *            the grid column to sort
	 */
	public DefaultSortComparator(@NonNull XGridColumn<@NonNull R, C> column) {
		this.column = column;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compare(@NonNull R o1, @NonNull R o2) {
		@Nullable
		C cellValue1 = column.cellValueFunctionProperty().get().apply(o1);
		@Nullable
		C cellValue2 = column.cellValueFunctionProperty().get().apply(o2);
		CharSequence value1 = column.textFunctionProperty().get()
				.apply(o1, cellValue1);
		CharSequence value2 = column.textFunctionProperty().get()
				.apply(o2, cellValue2);
		if (value1 == null && value2 == null) {
			return 0;
		} else if (value1 == null) {
			return -1;
		} else if (value2 == null) {
			return 1;
		} else {
			if (value1 instanceof Comparable) {
				return ((Comparable<CharSequence>) value1).compareTo(value2);
			} else {
				return 0;
			}
		}
	}
}
