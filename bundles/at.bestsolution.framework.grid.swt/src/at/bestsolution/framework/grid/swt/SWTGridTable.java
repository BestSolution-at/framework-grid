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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.Util;
import at.bestsolution.framework.grid.XCellSelection;
import at.bestsolution.framework.grid.XGridCell;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.XGridContentProvider;
import at.bestsolution.framework.grid.XGridMetaData;
import at.bestsolution.framework.grid.XGridTable;
import at.bestsolution.framework.grid.XSelection;
import at.bestsolution.framework.grid.swt.internal.SWTGridCell;
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
	@NonNull
	Property<@NonNull SelectionMode> selectionModeProperty = new SimpleProperty<>(SelectionMode.SINGLE_ROW);
	@NonNull
	Property<@Nullable XGridContentProvider<R>> contentProviderProperty = new SimpleProperty<>(null);
	@NonNull
	Property<@NonNull XSelection<@NonNull R>> selectionProperty = new SimpleProperty<>(Util.emptySelection());
	@SuppressWarnings("null")
	private @NonNull Property<@NonNull Locale> localeProperty = new SimpleProperty<>(Locale.getDefault());

	protected @NonNull Grid nebulaGrid;
	final @NonNull List<@NonNull SWTGridColumn<@NonNull R, ?>> columns = new ArrayList<>();
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
		contentHandler = new SWTGridContentHandler<R>(this);
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
	public @NonNull Property<@NonNull XSelection<@NonNull R>> selectionProperty() {
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
				} else {
					if (selectionModeProperty.get() == SelectionMode.SINGLE_ROW) {
						R selectedRow = getSelectedElement();
						List<@NonNull R> singletonList = createSingletonList(selectedRow);
						selectionProperty.set(new SimpleSelection<@NonNull R>(singletonList, columns));
					} else {
						Point[] cellSelection = nebulaGrid.getCellSelection();
						if (cellSelection.length == 0) {
							selectionProperty.set(Util.emptySelection());
						} else {
							nebulaGrid.deselectAllCells();
							nebulaGrid.selectCell(nebulaGrid.getFocusCell());

							R selectedRow = getSelectedElement();
							List<@NonNull R> singletonList = createSingletonList(selectedRow);
							List<XGridCell<@NonNull R, ?>> cellList = new ArrayList<XGridCell<@NonNull R, ?>>();
							Point p = nebulaGrid.getFocusCell();
							@SuppressWarnings("unchecked")
							SWTGridCell<@NonNull R, Object> cell = new SWTGridCell<@NonNull R, Object>(selectedRow,
									(@NonNull XGridColumn<@NonNull R, Object>) columns.get(p.x));
							cellList.add(cell);
							selectionProperty.set(new SimpleCellSelection<@NonNull R>(cellList, singletonList, columns));
						}
					}
				}
			}

			private @NonNull List<@NonNull R> createSingletonList(R selectedRow) {
				@SuppressWarnings("null")
				@NonNull
				List<@NonNull R> singletonList = Collections.singletonList(selectedRow);
				return singletonList;
			}

			private @NonNull R getSelectedElement() {
				@SuppressWarnings("null")
				@NonNull
				R selectedRow = getContentHandler().get(nebulaGrid.getSelection()[0]);
				return selectedRow;
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

	static class SimpleSelection<R> implements XSelection<R> {
		private final @NonNull List<@NonNull R> rowList;
		private final @NonNull List<SWTGridColumn<R, ?>> columnList;

		SimpleSelection(@NonNull List<@NonNull R> rowList, @NonNull List<@NonNull SWTGridColumn<R, ?>> columnList) {
			this.rowList = rowList;
			this.columnList = columnList;
		}

		@Override
		public @Nullable R getFirst() {
			return rowList.isEmpty() ? null : rowList.get(0);
		}

		@SuppressWarnings("null")
		@Override
		public @NonNull List<@NonNull R> asList() {
			return Collections.unmodifiableList(rowList);
		}

		@Override
		public boolean isEmpty() {
			return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public @NonNull List<@NonNull XGridMetaData> getMetaData() {
			List<@NonNull XGridMetaData> rv = new ArrayList<>();
			for (R r : rowList) {
				for (XGridColumn<R, ?> c : columnList) {
					List<@NonNull XGridMetaData> data = ((XGridColumn<R, Object>) c).metaDataFunctionProperty().get()
							.getMetaData(r, c.cellValueFunctionProperty().get().apply(r));
					rv.addAll(data);
				}
			}
			return rv;
		}
	}

	static class SimpleCellSelection<R> extends SimpleSelection<R> implements XCellSelection<R> {
		// TODO Should we do that lazy??
		private List<XGridCell<R, ?>> cells;

		SimpleCellSelection(List<XGridCell<R, ?>> cells, @NonNull List<@NonNull R> rowList,
				@NonNull List<@NonNull SWTGridColumn<R, ?>> columnList) {
			super(rowList, columnList);
			this.cells = cells;
		}

		@Override
		public <C> List<XGridCell<R, C>> getCells() {
			@SuppressWarnings("unchecked")
			List<XGridCell<R, C>> l = (List<XGridCell<R, C>>) (List<?>) cells;
			return Collections.<XGridCell<R, C>> unmodifiableList(l);
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
