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
package at.bestsolution.framework.grid.component;

import org.eclipse.jdt.annotation.NonNull;

import at.bestsolution.framework.grid.XGridTable;

/**
 * Service applying a given configuration on a grid
 */
public interface XGridTableConfigurator {
	/**
	 * Check if the configuration applies to this configurator
	 *
	 * @param configuration
	 *            the configuration
	 * @return <code>true</code> if the configuration applies
	 */
	public boolean applies(@NonNull XGridTableConfiguration configuration);

	/**
	 * Configure the grid instance from the given configuration
	 *
	 * @param grid
	 *            the grid to configure
	 * @param configuration
	 *            the configuration
	 * @return the configure instance
	 */
	public <R> XConfiguredGridTable<R> configure(@NonNull XGridTable<R> grid, @NonNull XGridTableConfiguration configuration);

	/**
	 * Configure grid instance which allows to reconfigure
	 *
	 * @param <R>
	 *            the type
	 */
	public interface XConfiguredGridTable<R> {
		/**
		 * Reconfigure the grid with a new configuration
		 *
		 * @param configuration
		 *            the configuration
		 */
		public void reconfigure(@NonNull XGridTableConfiguration configuration);
	}
}
