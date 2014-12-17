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
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.XGrid.SelectionMode;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.XGridTable;
import at.bestsolution.framework.grid.model.grid.GridPackage;
import at.bestsolution.framework.grid.model.grid.MBooleanGridColumn;
import at.bestsolution.framework.grid.model.grid.MCellValueFunction;
import at.bestsolution.framework.grid.model.grid.MGridColumn;
import at.bestsolution.framework.grid.model.grid.MGridConfigurationColumn;
import at.bestsolution.framework.grid.model.grid.MGridConfigurationSet;
import at.bestsolution.framework.grid.model.grid.MPathCellValueFunction;

/**
 * configure a grid instance with model meta data
 *
 * @param <R>
 *            grid data type
 */
public class EmfGridTableConfigurator<R> {
	private final @NonNull XGridTable<R> table;
	private @NonNull MGridConfigurationSet config;

	private Adapter configAdapter;
	private final @NonNull Map<MGridColumn, EmfGridColumnConfigurator<R, ?>> columnConfigurators = new HashMap<>();

	/**
	 * EMF Model table configurator
	 * 
	 * @param table
	 *            the table to configure
	 * @param config
	 *            initial table configuration
	 */
	public EmfGridTableConfigurator(@NonNull XGridTable<R> table, @NonNull MGridConfigurationSet config) {
		this.table = table;
		this.config = config;
		setConfiguration(config);
	}

	/**
	 * reconfigure grid with a new configuration
	 * 
	 * @param config
	 *            the new configuration
	 */
	public void setConfiguration(@NonNull MGridConfigurationSet config) {
		for (MGridColumn col : new ArrayList<>(columnConfigurators.keySet())) {
			columnConfigurators.get(col).dispose();
			columnConfigurators.remove(col);
		}
		// remove possibly set default sort column
		table.defaultSortProperty().set(null);
		for (XGridColumn<R, ?> col : new ArrayList<>(table.getColumns())) {
			col.dispose();
		}
		this.config.eAdapters().remove(configAdapter);
		this.config = config;
		apply();
		registerAdapters();
	}

	private void registerAdapters() {
		configAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() == GridPackage.Literals.MGRID_CONFIGURATION_SET__VIEW_SELECTION_MODE) {
					applySelectionMode();
				}
				// TODO add missing features
			}
		};
		config.eAdapters().add(configAdapter);
	}

	private void apply() {
		applySelectionMode();
		addViewColumns();
		applyDefaultSort();
		// TODO add missing features
	}

	private void applyDefaultSort() {
		if (config.getDefaultSortColumn() != null) {
			table.defaultSortProperty().set(columnConfigurators.get(config.getDefaultSortColumn()).createDefaultComparator());
			columnConfigurators.get(config.getDefaultSortColumn()).applySorting(XGridColumn.Sorting.UP);
		}
	}

	private void addViewColumns() {
		if (config.getViewConfiguration() != null) {
			for (MGridConfigurationColumn columnConfig : config.getViewConfiguration().getColumns()) {
				MGridColumn column = columnConfig.getColumn();
				if (column != null) {
					if (column instanceof MBooleanGridColumn) {
						XGridColumn<@NonNull R, @Nullable Boolean> gridColumn = table.createCheckedColumn(column.getId(),
								new NullCellValueFunction<R, Boolean>());
						gridColumn.cellValueFunctionProperty().set(createCellValueFunction(gridColumn, column.getCellValueFunction()));
						EmfGridColumnConfigurator<R, Boolean> configurator = new EmfGridColumnConfigurator<R, Boolean>(gridColumn,
								columnConfig);
						columnConfigurators.put(column, configurator);
					} else {
						XGridColumn<@NonNull R, @Nullable Object> gridColumn = table.createColumn(column.getId(),
								new NullCellValueFunction<R, Object>());
						gridColumn.cellValueFunctionProperty().set(createCellValueFunction(gridColumn, column.getCellValueFunction()));
						EmfGridColumnConfigurator<R, Object> configurator = new EmfGridColumnConfigurator<R, Object>(gridColumn,
								columnConfig);
						columnConfigurators.put(column, configurator);
					}
				}
			}
		}
	}

	private @NonNull <@Nullable C> Function<@NonNull R, @Nullable C> createCellValueFunction(@NonNull XGridColumn<@NonNull R, @Nullable ?> column,
			@Nullable MCellValueFunction mFunction) {
		if (mFunction == null) {
			return new NullCellValueFunction<R, C>();
		} else if (mFunction instanceof MPathCellValueFunction) {
			return new PathCellValueFunction<R, C>(column, (MPathCellValueFunction) mFunction);
		} else {
			throw new UnsupportedOperationException("Unknown cell value function type: " + mFunction); //$NON-NLS-1$
		}
	}

	void applySelectionMode() {
		switch (config.getViewSelectionMode()) {
		case SINGLE_CELL:
			table.selectionModeProperty().set(SelectionMode.SINGLE_CELL);
			break;
		case SINGLE_ROW:
		default:
			table.selectionModeProperty().set(SelectionMode.SINGLE_ROW);
		}
	}
}
