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
import at.bestsolution.framework.grid.func.DisposableCellDataFunction;

/**
 * Number formatter function.
 * 
 * @param <R>
 *            row type
 * @param <C>
 *            data type
 */
public class DecimalCellDataFunction<R, C> implements DisposableCellDataFunction<R, C, @Nullable CharSequence> {
	private final @NonNull String pattern;
	private final @NonNull XGridColumn<R, C> column;
	private final @NonNull Property<Locale> localeProperty;
	private @NonNull ChangeListener<@NonNull Locale> localeListener;
	@NonNull
	DecimalFormat format;

	/**
	 * @param column
	 *            grid column
	 * @param pattern
	 *            pattern;
	 * @param localeProperty
	 *            locale property
	 */
	public DecimalCellDataFunction(@NonNull XGridColumn<R, C> column, @NonNull String pattern,
			@NonNull Property<@NonNull Locale> localeProperty) {
		this.pattern = pattern;
		this.column = column;
		this.localeProperty = localeProperty;
		format = createFormat(localeProperty.get());
		localeListener = this::localeValueChanged;
		localeProperty.addChangeListener(localeListener);
	}

	void localeValueChanged(Property<@NonNull Locale> property, @NonNull Locale oldValue, @NonNull Locale newValue) {
		format = createFormat(newValue);
		column.requestUpdate();
	}

	/**
	 * create new DecimalFormat instance localized with given locale
	 * 
	 * @param locale
	 *            format locale
	 * @return created format
	 */
	@NonNull
	DecimalFormat createFormat(@NonNull Locale locale) {
		return new DecimalFormat(pattern, DecimalFormatSymbols.getInstance(locale));
	}

	@Override
	public CharSequence apply(R row, C number) {
		if (number != null) {
			return format.format(number);
		} else {
			return null;
		}
	}

	@Override
	public void dispose() {
		localeProperty.removeChangeListener(localeListener);
	}
}
