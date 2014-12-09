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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import at.bestsolution.framework.grid.func.CellValueMatcherFunction;
import at.bestsolution.framework.grid.swt.SWTGridColumn;

/**
 * @param <R>
 *            row type
 * @param <C>
 *            cell type
 */
public class SWTTextColumnFilter<R, C> implements SWTColumnFilter<R, C> {
	final @NonNull Text text;
	final @NonNull SWTGridColumn<R, C> column;
	final @NonNull FreeTextModifyListener modifyListener = new FreeTextModifyListener();

	@Nullable Point cachedBounds;

	/**
	 * @param column
	 *            the corresponding column
	 */
	public SWTTextColumnFilter(@NonNull SWTGridColumn<R, C> column) {
		this.column = column;
		text = new Text(column.getNebulaColumn().getParent(), SWT.BORDER) {
			@Override
			public Point computeSize(int wHint, int hHint, boolean changed) {
				if( cachedBounds != null ) {
					return cachedBounds;
				}
				return cachedBounds = super.computeSize(wHint, hHint, changed);
			}

			protected void checkSubclass() {
				// keep empty
			}
		};
		column.getNebulaColumn().setHeaderControl(text);
		text.addModifyListener(modifyListener);
	}

	@Override
	public boolean matches(@NonNull R element) {
		CellValueMatcherFunction<R, @Nullable C, Object> matcher = column.autoFilterMatcherFunctionProperty().get();
		return matcher.apply(element, column.cellValueFunctionProperty().get().apply(element), column.autoFilterFreeTextProperty().get());
	}

	private class FreeTextModifyListener implements ModifyListener {
		final Runnable runnable = new Runnable() {
			public void run() {
				if (!text.isDisposed()) {
					column.autoFilterFreeTextProperty().set(text.getText());
				}
			}
		};

		public FreeTextModifyListener() {
		}

		@Override
		public void modifyText(ModifyEvent e) {
			Display.getDefault().disposeExec(runnable);
			Display.getDefault().timerExec(300, runnable);
		}
	}

	@Override
	public void dispose() {
		text.removeModifyListener(modifyListener);
		text.dispose();
	}
}
