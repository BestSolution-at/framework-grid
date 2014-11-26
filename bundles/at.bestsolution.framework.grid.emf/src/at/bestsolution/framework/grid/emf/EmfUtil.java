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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.Util;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.func.AutoFilterEntry;
import at.bestsolution.framework.grid.func.CellValueMatcherFunction;
import at.bestsolution.framework.grid.func.TranslationFunction;
import at.bestsolution.framework.grid.model.grid.MAutoFilterEntry;
import at.bestsolution.framework.grid.model.grid.MDefaultAutoFilterEntry;
import at.bestsolution.framework.grid.model.grid.MGrid;
import at.bestsolution.framework.grid.model.grid.MResourceBundle;
import at.bestsolution.framework.grid.model.grid.MResourceBundleEntry;
import at.bestsolution.framework.grid.model.grid.MTextAutoFilterEntry;

/**
 * EMF configuration Utilities
 */
public class EmfUtil {
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
			public @Nullable String translate(@NonNull Locale locale, @NonNull String key) {
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

	/**
	 * @param mEntries
	 *            entries defined from presentation model
	 * @param column
	 *            the corresponding column
	 * @param translationFunction
	 *            translation function
	 * @return a supplier for default entries
	 */
	public static <@NonNull R, @Nullable C> @NonNull Supplier<@NonNull List<@NonNull AutoFilterEntry<@NonNull R, @Nullable C, @NonNull Object>>> createFilterDataSupplier(
			@NonNull List<@NonNull MAutoFilterEntry> mEntries, @NonNull XGridColumn<@NonNull R, @Nullable C> column,
			@NonNull TranslationFunction translationFunction) {
		return new Supplier<@NonNull List<@NonNull AutoFilterEntry<@NonNull R, @Nullable C, @NonNull Object>>>() {
			@Override
			public @NonNull List<@NonNull AutoFilterEntry<@NonNull R, @Nullable C, @NonNull Object>> get() {
				List<@NonNull AutoFilterEntry<@NonNull R, @Nullable C, @NonNull Object>> entries = new ArrayList<>();
				for (MAutoFilterEntry entry : mEntries) {
					@SuppressWarnings("null")
					@NonNull
					String resourceKey = entry.getResourceKey();
					final String name = translationFunction.translate(column.getGrid().localeProperty().get(), resourceKey);
					if (name == null) {
						throw new IllegalArgumentException("no translation found for resource key: " + resourceKey); //$NON-NLS-1$
					}

					@NonNull
					final CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull Object> matcher;
					if (entry instanceof MTextAutoFilterEntry) {
						matcher = Util.<R, C, Object> defaultToStringMatcher();
					} else if (entry instanceof MDefaultAutoFilterEntry) {
						MDefaultAutoFilterEntry defEntry = (MDefaultAutoFilterEntry) entry;
						if (defEntry.getType() != null) {
							switch (defEntry.getType()) {
							case ALL:
								matcher = Util.defaultTrueMatcher();
								break;
							case EMPTY:
								matcher = Util.defaultEmptyMatcher(column.textFunctionProperty());
								break;
							case NOT_EMPTY:
								matcher = Util.defaultNotEmptyMatcher(column.textFunctionProperty());
								break;
							default:
								throw new UnsupportedOperationException("unknown autofilter default entry type: " + defEntry.getType()); //$NON-NLS-1$
							}
						} else {
							throw new UnsupportedOperationException("autofilter default entry type is not set: " + defEntry); //$NON-NLS-1$
						}
					} else {
						throw new UnsupportedOperationException("unknown autofilter entry type: " + entry); //$NON-NLS-1$
					}

					entries.add(new AutoFilterEntry<@NonNull R, @Nullable C, @NonNull Object>() {
						@Override
						public @NonNull String getName() {
							return name;
						}

						@Override
						public @NonNull CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull Object> getMatcher() {
							return matcher;
						}
					});
				}
				return entries;
			}
		};
	}
}
