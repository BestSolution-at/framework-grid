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

import java.util.Comparator;
import java.util.function.Function;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.GridColumn;
import at.bestsolution.framework.grid.GridContentProvider;
import at.bestsolution.framework.grid.GridTable;
import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.Util;
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
	private @NonNull Property<@Nullable Comparator<@NonNull R>> defaultSortProperty = new SimpleProperty<>(
			null);
	private @NonNull Property<@Nullable GridContentProvider<R>> contentProviderProperty = new SimpleProperty<>(
			null);
	private @NonNull Property<@NonNull Selection<@Nullable R, @Nullable R>> selectionProperty = new SimpleProperty<>(
			Util.emptySelection());

	@SuppressWarnings("null")
	@Override
	public <C> @NonNull GridColumn<@NonNull R, @Nullable C> createColumn(
			String id,
			@NonNull Function<@NonNull R, @Nullable C> cellValueFunction) {
		return new SWTGridColumn<@NonNull R, @Nullable C>(this,
				cellValueFunction);
	}

	@Override
	public @NonNull Property<@NonNull SelectionMode> selectionModeProperty() {
		return selectionModeProperty;
	}

	@Override
	public @NonNull Property<@Nullable Comparator<@NonNull R>> defaultSortProperty() {
		return defaultSortProperty;
	}

	@Override
	public @NonNull Property<@Nullable GridContentProvider<R>> contentProviderProperty() {
		return contentProviderProperty;
	}

	@Override
	public @NonNull Property<@NonNull Selection<@Nullable R, @Nullable R>> selectionProperty() {
		return selectionProperty;
	}

}
