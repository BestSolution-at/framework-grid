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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
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

import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.Property.ChangeListener;
import at.bestsolution.framework.grid.XGrid.Selection;
import at.bestsolution.framework.grid.XGridTable;
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

	public PersonSample() throws Exception {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());

		table = new SWTGridTable<>(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		configurator = new EmfGridTableConfigurator<Person>(table, currentConfig);

		table.contentProviderProperty().set(new EListGridContentProvider<Person>(data, PersonPackage.Literals.ROOT__PERSONS));

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
		addAddRemoveButtons(settings);

		shell.setSize(1000, 400);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

	private void addAddRemoveButtons(Composite settings) {
		Button bAdd = new Button(settings, SWT.NONE);
		bAdd.setText("duplicate first entry");
		bAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!data.getPersons().isEmpty()) {
					data.getPersons().add(EcoreUtil.copy(data.getPersons().get(0)));
				}
			}
		});
		bAdd.setSelection(true);
		Button bRemove = new Button(settings, SWT.NONE);
		bRemove.setText("remove last entry");
		bRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!data.getPersons().isEmpty()) {
					data.getPersons().remove(data.getPersons().size() - 1);
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
		final Label lSelectedItems = new Label(comp, SWT.NONE);
		GridData gd = new GridData();
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessHorizontalSpace = true;
		// gd.widthHint=200;
		lSelectedItems.setLayoutData(gd);
		table.selectionProperty().addChangeListener(new ChangeListener<Selection<Person, Person>>() {
			@Override
			public void valueChanged(Property<Selection<Person, Person>> property, Selection<Person, Person> oldValue,
					Selection<Person, Person> newValue) {
				StringBuffer sb = new StringBuffer();
				for (Person p : newValue.asList()) {
					if (sb.length() > 0) {
						sb.append(", "); //$NON-NLS-1$
					}
					sb.append(p.getFirstname() + " " + p.getLastname()); //$NON-NLS-1$
				}
				lSelectedItems.setText(sb.toString());
			}
		});
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
}
