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

import java.util.List;

import at.bestsolution.framework.grid.Property;

/**
 * Simple implementation of the property
 *
 * @param <T>
 *            the value type
 */
public class SimpleProperty<T> implements Property<T> {
	private T value;
	private List<ChangeListener<T>> listenerList;
	private boolean disposed = false;

	private void checkDisposed() {
		if (disposed) {
			throw new IllegalStateException("Property is disposed"); //$NON-NLS-1$
		}
	}

	/**
	 * @param initialValue
	 *            the initial value
	 */
	public SimpleProperty(T initialValue) {
		this.value = initialValue;
	}

	@Override
	public void set(T value) {
		checkDisposed();
		T oldValue = this.value;
		this.value = value;
		for (ChangeListener<T> listener : listenerList) {
			listener.valueChanged(this, oldValue, value);
		}
	}

	@Override
	public T get() {
		checkDisposed();
		return this.value;
	}

	@Override
	public void dispose() {
		if (listenerList != null) {
			listenerList.clear();
		}
		listenerList = null;
		disposed = true;
	}

	@Override
	public void addChangeListener(
			at.bestsolution.framework.grid.Property.ChangeListener<T> listener) {
		checkDisposed();
		listenerList.add(listener);
	}

	@Override
	public void removeChangeListener(
			at.bestsolution.framework.grid.Property.ChangeListener<T> listener) {
		checkDisposed();
		listenerList.remove(listener);
	}
}
