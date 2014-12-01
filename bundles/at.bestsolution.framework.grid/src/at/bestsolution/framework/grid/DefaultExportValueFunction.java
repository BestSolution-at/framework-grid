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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.func.ExportValueFunction;

/**
 * Default Export Value implementation.
 * <p>
 * <code>null</code> values will be exported as <code>null</code>
 * </p>
 * <p>
 * Whole number values will be exported as {@link BigInteger}
 * </p>
 * <p>
 * Decimal values will be exported as {@link BigDecimal}
 * </p>
 * <p>
 * {@link Date} values will be exported as {@link Date}
 * </p>
 * <p>
 * all other values will be exported as {@link String}
 * </p>
 * 
 * @param <R>
 *            row type
 * @param <C>
 *            cell type
 */
public class DefaultExportValueFunction<@NonNull R, @Nullable C> implements ExportValueFunction<R, C> {
	private final @NonNull XGridColumn<R, C> column;

	/**
	 * @param column
	 *            the column
	 */
	public DefaultExportValueFunction(@NonNull XGridColumn<@NonNull R, @Nullable C> column) {
		this.column = column;
	}

	@Override
	public Object apply(@NonNull R row, @Nullable C cellValue) {
		C value = column.cellValueFunctionProperty().get().apply(row);
		Object exportValue = null;
		if (value != null) {
			if (value instanceof Integer || value instanceof Long || value instanceof Short) {
				exportValue = BigInteger.valueOf(((Number) value).longValue());
			} else if (value instanceof Double || value instanceof Float) {
				exportValue = BigDecimal.valueOf(((Number) value).doubleValue());
			} else if (value instanceof Date) {
				exportValue = value;
			} else {
				CharSequence text = column.textFunctionProperty().get().apply(row, value);
				if (text != null) {
					exportValue = text.toString();
				}
			}
		}
		return exportValue;
	}
}
