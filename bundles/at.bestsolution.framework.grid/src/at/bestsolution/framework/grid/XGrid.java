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
	public enum SelectionMode {
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
	public <C> @NonNull XGridColumn<@NonNull R, @Nullable C> createColumn(
			String id,
			@NonNull Function<@NonNull R, @Nullable C> cellValueFunction);

	/**
	 * The selection mode.
	 * <p>
	 * Default {@link SelectionMode#SINGLE_ROW}
	 * </p>
	 *
	 * @return the property
	 */
	public @NonNull Property<@NonNull SelectionMode> selectionModeProperty();

	/**
	 * The default sort.
	 * <p>
	 * Default <code>null</code>
	 * </p>
	 *
	 * @return the default sort property
	 */
	public @NonNull Property<@Nullable Comparator<@NonNull R>> defaultSortProperty();

	/**
	 * The current locale used by the grid
	 * <p>
	 * Default {@link Locale#getDefault()}
	 * </p>
	 * @return the locale property
	 */
	public @NonNull Property<@NonNull Locale> localeProperty();

	/**
	 * The default content provider
	 * <p>
	 * Default <code>null</code>
	 * </p>
	 *
	 * @return the content provider
	 */
	public @NonNull Property<@Nullable CP> contentProviderProperty();

	/**
	 * The selection property
	 * <p>
	 * Default an empty selection
	 * </p>
	 *
	 * @return the default selection
	 */
	public @NonNull Property<@NonNull Selection<@Nullable R, @Nullable R>> selectionProperty();

	/**
	 * Selection
	 *
	 * @param <R>
	 *            the row value type
	 *
	 * @param <O>
	 *            the selection value type
	 *
	 * @since 1.0
	 */
	public interface Selection<R, O> {
		/**
		 * @return the first entry or <code>null</code> if empty
		 */
		public @Nullable O getFirst();

		/**
		 * @return as a list
		 */
		public @NonNull List<@NonNull O> asList();

		/**
		 * @return check if empty
		 */
		public boolean isEmpty();

		/**
		 * @param <C>
		 *            the cell type
		 * @return retrieve as cell selection
		 */
		public <C> @NonNull Selection<R, XGridCell<R, C>> asCellSelection();
	}
}
