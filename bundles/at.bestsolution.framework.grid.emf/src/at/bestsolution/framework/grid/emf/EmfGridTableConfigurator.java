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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.XGrid.SelectionMode;
import at.bestsolution.framework.grid.XGridTable;
import at.bestsolution.framework.grid.model.grid.GridPackage;
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
	private final @NonNull MGridConfigurationSet config;

	private Adapter configAdapter;
	private final @NonNull Map<MGridColumn, EmfGridColumnConfigurator<R, ?>> columnConfigurators = new HashMap<>();

	/**
	 * EMF Model table configurator
	 * 
	 * @param table
	 *            the table to configure
	 * @param config
	 *            table configuration
	 */
	public EmfGridTableConfigurator(XGridTable<R> table,
			MGridConfigurationSet config) {
		if (table == null) {
			throw new IllegalArgumentException("table must not be null"); //$NON-NLS-1$
		}
		if (config == null) {
			throw new IllegalArgumentException("config must not be null"); //$NON-NLS-1$
		}
		this.table = table;
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
			table.defaultSortProperty().set(
					columnConfigurators.get(config.getDefaultSortColumn())
							.createDefaultComparator());
		}
	}

	private void addViewColumns() {
		if (config.getViewConfiguration() != null) {
			for (MGridConfigurationColumn columnConfig : config
					.getViewConfiguration().getColumns()) {
				MGridColumn column = columnConfig.getColumn();
				if (column != null) {
					@NonNull
					Function<@NonNull R, @Nullable Object> cellValueFunction = createCellValueFunction(column
							.getCellValueFunction());
					columnConfigurators.put(
							column,
							new EmfGridColumnConfigurator<R, Object>(table
									.createColumn(column.getId(),
											cellValueFunction), columnConfig));
				}
			}
		}
	}

	private @NonNull Function<@NonNull R, @Nullable Object> createCellValueFunction(
			@Nullable MCellValueFunction mFunction) {
		if (mFunction == null) {
			return new NullCellValueFunction<R>();
		} else if (mFunction instanceof MPathCellValueFunction) {
			return new PathCellValueFunction<R>(
					(MPathCellValueFunction) mFunction);
		} else {
			throw new UnsupportedOperationException(
					"Unknown cell value function type: " + mFunction); //$NON-NLS-1$
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
