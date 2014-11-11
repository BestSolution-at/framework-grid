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

import java.util.Comparator;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Compare cell values
 *
 * @param <R>
 *            the row type
 * @param <C>
 *            the cell value type
 */
@FunctionalInterface
public interface ColumnComparator<R, C> {
	/**
	 * Compare the cell value
	 *
	 * @param r1
	 *            the row of value 1
	 * @param c1
	 *            the cell value 1
	 * @param r2
	 *            the row of value 2
	 * @param c2
	 *            the cell value 2
	 * @return a negative integer, zero, or a positive integer as
	 *         <code>c1</code> is less than, equal to, or greater than
	 *         <code>c2</code>.
	 */
	public int compare(R r1, C c1, R r2, C c2);

	/**
	 * Create a comparator from a default {@link Comparator}
	 *
	 * @param c
	 *            the default comparator
	 * @return a column comparator
	 */
	public static <R, C> ColumnComparator<R, C> create(@NonNull Comparator<C> c) {
		return new ColumnComparator<R, C>() {

			@Override
			public int compare(R r1, C c1, R r2, C c2) {
				return c.compare(c1, c2);
			}

		};
	}
}