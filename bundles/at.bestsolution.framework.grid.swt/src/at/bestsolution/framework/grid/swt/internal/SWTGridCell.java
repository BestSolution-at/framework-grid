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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.XGridCell;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.XGridMetaData;

public class SWTGridCell<R,C> implements XGridCell<R, C> {
	@NonNull
	private final R row;

	@NonNull
	private final XGridColumn<R, C> column;

	public SWTGridCell(@NonNull R row, @NonNull XGridColumn<R, C> column) {
		this.row = row;
		this.column = column;
	}

	@Override
	public @NonNull R getRowValue() {
		return row;
	}

	@Override
	public @Nullable C getCellValue() {
		return column.cellValueFunctionProperty().get().apply(row);
	}

	@Override
	public @NonNull XGridColumn<R, C> getColumn() {
		return column;
	}

	@Override
	public @NonNull List<@NonNull XGridMetaData> getMetaData() {
		return column.metaDataFunctionProperty().get().getMetaData(row, getCellValue());
	}

}
