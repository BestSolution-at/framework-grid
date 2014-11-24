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

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.Property.ChangeListener;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.func.DisposableCellDataFunction;
import at.bestsolution.framework.grid.func.TranslationFunction;

/**
 * Date formatter function.
 * 
 * @param <R>
 *            row type
 * @param <C>
 *            data type
 */
public class LocalizedDateCellDataFunction<R, C> implements DisposableCellDataFunction<R, C, @Nullable CharSequence> {
	private final @NonNull String patternKey;
	private final @NonNull XGridColumn<R, C> column;
	private final @NonNull TranslationFunction translationFunction;
	private final @NonNull Property<Locale> localeProperty;
	private @NonNull ChangeListener<@NonNull Locale> localeListener;
	@NonNull
	DateFormat format;

	/**
	 * @param column
	 *            grid column
	 * @param patternKey
	 *            pattern key
	 * @param translationFunction
	 * @param localeProperty
	 *            locale property
	 */
	public LocalizedDateCellDataFunction(@NonNull XGridColumn<R, C> column, @NonNull String patternKey,
			@NonNull TranslationFunction translationFunction, @NonNull Property<@NonNull Locale> localeProperty) {
		this.column = column;
		this.patternKey = patternKey;
		this.translationFunction = translationFunction;
		this.localeProperty = localeProperty;
		format = createFormat(localeProperty.get(), patternKey, translationFunction);
		localeListener = this::localeValueChanged;
		localeProperty.addChangeListener(localeListener);
	}

	void localeValueChanged(Property<@NonNull Locale> property, @NonNull Locale oldValue, @NonNull Locale newValue) {
		format = createFormat(property.get(), patternKey, translationFunction);
		column.requestUpdate();
	}

	/**
	 * create new DateFormat instance localized with given locale
	 * 
	 * @param locale
	 *            format locale
	 * @param pattern
	 *            format pattern
	 * @return created format
	 */
	@NonNull
	static DateFormat createFormat(@NonNull Locale locale, @NonNull String patternKey, @NonNull TranslationFunction translationFunction) {
		String pattern = translationFunction.translate(locale, patternKey);
		if (pattern == null) {
			throw new IllegalArgumentException("Could not resolve pattern for Locale=" + locale + ", key=" + patternKey); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return new SimpleDateFormat(pattern, DateFormatSymbols.getInstance(locale));
	}

	@Override
	public CharSequence apply(R row, C date) {
		if (date != null) {
			return format.format(date);
		} else {
			return null;
		}
	}

	@Override
	public void dispose() {
		localeProperty.removeChangeListener(localeListener);
	}
}
