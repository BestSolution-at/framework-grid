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
package at.bestsolution.framework.grid.component.e4;

import java.util.Optional;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;

import at.bestsolution.framework.grid.component.XGridTableConfiguration;
import at.bestsolution.framework.grid.component.XGridTableConfigurationProvider;
import at.bestsolution.framework.grid.component.XGridTableConfigurationProviderLookup;

/**
 * Context function to load a {@link XGridTableConfiguration} on request
 */
public class XGridTableConfigurationCF extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		MPart mPart = context.get(MPart.class);

		XGridTableConfiguration config = (XGridTableConfiguration) context.get("_cached_config"); //$NON-NLS-1$
		if( config != null ) {
			return config;
		}

		String xconfig = mPart.getPersistedState().get("xgrid.configuration"); //$NON-NLS-1$
		Optional<XGridTableConfigurationProvider> provider = context.get(XGridTableConfigurationProviderLookup.class).getTableConfigurationProvider(xconfig);
		if( provider.isPresent() ) {
			XGridTableConfiguration loadConfiguration = provider.get().loadConfiguration(xconfig);
			context.set("_cached_config", loadConfiguration); //$NON-NLS-1$
			return loadConfiguration;
		}

		return null;
	}
}
