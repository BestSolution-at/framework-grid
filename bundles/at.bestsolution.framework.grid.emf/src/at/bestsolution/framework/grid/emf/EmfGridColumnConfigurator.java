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

import at.bestsolution.framework.grid.DefaultSortComparator;
import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.Property.ChangeListener;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.XGridColumn.Alignment;
import at.bestsolution.framework.grid.XGridColumn.AutoFilterType;
import at.bestsolution.framework.grid.XGridColumn.SortingBehavior;
import at.bestsolution.framework.grid.func.CellDataFunction;
import at.bestsolution.framework.grid.func.CompositeTranslationFunction;
import at.bestsolution.framework.grid.func.TranslationFunction;
import at.bestsolution.framework.grid.model.grid.MAutoFilterConfiguration;
import at.bestsolution.framework.grid.model.grid.MCellTextFunction;
import at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration;
import at.bestsolution.framework.grid.model.grid.MFormatType;
import at.bestsolution.framework.grid.model.grid.MFormattedCellTextFunction;
import at.bestsolution.framework.grid.model.grid.MFreeTextAutoFilterConfiguration;
import at.bestsolution.framework.grid.model.grid.MGrid;
import at.bestsolution.framework.grid.model.grid.MGridConfigurationColumn;
import at.bestsolution.framework.grid.model.grid.MPattern;
import at.bestsolution.framework.grid.model.grid.MReferencePattern;
import at.bestsolution.framework.grid.model.grid.MSortingBehavior;
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
	private @NonNull final XGridColumn<R, C> column;

	private final MGridConfigurationColumn config;

	private final @NonNull TranslationFunction translationFunction;

	private ChangeListener<@NonNull Locale> localeChangelistener;

	/**
	 * EMF Model column configurator
	 * 
	 * @param column
	 *            the column to configure
	 * @param config
	 *            column configuration
	 */
	public EmfGridColumnConfigurator(@NonNull XGridColumn<@NonNull R, @Nullable C> column, @NonNull MGridConfigurationColumn config) {
		if (config.getColumn() == null) {
			throw new IllegalArgumentException("invalid column configuration: no column"); //$NON-NLS-1$
		}
		this.column = column;
		this.config = config;
		translationFunction = createTranslationFunction();
		apply();
		registerPropertyListeners();
	}

	/**
	 * register property listeners on grid instance to immediate apply
	 * configuration changes
	 */
	private void registerPropertyListeners() {
		localeChangelistener = new ChangeListener<@NonNull Locale>() {
			@Override
			public void valueChanged(Property<@NonNull Locale> property, @NonNull Locale oldValue, @NonNull Locale newValue) {
				if (!oldValue.equals(newValue)) {
					applyHeaderTitle();
				}
			}
		};
		column.getGrid().localeProperty().addChangeListener(localeChangelistener);
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

		applyAutoFilter();

		applySortingBehavior();
		// TODO add missing features
	}

	private void applySortingBehavior() {
		MSortingBehavior sortingBehavior = config.getColumn().getSortingBehavior();
		if (sortingBehavior != null) {
			switch (sortingBehavior) {
			case UP_DOWN_DEFAULT:
				column.sortingBehaviorProperty().set(SortingBehavior.UP_DOWN_DEFAULT);
				break;
			case UP_DOWN:
				column.sortingBehaviorProperty().set(SortingBehavior.UP_DOWN);
				break;
			default:
				throw new UnsupportedOperationException("unknown sorting behavior type: " + sortingBehavior); //$NON-NLS-1$}
			}
		}
	}

	private void applyAutoFilter() {
		if (config.getColumn().getAutoFilterConfiguration() != null) {
			MAutoFilterConfiguration filterConf = config.getColumn().getAutoFilterConfiguration();
			if (filterConf instanceof MComboAutoFilterConfiguration) {
				// MComboAutoFilterConfiguration comboConf =
				// (MComboAutoFilterConfiguration) filterConf;
				// column.autoFilterTypeProperty().set(AutoFilterType.DROPDOWN);
				// TODO
				column.autoFilterDataSupplierProperty();
				column.autoFilterMatcherFunctionProperty();
				column.autoFilterTextFunctionProperty();
			} else if (filterConf instanceof MFreeTextAutoFilterConfiguration) {
				MFreeTextAutoFilterConfiguration textConf = (MFreeTextAutoFilterConfiguration) filterConf;
				column.autoFilterTypeProperty().set(AutoFilterType.TEXT);
				if (textConf.getMatchType() != null) {
					switch (textConf.getMatchType()) {
					case SUBSTRING:
						column.autoFilterMatcherFunctionProperty().set(
								at.bestsolution.framework.grid.Util.defaultSubstringMatcher(column.textFunctionProperty()));
						break;
					default:
						throw new UnsupportedOperationException("unknown autofilter matcher type: " + textConf.getMatchType()); //$NON-NLS-1$}
					}
				}
				column.autoFilterTextFunctionProperty();
			}
		} else {
			column.autoFilterTypeProperty().set(AutoFilterType.NONE);
		}
	}

	/**
	 * apply text function configuration to grid
	 */
	void applyTextFunction() {
		Property<@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence>> textFunctionProperty = column
				.textFunctionProperty();
		MCellTextFunction cellTextFunction = config.getColumn().getCellTextFunction();

		boolean wasSet = false;
		if (cellTextFunction != null) {
			if (cellTextFunction instanceof MFormattedCellTextFunction) {
				MFormattedCellTextFunction formattedCellTextFunction = (MFormattedCellTextFunction) cellTextFunction;
				MPattern pattern = formattedCellTextFunction.getPattern();
				if (pattern != null) {
					if (pattern instanceof MStringPattern) {
						MStringPattern stringPattern = (MStringPattern) pattern;
						String p = stringPattern.getPattern();
						if (p != null) {
							textFunctionProperty.set(createCellDataFunction(column, formattedCellTextFunction.getFormatType(), p));
							wasSet = true;
						}
					} else if (pattern instanceof MReferencePattern) {
						MReferencePattern refPattern = (MReferencePattern) pattern;
						@SuppressWarnings("null")
						@NonNull
						String patternKey = refPattern.getPatternKey();
						textFunctionProperty.set(createLocalizedCellDataFunction(column, formattedCellTextFunction.getFormatType(),
								patternKey, translationFunction));
						wasSet = true;
					} else {
						throw new UnsupportedOperationException("unknown pattern type: " + pattern); //$NON-NLS-1$}
					}
				}
			}
		}
		if (!wasSet) {
			textFunctionProperty.set(at.bestsolution.framework.grid.Util.defaultToStringCellDataFunction());
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
	private CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence> createCellDataFunction(@NonNull XGridColumn<R, C> column,
			MFormatType type, @NonNull String pattern) {
		switch (type) {
		case DATE:
			return new DateCellDataFunction<R, C>(column, pattern, column.getGrid().localeProperty());
		case NUMBER:
			return new DecimalCellDataFunction<R, C>(column, pattern, column.getGrid().localeProperty());
		default:
			throw new UnsupportedOperationException("unknown format type: " + type); //$NON-NLS-1$
		}
	}

	/**
	 * create a cell data function depending on type and pattern, where the
	 * pattern is locale dependent
	 * 
	 * @param type
	 *            format type
	 * @param pattern
	 *            format pattern
	 * @return cell data function
	 */
	@NonNull
	private CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence> createLocalizedCellDataFunction(
			@NonNull XGridColumn<R, C> column, MFormatType type, @NonNull String pattern, @NonNull TranslationFunction tFunction) {
		switch (type) {
		case DATE:
			return new LocalizedDateCellDataFunction<R, C>(column, pattern, tFunction, column.getGrid().localeProperty());
		case NUMBER:
			return new LocalizedDecimalCellDataFunction<R, C>(column, pattern, tFunction, column.getGrid().localeProperty());
		default:
			throw new UnsupportedOperationException("unknown format type: " + type); //$NON-NLS-1$
		}
	}

	/**
	 * apply autoWidth to grid
	 */
	private void applyAutoWidth() {
		column.autoWidthProperty().set(new Boolean(config.getColumn().isAutoWidth()));
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
			throw new UnsupportedOperationException("unknown alignment type: " + config.getColumn().getAlignment()); //$NON-NLS-1$
		}
	}

	/**
	 * apply header title
	 */
	void applyHeaderTitle() {
		@SuppressWarnings("null")
		@NonNull
		String key = config.getColumn().getTitleKey();
		column.labelProperty().set(translationFunction.translate(getLocale(), key));
	}

	private @NonNull Locale getLocale() {
		return column.getGrid().localeProperty().get();
	}

	@NonNull
	private TranslationFunction createTranslationFunction() {
		// TODO add TranslationFunction fallback
		@SuppressWarnings("null")
		@NonNull
		MGrid grid = config.getColumn().getGrid();
		return new CompositeTranslationFunction(Util.createTranslationFunction(grid));
	}

	/**
	 * @return a default comparator instance for sorting this column
	 */
	public @NonNull Comparator<@NonNull R> createDefaultComparator() {
		return new DefaultSortComparator<R, C>(column);
	}

	/**
	 * dispose column configurator
	 */
	public void dispose() {
		column.getGrid().localeProperty().removeChangeListener(localeChangelistener);
	}
}
