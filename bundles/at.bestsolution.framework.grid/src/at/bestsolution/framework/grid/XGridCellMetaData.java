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
 * Object with meta data
 *
 * @param <R>
 *            the row type
 *
 * @since 1.0
 */
public interface XGridCellMetaData<@NonNull R> {
	/**
	 * @return the value
	 * @param <V>
	 *            value type
	 */
	public <V> @Nullable V getCellValue();

	/**
	 * @return the row value
	 */
	public R getRowValue();

	/**
	 * @return the meta data
	 * @param <M>
	 *            MetaData type
	 */
	public <M> @Nullable M getMetaData();

	/**
	 * @return the object
	 */
	public @NonNull String getTopic();
}
