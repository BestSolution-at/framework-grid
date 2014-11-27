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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import at.bestsolution.framework.grid.component.XGridTableConfiguration;
import at.bestsolution.framework.grid.component.XGridTableConfigurationProvider;
import at.bestsolution.framework.grid.component.emf.EmfXGridTableConfiguration;
import at.bestsolution.framework.grid.model.grid.MGrid;
import at.bestsolution.framework.grid.model.grid.MGridConfigurationSet;

/**
 * Provider who loads an emf-resource
 */
public class EmfResourceXGridTableConfigurationProvider implements XGridTableConfigurationProvider {

	@Override
	public boolean applies(String description) {
		return description.startsWith("emf-resource:"); //$NON-NLS-1$
	}

	@Override
	public XGridTableConfiguration loadConfiguration(String description) {
		URI uri = URI.createURI(description.substring("emf-resource:".length())); //$NON-NLS-1$
		ResourceSet s = new ResourceSetImpl();
		Resource r = s.getResource(uri, true);

		return new EmfXGridTableConfiguration() {

			@Override
			public MGridConfigurationSet getConfigurationSet() {
				return ((MGrid)r.getContents().get(0)).getDefaultConfiguration();
			}

		};
	}

}
