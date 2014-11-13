/**
 *   Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,
 *   http://www.BestSolution.at
 *  
 *   This file is part of framework-grid which was developed with funding
 *   from DI Christoph Hermann - InformationsTechnologie Beratung Hermann
 *   /Austria.
 *  
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *  
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 */
package at.bestsolution.framework.grid.model.grid.impl;

import at.bestsolution.framework.grid.model.grid.GridPackage;
import at.bestsolution.framework.grid.model.grid.MGrid;
import at.bestsolution.framework.grid.model.grid.MGridColumn;
import at.bestsolution.framework.grid.model.grid.MGridConfigurationSet;
import at.bestsolution.framework.grid.model.grid.MResourceBundle;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MGrid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridImpl#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridImpl#getDefaultConfiguration <em>Default Configuration</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridImpl#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MGridImpl extends MinimalEObjectImpl.Container implements MGrid {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * The cached value of the '{@link #getColumns() <em>Columns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumns()
	 * @generated
	 * @ordered
	 */
	protected EList<MGridColumn> columns;

	/**
	 * The cached value of the '{@link #getConfigurations() <em>Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<MGridConfigurationSet> configurations;

	/**
	 * The cached value of the '{@link #getDefaultConfiguration() <em>Default Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultConfiguration()
	 * @generated
	 * @ordered
	 */
	protected MGridConfigurationSet defaultConfiguration;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<MResourceBundle> resources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MGridImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GridPackage.Literals.MGRID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MGridColumn> getColumns() {
		if (columns == null) {
			columns = new EObjectContainmentWithInverseEList<MGridColumn>(MGridColumn.class, this, GridPackage.MGRID__COLUMNS, GridPackage.MGRID_COLUMN__GRID);
		}
		return columns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MGridConfigurationSet> getConfigurations() {
		if (configurations == null) {
			configurations = new EObjectContainmentWithInverseEList<MGridConfigurationSet>(MGridConfigurationSet.class, this, GridPackage.MGRID__CONFIGURATIONS, GridPackage.MGRID_CONFIGURATION_SET__GRID);
		}
		return configurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MGridConfigurationSet getDefaultConfiguration() {
		if (defaultConfiguration != null && defaultConfiguration.eIsProxy()) {
			InternalEObject oldDefaultConfiguration = (InternalEObject)defaultConfiguration;
			defaultConfiguration = (MGridConfigurationSet)eResolveProxy(oldDefaultConfiguration);
			if (defaultConfiguration != oldDefaultConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GridPackage.MGRID__DEFAULT_CONFIGURATION, oldDefaultConfiguration, defaultConfiguration));
			}
		}
		return defaultConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MGridConfigurationSet basicGetDefaultConfiguration() {
		return defaultConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultConfiguration(MGridConfigurationSet newDefaultConfiguration) {
		MGridConfigurationSet oldDefaultConfiguration = defaultConfiguration;
		defaultConfiguration = newDefaultConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID__DEFAULT_CONFIGURATION, oldDefaultConfiguration, defaultConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MResourceBundle> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<MResourceBundle>(MResourceBundle.class, this, GridPackage.MGRID__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GridPackage.MGRID__COLUMNS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getColumns()).basicAdd(otherEnd, msgs);
			case GridPackage.MGRID__CONFIGURATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConfigurations()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GridPackage.MGRID__COLUMNS:
				return ((InternalEList<?>)getColumns()).basicRemove(otherEnd, msgs);
			case GridPackage.MGRID__CONFIGURATIONS:
				return ((InternalEList<?>)getConfigurations()).basicRemove(otherEnd, msgs);
			case GridPackage.MGRID__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GridPackage.MGRID__COLUMNS:
				return getColumns();
			case GridPackage.MGRID__CONFIGURATIONS:
				return getConfigurations();
			case GridPackage.MGRID__DEFAULT_CONFIGURATION:
				if (resolve) return getDefaultConfiguration();
				return basicGetDefaultConfiguration();
			case GridPackage.MGRID__RESOURCES:
				return getResources();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GridPackage.MGRID__COLUMNS:
				getColumns().clear();
				getColumns().addAll((Collection<? extends MGridColumn>)newValue);
				return;
			case GridPackage.MGRID__CONFIGURATIONS:
				getConfigurations().clear();
				getConfigurations().addAll((Collection<? extends MGridConfigurationSet>)newValue);
				return;
			case GridPackage.MGRID__DEFAULT_CONFIGURATION:
				setDefaultConfiguration((MGridConfigurationSet)newValue);
				return;
			case GridPackage.MGRID__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends MResourceBundle>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GridPackage.MGRID__COLUMNS:
				getColumns().clear();
				return;
			case GridPackage.MGRID__CONFIGURATIONS:
				getConfigurations().clear();
				return;
			case GridPackage.MGRID__DEFAULT_CONFIGURATION:
				setDefaultConfiguration((MGridConfigurationSet)null);
				return;
			case GridPackage.MGRID__RESOURCES:
				getResources().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GridPackage.MGRID__COLUMNS:
				return columns != null && !columns.isEmpty();
			case GridPackage.MGRID__CONFIGURATIONS:
				return configurations != null && !configurations.isEmpty();
			case GridPackage.MGRID__DEFAULT_CONFIGURATION:
				return defaultConfiguration != null;
			case GridPackage.MGRID__RESOURCES:
				return resources != null && !resources.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MGridImpl
