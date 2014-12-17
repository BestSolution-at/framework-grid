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
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.XGrid;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.XGridCellMetaData;
import at.bestsolution.framework.grid.XGridContentProvider;
import at.bestsolution.framework.grid.XGridRowMetaData;
import at.bestsolution.framework.grid.XSelection;

/**
 * a simple selection implementation
 *
 * @param <R>
 *            row type
 */
public class SimpleSelection<R> implements XSelection<R> {
	private final @NonNull List<@NonNull R> rowList;
	private final @NonNull List<XGridColumn<R, ?>> columnList;
	private final @NonNull XGrid<R, XGridContentProvider<R>> grid;

	/**
	 * @param rowList
	 *            selected rows
	 * @param grid
	 *            the grid
	 * @param columnList
	 *            selected columns
	 */
	public SimpleSelection(@NonNull XGrid<R, XGridContentProvider<R>> grid, @NonNull List<@NonNull R> rowList,
			@NonNull List<@NonNull XGridColumn<R, ?>> columnList) {
		this.rowList = rowList;
		this.grid = grid;
		this.columnList = columnList;
	}

	@Override
	public @Nullable R getFirst() {
		return rowList.isEmpty() ? null : rowList.get(0);
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull List<@NonNull R> asList() {
		return Collections.unmodifiableList(rowList);
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public @NonNull List<@NonNull XGridCellMetaData<R>> getCellMetaData() {
		List<@NonNull XGridCellMetaData<R>> rv = new ArrayList<>();
		for (R r : rowList) {
			for (XGridColumn<R, ?> c : columnList) {
				List<@NonNull XGridCellMetaData<R>> data = ((XGridColumn<R, Object>) c).metaDataFunctionProperty().get()
						.getMetaData(r, c.cellValueFunctionProperty().get().apply(r));
				rv.addAll(data);
			}
		}
		return rv;
	}

	@Override
	public List<XGridRowMetaData<@NonNull R>> getRowMetaData() {
		List<XGridRowMetaData<@NonNull R>> rv = new ArrayList<>();
		for( R r : rowList ) {
			List<@NonNull XGridRowMetaData<@NonNull R>> metaData = grid.metaDataFunctionProperty().get().getMetaData(r);
			rv.addAll(metaData);
		}
		return rv;
	}
}
