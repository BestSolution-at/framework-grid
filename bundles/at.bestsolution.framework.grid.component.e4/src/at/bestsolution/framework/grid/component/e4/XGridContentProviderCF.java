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

import at.bestsolution.framework.grid.component.XGridContentProviderProvider;
import at.bestsolution.framework.grid.component.XGridContentProviderProviderLookup;

/**
 * Context function to supply an {@link XGridContentProviderCF} on request
 */
public class XGridContentProviderCF extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		XGridContentProviderProviderLookup lookup = context.get(XGridContentProviderProviderLookup.class);
		MPart part = context.get(MPart.class);
		Optional<XGridContentProviderProvider> contentProvider = lookup.getContentProvider(part.getPersistedState().get("xgrid.content")); //$NON-NLS-1$
		if( contentProvider.isPresent() ) {
			String descriptor = part.getPersistedState().get("xgrid.content"); //$NON-NLS-1$
			if( descriptor != null ) {
				contentProvider.get().getContentProvider(descriptor);
			}
			return null;
		}
		return super.compute(context, contextKey);
	}
}
