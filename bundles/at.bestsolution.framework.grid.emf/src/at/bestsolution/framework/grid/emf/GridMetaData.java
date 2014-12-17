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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.XGridCellMetaData;

/**
 * Meta data impl
 *
 * @param <R>
 *            row type
 */
public class GridMetaData<R> implements XGridCellMetaData<R> {

	@NonNull
	private final String topic;

	@Nullable
	private final Object value;

	@Nullable
	private final Object data;

	@NonNull
	private final R rowValue;

	/**
	 * Create a meta data object
	 *
	 * @param topic
	 *            the topic
	 * @param data
	 *            the data
	 * @param rowValue
	 *            the row value
	 * @param value
	 *            the value
	 */
	public GridMetaData(@NonNull String topic, Object data, @NonNull R rowValue, Object value) {
		this.topic = topic;
		this.data = data;
		this.value = value;
		this.rowValue = rowValue;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V> @Nullable V getCellValue() {
		return (V) value;
	}

	@Override
	public @NonNull R getRowValue() {
		return rowValue;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <M> @Nullable M getMetaData() {
		return (M) data;
	}

	@Override
	public @NonNull String getTopic() {
		return topic;
	}

	@Override
	public String toString() {
		return "GridMetaData [topic=" + topic + ", value=" + value + ", data=" + data + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

}
