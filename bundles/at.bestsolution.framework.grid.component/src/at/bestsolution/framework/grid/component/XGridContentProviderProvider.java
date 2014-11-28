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

import at.bestsolution.framework.grid.XGridContentProvider;

/**
 * Provider the content provider based on the given descriptor
 */
public interface XGridContentProviderProvider {
	/**
	 * Check if the provider applies to the given descriptor
	 *
	 * @param descriptor
	 *            the descriptor
	 * @return <code>true</code> if the descriptor applies
	 */
	public boolean applies(@NonNull String descriptor);

	/**
	 * Get a content provider for the given descriptor
	 *
	 * @param descriptor
	 *            the descriptor
	 * @return the content provider
	 */
	public <R> @NonNull XGridContentProvider<R> getContentProvider(@NonNull String descriptor);
}
