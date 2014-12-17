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
import java.util.stream.Collectors;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

import at.bestsolution.framework.grid.ElementComparer;
import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.Property.ChangeListener;
import at.bestsolution.framework.grid.Util;
import at.bestsolution.framework.grid.XCellSelection;
import at.bestsolution.framework.grid.XGridCell;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.XGridContentProvider;
import at.bestsolution.framework.grid.XGridTable;
import at.bestsolution.framework.grid.XSelection;
import at.bestsolution.framework.grid.swt.internal.SWTGridCell;
import at.bestsolution.framework.grid.swt.internal.SWTGridContentHandler;
import at.bestsolution.framework.grid.swt.internal.SimpleCellSelection;
import at.bestsolution.framework.grid.swt.internal.SimpleProperty;
import at.bestsolution.framework.grid.swt.internal.SimpleSelection;

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
	Property<@NonNull XSelection<R>> selectionProperty = new SimpleProperty<>(Util.emptySelection());
	@SuppressWarnings("null")
	private @NonNull Property<@NonNull Locale> localeProperty = new SimpleProperty<>(Locale.getDefault());
	private @NonNull Property<@NonNull ElementComparer<@NonNull R>> elementComparer = new SimpleProperty<>(Util.defaultElementComparer());

	private final @NonNull ChangeListener<@NonNull XSelection<@NonNull R>> selectionChangedListener = this::handleSelectionChanged;
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
		SWTGridColumn<@NonNull R, @Nullable C> swtGridColumn = new SWTGridColumn<>(this, cellValueFunction);
		columns.add(swtGridColumn);
		return swtGridColumn;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull XGridColumn<@NonNull R, @Nullable Boolean> createCheckedColumn(String id,
			@NonNull Function<@NonNull R, @Nullable Boolean> cellValueFunction) {
		SWTGridColumn<@NonNull R, @Nullable Boolean> swtGridColumn = new SWTCheckedGridColumn<R>(this, cellValueFunction);
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
	public @NonNull Property<@NonNull XSelection<R>> selectionProperty() {
		return selectionProperty;
	}

	@Override
	public @NonNull Property<@NonNull Locale> localeProperty() {
		return localeProperty;
	}

	@Override
	public @NonNull Property<@NonNull ElementComparer<@NonNull R>> elementComparerProperty() {
		return elementComparer;
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
		selectionProperty.addChangeListener(selectionChangedListener);
	}

	private void applySelectionMode(@NonNull SelectionMode newSelectionMode) {
		switch (newSelectionMode) {
		case SINGLE_CELL:
			nebulaGrid.setCellSelectionEnabled(true);
			nebulaGrid.deselectAll();
			Point focusCell = nebulaGrid.getFocusCell();
			if (focusCell.x < 0) { // this happens if no cell got focus
				nebulaGrid.selectCell(new Point(0, focusCell.y));
			} else {
				nebulaGrid.selectCell(focusCell);
			}
			break;
		case SINGLE_ROW:
		default:
			nebulaGrid.setCellSelectionEnabled(false);
			nebulaGrid.deselectAll();
			@Nullable
			R currentSelection = selectionProperty.get().getFirst();
			if (currentSelection != null) {
				nebulaGrid.setSelection(new GridItem[] { contentHandler.get(currentSelection) });
			} else {
				if (nebulaGrid.getRootItemCount() > 0) {
					nebulaGrid.setSelection(0);
				}
			}
		}
		selectionProperty.set(createSelection(true));
	}

	private void registerSelectionListener() {
		nebulaGrid.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectionProperty.set(createSelection(false));
			}

		});
	}

	@NonNull
	XSelection<@NonNull R> createSelection(boolean respectiveCurrentSelection) {
		@SuppressWarnings("null")
		@NonNull
		GridItem[] selection = nebulaGrid.getSelection();
		@NonNull
		XSelection<@NonNull R> xSelection;
		if (selection == null || selection.length == 0) {
			xSelection = Util.emptySelection();
		} else {
			if (selectionModeProperty.get() == SelectionMode.SINGLE_ROW) {
				@Nullable
				R selectedRow = getSelectedElement(respectiveCurrentSelection);
				if (selectedRow != null) {
					List<@NonNull R> singletonList = createSingletonList(selectedRow);
					xSelection = new SimpleSelection<@NonNull R>(singletonList, getColumns());
				} else {
					xSelection = Util.emptySelection();
				}
			} else {
				Point[] cellSelection = nebulaGrid.getCellSelection();
				if (cellSelection.length == 0) {
					xSelection = Util.emptyCellSelection();
				} else {
					nebulaGrid.deselectAllCells();
					nebulaGrid.selectCell(nebulaGrid.getFocusCell());

					@Nullable
					R selectedRow = getSelectedElement(respectiveCurrentSelection);
					if (selectedRow != null) {
						List<@NonNull R> singletonList = createSingletonList(selectedRow);
						List<XGridCell<@NonNull R, ?>> cellList = new ArrayList<XGridCell<@NonNull R, ?>>();
						Point p = nebulaGrid.getFocusCell();
						if (p.x < 0) {
							p.x = 0;
						}
						@SuppressWarnings("unchecked")
						SWTGridCell<@NonNull R, Object> cell = new SWTGridCell<@NonNull R, Object>(selectedRow,
								(@NonNull XGridColumn<@NonNull R, Object>) columns.get(p.x));
						cellList.add(cell);
						xSelection = new SimpleCellSelection<@NonNull R>(cellList, singletonList, getColumns());
					} else {
						xSelection = Util.emptyCellSelection();
					}
				}
			}
		}
		return xSelection;
	}

	private @NonNull List<@NonNull R> createSingletonList(R selectedRow) {
		@SuppressWarnings("null")
		@NonNull
		List<@NonNull R> singletonList = Collections.singletonList(selectedRow);
		return singletonList;
	}

	private @Nullable R getSelectedElement(boolean respectiveCurrentSelection) {
		@SuppressWarnings("null")
		@NonNull
		GridItem[] selection = nebulaGrid.getSelection();
		if (selection.length == 0) {
			if (respectiveCurrentSelection) {
				return selectionProperty.get().getFirst();
			}
			return null;
		} else {
			R selectedRow = getContentHandler().get(selection[0]);
			return selectedRow;
		}
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

	@SuppressWarnings("all")
	private void handleSelectionChanged(Property<XSelection<R>> property, XSelection<R> oldSelection, XSelection<R> newSelection) {
		if (newSelection instanceof XCellSelection) {
			// fix selection mode if necessary
			switch (selectionModeProperty.get()) {
			case SINGLE_ROW:
				selectionModeProperty.set(SelectionMode.SINGLE_CELL);
				break;
			default:
				nebulaGrid.deselectAll();
				if (!newSelection.isEmpty()) {
					XCellSelection<R> cellSelection = (XCellSelection<R>) newSelection;
					boolean scrolled = false;
					for (XGridCell<R, Object> cell : cellSelection.getCells()) {
						final int x = getColumns().indexOf(cell.getColumn());
						final @Nullable GridItem item = contentHandler.get(cell.getRowValue());
						if (item != null) {
							final int y = nebulaGrid.indexOf(item);
							nebulaGrid.selectCell(new Point(x, y));
							if (!scrolled) {
								nebulaGrid.showItem(item);
							}
						}
					}
				}
			}
		} else {
			// fix selection mode if necessary
			switch (selectionModeProperty.get()) {
			case SINGLE_CELL:
				selectionModeProperty.set(SelectionMode.SINGLE_ROW);
				break;
			default:
				// TODO we could ignore this if the selection is set inside
				nebulaGrid.deselectAll();
				if (!newSelection.isEmpty()) {
					List<GridItem> elements = newSelection.asList().stream().map((x) -> contentHandler.get(x)).filter((x) -> x != null)
							.collect(Collectors.<@Nullable GridItem> toList());
					nebulaGrid.setSelection(elements.toArray(new GridItem[elements.size()]));
					if (!elements.isEmpty()) {
						nebulaGrid.showItem(elements.get(0));
					}
				}
			}
		}
	}

	@Override
	public void dispose() {
		for (@NonNull
		XGridColumn<@NonNull R, @Nullable ?> col : getColumns()) {
			col.dispose();
		}
		selectionProperty.removeChangeListener(selectionChangedListener);
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
