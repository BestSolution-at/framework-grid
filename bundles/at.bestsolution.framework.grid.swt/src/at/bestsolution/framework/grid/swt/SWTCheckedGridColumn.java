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

import java.util.function.Function;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;

/**
 * SWT checked column implementation
 *
 * @param <R>
 *            row type
 */
public class SWTCheckedGridColumn<R> extends SWTGridColumn<R, Boolean> {
	/**
	 * Create a new checked column
	 *
	 * @param grid
	 *            the containing grid
	 * @param cellValueFunction
	 *            the value function
	 */
	public SWTCheckedGridColumn(@NonNull SWTGridTable<@NonNull R> grid, @NonNull Function<@NonNull R, @Nullable Boolean> cellValueFunction) {
		super(grid, cellValueFunction, SWT.CHECK);
		getNebulaColumn().setCheckable(true);
	}

	/**
	 * @param item
	 *            grid item
	 * @param element
	 *            row element
	 */
	@Override
	protected void fillGridItem(@NonNull GridItem item, @NonNull R element) {
		Boolean value = cellValueFunctionProperty().get().apply(element);
		final int index = indexProperty().get().intValue();
		item.setCheckable(index, false);
		if (value != null) {
			item.setChecked(index, value.booleanValue());
			
		} 
	}
}
