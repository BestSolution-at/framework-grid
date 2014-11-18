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

import at.bestsolution.framework.grid.GridCell;
import at.bestsolution.framework.grid.GridColumn;
import at.bestsolution.framework.grid.GridContentProvider;
import at.bestsolution.framework.grid.GridTable;
import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.Property.ChangeListener;
import at.bestsolution.framework.grid.Util;
import at.bestsolution.framework.grid.swt.internal.SWTGridContentHandler;
import at.bestsolution.framework.grid.swt.internal.SimpleProperty;

/**
 * An SWT implementation of the table
 *
 * @param <R>
 *            the row type
 */
public class SWTGridTable<R> implements GridTable<R> {
	@SuppressWarnings("all")
	private @NonNull Property<@NonNull SelectionMode> selectionModeProperty = new SimpleProperty<>(
			SelectionMode.SINGLE_ROW);
	@NonNull Property<@Nullable GridContentProvider<R>> contentProviderProperty = new SimpleProperty<>(
			null);
	@NonNull
	Property<@NonNull Selection<@Nullable R, @Nullable R>> selectionProperty = new SimpleProperty<>(
			Util.emptySelection());
	@SuppressWarnings("null")
	private @NonNull Property<@NonNull Locale> localeProperty = new SimpleProperty<>(
			Locale.getDefault());

	protected @NonNull Grid nebulaGrid;
	final List<@NonNull SWTGridColumn<R, ?>> columns = new ArrayList<>();
	final @NonNull SWTGridContentHandler<R> contentHandler;

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
	public <C> @NonNull GridColumn<@NonNull R, @Nullable C> createColumn(
			String id,
			@NonNull Function<@NonNull R, @Nullable C> cellValueFunction) {
		SWTGridColumn<@NonNull R, @Nullable C> swtGridColumn = new SWTGridColumn<@NonNull R, @Nullable C>(
				this, cellValueFunction);
		columns.add(swtGridColumn);
		return swtGridColumn;
	}

	@Override
	public @NonNull Property<@NonNull SelectionMode> selectionModeProperty() {
		return selectionModeProperty;
	}

	@Override
	public @NonNull Property<@Nullable Comparator<@NonNull R>> defaultSortProperty() {
		return contentHandler.getDefaultSortProperty();
	}

	@Override
	public @NonNull Property<@Nullable GridContentProvider<R>> contentProviderProperty() {
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
	protected Grid getNebulaGrid() {
		return nebulaGrid;
	}

	/**
	 * register property listeners
	 */
	@SuppressWarnings("null")
	private void registerPropertyListeners() {
		selectionModeProperty
				.addChangeListener(new ChangeListener<at.bestsolution.framework.grid.Grid.SelectionMode>() {
					@Override
					public void valueChanged(Property<SelectionMode> property,
							@Nullable SelectionMode oldValue,
							@Nullable SelectionMode newValue) {
						if (newValue == null) {
							nebulaGrid.setCellSelectionEnabled(false);
						} else {
							switch (newValue) {
							case SINGLE_CELL:
								nebulaGrid.setCellSelectionEnabled(true);
								break;
							case SINGLE_ROW:
							default:
								nebulaGrid.setCellSelectionEnabled(false);
							}
						}
					}
				});

		contentProviderProperty
				.addChangeListener(new ChangeListener<GridContentProvider<R>>() {
					@Override
					public void valueChanged(
							Property<GridContentProvider<R>> property,
							@Nullable GridContentProvider<R> oldValue,
							@Nullable GridContentProvider<R> newValue) {
						contentHandler.resetContent(newValue);
					}
				});
		localeProperty.addChangeListener(new ChangeListener<@NonNull Locale>() {
			@Override
			public void valueChanged(Property<@NonNull Locale> property,
					Locale oldValue, Locale newValue) {
				contentHandler.resetContent(contentProviderProperty.get());
			}
		});
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
					R selectedRow = contentHandler.get(selection[0]);
					GridColumn<R, R> b = null; // TODO
					selectionProperty.set(new SimpleSelection<R, R>(
							selectedRow, b, selectedRow));
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
	public List<@NonNull GridColumn<@NonNull R, @Nullable ?>> getColumns() {
		return Collections.unmodifiableList(columns);
	}

	static class SimpleSelection<R, O> implements Selection<R, O> {
		private final @Nullable R r;
		private final GridColumn<R, O> column;
		private final O c;

		SimpleSelection(@Nullable R r, GridColumn<R, O> column, O c) {
			this.r = r;
			this.column = column;
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
		public <C> at.bestsolution.framework.grid.Grid.@NonNull Selection<R, GridCell<R, C>> asCellSelection() {
			@Nullable
			GridCell<R, C> a = null;
			GridColumn<R, GridCell<R, C>> col = null;
			return new SimpleSelection<R, GridCell<R, C>>(r, col, a);
		}
	}
}
