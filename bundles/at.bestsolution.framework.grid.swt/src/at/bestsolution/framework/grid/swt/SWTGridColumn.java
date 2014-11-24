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

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import at.bestsolution.framework.grid.DefaultSortComparator;
import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.Property.ChangeListener;
import at.bestsolution.framework.grid.Util;
import at.bestsolution.framework.grid.XGrid;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.XGridContentProvider;
import at.bestsolution.framework.grid.func.CellDataFunction;
import at.bestsolution.framework.grid.func.CellValueMatcherFunction;
import at.bestsolution.framework.grid.func.DisposableCellDataFunction;
import at.bestsolution.framework.grid.swt.internal.SimpleProperty;

/**
 * SWT column implementation
 *
 * @param <R>
 *            row type
 * @param <C>
 *            cell value type
 */
public class SWTGridColumn<@NonNull R, @Nullable C> implements XGridColumn<R, C> {
	private final @NonNull Property<@Nullable URI> iconProperty = new SimpleProperty<>(null);
	private final @NonNull Property<@Nullable Integer> maxWidthProperty = new SimpleProperty<>(null);
	private final @NonNull Property<@Nullable Integer> minWidthProperty = new SimpleProperty<>(null);
	@SuppressWarnings("null")
	private final @NonNull Property<@NonNull Boolean> autoWidthProperty = new SimpleProperty<>(Boolean.FALSE);
	private final @NonNull Property<@NonNull Function<@NonNull R, @Nullable C>> cellValueFunctionProperty;
	private final @NonNull Property<@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence>> textFunctionProperty = new SimpleProperty<>(
			Util.defaultToStringCellDataFunction());
	private final @NonNull Property<@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable URI>> iconFunctionProperty = new SimpleProperty<>(
			Util.nullCellDataFunction());
	@SuppressWarnings(value = "all")
	private final @NonNull Property<@NonNull AutoFilterType> autoFilterTypeProperty = new SimpleProperty<>(AutoFilterType.NONE);
	private final @NonNull Property<@NonNull Alignment> alignmentProperty = new SimpleProperty<>(Alignment.LEFT);
	private final @NonNull Property<@NonNull CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull Object>> autoFilterMatcherProperty = new SimpleProperty<>(
			Util.defaultToStringMatcher());
	private final @NonNull Property<@NonNull Supplier<@NonNull List<@NonNull Object>>> autoFilterDataSupplierProperty = new SimpleProperty<>(
			Util.emptyListSupplier());
	private final @NonNull Property<Function<@NonNull Object, @Nullable CharSequence>> autoFilterTextFunctionProperty = new SimpleProperty<>(
			Util.defaultToStringFunction());
	private final @NonNull Property<@Nullable Comparator<@NonNull R>> sorterProperty = new SimpleProperty<>(
			new DefaultSortComparator<R, C>(this));
	private final @NonNull Property<@NonNull Integer> indexProperty;
	private final @NonNull Property<@Nullable String> labelProperty = new SimpleProperty<>(null);
	final @NonNull Property<@NonNull Sorting> sortingProperty = new SimpleProperty<>(Sorting.NONE);
	final @NonNull Property<@NonNull SortingBehavior> sortingBehaviorProperty = new SimpleProperty<>(SortingBehavior.UP_DOWN);

	private final @NonNull SWTGridTable<R> grid;
	final @NonNull Property<@NonNull String> autoFilterFreeTextProperty = new SimpleProperty<>(""); //$NON-NLS-1$
	GridColumn nebulaColumn;

	/**
	 * Create a new column
	 *
	 * @param cellValueFunction
	 *            the value function
	 */
	SWTGridColumn(@NonNull SWTGridTable<R> grid, @NonNull Function<@NonNull R, @Nullable C> cellValueFunction) {
		this.cellValueFunctionProperty = new SimpleProperty<>(cellValueFunction);
		this.grid = grid;
		this.indexProperty = new SimpleProperty<@NonNull Integer>(new Integer(grid.getColumns().size()));

		nebulaColumn = new GridColumn(grid.getNebulaGrid(), SWT.NONE);

		registerListeners();
		registerPropertyListeners();
	}

	private void registerListeners() {
		nebulaColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				switch (sortingProperty.get()) {
				case UP:
					sortingProperty.set(Sorting.DOWN);
					break;
				case DOWN:
					switch (sortingBehaviorProperty.get()) {
					case UP_DOWN_DEFAULT:
						sortingProperty.set(Sorting.NONE);
						break;
					case UP_DOWN:
					default:
						sortingProperty.set(Sorting.UP);
					}
					break;
				default:
					sortingProperty.set(Sorting.UP);
				}
			}
		});
	}

	@Override
	public @NonNull Property<@Nullable String> labelProperty() {
		return labelProperty;
	}

	@Override
	public @NonNull Property<@Nullable URI> iconProperty() {
		return iconProperty;
	}

	@Override
	public @NonNull Property<@Nullable Integer> maxWidthProperty() {
		return maxWidthProperty;
	}

	@Override
	public @NonNull Property<@Nullable Integer> minWidthProperty() {
		return minWidthProperty;
	}

	@Override
	public @NonNull Property<@NonNull Boolean> autoWidthProperty() {
		return autoWidthProperty;
	}

	@Override
	public @NonNull Property<@NonNull Function<@NonNull R, @Nullable C>> cellValueFunctionProperty() {
		return cellValueFunctionProperty;
	}

	@Override
	public @NonNull Property<@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable CharSequence>> textFunctionProperty() {
		return textFunctionProperty;
	}

	@Override
	public @NonNull Property<@NonNull CellDataFunction<@NonNull R, @Nullable C, @Nullable URI>> iconFunctionProperty() {
		return iconFunctionProperty;
	}

	@Override
	public @NonNull Property<@NonNull AutoFilterType> autoFilterTypeProperty() {
		return autoFilterTypeProperty;
	}

	@Override
	public @NonNull Property<@NonNull CellValueMatcherFunction<@NonNull R, @Nullable C, @NonNull Object>> autoFilterMatcherFunctionProperty() {
		return autoFilterMatcherProperty;
	}

	@Override
	public @NonNull Property<@NonNull Supplier<@NonNull List<@NonNull Object>>> autoFilterDataSupplierProperty() {
		return autoFilterDataSupplierProperty;
	}

	@Override
	public @NonNull Property<Function<@NonNull Object, @Nullable CharSequence>> autoFilterTextFunctionProperty() {
		return autoFilterTextFunctionProperty;
	}

	@Override
	public @NonNull Property<@Nullable Comparator<@NonNull R>> sorterProperty() {
		return sorterProperty;
	}

	@Override
	public @NonNull Property<@NonNull Alignment> alignmentProperty() {
		return alignmentProperty;
	}

	@Override
	public @NonNull Property<@NonNull Integer> indexProperty() {
		return indexProperty;
	}

	@Override
	public @NonNull XGrid<R, XGridContentProvider<R>> getGrid() {
		return grid;
	}

	@SuppressWarnings("null")
	private void registerPropertyListeners() {
		labelProperty.addChangeListener((property, oldValue, newValue) -> nebulaColumn.setText(newValue));
		alignmentProperty.addChangeListener(new ChangeListener<Alignment>() {
			@Override
			public void valueChanged(Property<Alignment> property, Alignment oldValue, Alignment newValue) {
				switch (newValue) {
				case LEFT:
					nebulaColumn.setAlignment(SWT.LEFT);
					break;
				case CENTER:
					nebulaColumn.setAlignment(SWT.CENTER);
					break;
				case RIGHT:
					nebulaColumn.setAlignment(SWT.RIGHT);
					break;
				default:
					throw new UnsupportedOperationException("unknown alignment type: " + newValue); //$NON-NLS-1$
				}
			}
		});
		autoWidthProperty.addChangeListener(new ChangeListener<Boolean>() {
			@Override
			public void valueChanged(Property<Boolean> property, Boolean oldValue, Boolean newValue) {
				// TODO
			}
		});
		minWidthProperty.addChangeListener(new ChangeListener<Integer>() {
			@Override
			public void valueChanged(Property<Integer> property, Integer oldValue, Integer newValue) {
				if (newValue != null) {
					if (newValue.intValue() < 0) {
						throw new IllegalArgumentException("min width must be a non-negative number"); //$NON-NLS-1$
					}
					nebulaColumn.setMinimumWidth(newValue.intValue());
					checkWidth();
				}
			}
		});
		maxWidthProperty.addChangeListener(new ChangeListener<Integer>() {
			@Override
			public void valueChanged(Property<Integer> property, Integer oldValue, Integer newValue) {
				// TODO set max width
				checkWidth();
			}
		});
		textFunctionProperty.addChangeListener((property, oldValue, newValue) -> requestUpdate());
		cellValueFunctionProperty.addChangeListener((property, oldValue, newValue) -> requestUpdate());
		sortingProperty().addChangeListener((property, oldValue, newValue) -> applySorting(property, oldValue, newValue));

		autoFilterTypeProperty.addChangeListener(new ChangeListener<XGridColumn.AutoFilterType>() {
			@Override
			public void valueChanged(Property<AutoFilterType> property, AutoFilterType oldValue, AutoFilterType newValue) {
				switch (newValue) {
				case DROPDOWN:
					nebulaColumn.setHeaderControl(new CCombo(nebulaColumn.getParent(), SWT.READ_ONLY | SWT.BORDER));
					break;
				case TEXT:
					Text text = new Text(nebulaColumn.getParent(), SWT.BORDER);
					nebulaColumn.setHeaderControl(text);
					text.addModifyListener(new ModifyListener() {
						private Timer timer = null;

						@Override
						public void modifyText(ModifyEvent e) {
							if (timer != null) {
								timer.cancel();
							}
							timer = new Timer();
							timer.schedule(new TimerTask() {
								@Override
								public void run() {
									Display.getDefault().syncExec(new Runnable() {
										public void run() {
											autoFilterFreeTextProperty.set(text.getText());
										}
									});
								}
							}, 300);
						}
					});
					break;
				default:
					nebulaColumn.setHeaderControl(null);
				}
			}
		});
		autoFilterFreeTextProperty.addChangeListener(new ChangeListener<String>() {
			@Override
			public void valueChanged(Property<String> property, String oldValue, String newValue) {
				grid.getContentHandler().filter();
			}
		});
	}

	private void applySorting(Property<at.bestsolution.framework.grid.XGridColumn.Sorting> property,
			at.bestsolution.framework.grid.XGridColumn.Sorting oldValue, at.bestsolution.framework.grid.XGridColumn.Sorting newValue) {
		switch (newValue) {
		case UP:
			nebulaColumn.setSort(SWT.UP);
			break;
		case DOWN:
			nebulaColumn.setSort(SWT.DOWN);
			break;
		default:
			nebulaColumn.setSort(SWT.NONE);
		}
		@Nullable
		SWTGridColumn<@NonNull R, ?> currentSortColumn = grid.getContentHandler().sortColumnProperty().get();
		// reset sorting state on previous sorted other column
		if (currentSortColumn != null && currentSortColumn != this) {
			currentSortColumn.sortingProperty.set(Sorting.NONE);
		}
		grid.getContentHandler().sortColumnProperty().set(this);
	}

	void checkWidth() {
		@Nullable
		Integer minWidth = minWidthProperty.get();
		@Nullable
		Integer maxWidth = maxWidthProperty.get();
		if (minWidth != null && maxWidth != null && minWidth.equals(maxWidth)) {
			nebulaColumn.setWidth(minWidth.intValue());
		}
	}

	/**
	 * @param item
	 *            grid item
	 * @param element
	 *            row element
	 */
	private void fillGridItem(@NonNull GridItem item, @NonNull R element) {
		C value = cellValueFunctionProperty().get().apply(element);
		if (value != null) {
			if (value instanceof Boolean) {
				item.setChecked(indexProperty().get().intValue(), ((Boolean) value).booleanValue());
			} else {
				CharSequence textValue = textFunctionProperty.get().apply(element, value);
				if (textValue != null) {
					item.setText(indexProperty().get().intValue(), textValue.toString());
				} else {
					item.setText(indexProperty().get().intValue(), ""); //$NON-NLS-1$
				}
			}
		} else {
			item.setText(indexProperty().get().intValue(), ""); //$NON-NLS-1$
		}
	}

	@Override
	public void requestUpdate() {
		for (GridItem item : nebulaColumn.getParent().getItems()) {
			if (item != null) {
				fillGridItem(item, grid.getContentHandler().get(item));
			}
		}
	}

	@Override
	public void dispose() {
		grid.columns.remove(this);
		if (nebulaColumn.getHeaderControl() != null) {
			nebulaColumn.getHeaderControl().dispose();
		}
		nebulaColumn.dispose();
		alignmentProperty.dispose();
		autoFilterDataSupplierProperty.dispose();
		autoFilterMatcherProperty.dispose();
		autoFilterTextFunctionProperty.dispose();
		autoFilterTypeProperty.dispose();
		autoWidthProperty.dispose();
		cellValueFunctionProperty.dispose();
		iconFunctionProperty.dispose();
		iconProperty.dispose();
		indexProperty.dispose();
		maxWidthProperty.dispose();
		minWidthProperty.dispose();
		sorterProperty.dispose();
		labelProperty.dispose();
		sortingProperty.dispose();
		if (textFunctionProperty.get() instanceof DisposableCellDataFunction) {
			((DisposableCellDataFunction<?, ?, ?>) textFunctionProperty.get()).dispose();
		}
		textFunctionProperty.dispose();
		autoFilterFreeTextProperty.dispose();
	}

	@Override
	public void requestUpdate(@NonNull R element) {
		@Nullable
		GridItem item = grid.getContentHandler().get(element);
		if (item != null) {
			fillGridItem(item, element);
		}
	}

	@Override
	public @NonNull Property<XGridColumn.@NonNull Sorting> sortingProperty() {
		return sortingProperty;
	}

	@Override
	public @NonNull Property<XGridColumn.@NonNull SortingBehavior> sortingBehaviorProperty() {
		return sortingBehaviorProperty;
	}

	/**
	 * @param element
	 *            the element
	 * @return <code>true</code> if the given element matches,
	 *         <code>false</code> otherwise
	 */
	public boolean matchesColumnFilter(R element) {
		AutoFilterType autoFilterType = autoFilterTypeProperty.get();
		switch (autoFilterType) {
		case TEXT:
			CellValueMatcherFunction<R, C, Object> matcher = autoFilterMatcherProperty.get();
			return matcher.apply(element, cellValueFunctionProperty.get().apply(element), autoFilterFreeTextProperty.get());
		default:
			return true;
		}
	}
}
