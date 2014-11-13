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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Represents a cell in the grid
 *
 * @param <R>
 *            the row type
 * @param <C>
 *            the cell type
 * @since 1.0
 */
public final class GridCell<R, C> {
	/**
	 * The row value
	 */
	public final @NonNull R rowValue;
	/**
	 * The cell value might be <code>null</code>
	 */
	public final @Nullable C cellValue;
	/**
	 * The column
	 */
	public final @NonNull GridColumn<R, C> column;

	/**
	 * Create a cell
	 *
	 * @param rowValue
	 *            the row value, must not be <code>null</code>
	 * @param cellValue
	 *            the cell value, might be <code>null</code>
	 * @param column
	 *            the column, must nod be <code>null</code>
	 */
	public GridCell(@NonNull R rowValue, @Nullable C cellValue,
			@NonNull GridColumn<R, C> column) {
		this.rowValue = rowValue;
		this.cellValue = cellValue;
		this.column = column;
	}
}
