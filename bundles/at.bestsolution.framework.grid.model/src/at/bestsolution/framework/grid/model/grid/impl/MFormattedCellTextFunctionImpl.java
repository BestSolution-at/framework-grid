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
import at.bestsolution.framework.grid.model.grid.MFormatType;
import at.bestsolution.framework.grid.model.grid.MFormattedCellTextFunction;
import at.bestsolution.framework.grid.model.grid.MPattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MFormatted Cell Text Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MFormattedCellTextFunctionImpl#getFormatType <em>Format Type</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MFormattedCellTextFunctionImpl#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MFormattedCellTextFunctionImpl extends MCellTextFunctionImpl implements MFormattedCellTextFunction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * The default value of the '{@link #getFormatType() <em>Format Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormatType()
	 * @generated
	 * @ordered
	 */
	protected static final MFormatType FORMAT_TYPE_EDEFAULT = MFormatType.NUMBER;

	/**
	 * The cached value of the '{@link #getFormatType() <em>Format Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormatType()
	 * @generated
	 * @ordered
	 */
	protected MFormatType formatType = FORMAT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected MPattern pattern;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MFormattedCellTextFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GridPackage.Literals.MFORMATTED_CELL_TEXT_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MFormatType getFormatType() {
		return formatType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormatType(MFormatType newFormatType) {
		MFormatType oldFormatType = formatType;
		formatType = newFormatType == null ? FORMAT_TYPE_EDEFAULT : newFormatType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MFORMATTED_CELL_TEXT_FUNCTION__FORMAT_TYPE, oldFormatType, formatType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MPattern getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPattern(MPattern newPattern, NotificationChain msgs) {
		MPattern oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GridPackage.MFORMATTED_CELL_TEXT_FUNCTION__PATTERN, oldPattern, newPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(MPattern newPattern) {
		if (newPattern != pattern) {
			NotificationChain msgs = null;
			if (pattern != null)
				msgs = ((InternalEObject)pattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GridPackage.MFORMATTED_CELL_TEXT_FUNCTION__PATTERN, null, msgs);
			if (newPattern != null)
				msgs = ((InternalEObject)newPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GridPackage.MFORMATTED_CELL_TEXT_FUNCTION__PATTERN, null, msgs);
			msgs = basicSetPattern(newPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MFORMATTED_CELL_TEXT_FUNCTION__PATTERN, newPattern, newPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GridPackage.MFORMATTED_CELL_TEXT_FUNCTION__PATTERN:
				return basicSetPattern(null, msgs);
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
			case GridPackage.MFORMATTED_CELL_TEXT_FUNCTION__FORMAT_TYPE:
				return getFormatType();
			case GridPackage.MFORMATTED_CELL_TEXT_FUNCTION__PATTERN:
				return getPattern();
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
			case GridPackage.MFORMATTED_CELL_TEXT_FUNCTION__FORMAT_TYPE:
				setFormatType((MFormatType)newValue);
				return;
			case GridPackage.MFORMATTED_CELL_TEXT_FUNCTION__PATTERN:
				setPattern((MPattern)newValue);
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
			case GridPackage.MFORMATTED_CELL_TEXT_FUNCTION__FORMAT_TYPE:
				setFormatType(FORMAT_TYPE_EDEFAULT);
				return;
			case GridPackage.MFORMATTED_CELL_TEXT_FUNCTION__PATTERN:
				setPattern((MPattern)null);
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
			case GridPackage.MFORMATTED_CELL_TEXT_FUNCTION__FORMAT_TYPE:
				return formatType != FORMAT_TYPE_EDEFAULT;
			case GridPackage.MFORMATTED_CELL_TEXT_FUNCTION__PATTERN:
				return pattern != null;
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
		result.append(" (formatType: ");
		result.append(formatType);
		result.append(')');
		return result.toString();
	}

} //MFormattedCellTextFunctionImpl
