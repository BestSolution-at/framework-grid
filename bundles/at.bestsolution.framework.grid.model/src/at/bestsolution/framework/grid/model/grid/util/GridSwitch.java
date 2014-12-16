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
package at.bestsolution.framework.grid.model.grid.util;

import at.bestsolution.framework.grid.model.grid.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see at.bestsolution.framework.grid.model.grid.GridPackage
 * @generated
 */
public class GridSwitch<@Nullable T> extends Switch<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GridPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GridSwitch() {
		if (modelPackage == null) {
			modelPackage = GridPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GridPackage.MRESOURCE_BUNDLE: {
				MResourceBundle mResourceBundle = (MResourceBundle)theEObject;
				T result = caseMResourceBundle(mResourceBundle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MRESOURCE_BUNDLE_ENTRY: {
				MResourceBundleEntry mResourceBundleEntry = (MResourceBundleEntry)theEObject;
				T result = caseMResourceBundleEntry(mResourceBundleEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MGRID: {
				MGrid mGrid = (MGrid)theEObject;
				T result = caseMGrid(mGrid);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MGRID_CONFIGURATION_SET: {
				MGridConfigurationSet mGridConfigurationSet = (MGridConfigurationSet)theEObject;
				T result = caseMGridConfigurationSet(mGridConfigurationSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MGRID_CONFIGURATION: {
				MGridConfiguration mGridConfiguration = (MGridConfiguration)theEObject;
				T result = caseMGridConfiguration(mGridConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MGRID_CONFIGURATION_COLUMN: {
				MGridConfigurationColumn mGridConfigurationColumn = (MGridConfigurationColumn)theEObject;
				T result = caseMGridConfigurationColumn(mGridConfigurationColumn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MGRID_COLUMN: {
				MGridColumn mGridColumn = (MGridColumn)theEObject;
				T result = caseMGridColumn(mGridColumn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MBOOLEAN_GRID_COLUMN: {
				MBooleanGridColumn mBooleanGridColumn = (MBooleanGridColumn)theEObject;
				T result = caseMBooleanGridColumn(mBooleanGridColumn);
				if (result == null) result = caseMGridColumn(mBooleanGridColumn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MCELL_VALUE_FUNCTION: {
				MCellValueFunction mCellValueFunction = (MCellValueFunction)theEObject;
				T result = caseMCellValueFunction(mCellValueFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MPATH_CELL_VALUE_FUNCTION: {
				MPathCellValueFunction mPathCellValueFunction = (MPathCellValueFunction)theEObject;
				T result = caseMPathCellValueFunction(mPathCellValueFunction);
				if (result == null) result = caseMCellValueFunction(mPathCellValueFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MPATH_SEGMENT: {
				MPathSegment mPathSegment = (MPathSegment)theEObject;
				T result = caseMPathSegment(mPathSegment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MSIMPLE_PATH_SEGMENT: {
				MSimplePathSegment mSimplePathSegment = (MSimplePathSegment)theEObject;
				T result = caseMSimplePathSegment(mSimplePathSegment);
				if (result == null) result = caseMPathSegment(mSimplePathSegment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MCELL_TEXT_FUNCTION: {
				MCellTextFunction mCellTextFunction = (MCellTextFunction)theEObject;
				T result = caseMCellTextFunction(mCellTextFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MFORMATTED_CELL_TEXT_FUNCTION: {
				MFormattedCellTextFunction mFormattedCellTextFunction = (MFormattedCellTextFunction)theEObject;
				T result = caseMFormattedCellTextFunction(mFormattedCellTextFunction);
				if (result == null) result = caseMCellTextFunction(mFormattedCellTextFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MPATTERN: {
				MPattern mPattern = (MPattern)theEObject;
				T result = caseMPattern(mPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MSTRING_PATTERN: {
				MStringPattern mStringPattern = (MStringPattern)theEObject;
				T result = caseMStringPattern(mStringPattern);
				if (result == null) result = caseMPattern(mStringPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MREFERENCE_PATTERN: {
				MReferencePattern mReferencePattern = (MReferencePattern)theEObject;
				T result = caseMReferencePattern(mReferencePattern);
				if (result == null) result = caseMPattern(mReferencePattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MAUTO_FILTER_CONFIGURATION: {
				MAutoFilterConfiguration mAutoFilterConfiguration = (MAutoFilterConfiguration)theEObject;
				T result = caseMAutoFilterConfiguration(mAutoFilterConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION: {
				MComboAutoFilterConfiguration mComboAutoFilterConfiguration = (MComboAutoFilterConfiguration)theEObject;
				T result = caseMComboAutoFilterConfiguration(mComboAutoFilterConfiguration);
				if (result == null) result = caseMAutoFilterConfiguration(mComboAutoFilterConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MFREE_TEXT_AUTO_FILTER_CONFIGURATION: {
				MFreeTextAutoFilterConfiguration mFreeTextAutoFilterConfiguration = (MFreeTextAutoFilterConfiguration)theEObject;
				T result = caseMFreeTextAutoFilterConfiguration(mFreeTextAutoFilterConfiguration);
				if (result == null) result = caseMAutoFilterConfiguration(mFreeTextAutoFilterConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MAUTO_FILTER_ENTRY: {
				MAutoFilterEntry mAutoFilterEntry = (MAutoFilterEntry)theEObject;
				T result = caseMAutoFilterEntry(mAutoFilterEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MTEXT_AUTO_FILTER_ENTRY: {
				MTextAutoFilterEntry mTextAutoFilterEntry = (MTextAutoFilterEntry)theEObject;
				T result = caseMTextAutoFilterEntry(mTextAutoFilterEntry);
				if (result == null) result = caseMAutoFilterEntry(mTextAutoFilterEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MDEFAULT_AUTO_FILTER_ENTRY: {
				MDefaultAutoFilterEntry mDefaultAutoFilterEntry = (MDefaultAutoFilterEntry)theEObject;
				T result = caseMDefaultAutoFilterEntry(mDefaultAutoFilterEntry);
				if (result == null) result = caseMAutoFilterEntry(mDefaultAutoFilterEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MMETA_DATA: {
				MMetaData mMetaData = (MMetaData)theEObject;
				T result = caseMMetaData(mMetaData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GridPackage.MSIMPLE_META_DATA: {
				MSimpleMetaData mSimpleMetaData = (MSimpleMetaData)theEObject;
				T result = caseMSimpleMetaData(mSimpleMetaData);
				if (result == null) result = caseMMetaData(mSimpleMetaData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MResource Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MResource Bundle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMResourceBundle(MResourceBundle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MResource Bundle Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MResource Bundle Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMResourceBundleEntry(MResourceBundleEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MGrid</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MGrid</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMGrid(MGrid object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MGrid Configuration Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MGrid Configuration Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMGridConfigurationSet(MGridConfigurationSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MGrid Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MGrid Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMGridConfiguration(MGridConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MGrid Configuration Column</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MGrid Configuration Column</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMGridConfigurationColumn(MGridConfigurationColumn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MGrid Column</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MGrid Column</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMGridColumn(MGridColumn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MBoolean Grid Column</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MBoolean Grid Column</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMBooleanGridColumn(MBooleanGridColumn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MCell Value Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MCell Value Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMCellValueFunction(MCellValueFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MPath Cell Value Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MPath Cell Value Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMPathCellValueFunction(MPathCellValueFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MPath Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MPath Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMPathSegment(MPathSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MSimple Path Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MSimple Path Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMSimplePathSegment(MSimplePathSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MCell Text Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MCell Text Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMCellTextFunction(MCellTextFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MFormatted Cell Text Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MFormatted Cell Text Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMFormattedCellTextFunction(MFormattedCellTextFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MPattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MPattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMPattern(MPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MString Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MString Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMStringPattern(MStringPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MReference Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MReference Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMReferencePattern(MReferencePattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MAuto Filter Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MAuto Filter Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMAutoFilterConfiguration(MAutoFilterConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MCombo Auto Filter Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MCombo Auto Filter Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMComboAutoFilterConfiguration(MComboAutoFilterConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MFree Text Auto Filter Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MFree Text Auto Filter Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMFreeTextAutoFilterConfiguration(MFreeTextAutoFilterConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MAuto Filter Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MAuto Filter Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMAutoFilterEntry(MAutoFilterEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MText Auto Filter Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MText Auto Filter Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMTextAutoFilterEntry(MTextAutoFilterEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MDefault Auto Filter Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MDefault Auto Filter Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMDefaultAutoFilterEntry(MDefaultAutoFilterEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MMeta Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MMeta Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMMetaData(MMetaData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MSimple Meta Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MSimple Meta Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMSimpleMetaData(MSimpleMetaData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //GridSwitch
