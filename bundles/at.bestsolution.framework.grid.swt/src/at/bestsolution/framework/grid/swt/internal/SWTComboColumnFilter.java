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
package at.bestsolution.framework.grid.swt.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import at.bestsolution.framework.grid.XGridColumn.AutoFilterType;
import at.bestsolution.framework.grid.func.AutoFilterEntry;
import at.bestsolution.framework.grid.func.CellDataFunction;
import at.bestsolution.framework.grid.func.CellValueMatcherFunction;
import at.bestsolution.framework.grid.swt.SWTGridColumn;

/**
 * @param <R>
 *            row type
 * @param <C>
 *            cell type
 */
public class SWTComboColumnFilter<R, C> implements SWTColumnFilter<R, C> {
	private final @NonNull Map<@NonNull Integer, @NonNull AutoFilterEntry<@NonNull R,@Nullable C,@NonNull Object> > autoFilterComboContent = new HashMap<>();
	private final @NonNull CCombo combo;
	private final @NonNull SWTGridColumn<R, C> column;

	/**
	 * @param column
	 *            the corresponding column
	 */
	public SWTComboColumnFilter(@NonNull SWTGridColumn<R, C> column) {
		this.column = column;
		combo = new CCombo(column.getNebulaColumn().getParent(), SWT.READ_ONLY | SWT.BORDER);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				column.getContentHandler().filter();
			}
		});
		column.getNebulaColumn().setHeaderControl(combo);
		updateFilterComboContent();
		column.autoFilterDataSupplierProperty().addChangeListener((property, oldValue, newValue) -> updateFilterComboContent());
		// translated values need refresh
		column.getGrid().localeProperty().addChangeListener((property, oldValue, newValue) -> updateFilterComboContent());
		// new input needs filter update
		column.getGrid().contentProviderProperty().addChangeListener((property, oldValue, newValue) -> updateFilterComboContent());
	}

	@Override
	public boolean matches(@NonNull R element) {
		int selectionIndex = combo.getSelectionIndex();
		if (selectionIndex < 0) {
			return true; // nothing selected
		} else {
			AutoFilterEntry<@NonNull R,@Nullable C,@NonNull Object>  filterEntry = autoFilterComboContent.get(new Integer(selectionIndex));
			CellValueMatcherFunction<R, @Nullable C, Object> matcher = filterEntry.getMatcher();
			return matcher.apply(element, column.cellValueFunctionProperty().get().apply(element), filterEntry.getName());
		}
	}

	private void updateFilterComboContent() {
		if (column.autoFilterTypeProperty().get() == AutoFilterType.DROPDOWN) {
			combo.removeAll();
			autoFilterComboContent.clear();
			// add default entries
			int index = 0;
			for (AutoFilterEntry<@NonNull R,@Nullable C,@NonNull Object>  entry : column.autoFilterDataSupplierProperty().get().get()) {
				combo.add(entry.getName());
				autoFilterComboContent.put(new Integer(index), entry);
				index++;
			}

			@NonNull
			CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence> textFunction;
			@Nullable
			CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence> autoFilterTextFunction = column
					.autoFilterTextFunctionProperty().get();
			if (autoFilterTextFunction != null) {
				textFunction = autoFilterTextFunction;
			} else {
				textFunction = column.textFunctionProperty().get();
			}

			Set<CharSequence> otherEntries = new TreeSet<>();
			for (R element : column.getContentHandler().getVisibleElements()) {
				@Nullable
				CharSequence text = textFunction.apply(element, column.cellValueFunctionProperty().get().apply(element));
				if (text != null) {
					otherEntries.add(text);
				}
			}
			for (CharSequence text : otherEntries) {
				combo.add(text.toString());
				autoFilterComboContent.put(new Integer(index), new ComboAutoFilterEntry<Object>(text, textFunction));
				index++;
			}
		}
	}

	private class ComboAutoFilterEntry<@NonNull O> implements AutoFilterEntry<@NonNull R,@Nullable C,@NonNull O>  {
		private final @NonNull CharSequence text;
		private final @NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence> textFunction;

		public ComboAutoFilterEntry(@NonNull CharSequence text,
				@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence> textFunction) {
			this.text = text;
			this.textFunction = textFunction;
		}

		@SuppressWarnings("null")
		@Override
		public @NonNull String getName() {
			return text.toString();
		}

		@Override
		public @NonNull CellValueMatcherFunction<@NonNull R, @Nullable C, O> getMatcher() {
			return (row, cellValue, filterData) -> text.equals(textFunction.apply(row, cellValue));
		}
	}
}
