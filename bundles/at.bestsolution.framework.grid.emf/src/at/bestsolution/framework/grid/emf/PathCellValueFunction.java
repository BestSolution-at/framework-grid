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

import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.model.grid.MPathCellValueFunction;
import at.bestsolution.framework.grid.model.grid.MPathSegment;
import at.bestsolution.framework.grid.model.grid.MSimplePathSegment;

/**
 * A cell value function which provides a cell value b
 *
 * @param <R>
 *            data type
 */
public class PathCellValueFunction<@NonNull R> implements Function<R, @Nullable Object> {
	private final @NonNull MPathCellValueFunction mFunction;
	private final @NonNull XGridColumn<@NonNull R, @Nullable ?> column;

	/**
	 * @param column
	 *            the corresponding column
	 * @param mFunction
	 *            the specified function
	 */
	public PathCellValueFunction(@NonNull XGridColumn<@NonNull R, @Nullable ?> column, @NonNull MPathCellValueFunction mFunction) {
		this.column = column;
		this.mFunction = mFunction;
	}

	@Override
	public Object apply(R r) {
		Object value = r;
		for (@Nullable
		// TODO we could cache the path to improve performance
		MPathSegment segment : mFunction.getSegments()) {
			if (segment == null || value == null) {
				break;
			}
			if (value instanceof EObject) {
				value = getSegmentValue((EObject) value, segment);
			} else {
				value = getSegmentValue(value, segment);
			}
		}
		return value;
	}

	/**
	 * @param r
	 *            the EObject to get the value from
	 * @param segment
	 *            path segment
	 * @return obtained value
	 */
	private Object getSegmentValue(@NonNull EObject r, @NonNull MPathSegment segment) {
		if (segment instanceof MSimplePathSegment) {
			String featureName = ((MSimplePathSegment) segment).getFeatureName();
			EStructuralFeature f = r.eClass().getEStructuralFeature(featureName);
			if (f != null) {
				return r.eGet(f);
			} else {
				return column.notPresentableValuePresentationProperty().get();
			}
		} else {
			throw new UnsupportedOperationException("unknown path segment type: " + segment); //$NON-NLS-1$
		}
	}

	/**
	 * @param r
	 *            the object to get the value from
	 * @param segment
	 *            path segment
	 * @return obtained value got by reflection
	 */
	private static Object getSegmentValue(@NonNull Object r, @NonNull MPathSegment segment) {
		throw new UnsupportedOperationException("get value by reflection is not implemented"); //$NON-NLS-1$
	}
}
