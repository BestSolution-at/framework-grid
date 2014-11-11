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

/**
 * An observable value
 *
 * @param <T>
 *            the type
 * @since 1.0
 */
public interface Property<T> {
	/**
	 * Set the new value
	 *
	 * @param value
	 *            the value
	 */
	public void set(T value);

	/**
	 * Get the current value
	 *
	 * @return the value
	 */
	public T get();

	/**
	 * Dispose the value
	 */
	public void dispose();

	/**
	 * Attach a listener
	 *
	 * @param listener
	 *            the listener
	 */
	public void addChangeListener(ChangeListener<T> listener);

	/**
	 * Remove the listener
	 *
	 * @param listener
	 *            the listener
	 */
	public void removeChangeListener(ChangeListener<T> listener);

	/**
	 * Listener to observe changes
	 *
	 * @param <T>
	 *            the type
	 */
	public interface ChangeListener<T> {
		/**
		 * Handle the changed value
		 *
		 * @param property
		 *            the property
		 * @param oldValue
		 *            the old value
		 * @param newValue
		 *            the new value
		 */
		public void valueChanged(Property<T> property, T oldValue, T newValue);
	}
}
