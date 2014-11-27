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
package at.bestsolution.framework.grid.swt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;

import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.Util;
import at.bestsolution.framework.grid.XGrid;
import at.bestsolution.framework.grid.XGridCell;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.XGridContentProvider;
import at.bestsolution.framework.grid.XGridTable;
import at.bestsolution.framework.grid.swt.internal.SWTGridContentHandler;
import at.bestsolution.framework.grid.swt.internal.SimpleProperty;

/**
 * An SWT implementation of the table
 *
 * @param <R>
 *            the row type
 */
public class SWTGridTable<R> implements XGridTable<R> {
	@SuppressWarnings("all")
	private @NonNull Property<@NonNull SelectionMode> selectionModeProperty = new SimpleProperty<>(SelectionMode.SINGLE_ROW);
	@NonNull
	Property<@Nullable XGridContentProvider<R>> contentProviderProperty = new SimpleProperty<>(null);
	@NonNull
	Property<@NonNull Selection<@Nullable R, @Nullable R>> selectionProperty = new SimpleProperty<>(Util.emptySelection());
	@SuppressWarnings("null")
	private @NonNull Property<@NonNull Locale> localeProperty = new SimpleProperty<>(Locale.getDefault());

	protected @NonNull Grid nebulaGrid;
	final List<@NonNull SWTGridColumn<R, ?>> columns = new ArrayList<>();
	private final @NonNull SWTGridContentHandler<R> contentHandler;

	/**
	 * SWT Grid
	 * 
	 * @param parent
	 *            parent composite
	 * @param style
	 *            SWT style
	 */
	public SWTGridTable(Composite parent, int style) {
		nebulaGrid = new Grid(parent, style);
		nebulaGrid.setHeaderVisible(true);
		contentHandler = new SWTGridContentHandler<R>(this, nebulaGrid);
		registerSelectionListener();
		registerPropertyListeners();
	}

	@SuppressWarnings("null")
	@Override
	public <C> @NonNull XGridColumn<@NonNull R, @Nullable C> createColumn(String id,
			@NonNull Function<@NonNull R, @Nullable C> cellValueFunction) {
		SWTGridColumn<@NonNull R, @Nullable C> swtGridColumn = new SWTGridColumn<@NonNull R, @Nullable C>(this, cellValueFunction);
		columns.add(swtGridColumn);
		return swtGridColumn;
	}

	@Override
	public @NonNull Property<@NonNull SelectionMode> selectionModeProperty() {
		return selectionModeProperty;
	}

	@Override
	public @NonNull Property<@Nullable Comparator<@NonNull R>> defaultSortProperty() {
		return contentHandler.defaultSortProperty();
	}

	@Override
	public @NonNull Property<@Nullable XGridContentProvider<R>> contentProviderProperty() {
		return contentProviderProperty;
	}

	@Override
	public @NonNull Property<@NonNull Selection<@Nullable R, @Nullable R>> selectionProperty() {
		return selectionProperty;
	}

	@Override
	public @NonNull Property<@NonNull Locale> localeProperty() {
		return localeProperty;
	}

	/**
	 * @return the nebulaGrid widget
	 */
	public Grid getNebulaGrid() {
		return nebulaGrid;
	}

	/**
	 * register property listeners
	 */
	private void registerPropertyListeners() {
		selectionModeProperty.addChangeListener((property, oldValue, newValue) -> applySelectionMode(newValue));
	}

	private void applySelectionMode(SelectionMode newSelectionMode) {
		if (newSelectionMode == null) {
			nebulaGrid.setCellSelectionEnabled(false);
		} else {
			switch (newSelectionMode) {
			case SINGLE_CELL:
				nebulaGrid.setCellSelectionEnabled(true);
				break;
			case SINGLE_ROW:
			default:
				nebulaGrid.setCellSelectionEnabled(false);
			}
		}
	}

	private void registerSelectionListener() {
		nebulaGrid.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				@SuppressWarnings("null")
				@NonNull
				GridItem[] selection = nebulaGrid.getSelection();
				if (selection == null || selection.length == 0) {
					selectionProperty.set(Util.emptySelection());
				} else if (selection.length == 1) {
					R selectedRow = getContentHandler().get(selection[0]);
					XGridColumn<R, R> b = null; // TODO
					selectionProperty.set(new SimpleSelection<R, R>(selectedRow, b, selectedRow));
				} else {
					// multiple row selection is not supported
					e.doit = false;
				}
			}
		});
	}

	/**
	 * @return grid columns
	 */
	@NonNull
	@SuppressWarnings("all")
	@Override
	public List<@NonNull XGridColumn<@NonNull R, @Nullable ?>> getColumns() {
		return Collections.unmodifiableList(columns);
	}

	static class SimpleSelection<R, O> implements Selection<R, O> {
		private final @Nullable R r;
		private final O c;

		SimpleSelection(@Nullable R r, XGridColumn<R, O> column, O c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public O getFirst() {
			return c;
		}

		@SuppressWarnings("null")
		@Override
		public @NonNull List<@NonNull O> asList() {
			return Arrays.asList(c);
		}

		@Override
		public boolean isEmpty() {
			return false;
		}

		@Override
		public <C> XGrid.@NonNull Selection<R, XGridCell<R, C>> asCellSelection() {
			@Nullable
			XGridCell<R, C> a = null;
			XGridColumn<R, XGridCell<R, C>> col = null;
			return new SimpleSelection<R, XGridCell<R, C>>(r, col, a);
		}
	}

	@Override
	public void dispose() {
		for (@NonNull
		XGridColumn<@NonNull R, @Nullable ?> col : getColumns()) {
			col.dispose();
		}
		nebulaGrid.dispose();
		selectionModeProperty.dispose();
		contentProviderProperty.dispose();
		selectionProperty.dispose();
		localeProperty.dispose();
	}

	/**
	 * @return the content handler
	 */
	public @NonNull SWTGridContentHandler<R> getContentHandler() {
		return contentHandler;
	}

	@Override
	public @NonNull Object[][] getData() {
		return contentHandler.getData(true);
	}
}
