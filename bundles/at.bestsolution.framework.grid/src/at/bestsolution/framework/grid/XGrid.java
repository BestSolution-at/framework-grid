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
package at.bestsolution.framework.grid;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.func.RowMetaDataFunction;

/**
 * Base interface of grid
 *
 * @param <R>
 *            the row type
 * @param <CP>
 *            the content provider type
 * @since 1.0
 */
public interface XGrid<R, CP extends XGridContentProvider<R>> {
	/**
	 * Selection mode
	 *
	 * @since 1.0
	 */
	enum SelectionMode {
		/**
		 * Single row selection
		 */
		SINGLE_ROW,
		/**
		 * Single cell selection
		 */
		SINGLE_CELL
	}

	/**
	 * Create a column
	 *
	 * @param id
	 *            the id of the column
	 * @param cellValueFunction
	 *            the cell value function
	 * @param <C>
	 *            the cell type
	 * @return column instance
	 * @see XGridColumn#cellValueFunctionProperty()
	 */
	<C> @NonNull XGridColumn<@NonNull R, @Nullable C> createColumn(String id, @NonNull Function<@NonNull R, @Nullable C> cellValueFunction);

	/**
	 * Create a column which presents boolean values as check box
	 *
	 * @param id
	 *            the id of the column
	 * @param cellValueFunction
	 *            the cell value function
	 * @return column instance
	 * @see XGridColumn#cellValueFunctionProperty()
	 */
	@NonNull
	XGridColumn<@NonNull R, @Nullable Boolean> createCheckedColumn(String id,
			@NonNull Function<@NonNull R, @Nullable Boolean> cellValueFunction);

	/**
	 * The selection mode.
	 * <p>
	 * Default {@link SelectionMode#SINGLE_ROW}
	 * </p>
	 *
	 * @return the property
	 */
	@NonNull
	Property<@NonNull SelectionMode> selectionModeProperty();

	/**
	 * The default sort.
	 * <p>
	 * Default <code>null</code>
	 * </p>
	 *
	 * @return the default sort property
	 */
	@NonNull
	Property<@Nullable Comparator<@NonNull R>> defaultSortProperty();

	/**
	 * The current locale used by the grid
	 * <p>
	 * Default {@link Locale#getDefault()}
	 * </p>
	 *
	 * @return the locale property
	 */
	@NonNull
	Property<@NonNull Locale> localeProperty();

	/**
	 * The default content provider
	 * <p>
	 * Default <code>null</code>
	 * </p>
	 *
	 * @return the content provider
	 */
	@NonNull
	Property<@Nullable CP> contentProviderProperty();

	/**
	 * The selection property
	 * <p>
	 * Default an empty selection
	 * </p>
	 *
	 * @return the default selection
	 */
	@NonNull
	Property<@NonNull XSelection<R>> selectionProperty();

	/**
	 * The element comparer property
	 * <p>
	 * Default implementation provides {@link #hashCode()} and
	 * {@link #equals(Object)} of R
	 * </p>
	 *
	 * @return the property
	 */
	@NonNull
	Property<@NonNull ElementComparer<@NonNull R>> elementComparerProperty();

	/**
	 * @return list of columns
	 */
	@NonNull
	List<@NonNull XGridColumn<@NonNull R, @Nullable ?>> getColumns();

	/**
	 * Function consulted to retrieve row meta data
	 * <p>
	 * Property value is initialized with a default function who returns no meta
	 * data
	 * </p>
	 *
	 * @return the property
	 */
	@NonNull
	Property<@NonNull RowMetaDataFunction<@NonNull R>> metaDataFunctionProperty();

	/**
	 * dispose grid
	 */
	void dispose();

	/**
	 * export shown data
	 * <p>
	 * if the content is empty an empty array will be exported
	 * </p>
	 *
	 * @return data
	 */
	@NonNull
	Object[][] getData();
}
