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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAuto Filter Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MAutoFilterEntryImpl#getResourceKey <em>Resource Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MAutoFilterEntryImpl extends MinimalEObjectImpl.Container implements MAutoFilterEntry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * The default value of the '{@link #getResourceKey() <em>Resource Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceKey()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceKey() <em>Resource Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceKey()
	 * @generated
	 * @ordered
	 */
	protected String resourceKey = RESOURCE_KEY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MAutoFilterEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GridPackage.Literals.MAUTO_FILTER_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceKey() {
		return resourceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceKey(String newResourceKey) {
		String oldResourceKey = resourceKey;
		resourceKey = newResourceKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MAUTO_FILTER_ENTRY__RESOURCE_KEY, oldResourceKey, resourceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GridPackage.MAUTO_FILTER_ENTRY__RESOURCE_KEY:
				return getResourceKey();
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
			case GridPackage.MAUTO_FILTER_ENTRY__RESOURCE_KEY:
				setResourceKey((String)newValue);
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
			case GridPackage.MAUTO_FILTER_ENTRY__RESOURCE_KEY:
				setResourceKey(RESOURCE_KEY_EDEFAULT);
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
			case GridPackage.MAUTO_FILTER_ENTRY__RESOURCE_KEY:
				return RESOURCE_KEY_EDEFAULT == null ? resourceKey != null : !RESOURCE_KEY_EDEFAULT.equals(resourceKey);
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
		result.append(" (resourceKey: ");
		result.append(resourceKey);
		result.append(')');
		return result.toString();
	}

} //MAutoFilterEntryImpl
