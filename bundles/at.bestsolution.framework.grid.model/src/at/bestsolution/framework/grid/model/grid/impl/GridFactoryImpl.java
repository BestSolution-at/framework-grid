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

import at.bestsolution.framework.grid.model.grid.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GridFactoryImpl extends EFactoryImpl implements GridFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GridFactory init() {
		try {
			GridFactory theGridFactory = (GridFactory)EPackage.Registry.INSTANCE.getEFactory(GridPackage.eNS_URI);
			if (theGridFactory != null) {
				return theGridFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GridFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GridFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GridPackage.MRESOURCE_BUNDLE: return createMResourceBundle();
			case GridPackage.MRESOURCE_BUNDLE_ENTRY: return createMResourceBundleEntry();
			case GridPackage.MGRID: return createMGrid();
			case GridPackage.MGRID_CONFIGURATION_SET: return createMGridConfigurationSet();
			case GridPackage.MGRID_CONFIGURATION: return createMGridConfiguration();
			case GridPackage.MGRID_CONFIGURATION_COLUMN: return createMGridConfigurationColumn();
			case GridPackage.MGRID_COLUMN: return createMGridColumn();
			case GridPackage.MPATH_CELL_VALUE_FUNCTION: return createMPathCellValueFunction();
			case GridPackage.MSIMPLE_PATH_SEGMENT: return createMSimplePathSegment();
			case GridPackage.MFORMATTED_CELL_TEXT_FUNCTION: return createMFormattedCellTextFunction();
			case GridPackage.MSTRING_PATTERN: return createMStringPattern();
			case GridPackage.MREFERENCE_PATTERN: return createMReferencePattern();
			case GridPackage.MCOMBO_AUTO_FILTER_CONFIGURATION: return createMComboAutoFilterConfiguration();
			case GridPackage.MFREE_TEXT_AUTO_FILTER_CONFIGURATION: return createMFreeTextAutoFilterConfiguration();
			case GridPackage.MTEXT_AUTO_FILTER_ENTRY: return createMTextAutoFilterEntry();
			case GridPackage.MDEFAULT_AUTO_FILTER_ENTRY: return createMDefaultAutoFilterEntry();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case GridPackage.MFORMAT_TYPE:
				return createMFormatTypeFromString(eDataType, initialValue);
			case GridPackage.MSELECTION_MODE:
				return createMSelectionModeFromString(eDataType, initialValue);
			case GridPackage.MALIGNMENT:
				return createMAlignmentFromString(eDataType, initialValue);
			case GridPackage.MDEFAULT_AUTO_FILTER_ENTRY_TYPE:
				return createMDefaultAutoFilterEntryTypeFromString(eDataType, initialValue);
			case GridPackage.MAUTO_FILTER_MATCH_TYPE:
				return createMAutoFilterMatchTypeFromString(eDataType, initialValue);
			case GridPackage.MSORTING_BEHAVIOR:
				return createMSortingBehaviorFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case GridPackage.MFORMAT_TYPE:
				return convertMFormatTypeToString(eDataType, instanceValue);
			case GridPackage.MSELECTION_MODE:
				return convertMSelectionModeToString(eDataType, instanceValue);
			case GridPackage.MALIGNMENT:
				return convertMAlignmentToString(eDataType, instanceValue);
			case GridPackage.MDEFAULT_AUTO_FILTER_ENTRY_TYPE:
				return convertMDefaultAutoFilterEntryTypeToString(eDataType, instanceValue);
			case GridPackage.MAUTO_FILTER_MATCH_TYPE:
				return convertMAutoFilterMatchTypeToString(eDataType, instanceValue);
			case GridPackage.MSORTING_BEHAVIOR:
				return convertMSortingBehaviorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MResourceBundle createMResourceBundle() {
		MResourceBundleImpl mResourceBundle = new MResourceBundleImpl();
		return mResourceBundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MResourceBundleEntry createMResourceBundleEntry() {
		MResourceBundleEntryImpl mResourceBundleEntry = new MResourceBundleEntryImpl();
		return mResourceBundleEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MGrid createMGrid() {
		MGridImpl mGrid = new MGridImpl();
		return mGrid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MGridConfigurationSet createMGridConfigurationSet() {
		MGridConfigurationSetImpl mGridConfigurationSet = new MGridConfigurationSetImpl();
		return mGridConfigurationSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MGridConfiguration createMGridConfiguration() {
		MGridConfigurationImpl mGridConfiguration = new MGridConfigurationImpl();
		return mGridConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MGridConfigurationColumn createMGridConfigurationColumn() {
		MGridConfigurationColumnImpl mGridConfigurationColumn = new MGridConfigurationColumnImpl();
		return mGridConfigurationColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MGridColumn createMGridColumn() {
		MGridColumnImpl mGridColumn = new MGridColumnImpl();
		return mGridColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MPathCellValueFunction createMPathCellValueFunction() {
		MPathCellValueFunctionImpl mPathCellValueFunction = new MPathCellValueFunctionImpl();
		return mPathCellValueFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MSimplePathSegment createMSimplePathSegment() {
		MSimplePathSegmentImpl mSimplePathSegment = new MSimplePathSegmentImpl();
		return mSimplePathSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MFormattedCellTextFunction createMFormattedCellTextFunction() {
		MFormattedCellTextFunctionImpl mFormattedCellTextFunction = new MFormattedCellTextFunctionImpl();
		return mFormattedCellTextFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MStringPattern createMStringPattern() {
		MStringPatternImpl mStringPattern = new MStringPatternImpl();
		return mStringPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MReferencePattern createMReferencePattern() {
		MReferencePatternImpl mReferencePattern = new MReferencePatternImpl();
		return mReferencePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MComboAutoFilterConfiguration createMComboAutoFilterConfiguration() {
		MComboAutoFilterConfigurationImpl mComboAutoFilterConfiguration = new MComboAutoFilterConfigurationImpl();
		return mComboAutoFilterConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MFreeTextAutoFilterConfiguration createMFreeTextAutoFilterConfiguration() {
		MFreeTextAutoFilterConfigurationImpl mFreeTextAutoFilterConfiguration = new MFreeTextAutoFilterConfigurationImpl();
		return mFreeTextAutoFilterConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MTextAutoFilterEntry createMTextAutoFilterEntry() {
		MTextAutoFilterEntryImpl mTextAutoFilterEntry = new MTextAutoFilterEntryImpl();
		return mTextAutoFilterEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MDefaultAutoFilterEntry createMDefaultAutoFilterEntry() {
		MDefaultAutoFilterEntryImpl mDefaultAutoFilterEntry = new MDefaultAutoFilterEntryImpl();
		return mDefaultAutoFilterEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MFormatType createMFormatTypeFromString(EDataType eDataType, String initialValue) {
		MFormatType result = MFormatType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMFormatTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MSelectionMode createMSelectionModeFromString(EDataType eDataType, String initialValue) {
		MSelectionMode result = MSelectionMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMSelectionModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAlignment createMAlignmentFromString(EDataType eDataType, String initialValue) {
		MAlignment result = MAlignment.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMAlignmentToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MDefaultAutoFilterEntryType createMDefaultAutoFilterEntryTypeFromString(EDataType eDataType, String initialValue) {
		MDefaultAutoFilterEntryType result = MDefaultAutoFilterEntryType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMDefaultAutoFilterEntryTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAutoFilterMatchType createMAutoFilterMatchTypeFromString(EDataType eDataType, String initialValue) {
		MAutoFilterMatchType result = MAutoFilterMatchType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMAutoFilterMatchTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MSortingBehavior createMSortingBehaviorFromString(EDataType eDataType, String initialValue) {
		MSortingBehavior result = MSortingBehavior.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMSortingBehaviorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GridPackage getGridPackage() {
		return (GridPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GridPackage getPackage() {
		return GridPackage.eINSTANCE;
	}

} //GridFactoryImpl
