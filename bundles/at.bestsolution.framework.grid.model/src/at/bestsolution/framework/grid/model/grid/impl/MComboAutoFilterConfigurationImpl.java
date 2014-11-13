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
import at.bestsolution.framework.grid.model.grid.MAutoFilterEntry;
import at.bestsolution.framework.grid.model.grid.MCellTextFunction;
import at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MCombo Auto Filter Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MComboAutoFilterConfigurationImpl#getPredefinedValues <em>Predefined Values</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MComboAutoFilterConfigurationImpl#getDefaultSelection <em>Default Selection</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MComboAutoFilterConfigurationImpl#getCellTextFunction <em>Cell Text Function</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MComboAutoFilterConfigurationImpl extends MAutoFilterConfigurationImpl implements MComboAutoFilterConfiguration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * The cached value of the '{@link #getPredefinedValues() <em>Predefined Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredefinedValues()
	 * @generated
	 * @ordered
	 */
	protected EList<MAutoFilterEntry> predefinedValues;

	/**
	 * The cached value of the '{@link #getDefaultSelection() <em>Default Selection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultSelection()
	 * @generated
	 * @ordered
	 */
	protected MAutoFilterEntry defaultSelection;

	/**
	 * The cached value of the '{@link #getCellTextFunction() <em>Cell Text Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCellTextFunction()
	 * @generated
	 * @ordered
	 */
	protected MCellTextFunction cellTextFunction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MComboAutoFilterConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GridPackage.Literals.MCOMBO_AUTO_FILTER_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MAutoFilterEntry> getPredefinedValues() {
		if (predefinedValues == null) {
			predefinedValues = new EObjectContainmentEList<MAutoFilterEntry>(MAutoFilterEntry.class, this, GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__PREDEFINED_VALUES);
		}
		return predefinedValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAutoFilterEntry getDefaultSelection() {
		if (defaultSelection != null && defaultSelection.eIsProxy()) {
			InternalEObject oldDefaultSelection = (InternalEObject)defaultSelection;
			defaultSelection = (MAutoFilterEntry)eResolveProxy(oldDefaultSelection);
			if (defaultSelection != oldDefaultSelection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__DEFAULT_SELECTION, oldDefaultSelection, defaultSelection));
			}
		}
		return defaultSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAutoFilterEntry basicGetDefaultSelection() {
		return defaultSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultSelection(MAutoFilterEntry newDefaultSelection) {
		MAutoFilterEntry oldDefaultSelection = defaultSelection;
		defaultSelection = newDefaultSelection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__DEFAULT_SELECTION, oldDefaultSelection, defaultSelection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MCellTextFunction getCellTextFunction() {
		return cellTextFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCellTextFunction(MCellTextFunction newCellTextFunction, NotificationChain msgs) {
		MCellTextFunction oldCellTextFunction = cellTextFunction;
		cellTextFunction = newCellTextFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__CELL_TEXT_FUNCTION, oldCellTextFunction, newCellTextFunction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCellTextFunction(MCellTextFunction newCellTextFunction) {
		if (newCellTextFunction != cellTextFunction) {
			NotificationChain msgs = null;
			if (cellTextFunction != null)
				msgs = ((InternalEObject)cellTextFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__CELL_TEXT_FUNCTION, null, msgs);
			if (newCellTextFunction != null)
				msgs = ((InternalEObject)newCellTextFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__CELL_TEXT_FUNCTION, null, msgs);
			msgs = basicSetCellTextFunction(newCellTextFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__CELL_TEXT_FUNCTION, newCellTextFunction, newCellTextFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__PREDEFINED_VALUES:
				return ((InternalEList<?>)getPredefinedValues()).basicRemove(otherEnd, msgs);
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__CELL_TEXT_FUNCTION:
				return basicSetCellTextFunction(null, msgs);
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
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__PREDEFINED_VALUES:
				return getPredefinedValues();
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__DEFAULT_SELECTION:
				if (resolve) return getDefaultSelection();
				return basicGetDefaultSelection();
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__CELL_TEXT_FUNCTION:
				return getCellTextFunction();
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
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__PREDEFINED_VALUES:
				getPredefinedValues().clear();
				getPredefinedValues().addAll((Collection<? extends MAutoFilterEntry>)newValue);
				return;
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__DEFAULT_SELECTION:
				setDefaultSelection((MAutoFilterEntry)newValue);
				return;
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__CELL_TEXT_FUNCTION:
				setCellTextFunction((MCellTextFunction)newValue);
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
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__PREDEFINED_VALUES:
				getPredefinedValues().clear();
				return;
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__DEFAULT_SELECTION:
				setDefaultSelection((MAutoFilterEntry)null);
				return;
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__CELL_TEXT_FUNCTION:
				setCellTextFunction((MCellTextFunction)null);
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
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__PREDEFINED_VALUES:
				return predefinedValues != null && !predefinedValues.isEmpty();
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__DEFAULT_SELECTION:
				return defaultSelection != null;
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION__CELL_TEXT_FUNCTION:
				return cellTextFunction != null;
		}
		return super.eIsSet(featureID);
	}

} //MComboAutoFilterConfigurationImpl
