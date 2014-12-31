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
 * Default implementation for row meta data
 *
 * @param <R>
 *            the row type
 */
public class DefaultXGridRowMetaData<@NonNull R> implements XGridRowMetaData<R> {
	@NonNull
	private final R rowValue;
	@Nullable
	private final Object metaData;
	@NonNull
	private final String topic;

	/**
	 * Create a new meta data object
	 *
	 * @param rowValue
	 *            the row value
	 * @param metaData
	 *            the meta data
	 * @param topic
	 *            the topic
	 */
	public DefaultXGridRowMetaData(@NonNull R rowValue, @Nullable Object metaData, @NonNull String topic) {
		super();
		this.rowValue = rowValue;
		this.metaData = metaData;
		this.topic = topic;
	}

	@Override
	public R getRowValue() {
		return rowValue;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <M> @Nullable M getMetaData() {
		return (M) metaData;
	}

	@Override
	public @NonNull String getTopic() {
		return topic;
	}

}
