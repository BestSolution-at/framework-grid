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
package at.bestsolution.framework.grid.func;

import java.util.Locale;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A {@link TranslationFunction} which considers multiple TranslationFunctions.
 * {@link TranslationFunction#translate(Locale, String)} works through each
 * Function and returns the first found translated value
 */
public class CompositeTranslationFunction implements TranslationFunction {
	private final @NonNull TranslationFunction[] functions;

	/**
	 * @param functions
	 *            translation functions
	 */
	public CompositeTranslationFunction(@NonNull TranslationFunction... functions) {
		this.functions = functions;
	}

	@Override
	public String translate(@NonNull Locale locale, @NonNull String key) {
		for (TranslationFunction function : functions) {
			String translated = function.translate(locale, key);
			if (translated != null) {
				return translated;
			}
		}
		return null;
	}
}
