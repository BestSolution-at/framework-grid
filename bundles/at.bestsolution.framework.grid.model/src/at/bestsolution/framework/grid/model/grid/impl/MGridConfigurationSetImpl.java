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
import at.bestsolution.framework.grid.model.grid.MGridConfiguration;
import at.bestsolution.framework.grid.model.grid.MGridConfigurationSet;
import at.bestsolution.framework.grid.model.grid.MSelectionMode;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MGrid Configuration Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationSetImpl#getViewConfiguration <em>View Configuration</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationSetImpl#getViewSelectionMode <em>View Selection Mode</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationSetImpl#getExportConfiguration <em>Export Configuration</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationSetImpl#getDefaultSortColumn <em>Default Sort Column</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationSetImpl#getGrid <em>Grid</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationSetImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MGridConfigurationSetImpl extends MinimalEObjectImpl.Container implements MGridConfigurationSet {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * The cached value of the '{@link #getViewConfiguration() <em>View Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewConfiguration()
	 * @generated
	 * @ordered
	 */
	protected MGridConfiguration viewConfiguration;

	/**
	 * The default value of the '{@link #getViewSelectionMode() <em>View Selection Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewSelectionMode()
	 * @generated
	 * @ordered
	 */
	protected static final MSelectionMode VIEW_SELECTION_MODE_EDEFAULT = MSelectionMode.SINGLE_ROW;

	/**
	 * The cached value of the '{@link #getViewSelectionMode() <em>View Selection Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewSelectionMode()
	 * @generated
	 * @ordered
	 */
	protected MSelectionMode viewSelectionMode = VIEW_SELECTION_MODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExportConfiguration() <em>Export Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExportConfiguration()
	 * @generated
	 * @ordered
	 */
	protected MGridConfiguration exportConfiguration;

	/**
	 * The cached value of the '{@link #getDefaultSortColumn() <em>Default Sort Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultSortColumn()
	 * @generated
	 * @ordered
	 */
	protected MGridColumn defaultSortColumn;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MGridConfigurationSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GridPackage.Literals.MGRID_CONFIGURATION_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MGridConfiguration getViewConfiguration() {
		if (viewConfiguration != null && viewConfiguration.eIsProxy()) {
			InternalEObject oldViewConfiguration = (InternalEObject)viewConfiguration;
			viewConfiguration = (MGridConfiguration)eResolveProxy(oldViewConfiguration);
			if (viewConfiguration != oldViewConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GridPackage.MGRID_CONFIGURATION_SET__VIEW_CONFIGURATION, oldViewConfiguration, viewConfiguration));
			}
		}
		return viewConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MGridConfiguration basicGetViewConfiguration() {
		return viewConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewConfiguration(MGridConfiguration newViewConfiguration) {
		MGridConfiguration oldViewConfiguration = viewConfiguration;
		viewConfiguration = newViewConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_CONFIGURATION_SET__VIEW_CONFIGURATION, oldViewConfiguration, viewConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MSelectionMode getViewSelectionMode() {
		return viewSelectionMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewSelectionMode(MSelectionMode newViewSelectionMode) {
		MSelectionMode oldViewSelectionMode = viewSelectionMode;
		viewSelectionMode = newViewSelectionMode == null ? VIEW_SELECTION_MODE_EDEFAULT : newViewSelectionMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_CONFIGURATION_SET__VIEW_SELECTION_MODE, oldViewSelectionMode, viewSelectionMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MGridConfiguration getExportConfiguration() {
		if (exportConfiguration != null && exportConfiguration.eIsProxy()) {
			InternalEObject oldExportConfiguration = (InternalEObject)exportConfiguration;
			exportConfiguration = (MGridConfiguration)eResolveProxy(oldExportConfiguration);
			if (exportConfiguration != oldExportConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GridPackage.MGRID_CONFIGURATION_SET__EXPORT_CONFIGURATION, oldExportConfiguration, exportConfiguration));
			}
		}
		return exportConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MGridConfiguration basicGetExportConfiguration() {
		return exportConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExportConfiguration(MGridConfiguration newExportConfiguration) {
		MGridConfiguration oldExportConfiguration = exportConfiguration;
		exportConfiguration = newExportConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_CONFIGURATION_SET__EXPORT_CONFIGURATION, oldExportConfiguration, exportConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MGridColumn getDefaultSortColumn() {
		if (defaultSortColumn != null && defaultSortColumn.eIsProxy()) {
			InternalEObject oldDefaultSortColumn = (InternalEObject)defaultSortColumn;
			defaultSortColumn = (MGridColumn)eResolveProxy(oldDefaultSortColumn);
			if (defaultSortColumn != oldDefaultSortColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GridPackage.MGRID_CONFIGURATION_SET__DEFAULT_SORT_COLUMN, oldDefaultSortColumn, defaultSortColumn));
			}
		}
		return defaultSortColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MGridColumn basicGetDefaultSortColumn() {
		return defaultSortColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultSortColumn(MGridColumn newDefaultSortColumn) {
		MGridColumn oldDefaultSortColumn = defaultSortColumn;
		defaultSortColumn = newDefaultSortColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_CONFIGURATION_SET__DEFAULT_SORT_COLUMN, oldDefaultSortColumn, defaultSortColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MGrid getGrid() {
		if (eContainerFeatureID() != GridPackage.MGRID_CONFIGURATION_SET__GRID) return null;
		return (MGrid)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGrid(MGrid newGrid, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGrid, GridPackage.MGRID_CONFIGURATION_SET__GRID, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrid(MGrid newGrid) {
		if (newGrid != eInternalContainer() || (eContainerFeatureID() != GridPackage.MGRID_CONFIGURATION_SET__GRID && newGrid != null)) {
			if (EcoreUtil.isAncestor(this, newGrid))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGrid != null)
				msgs = ((InternalEObject)newGrid).eInverseAdd(this, GridPackage.MGRID__CONFIGURATION_SETS, MGrid.class, msgs);
			msgs = basicSetGrid(newGrid, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_CONFIGURATION_SET__GRID, newGrid, newGrid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_CONFIGURATION_SET__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GridPackage.MGRID_CONFIGURATION_SET__GRID:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGrid((MGrid)otherEnd, msgs);
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
			case GridPackage.MGRID_CONFIGURATION_SET__GRID:
				return basicSetGrid(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GridPackage.MGRID_CONFIGURATION_SET__GRID:
				return eInternalContainer().eInverseRemove(this, GridPackage.MGRID__CONFIGURATION_SETS, MGrid.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GridPackage.MGRID_CONFIGURATION_SET__VIEW_CONFIGURATION:
				if (resolve) return getViewConfiguration();
				return basicGetViewConfiguration();
			case GridPackage.MGRID_CONFIGURATION_SET__VIEW_SELECTION_MODE:
				return getViewSelectionMode();
			case GridPackage.MGRID_CONFIGURATION_SET__EXPORT_CONFIGURATION:
				if (resolve) return getExportConfiguration();
				return basicGetExportConfiguration();
			case GridPackage.MGRID_CONFIGURATION_SET__DEFAULT_SORT_COLUMN:
				if (resolve) return getDefaultSortColumn();
				return basicGetDefaultSortColumn();
			case GridPackage.MGRID_CONFIGURATION_SET__GRID:
				return getGrid();
			case GridPackage.MGRID_CONFIGURATION_SET__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GridPackage.MGRID_CONFIGURATION_SET__VIEW_CONFIGURATION:
				setViewConfiguration((MGridConfiguration)newValue);
				return;
			case GridPackage.MGRID_CONFIGURATION_SET__VIEW_SELECTION_MODE:
				setViewSelectionMode((MSelectionMode)newValue);
				return;
			case GridPackage.MGRID_CONFIGURATION_SET__EXPORT_CONFIGURATION:
				setExportConfiguration((MGridConfiguration)newValue);
				return;
			case GridPackage.MGRID_CONFIGURATION_SET__DEFAULT_SORT_COLUMN:
				setDefaultSortColumn((MGridColumn)newValue);
				return;
			case GridPackage.MGRID_CONFIGURATION_SET__GRID:
				setGrid((MGrid)newValue);
				return;
			case GridPackage.MGRID_CONFIGURATION_SET__NAME:
				setName((String)newValue);
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
			case GridPackage.MGRID_CONFIGURATION_SET__VIEW_CONFIGURATION:
				setViewConfiguration((MGridConfiguration)null);
				return;
			case GridPackage.MGRID_CONFIGURATION_SET__VIEW_SELECTION_MODE:
				setViewSelectionMode(VIEW_SELECTION_MODE_EDEFAULT);
				return;
			case GridPackage.MGRID_CONFIGURATION_SET__EXPORT_CONFIGURATION:
				setExportConfiguration((MGridConfiguration)null);
				return;
			case GridPackage.MGRID_CONFIGURATION_SET__DEFAULT_SORT_COLUMN:
				setDefaultSortColumn((MGridColumn)null);
				return;
			case GridPackage.MGRID_CONFIGURATION_SET__GRID:
				setGrid((MGrid)null);
				return;
			case GridPackage.MGRID_CONFIGURATION_SET__NAME:
				setName(NAME_EDEFAULT);
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
			case GridPackage.MGRID_CONFIGURATION_SET__VIEW_CONFIGURATION:
				return viewConfiguration != null;
			case GridPackage.MGRID_CONFIGURATION_SET__VIEW_SELECTION_MODE:
				return viewSelectionMode != VIEW_SELECTION_MODE_EDEFAULT;
			case GridPackage.MGRID_CONFIGURATION_SET__EXPORT_CONFIGURATION:
				return exportConfiguration != null;
			case GridPackage.MGRID_CONFIGURATION_SET__DEFAULT_SORT_COLUMN:
				return defaultSortColumn != null;
			case GridPackage.MGRID_CONFIGURATION_SET__GRID:
				return getGrid() != null;
			case GridPackage.MGRID_CONFIGURATION_SET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (viewSelectionMode: ");
		result.append(viewSelectionMode);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MGridConfigurationSetImpl
