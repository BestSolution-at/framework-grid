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

import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.XGridMetaData;
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

	/**
	 * @param rowList
	 *            selected rows
	 * @param columnList
	 *            selected columns
	 */
	public SimpleSelection(@NonNull List<@NonNull R> rowList, @NonNull List<@NonNull XGridColumn<R, ?>> columnList) {
		this.rowList = rowList;
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
	public @NonNull List<@NonNull XGridMetaData> getMetaData() {
		List<@NonNull XGridMetaData> rv = new ArrayList<>();
		for (R r : rowList) {
			for (XGridColumn<R, ?> c : columnList) {
				List<@NonNull XGridMetaData> data = ((XGridColumn<R, Object>) c).metaDataFunctionProperty().get()
						.getMetaData(r, c.cellValueFunctionProperty().get().apply(r));
				rv.addAll(data);
			}
		}
		return rv;
	}
}
