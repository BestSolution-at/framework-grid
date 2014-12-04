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

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

import at.bestsolution.framework.grid.XCellSelection;
import at.bestsolution.framework.grid.XGridCell;
import at.bestsolution.framework.grid.XGridColumn;

/**
 * a simple cell selection implementation
 * 
 * @param <R>
 *            row type
 */
public class SimpleCellSelection<R> extends SimpleSelection<R> implements XCellSelection<R> {
	// TODO Should we do that lazy??
	private List<XGridCell<R, ?>> cells;

	/**
	 * @param cells
	 *            selected cells
	 * @param rowList
	 *            selected rows
	 * @param columnList
	 *            selected columns
	 */
	public SimpleCellSelection(List<XGridCell<R, ?>> cells, @NonNull List<@NonNull R> rowList,
			@NonNull List<@NonNull XGridColumn<R, ?>> columnList) {
		super(rowList, columnList);
		this.cells = cells;
	}

	@Override
	public <C> List<XGridCell<R, C>> getCells() {
		@SuppressWarnings("unchecked")
		List<XGridCell<R, C>> l = (List<XGridCell<R, C>>) (List<?>) cells;
		return Collections.<XGridCell<R, C>> unmodifiableList(l);
	}

}
