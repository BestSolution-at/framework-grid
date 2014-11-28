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
package at.bestsolution.framework.grid.component.emf.internal;

import org.eclipse.jdt.annotation.NonNull;

import at.bestsolution.framework.grid.XGridTable;
import at.bestsolution.framework.grid.component.XGridTableConfiguration;
import at.bestsolution.framework.grid.component.XGridTableConfigurator;
import at.bestsolution.framework.grid.component.emf.EmfXGridTableConfiguration;
import at.bestsolution.framework.grid.emf.EmfGridTableConfigurator;

/**
 * Configuration which works with the {@link EmfXGridTableConfiguration}
 */
public class EmfXGridTableConfigurator implements XGridTableConfigurator {

	@Override
	public boolean applies(@NonNull XGridTableConfiguration configuration) {
		return configuration instanceof EmfXGridTableConfiguration;
	}

	@Override
	public <R> XConfiguredGridTable<R> configure(@NonNull XGridTable<R> grid, @NonNull XGridTableConfiguration configuration) {
		@SuppressWarnings("null")
		EmfGridTableConfigurator<R> configurator = new EmfGridTableConfigurator<R>(grid, ((EmfXGridTableConfiguration)configuration).getConfigurationSet());

		return new XConfiguredGridTable<R>() {

			@SuppressWarnings("null")
			@Override
			public void reconfigure(@NonNull XGridTableConfiguration configuration) {
				configurator.setConfiguration(((EmfXGridTableConfiguration)configuration).getConfigurationSet());
			}
		};
	}

}
