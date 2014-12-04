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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Provides the content to the grid
 *
 * @param <R>
 *            the content type
 * @since 1.0
 */
public interface XGridContentProvider<R> {
	/**
	 * @return the size
	 */
	int size();

	/**
	 * Retrieve the element at the given index
	 *
	 * @param index
	 *            the index
	 * @return the element
	 * @throws IndexOutOfBoundsException
	 *             if index is negative or index &gt;= {@link #size()}
	 */
	@NonNull
	R getElementAt(int index) throws IndexOutOfBoundsException;

	/**
	 * content change types
	 */
	enum ContentChangeType {
		/**
		 * add elements
		 */
		ADD,
		/**
		 * remove elements
		 */
		REMOVE,
		/**
		 * modify elements
		 */
		MODIFY
	}

	/**
	 * Attach a listener
	 *
	 * @param listener
	 *            the listener
	 */
	void addChangeListener(ContentChangeListener<R> listener);

	/**
	 * Remove the listener
	 *
	 * @param listener
	 *            the listener
	 */
	void removeChangeListener(ContentChangeListener<R> listener);

	/**
	 * Listener to observe content changes
	 *
	 * @param <T>
	 *            the type
	 */
	@FunctionalInterface
	interface ContentChangeListener<@NonNull T> {
		/**
		 * Handle the changed value
		 * 
		 * @param type
		 *            content change type
		 * @param values
		 *            changed values
		 */
		void contentChanged(@NonNull ContentChangeType type, @NonNull List<@NonNull T> values);
	}
}
