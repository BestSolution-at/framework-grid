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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Default grid cell meta data
 *
 * @param <R>
 *            the row type
 */
public class DefaultXGridCellMetaData<@NonNull R> implements XGridCellMetaData<R> {
	@NonNull
	private final R rowValue;
	@Nullable
	private final Object cellValue;
	@Nullable
	private final Object metaData;
	@NonNull
	private final String topic;

	/**
	 * Create a default meta data object
	 *
	 * @param rowValue
	 *            the row value
	 * @param cellValue
	 *            the cell value
	 * @param metaData
	 *            the meta data
	 * @param topic
	 *            the topic
	 */
	public DefaultXGridCellMetaData(R rowValue, @Nullable Object cellValue, @Nullable Object metaData, @NonNull String topic) {
		super();
		this.rowValue = rowValue;
		this.cellValue = cellValue;
		this.metaData = metaData;
		this.topic = topic;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V> @Nullable V getCellValue() {
		return (V) cellValue;
	}

	@Override
	public R getRowValue() {
		return rowValue;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <M> @Nullable M getMetaData() {
		return (M)metaData;
	}

	@Override
	public @NonNull String getTopic() {
		return topic;
	}

}
