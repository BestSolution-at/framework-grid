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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.Property.ChangeListener;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.func.CellDataFunction;
import at.bestsolution.framework.grid.func.TranslationFunction;

/**
 * Number formatter function.
 * 
 * @param <R>
 *            row type
 * @param <C>
 *            data type
 */
public class LocalizedDecimalCellDataFunction<R, C> implements
		CellDataFunction<R, C, @Nullable CharSequence> {
	@NonNull
	DecimalFormat format;

	/**
	 * @param column
	 *            grid column
	 * @param patternKey
	 *            pattern key
	 * @param translationFunction
	 * @param localeProperty
	 *            locale property
	 */
	public LocalizedDecimalCellDataFunction(@NonNull XGridColumn<R, C> column,
			@NonNull String patternKey,
			@NonNull TranslationFunction translationFunction,
			@NonNull Property<@NonNull Locale> localeProperty) {
		format = createFormat(localeProperty.get(), patternKey,
				translationFunction);
		localeProperty.addChangeListener(new ChangeListener<@NonNull Locale>() {
			@Override
			public void valueChanged(Property<@NonNull Locale> property,
					@NonNull Locale oldValue, @NonNull Locale newValue) {
				format = createFormat(newValue, patternKey, translationFunction);
				column.requestUpdate();
			}
		});
	}

	/**
	 * create new {@link DecimalFormat} instance localized with given locale
	 * 
	 * @param locale
	 *            format locale
	 * @param pattern
	 *            format pattern
	 * @return created format
	 */
	@NonNull
	static DecimalFormat createFormat(@NonNull Locale locale,
			@NonNull String patternKey,
			@NonNull TranslationFunction translationFunction) {
		String pattern = translationFunction.translate(locale, patternKey);
		if (pattern == null) {
			throw new IllegalArgumentException(
					"Could not resolve pattern for Locale=" + locale + ", key=" + patternKey); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return new DecimalFormat(pattern,
				DecimalFormatSymbols.getInstance(locale));
	}

	@Override
	public CharSequence apply(R row, C number) {
		if (number != null) {
			return format.format(number);
		} else {
			return null;
		}
	}
}
