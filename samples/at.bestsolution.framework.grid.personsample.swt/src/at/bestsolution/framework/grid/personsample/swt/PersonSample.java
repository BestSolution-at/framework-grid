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
import java.util.Locale;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import at.bestsolution.framework.grid.ElementComparer;
import at.bestsolution.framework.grid.XCellSelection;
import at.bestsolution.framework.grid.XGridCell;
import at.bestsolution.framework.grid.XGridCellMetaData;
import at.bestsolution.framework.grid.XGridTable;
import at.bestsolution.framework.grid.XSelection;
import at.bestsolution.framework.grid.emf.EListGridContentProvider;
import at.bestsolution.framework.grid.emf.EmfGridTableConfigurator;
import at.bestsolution.framework.grid.model.grid.GridPackage;
import at.bestsolution.framework.grid.model.grid.MGrid;
import at.bestsolution.framework.grid.model.grid.MGridConfigurationSet;
import at.bestsolution.framework.grid.model.grid.MSelectionMode;
import at.bestsolution.framework.grid.personsample.model.person.Person;
import at.bestsolution.framework.grid.personsample.model.person.PersonPackage;
import at.bestsolution.framework.grid.personsample.model.person.Root;
import at.bestsolution.framework.grid.swt.SWTGridTable;

@SuppressWarnings("restriction")
public class PersonSample {
	private XGridTable<Person> table;
	private MGridConfigurationSet config1 = getConfiguration("sampleConfig.xmi");
	private MGridConfigurationSet config2 = getConfiguration("sampleConfig2.xmi");
	private MGridConfigurationSet currentConfig = config1;
	private EmfGridTableConfigurator<Person> configurator;
	private final Root dataSample = getData("sampleData.xmi");
	private final Root dataSampleMass = getData("sampleDataMass.xmi");
	private Root data = dataSample;
	private Label lSelectedItems;
	private Label lSelectionMetaItems;

	public PersonSample() throws Exception {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());

		table = new SWTGridTable<>(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		table.elementComparerProperty().set(new PersonComparer());
		configurator = new EmfGridTableConfigurator<Person>(table, currentConfig);

		Composite settings = new Composite(shell, SWT.FILL);
		settings.setLayout(new GridLayout(1, false));
		GridData layoutData = new GridData();
		layoutData.grabExcessHorizontalSpace = true;
		settings.setLayoutData(layoutData);

		addToggleSelectionMode(settings);
		addSelection(settings);
		addToggleLocale(settings);
		addToggleConfiguration(settings);
		addToggleContent(settings);
		addExportButtons(settings);
		addIncrementNumber(settings);

		table.contentProviderProperty().set(new EListGridContentProvider<Person>(data, PersonPackage.Literals.ROOT__PERSONS));

		shell.setSize(1400, 400);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

	private void addIncrementNumber(Composite settings) {
		Button bExport = new Button(settings, SWT.NONE);
		bExport.setText("Increment number");
		bExport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				@NonNull
				XSelection<@NonNull Person> s = table.selectionProperty().get();
				if (!s.isEmpty()) {
					Person p = s.getFirst();
					if (p.getAddress() != null) {
						if (p.getAddress().getNumber() != null) {
							p.getAddress().setNumber(p.getAddress().getNumber() + 1);
						} else {
							p.getAddress().setNumber(1);
						}
					}
				}
			}
		});
	}

	private void addExportButtons(Composite settings) {
		Button bExport = new Button(settings, SWT.NONE);
		bExport.setText("Export data to System.err");
		bExport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Object[][] data = table.getData();
				for (int i = 0; i < data.length; i++) {
					for (int j = 0; j < data[i].length; j++) {
						StringBuffer sb = new StringBuffer();
						sb.append(i + "/" + j + ": ");
						if (data[i][j] != null) {
							sb.append(data[i][j].getClass().getSimpleName());
							sb.append(" / " + data[i][j]);
						} else {
							sb.append("null");
						}
						System.err.println(sb.toString());
					}
				}
			}
		});
	}

	private void setCurrentConfig(MGridConfigurationSet newConfig) {
		currentConfig = newConfig;
		configurator.setConfiguration(currentConfig);
	}

	private void addToggleContent(Composite parent) {
		Group group1 = new Group(parent, SWT.SHADOW_IN);
		group1.setText("Content");
		group1.setLayout(new RowLayout(SWT.VERTICAL));
		Button bSmallData = new Button(group1, SWT.RADIO);
		bSmallData.setText("small");
		bSmallData.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (bSmallData.getSelection()) {
					data = dataSample;
					table.contentProviderProperty().set(new EListGridContentProvider<Person>(data, PersonPackage.Literals.ROOT__PERSONS));
				}
			}
		});
		bSmallData.setSelection(true);
		Button bMassData = new Button(group1, SWT.RADIO);
		bMassData.setText("~10k lines");
		bMassData.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (bMassData.getSelection()) {
					data = dataSampleMass;
					table.contentProviderProperty().set(new EListGridContentProvider<Person>(data, PersonPackage.Literals.ROOT__PERSONS));
				}
			}
		});
	}

	private void addToggleConfiguration(Composite parent) {
		Group group1 = new Group(parent, SWT.SHADOW_IN);
		group1.setText("Presentation model");
		group1.setLayout(new RowLayout(SWT.VERTICAL));
		Button bAll = new Button(group1, SWT.RADIO);
		bAll.setText("all columns");
		bAll.setSelection(true);
		bAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (bAll.getSelection()) {
					setCurrentConfig(config1);
				}
			}
		});
		Button bNoAddress = new Button(group1, SWT.RADIO);
		bNoAddress.setText("no address");
		bNoAddress.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (bNoAddress.getSelection()) {
					setCurrentConfig(config2);
				}
			}
		});
	}

	private void addToggleLocale(Composite parent) {
		Group group1 = new Group(parent, SWT.SHADOW_IN);
		group1.setText("Language");
		group1.setLayout(new RowLayout(SWT.VERTICAL));
		Button bEnglish = new Button(group1, SWT.RADIO);
		bEnglish.setText("English");
		bEnglish.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (bEnglish.getSelection()) {
					table.localeProperty().set(Locale.ENGLISH);
				}
			}
		});
		Button bGerman = new Button(group1, SWT.RADIO);
		bGerman.setSelection(true);
		bGerman.setText("German");
		bGerman.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (bGerman.getSelection()) {
					table.localeProperty().set(Locale.GERMAN);
				}
			}
		});
	}

	public static void main(String[] args) throws Exception {
		new PersonSample();
	}

	private void addSelection(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		GridData cData = new GridData();
		cData.horizontalAlignment = SWT.FILL;
		cData.grabExcessHorizontalSpace = true;
		comp.setLayoutData(cData);
		Label lSelection = new Label(comp, SWT.NONE);
		lSelection.setText("Selection:"); //$NON-NLS-1$
		lSelectedItems = new Label(comp, SWT.NONE);
		GridData gd = new GridData();
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessHorizontalSpace = true;
		// gd.widthHint=200;
		lSelectedItems.setLayoutData(gd);

		Label lSelectionMeta = new Label(comp, SWT.NONE);
		lSelectionMeta.setText("Selection-Meta-Data:"); //$NON-NLS-1$
		lSelectionMetaItems = new Label(comp, SWT.NONE);

		gd = new GridData();
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessHorizontalSpace = true;
		// gd.widthHint=200;
		lSelectionMetaItems.setLayoutData(gd);


		table.selectionProperty().addChangeListener((property, oldValue, newValue) -> updateSelectionLabel(newValue));


	}

	private void addToggleSelectionMode(Composite parent) {
		Group group1 = new Group(parent, SWT.SHADOW_IN);
		group1.setText("Selection mode");
		group1.setLayout(new RowLayout(SWT.VERTICAL));
		Button bSingleCell = new Button(group1, SWT.RADIO);
		bSingleCell.setText("Single Cell");
		bSingleCell.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (bSingleCell.getSelection()) {
					config1.setViewSelectionMode(MSelectionMode.SINGLE_CELL);
					updateSelectionLabel(table.selectionProperty().get());
				}
			}
		});
		Button bSingleRow = new Button(group1, SWT.RADIO);
		bSingleRow.setSelection(true);
		bSingleRow.setText("Single Row");
		bSingleRow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (bSingleRow.getSelection()) {
					config1.setViewSelectionMode(MSelectionMode.SINGLE_ROW);
					updateSelectionLabel(table.selectionProperty().get());
				}
			}
		});
	}

	private MGridConfigurationSet getConfiguration(String configFile) throws IOException {
		GridPackage.eINSTANCE.eClass();
		Resource resourceModel = new XMIResourceImpl();
		resourceModel.load(PersonSample.class.getResourceAsStream(configFile), null); //$NON-NLS-1$
		MGrid config = (MGrid) resourceModel.getContents().get(0);
		return config.getDefaultConfiguration();
	}

	private Root getData(String dataFile) throws IOException {
		PersonPackage.eINSTANCE.eClass();
		Resource resourceModel = new XMIResourceImpl();
		resourceModel.load(PersonSample.class.getResourceAsStream(dataFile), null); //$NON-NLS-1$
		return (Root) resourceModel.getContents().get(0);
	}

	private void updateSelectionLabel(XSelection<Person> newValue) {
		StringBuffer sb = new StringBuffer();
		StringBuffer metaSb = new StringBuffer();

		if (newValue instanceof XCellSelection<?>) {
			XCellSelection<Person> s = (XCellSelection<Person>) newValue;
			for (XGridCell<Person, Object> p : s.getCells()) {
				if (sb.length() > 0) {
					sb.append(", "); //$NON-NLS-1$
				}
				sb.append(p.getCellValue());

				for( XGridCellMetaData m : p.getMetaData() ) {
					metaSb.append( m + "\n");
				}
			}
		} else {
			for (Person p : newValue.asList()) {
				if (sb.length() > 0) {
					sb.append(", "); //$NON-NLS-1$
				}
				sb.append(p.getFirstname() + " " + p.getLastname()); //$NON-NLS-1$
			}

			for( XGridCellMetaData m : newValue.getMetaData() ) {
				metaSb.append( m + "\n");
			}
		}

		lSelectedItems.setText(sb.toString());
		lSelectionMetaItems.setText(metaSb.toString());
	}

	private static class PersonComparer implements ElementComparer<Person> {
		@Override
		public boolean equals(@NonNull Person a, Object obj) {
			if (a == obj)
				return true;
			if (obj == null)
				return false;
			if (a.getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (a.getFirstname() == null) {
				if (other.getFirstname() != null)
					return false;
			} else if (!a.getFirstname().equals(other.getFirstname()))
				return false;
			if (a.getLastname() == null) {
				if (other.getLastname() != null)
					return false;
			} else if (!a.getLastname().equals(other.getLastname()))
				return false;
			return true;
		}

		@Override
		public int hashCode(@NonNull Person element) {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((element.getFirstname() == null) ? 0 : element.getFirstname().hashCode());
			result = prime * result + ((element.getLastname() == null) ? 0 : element.getLastname().hashCode());
			return result;
		}

	}
}
