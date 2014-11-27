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
package at.bestsolution.framework.grid.swt.e4;

import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import at.bestsolution.framework.grid.XGridTable;
import at.bestsolution.framework.grid.component.XGridFactory;
import at.bestsolution.framework.grid.swt.SWTGridTable;

/**
 * Factory to create a grid
 */
public class SWTGridFactory implements XGridFactory {
	private final Composite parent;

	/**
	 * Create a factory instance
	 *
	 * @param parent
	 *            the parent the grid is created on
	 */
	@Inject
	public SWTGridFactory(Composite parent) {
		this.parent = parent;
	}

	@Override
	public <R> XGridTable<R> createGridTable() {
		return new SWTGridTable<>(parent, SWT.NONE);
	}

}
