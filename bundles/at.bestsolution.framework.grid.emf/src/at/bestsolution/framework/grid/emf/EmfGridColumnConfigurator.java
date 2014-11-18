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

import java.util.Comparator;
import java.util.Locale;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.GridColumn;
import at.bestsolution.framework.grid.GridColumn.Alignment;
import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.Property.ChangeListener;
import at.bestsolution.framework.grid.func.CellDataFunction;
import at.bestsolution.framework.grid.model.grid.MCellTextFunction;
import at.bestsolution.framework.grid.model.grid.MFormatType;
import at.bestsolution.framework.grid.model.grid.MFormattedCellTextFunction;
import at.bestsolution.framework.grid.model.grid.MGrid;
import at.bestsolution.framework.grid.model.grid.MGridConfigurationColumn;
import at.bestsolution.framework.grid.model.grid.MPattern;
import at.bestsolution.framework.grid.model.grid.MReferencePattern;
import at.bestsolution.framework.grid.model.grid.MStringPattern;

/**
 * configure a grid column instance
 *
 * @param <R>
 *            row type
 * @param <C>
 *            cell type
 */
public class EmfGridColumnConfigurator<@NonNull R, @Nullable C> {
	private @NonNull final GridColumn<R, C> column;

	private final MGridConfigurationColumn config;

	/**
	 * EMF Model column configurator
	 * 
	 * @param column
	 *            the column to configure
	 * @param config
	 *            column configuration
	 */
	public EmfGridColumnConfigurator(
			@NonNull GridColumn<@NonNull R, @Nullable C> column,
			@NonNull MGridConfigurationColumn config) {
		if (config.getColumn() == null) {
			throw new IllegalArgumentException(
					"invalid column configuration: no column"); //$NON-NLS-1$
		}
		this.column = column;
		this.config = config;
		apply();
		registerPropertyListeners();
	}

	/**
	 * register property listeners on grid instance to immediate apply
	 * configuration changes
	 */
	private void registerPropertyListeners() {
		column.getGrid().localeProperty()
				.addChangeListener(new ChangeListener<@NonNull Locale>() {
					@Override
					public void valueChanged(
							Property<@NonNull Locale> property,
							@NonNull Locale oldValue, @NonNull Locale newValue) {
						if (!oldValue.equals(newValue)) {
							applyHeaderTitle();
							applyTextFunction();
						}
					}
				});
	}

	/**
	 * apply configuration to column
	 */
	private void apply() {
		applyAlignment();
		applyHeaderTitle();
		applyMinWidth();
		applyMaxWidth();
		applyAutoWidth();
		applyTextFunction();
		// TODO add missing features
	}

	/**
	 * apply text function configuration to grid
	 */
	void applyTextFunction() {
		MCellTextFunction cellTextFunction = config.getColumn()
				.getCellTextFunction();
		if (cellTextFunction != null) {
			if (cellTextFunction instanceof MFormattedCellTextFunction) {
				MFormattedCellTextFunction formattedCellTextFunction = (MFormattedCellTextFunction) cellTextFunction;
				MPattern pattern = formattedCellTextFunction.getPattern();
				if (pattern != null) {
					if (pattern instanceof MStringPattern) {
						MStringPattern stringPattern = (MStringPattern) pattern;
						String p = stringPattern.getPattern();
						if (p != null) {
							column.textFunctionProperty().set(
									createCellDataFunction(
											formattedCellTextFunction
													.getFormatType(), p));
						}
					} else if (pattern instanceof MReferencePattern) {
						MReferencePattern refPattern = (MReferencePattern) pattern;
						@SuppressWarnings("null")
						@NonNull
						String patternKey = refPattern.getPatternKey();
						String p = getTranslation(getLocale(), patternKey);
						if (p != null) {
							column.textFunctionProperty().set(
									createCellDataFunction(
											formattedCellTextFunction
													.getFormatType(), p));
						}
						throw new UnsupportedOperationException(
								"reference pattern is not implemented: " + pattern); //$NON-NLS-1$
					} else {
						throw new UnsupportedOperationException(
								"unknown pattern type: " + pattern); //$NON-NLS-1$}
					}
				}
			}
		}
	}

	/**
	 * create a cell data function depending on type and pattern
	 * 
	 * @param type
	 *            format type
	 * @param pattern
	 *            format pattern
	 * @return cell data function
	 */
	@NonNull
	private CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence> createCellDataFunction(
			MFormatType type, @NonNull String pattern) {
		switch (type) {
		case DATE:
			return new DateCellDataFunction<R, C>(pattern, column.getGrid()
					.localeProperty());
		case NUMBER:
			return new DecimalCellDataFunction<R, C>(pattern, column.getGrid()
					.localeProperty());
		default:
			throw new UnsupportedOperationException(
					"unknown format type: " + type); //$NON-NLS-1$
		}
	}

	/**
	 * apply autoWidth to grid
	 */
	private void applyAutoWidth() {
		column.autoWidthProperty().set(
				new Boolean(config.getColumn().isAutoWidth()));
	}

	/**
	 * apply minWidth to grid
	 */
	private void applyMinWidth() {
		column.minWidthProperty().set(config.getColumn().getMinWidth());
	}

	/**
	 * apply minWidth to grid
	 */
	private void applyMaxWidth() {
		column.maxWidthProperty().set(config.getColumn().getMaxWidth());
	}

	/**
	 * apply alignment
	 */
	private void applyAlignment() {
		switch (config.getColumn().getAlignment()) {
		case LEFT:
			column.alignmentProperty().set(Alignment.LEFT);
			break;
		case CENTER:
			column.alignmentProperty().set(Alignment.CENTER);
			break;
		case RIGHT:
			column.alignmentProperty().set(Alignment.RIGHT);
			break;
		default:
			throw new UnsupportedOperationException(
					"unknown alignment type: " + config.getColumn().getAlignment()); //$NON-NLS-1$
		}
	}

	/**
	 * apply header title
	 */
	void applyHeaderTitle() {
		@SuppressWarnings("null")
		@NonNull
		String key = config.getColumn().getTitleKey();
		column.labelProperty().set(getTranslation(getLocale(), key));
	}

	private @NonNull Locale getLocale() {
		return column.getGrid().localeProperty().get();
	}

	@Nullable
	private String getTranslation(@NonNull Locale locale, @NonNull String key) {
		@SuppressWarnings("null")
		@NonNull
		MGrid grid = config.getColumn().getGrid();
		String result = Util.getTranslation(grid, locale, key);
		// TODO TranslationFunction fallback
		return result;
	}

	/**
	 * @return a default comparator instance for sorting this column
	 */
	public @NonNull Comparator<@NonNull R> createDefaultComparator() {
		return new DefaultSortComparator<R, C>(column);
	}
}
