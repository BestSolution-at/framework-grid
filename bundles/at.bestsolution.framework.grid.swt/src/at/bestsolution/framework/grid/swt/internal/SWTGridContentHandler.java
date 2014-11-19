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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;

import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.XGrid.Selection;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.XGridContentProvider;
import at.bestsolution.framework.grid.swt.SWTGridTable;

/**
 * @param <R>
 *            content type
 */
public class SWTGridContentHandler<R> {
	private final Map<@NonNull R, @NonNull GridItem> dataByR = new IdentityHashMap<>();
	private final Map<@NonNull GridItem, @NonNull R> dataByCol = new IdentityHashMap<>();
	private final @NonNull Grid nebulaGrid;
	private final @NonNull SWTGridTable<R> grid;
	private final @NonNull Property<@Nullable Comparator<@NonNull R>> defaultSortProperty = new SimpleProperty<>(
			null);

	/**
	 * @param grid
	 *            grid
	 * @param nebulaGrid
	 */
	public SWTGridContentHandler(@NonNull SWTGridTable<R> grid,
			@NonNull Grid nebulaGrid) {
		this.grid = grid;
		this.nebulaGrid = nebulaGrid;
	}

	/**
	 * 
	 * @param contentProvider
	 *            the new content provider
	 */
	public synchronized void resetContent(
			@Nullable XGridContentProvider<R> contentProvider) {
		Selection<@Nullable R, @Nullable R> previousSelection = grid
				.selectionProperty().get();
		dataByR.clear();
		dataByCol.clear();
		nebulaGrid.clearItems();
		List<@NonNull R> items = new ArrayList<>();

		if (contentProvider != null) {
			for (int i = 0; i < contentProvider.size(); i++) {
				items.add(contentProvider.getElementAt(i));
			}
		}

		if (defaultSortProperty.get() != null) {
			Collections.sort(items, defaultSortProperty.get());
		}
		insertItems(items);
		// restore selection
		grid.selectionProperty().set(previousSelection);
	}

	private void insertItems(List<@NonNull R> items) {
		for (@NonNull
		R element : items) {
			final GridItem item = new GridItem(nebulaGrid, SWT.NONE);
			dataByR.put(element, item);
			dataByCol.put(item, element);
			for (XGridColumn<@NonNull R, @Nullable ?> col : grid.getColumns()) {
				col.requestUpdate(element);
			}
		}
	}

	/**
	 * @param item
	 *            grid item
	 * @return corresponding row value
	 */
	public R get(@NonNull GridItem item) {
		return dataByCol.get(item);
	}

	/**
	 * @param r
	 *            row value
	 * @return corresponding GridItem
	 */
	public GridItem get(@NonNull R r) {
		return dataByR.get(r);
	}

	/**
	 * @return the defaultSortProperty
	 */
	public @NonNull Property<@Nullable Comparator<@NonNull R>> getDefaultSortProperty() {
		return defaultSortProperty;
	}
}
