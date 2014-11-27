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

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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

	/**
	 * @param column
	 *            the corresponding column
	 */
	public SWTTextColumnFilter(@NonNull SWTGridColumn<R, C> column) {
		this.column = column;
		text = new Text(column.getNebulaColumn().getParent(), SWT.BORDER);
		column.getNebulaColumn().setHeaderControl(text);
		text.addModifyListener(new FreeTextModifyListener());
	}

	@Override
	public boolean matches(@NonNull R element) {
		CellValueMatcherFunction<R, @Nullable C, Object> matcher = column.autoFilterMatcherFunctionProperty().get();
		return matcher.apply(element, column.cellValueFunctionProperty().get().apply(element), column.autoFilterFreeTextProperty().get());
	}

	private class FreeTextModifyListener implements ModifyListener {
		private Timer timer = null;

		public FreeTextModifyListener() {
		}

		@Override
		public void modifyText(ModifyEvent e) {
			if (timer != null) {
				timer.cancel();
			}
			timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					Display.getDefault().syncExec(new Runnable() {
						public void run() {
							column.autoFilterFreeTextProperty().set(text.getText());
						}
					});
				}
			}, 300);
		}
	}
}