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
import at.bestsolution.framework.grid.model.grid.MResourceBundle;
import at.bestsolution.framework.grid.model.grid.MResourceBundleEntry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MResource Bundle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MResourceBundleImpl#getLocale <em>Locale</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MResourceBundleImpl#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MResourceBundleImpl extends MinimalEObjectImpl.Container implements MResourceBundle {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * The default value of the '{@link #getLocale() <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocale()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCALE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocale() <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocale()
	 * @generated
	 * @ordered
	 */
	protected String locale = LOCALE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntries()
	 * @generated
	 * @ordered
	 */
	protected MResourceBundleEntry entries;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MResourceBundleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GridPackage.Literals.MRESOURCE_BUNDLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocale(String newLocale) {
		String oldLocale = locale;
		locale = newLocale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MRESOURCE_BUNDLE__LOCALE, oldLocale, locale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MResourceBundleEntry getEntries() {
		return entries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntries(MResourceBundleEntry newEntries, NotificationChain msgs) {
		MResourceBundleEntry oldEntries = entries;
		entries = newEntries;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GridPackage.MRESOURCE_BUNDLE__ENTRIES, oldEntries, newEntries);
			if (msgs == null) return notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntries(MResourceBundleEntry newEntries) {
		if (newEntries != entries) {
			NotificationChain msgs = null;
			if (entries != null)
				msgs = ((InternalEObject)entries).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GridPackage.MRESOURCE_BUNDLE__ENTRIES, null, msgs);
			if (newEntries != null)
				msgs = ((InternalEObject)newEntries).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GridPackage.MRESOURCE_BUNDLE__ENTRIES, null, msgs);
			msgs = basicSetEntries(newEntries, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MRESOURCE_BUNDLE__ENTRIES, newEntries, newEntries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GridPackage.MRESOURCE_BUNDLE__ENTRIES:
				return basicSetEntries(null, msgs);
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
			case GridPackage.MRESOURCE_BUNDLE__LOCALE:
				return getLocale();
			case GridPackage.MRESOURCE_BUNDLE__ENTRIES:
				return getEntries();
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
			case GridPackage.MRESOURCE_BUNDLE__LOCALE:
				setLocale((String)newValue);
				return;
			case GridPackage.MRESOURCE_BUNDLE__ENTRIES:
				setEntries((MResourceBundleEntry)newValue);
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
			case GridPackage.MRESOURCE_BUNDLE__LOCALE:
				setLocale(LOCALE_EDEFAULT);
				return;
			case GridPackage.MRESOURCE_BUNDLE__ENTRIES:
				setEntries((MResourceBundleEntry)null);
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
			case GridPackage.MRESOURCE_BUNDLE__LOCALE:
				return LOCALE_EDEFAULT == null ? locale != null : !LOCALE_EDEFAULT.equals(locale);
			case GridPackage.MRESOURCE_BUNDLE__ENTRIES:
				return entries != null;
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
		result.append(" (locale: ");
		result.append(locale);
		result.append(')');
		return result.toString();
	}

} //MResourceBundleImpl
