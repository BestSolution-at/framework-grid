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
package at.bestsolution.framework.grid.emf;

import java.util.Locale;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.func.TranslationFunction;
import at.bestsolution.framework.grid.model.grid.MGrid;
import at.bestsolution.framework.grid.model.grid.MResourceBundle;
import at.bestsolution.framework.grid.model.grid.MResourceBundleEntry;

/**
 * EMF configuration Utilities
 */
public class Util {
	/**
	 * create a {@link TranslationFunction} which tries to find translations in
	 * the given grid configuration
	 * 
	 * @param grid
	 *            grid configuration
	 * @return TranslationFunction
	 */
	@NonNull
	public static TranslationFunction createTranslationFunction(@NonNull MGrid grid) {
		return new TranslationFunction() {
			@Override
			public @Nullable String translate(@NonNull Locale locale,
					@NonNull String key) {
				for (MResourceBundle b : grid.getResources()) {
					if (b.getLocale().equals(locale.getLanguage())) {
						for (MResourceBundleEntry entry : b.getEntries()) {
							if (key.equals(entry.getKey())) {
								return entry.getValue();
							}
						}
					}
				}
				return null;
			}
		};
	}
}
