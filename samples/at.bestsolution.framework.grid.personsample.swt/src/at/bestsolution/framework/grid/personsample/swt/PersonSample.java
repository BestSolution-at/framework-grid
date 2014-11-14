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
package at.bestsolution.framework.grid.personsample.swt;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

import at.bestsolution.framework.grid.GridTable;
import at.bestsolution.framework.grid.ListGridContentProvider;
import at.bestsolution.framework.grid.emf.EmfGridTableConfigurator;
import at.bestsolution.framework.grid.model.grid.GridPackage;
import at.bestsolution.framework.grid.model.grid.MGrid;
import at.bestsolution.framework.grid.model.grid.MGridConfigurationSet;
import at.bestsolution.framework.grid.model.grid.MSelectionMode;
import at.bestsolution.framework.grid.personsample.model.person.Person;
import at.bestsolution.framework.grid.personsample.model.person.PersonPackage;
import at.bestsolution.framework.grid.personsample.model.person.Root;
import at.bestsolution.framework.grid.swt.SWTGridTable;

public class PersonSample {
	private GridTable<Person> table;
	private MGridConfigurationSet config = getConfiguration();

	public PersonSample() throws Exception {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());

		table = new SWTGridTable<>(shell, SWT.BORDER | SWT.V_SCROLL
				| SWT.H_SCROLL);

		new EmfGridTableConfigurator<Person>(table, config);

		table.contentProviderProperty().set(
				new ListGridContentProvider<Person>(getData().getPersons()));

		addToggleSelectionMode(shell);
		shell.setSize(1000, 400);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

	public static void main(String[] args) throws Exception {
		new PersonSample();
	}

	private void addToggleSelectionMode(Shell shell) {
		Group group1 = new Group(shell, SWT.SHADOW_IN);
		group1.setText("Selection mode");
		group1.setLayout(new RowLayout(SWT.VERTICAL));
		Button bSingleCell = new Button(group1, SWT.RADIO);
		bSingleCell.setText("Single Cell");
		bSingleCell.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				config.setViewSelectionMode(MSelectionMode.SINGLE_CELL);
			}
		});
		Button bSingleRow = new Button(group1, SWT.RADIO);
		bSingleRow.setSelection(true);
		bSingleRow.setText("Single Row");
		bSingleRow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				config.setViewSelectionMode(MSelectionMode.SINGLE_ROW);
			}
		});
	}

	private MGridConfigurationSet getConfiguration() throws IOException {
		GridPackage.eINSTANCE.eClass();
		Resource resourceModel = new XMIResourceImpl();
		resourceModel
				.load(PersonSample.class
						.getResourceAsStream("sampleConfig.xmi"), null); //$NON-NLS-1$
		MGrid config = (MGrid) resourceModel.getContents().get(0);
		return config.getDefaultConfiguration();
	}

	private Root getData() throws IOException {
		PersonPackage.eINSTANCE.eClass();
		Resource resourceModel = new XMIResourceImpl();
		resourceModel.load(
				PersonSample.class.getResourceAsStream("sampleData.xmi"), null); //$NON-NLS-1$
		return (Root) resourceModel.getContents().get(0);
	}
}
