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

import at.bestsolution.framework.grid.model.grid.GridFactory;
import at.bestsolution.framework.grid.model.grid.GridPackage;
import at.bestsolution.framework.grid.model.grid.MAlignment;
import at.bestsolution.framework.grid.model.grid.MAutoFilterConfiguration;
import at.bestsolution.framework.grid.model.grid.MAutoFilterEntry;
import at.bestsolution.framework.grid.model.grid.MAutoFilterMatchType;
import at.bestsolution.framework.grid.model.grid.MBooleanGridColumn;
import at.bestsolution.framework.grid.model.grid.MCellTextFunction;
import at.bestsolution.framework.grid.model.grid.MCellValueFunction;
import at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration;
import at.bestsolution.framework.grid.model.grid.MDefaultAutoFilterEntry;
import at.bestsolution.framework.grid.model.grid.MDefaultAutoFilterEntryType;
import at.bestsolution.framework.grid.model.grid.MFormatType;
import at.bestsolution.framework.grid.model.grid.MFormattedCellTextFunction;
import at.bestsolution.framework.grid.model.grid.MFreeTextAutoFilterConfiguration;
import at.bestsolution.framework.grid.model.grid.MGrid;
import at.bestsolution.framework.grid.model.grid.MGridColumn;
import at.bestsolution.framework.grid.model.grid.MGridConfiguration;
import at.bestsolution.framework.grid.model.grid.MGridConfigurationColumn;
import at.bestsolution.framework.grid.model.grid.MGridConfigurationSet;
import at.bestsolution.framework.grid.model.grid.MMetaData;
import at.bestsolution.framework.grid.model.grid.MPathCellValueFunction;
import at.bestsolution.framework.grid.model.grid.MPathSegment;
import at.bestsolution.framework.grid.model.grid.MPattern;
import at.bestsolution.framework.grid.model.grid.MReferencePattern;
import at.bestsolution.framework.grid.model.grid.MResourceBundle;
import at.bestsolution.framework.grid.model.grid.MResourceBundleEntry;
import at.bestsolution.framework.grid.model.grid.MSelectionMode;
import at.bestsolution.framework.grid.model.grid.MSimpleMetaData;
import at.bestsolution.framework.grid.model.grid.MSimplePathSegment;
import at.bestsolution.framework.grid.model.grid.MSortingBehavior;
import at.bestsolution.framework.grid.model.grid.MStringPattern;
import at.bestsolution.framework.grid.model.grid.MTextAutoFilterEntry;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GridPackageImpl extends EPackageImpl implements GridPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mResourceBundleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mResourceBundleEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mGridEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mGridConfigurationSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mGridConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mGridConfigurationColumnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mGridColumnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mBooleanGridColumnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mCellValueFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mPathCellValueFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mPathSegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mSimplePathSegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mCellTextFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mFormattedCellTextFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mStringPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mReferencePatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mAutoFilterConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mComboAutoFilterConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mFreeTextAutoFilterConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mAutoFilterEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mTextAutoFilterEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mDefaultAutoFilterEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mMetaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mSimpleMetaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mFormatTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mSelectionModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mAlignmentEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mDefaultAutoFilterEntryTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mAutoFilterMatchTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mSortingBehaviorEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GridPackageImpl() {
		super(eNS_URI, GridFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link GridPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GridPackage init() {
		if (isInited) return (GridPackage)EPackage.Registry.INSTANCE.getEPackage(GridPackage.eNS_URI);

		// Obtain or create and register package
		GridPackageImpl theGridPackage = (GridPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GridPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GridPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theGridPackage.createPackageContents();

		// Initialize created meta-data
		theGridPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGridPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GridPackage.eNS_URI, theGridPackage);
		return theGridPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMResourceBundle() {
		return mResourceBundleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMResourceBundle_Locale() {
		return (EAttribute)mResourceBundleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMResourceBundle_Entries() {
		return (EReference)mResourceBundleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMResourceBundleEntry() {
		return mResourceBundleEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMResourceBundleEntry_Key() {
		return (EAttribute)mResourceBundleEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMResourceBundleEntry_Value() {
		return (EAttribute)mResourceBundleEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMGrid() {
		return mGridEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGrid_Columns() {
		return (EReference)mGridEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGrid_Configurations() {
		return (EReference)mGridEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGrid_ConfigurationSets() {
		return (EReference)mGridEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGrid_DefaultConfiguration() {
		return (EReference)mGridEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGrid_Resources() {
		return (EReference)mGridEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGrid_MetaDataList() {
		return (EReference)mGridEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMGridConfigurationSet() {
		return mGridConfigurationSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGridConfigurationSet_ViewConfiguration() {
		return (EReference)mGridConfigurationSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMGridConfigurationSet_ViewSelectionMode() {
		return (EAttribute)mGridConfigurationSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGridConfigurationSet_ExportConfiguration() {
		return (EReference)mGridConfigurationSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGridConfigurationSet_DefaultSortColumn() {
		return (EReference)mGridConfigurationSetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGridConfigurationSet_Grid() {
		return (EReference)mGridConfigurationSetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMGridConfigurationSet_Name() {
		return (EAttribute)mGridConfigurationSetEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMGridConfiguration() {
		return mGridConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGridConfiguration_Columns() {
		return (EReference)mGridConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMGridConfigurationColumn() {
		return mGridConfigurationColumnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGridConfigurationColumn_Column() {
		return (EReference)mGridConfigurationColumnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMGridColumn() {
		return mGridColumnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMGridColumn_Id() {
		return (EAttribute)mGridColumnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGridColumn_Grid() {
		return (EReference)mGridColumnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMGridColumn_TitleKey() {
		return (EAttribute)mGridColumnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMGridColumn_MinWidth() {
		return (EAttribute)mGridColumnEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMGridColumn_MaxWidth() {
		return (EAttribute)mGridColumnEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMGridColumn_AutoWidth() {
		return (EAttribute)mGridColumnEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGridColumn_CellValueFunction() {
		return (EReference)mGridColumnEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGridColumn_CellTextFunction() {
		return (EReference)mGridColumnEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMGridColumn_Alignment() {
		return (EAttribute)mGridColumnEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGridColumn_AutoFilterConfiguration() {
		return (EReference)mGridColumnEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMGridColumn_SortingBehavior() {
		return (EAttribute)mGridColumnEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMGridColumn_MetaDataList() {
		return (EReference)mGridColumnEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMBooleanGridColumn() {
		return mBooleanGridColumnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMCellValueFunction() {
		return mCellValueFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMPathCellValueFunction() {
		return mPathCellValueFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMPathCellValueFunction_Segments() {
		return (EReference)mPathCellValueFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMPathSegment() {
		return mPathSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMSimplePathSegment() {
		return mSimplePathSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMSimplePathSegment_FeatureName() {
		return (EAttribute)mSimplePathSegmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMCellTextFunction() {
		return mCellTextFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMFormattedCellTextFunction() {
		return mFormattedCellTextFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMFormattedCellTextFunction_FormatType() {
		return (EAttribute)mFormattedCellTextFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMFormattedCellTextFunction_Pattern() {
		return (EReference)mFormattedCellTextFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMPattern() {
		return mPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMStringPattern() {
		return mStringPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMStringPattern_Pattern() {
		return (EAttribute)mStringPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMReferencePattern() {
		return mReferencePatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMReferencePattern_PatternKey() {
		return (EAttribute)mReferencePatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMAutoFilterConfiguration() {
		return mAutoFilterConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMComboAutoFilterConfiguration() {
		return mComboAutoFilterConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMComboAutoFilterConfiguration_PredefinedValues() {
		return (EReference)mComboAutoFilterConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMComboAutoFilterConfiguration_DefaultSelection() {
		return (EReference)mComboAutoFilterConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMComboAutoFilterConfiguration_CellTextFunction() {
		return (EReference)mComboAutoFilterConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMFreeTextAutoFilterConfiguration() {
		return mFreeTextAutoFilterConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMFreeTextAutoFilterConfiguration_MatchType() {
		return (EAttribute)mFreeTextAutoFilterConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMAutoFilterEntry() {
		return mAutoFilterEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMAutoFilterEntry_ResourceKey() {
		return (EAttribute)mAutoFilterEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMTextAutoFilterEntry() {
		return mTextAutoFilterEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMDefaultAutoFilterEntry() {
		return mDefaultAutoFilterEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMDefaultAutoFilterEntry_Type() {
		return (EAttribute)mDefaultAutoFilterEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMMetaData() {
		return mMetaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMMetaData_Topic() {
		return (EAttribute)mMetaDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMSimpleMetaData() {
		return mSimpleMetaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMSimpleMetaData_MetaDataValue() {
		return (EAttribute)mSimpleMetaDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMFormatType() {
		return mFormatTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMSelectionMode() {
		return mSelectionModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMAlignment() {
		return mAlignmentEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMDefaultAutoFilterEntryType() {
		return mDefaultAutoFilterEntryTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMAutoFilterMatchType() {
		return mAutoFilterMatchTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMSortingBehavior() {
		return mSortingBehaviorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GridFactory getGridFactory() {
		return (GridFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		mResourceBundleEClass = createEClass(MRESOURCE_BUNDLE);
		createEAttribute(mResourceBundleEClass, MRESOURCE_BUNDLE__LOCALE);
		createEReference(mResourceBundleEClass, MRESOURCE_BUNDLE__ENTRIES);

		mResourceBundleEntryEClass = createEClass(MRESOURCE_BUNDLE_ENTRY);
		createEAttribute(mResourceBundleEntryEClass, MRESOURCE_BUNDLE_ENTRY__KEY);
		createEAttribute(mResourceBundleEntryEClass, MRESOURCE_BUNDLE_ENTRY__VALUE);

		mGridEClass = createEClass(MGRID);
		createEReference(mGridEClass, MGRID__COLUMNS);
		createEReference(mGridEClass, MGRID__CONFIGURATIONS);
		createEReference(mGridEClass, MGRID__CONFIGURATION_SETS);
		createEReference(mGridEClass, MGRID__DEFAULT_CONFIGURATION);
		createEReference(mGridEClass, MGRID__RESOURCES);
		createEReference(mGridEClass, MGRID__META_DATA_LIST);

		mGridConfigurationSetEClass = createEClass(MGRID_CONFIGURATION_SET);
		createEReference(mGridConfigurationSetEClass, MGRID_CONFIGURATION_SET__VIEW_CONFIGURATION);
		createEAttribute(mGridConfigurationSetEClass, MGRID_CONFIGURATION_SET__VIEW_SELECTION_MODE);
		createEReference(mGridConfigurationSetEClass, MGRID_CONFIGURATION_SET__EXPORT_CONFIGURATION);
		createEReference(mGridConfigurationSetEClass, MGRID_CONFIGURATION_SET__DEFAULT_SORT_COLUMN);
		createEReference(mGridConfigurationSetEClass, MGRID_CONFIGURATION_SET__GRID);
		createEAttribute(mGridConfigurationSetEClass, MGRID_CONFIGURATION_SET__NAME);

		mGridConfigurationEClass = createEClass(MGRID_CONFIGURATION);
		createEReference(mGridConfigurationEClass, MGRID_CONFIGURATION__COLUMNS);

		mGridConfigurationColumnEClass = createEClass(MGRID_CONFIGURATION_COLUMN);
		createEReference(mGridConfigurationColumnEClass, MGRID_CONFIGURATION_COLUMN__COLUMN);

		mGridColumnEClass = createEClass(MGRID_COLUMN);
		createEAttribute(mGridColumnEClass, MGRID_COLUMN__ID);
		createEReference(mGridColumnEClass, MGRID_COLUMN__GRID);
		createEAttribute(mGridColumnEClass, MGRID_COLUMN__TITLE_KEY);
		createEAttribute(mGridColumnEClass, MGRID_COLUMN__MIN_WIDTH);
		createEAttribute(mGridColumnEClass, MGRID_COLUMN__MAX_WIDTH);
		createEAttribute(mGridColumnEClass, MGRID_COLUMN__AUTO_WIDTH);
		createEReference(mGridColumnEClass, MGRID_COLUMN__CELL_VALUE_FUNCTION);
		createEReference(mGridColumnEClass, MGRID_COLUMN__CELL_TEXT_FUNCTION);
		createEAttribute(mGridColumnEClass, MGRID_COLUMN__ALIGNMENT);
		createEReference(mGridColumnEClass, MGRID_COLUMN__AUTO_FILTER_CONFIGURATION);
		createEAttribute(mGridColumnEClass, MGRID_COLUMN__SORTING_BEHAVIOR);
		createEReference(mGridColumnEClass, MGRID_COLUMN__META_DATA_LIST);

		mBooleanGridColumnEClass = createEClass(MBOOLEAN_GRID_COLUMN);

		mCellValueFunctionEClass = createEClass(MCELL_VALUE_FUNCTION);

		mPathCellValueFunctionEClass = createEClass(MPATH_CELL_VALUE_FUNCTION);
		createEReference(mPathCellValueFunctionEClass, MPATH_CELL_VALUE_FUNCTION__SEGMENTS);

		mPathSegmentEClass = createEClass(MPATH_SEGMENT);

		mSimplePathSegmentEClass = createEClass(MSIMPLE_PATH_SEGMENT);
		createEAttribute(mSimplePathSegmentEClass, MSIMPLE_PATH_SEGMENT__FEATURE_NAME);

		mCellTextFunctionEClass = createEClass(MCELL_TEXT_FUNCTION);

		mFormattedCellTextFunctionEClass = createEClass(MFORMATTED_CELL_TEXT_FUNCTION);
		createEAttribute(mFormattedCellTextFunctionEClass, MFORMATTED_CELL_TEXT_FUNCTION__FORMAT_TYPE);
		createEReference(mFormattedCellTextFunctionEClass, MFORMATTED_CELL_TEXT_FUNCTION__PATTERN);

		mPatternEClass = createEClass(MPATTERN);

		mStringPatternEClass = createEClass(MSTRING_PATTERN);
		createEAttribute(mStringPatternEClass, MSTRING_PATTERN__PATTERN);

		mReferencePatternEClass = createEClass(MREFERENCE_PATTERN);
		createEAttribute(mReferencePatternEClass, MREFERENCE_PATTERN__PATTERN_KEY);

		mAutoFilterConfigurationEClass = createEClass(MAUTO_FILTER_CONFIGURATION);

		mComboAutoFilterConfigurationEClass = createEClass(MCOMBO_AUTO_FILTER_CONFIGURATION);
		createEReference(mComboAutoFilterConfigurationEClass, MCOMBO_AUTO_FILTER_CONFIGURATION__PREDEFINED_VALUES);
		createEReference(mComboAutoFilterConfigurationEClass, MCOMBO_AUTO_FILTER_CONFIGURATION__DEFAULT_SELECTION);
		createEReference(mComboAutoFilterConfigurationEClass, MCOMBO_AUTO_FILTER_CONFIGURATION__CELL_TEXT_FUNCTION);

		mFreeTextAutoFilterConfigurationEClass = createEClass(MFREE_TEXT_AUTO_FILTER_CONFIGURATION);
		createEAttribute(mFreeTextAutoFilterConfigurationEClass, MFREE_TEXT_AUTO_FILTER_CONFIGURATION__MATCH_TYPE);

		mAutoFilterEntryEClass = createEClass(MAUTO_FILTER_ENTRY);
		createEAttribute(mAutoFilterEntryEClass, MAUTO_FILTER_ENTRY__RESOURCE_KEY);

		mTextAutoFilterEntryEClass = createEClass(MTEXT_AUTO_FILTER_ENTRY);

		mDefaultAutoFilterEntryEClass = createEClass(MDEFAULT_AUTO_FILTER_ENTRY);
		createEAttribute(mDefaultAutoFilterEntryEClass, MDEFAULT_AUTO_FILTER_ENTRY__TYPE);

		mMetaDataEClass = createEClass(MMETA_DATA);
		createEAttribute(mMetaDataEClass, MMETA_DATA__TOPIC);

		mSimpleMetaDataEClass = createEClass(MSIMPLE_META_DATA);
		createEAttribute(mSimpleMetaDataEClass, MSIMPLE_META_DATA__META_DATA_VALUE);

		// Create enums
		mFormatTypeEEnum = createEEnum(MFORMAT_TYPE);
		mSelectionModeEEnum = createEEnum(MSELECTION_MODE);
		mAlignmentEEnum = createEEnum(MALIGNMENT);
		mDefaultAutoFilterEntryTypeEEnum = createEEnum(MDEFAULT_AUTO_FILTER_ENTRY_TYPE);
		mAutoFilterMatchTypeEEnum = createEEnum(MAUTO_FILTER_MATCH_TYPE);
		mSortingBehaviorEEnum = createEEnum(MSORTING_BEHAVIOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		mBooleanGridColumnEClass.getESuperTypes().add(this.getMGridColumn());
		mPathCellValueFunctionEClass.getESuperTypes().add(this.getMCellValueFunction());
		mSimplePathSegmentEClass.getESuperTypes().add(this.getMPathSegment());
		mFormattedCellTextFunctionEClass.getESuperTypes().add(this.getMCellTextFunction());
		mStringPatternEClass.getESuperTypes().add(this.getMPattern());
		mReferencePatternEClass.getESuperTypes().add(this.getMPattern());
		mComboAutoFilterConfigurationEClass.getESuperTypes().add(this.getMAutoFilterConfiguration());
		mFreeTextAutoFilterConfigurationEClass.getESuperTypes().add(this.getMAutoFilterConfiguration());
		mTextAutoFilterEntryEClass.getESuperTypes().add(this.getMAutoFilterEntry());
		mDefaultAutoFilterEntryEClass.getESuperTypes().add(this.getMAutoFilterEntry());
		mSimpleMetaDataEClass.getESuperTypes().add(this.getMMetaData());

		// Initialize classes, features, and operations; add parameters
		initEClass(mResourceBundleEClass, MResourceBundle.class, "MResourceBundle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMResourceBundle_Locale(), ecorePackage.getEString(), "locale", null, 0, 1, MResourceBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMResourceBundle_Entries(), this.getMResourceBundleEntry(), null, "entries", null, 0, -1, MResourceBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mResourceBundleEntryEClass, MResourceBundleEntry.class, "MResourceBundleEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMResourceBundleEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, MResourceBundleEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMResourceBundleEntry_Value(), ecorePackage.getEString(), "value", null, 0, 1, MResourceBundleEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mGridEClass, MGrid.class, "MGrid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMGrid_Columns(), this.getMGridColumn(), this.getMGridColumn_Grid(), "columns", null, 0, -1, MGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMGrid_Configurations(), this.getMGridConfiguration(), null, "configurations", null, 0, -1, MGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMGrid_ConfigurationSets(), this.getMGridConfigurationSet(), this.getMGridConfigurationSet_Grid(), "configurationSets", null, 0, -1, MGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMGrid_DefaultConfiguration(), this.getMGridConfigurationSet(), null, "defaultConfiguration", null, 0, 1, MGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMGrid_Resources(), this.getMResourceBundle(), null, "resources", null, 0, -1, MGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMGrid_MetaDataList(), this.getMMetaData(), null, "metaDataList", null, 0, -1, MGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mGridConfigurationSetEClass, MGridConfigurationSet.class, "MGridConfigurationSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMGridConfigurationSet_ViewConfiguration(), this.getMGridConfiguration(), null, "viewConfiguration", null, 0, 1, MGridConfigurationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMGridConfigurationSet_ViewSelectionMode(), this.getMSelectionMode(), "viewSelectionMode", null, 0, 1, MGridConfigurationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMGridConfigurationSet_ExportConfiguration(), this.getMGridConfiguration(), null, "exportConfiguration", null, 0, 1, MGridConfigurationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMGridConfigurationSet_DefaultSortColumn(), this.getMGridColumn(), null, "defaultSortColumn", null, 0, 1, MGridConfigurationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMGridConfigurationSet_Grid(), this.getMGrid(), this.getMGrid_ConfigurationSets(), "grid", null, 0, 1, MGridConfigurationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMGridConfigurationSet_Name(), ecorePackage.getEString(), "name", null, 0, 1, MGridConfigurationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mGridConfigurationEClass, MGridConfiguration.class, "MGridConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMGridConfiguration_Columns(), this.getMGridConfigurationColumn(), null, "columns", null, 0, -1, MGridConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mGridConfigurationColumnEClass, MGridConfigurationColumn.class, "MGridConfigurationColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMGridConfigurationColumn_Column(), this.getMGridColumn(), null, "column", null, 0, 1, MGridConfigurationColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mGridColumnEClass, MGridColumn.class, "MGridColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMGridColumn_Id(), ecorePackage.getEString(), "id", null, 0, 1, MGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMGridColumn_Grid(), this.getMGrid(), this.getMGrid_Columns(), "grid", null, 0, 1, MGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMGridColumn_TitleKey(), ecorePackage.getEString(), "titleKey", null, 0, 1, MGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMGridColumn_MinWidth(), ecorePackage.getEIntegerObject(), "minWidth", null, 0, 1, MGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMGridColumn_MaxWidth(), ecorePackage.getEIntegerObject(), "maxWidth", null, 0, 1, MGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMGridColumn_AutoWidth(), ecorePackage.getEBoolean(), "autoWidth", null, 0, 1, MGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMGridColumn_CellValueFunction(), this.getMCellValueFunction(), null, "cellValueFunction", null, 0, 1, MGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMGridColumn_CellTextFunction(), this.getMCellTextFunction(), null, "cellTextFunction", null, 0, 1, MGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMGridColumn_Alignment(), this.getMAlignment(), "alignment", null, 0, 1, MGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMGridColumn_AutoFilterConfiguration(), this.getMAutoFilterConfiguration(), null, "autoFilterConfiguration", null, 0, 1, MGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMGridColumn_SortingBehavior(), this.getMSortingBehavior(), "sortingBehavior", null, 0, 1, MGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMGridColumn_MetaDataList(), this.getMMetaData(), null, "metaDataList", null, 0, -1, MGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mBooleanGridColumnEClass, MBooleanGridColumn.class, "MBooleanGridColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mCellValueFunctionEClass, MCellValueFunction.class, "MCellValueFunction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mPathCellValueFunctionEClass, MPathCellValueFunction.class, "MPathCellValueFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMPathCellValueFunction_Segments(), this.getMPathSegment(), null, "segments", null, 0, -1, MPathCellValueFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mPathSegmentEClass, MPathSegment.class, "MPathSegment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mSimplePathSegmentEClass, MSimplePathSegment.class, "MSimplePathSegment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMSimplePathSegment_FeatureName(), ecorePackage.getEString(), "featureName", null, 0, 1, MSimplePathSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mCellTextFunctionEClass, MCellTextFunction.class, "MCellTextFunction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mFormattedCellTextFunctionEClass, MFormattedCellTextFunction.class, "MFormattedCellTextFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMFormattedCellTextFunction_FormatType(), this.getMFormatType(), "formatType", null, 0, 1, MFormattedCellTextFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMFormattedCellTextFunction_Pattern(), this.getMPattern(), null, "pattern", null, 0, 1, MFormattedCellTextFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mPatternEClass, MPattern.class, "MPattern", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mStringPatternEClass, MStringPattern.class, "MStringPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMStringPattern_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, MStringPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mReferencePatternEClass, MReferencePattern.class, "MReferencePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMReferencePattern_PatternKey(), ecorePackage.getEString(), "patternKey", null, 0, 1, MReferencePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mAutoFilterConfigurationEClass, MAutoFilterConfiguration.class, "MAutoFilterConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mComboAutoFilterConfigurationEClass, MComboAutoFilterConfiguration.class, "MComboAutoFilterConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMComboAutoFilterConfiguration_PredefinedValues(), this.getMAutoFilterEntry(), null, "predefinedValues", null, 0, -1, MComboAutoFilterConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMComboAutoFilterConfiguration_DefaultSelection(), this.getMAutoFilterEntry(), null, "defaultSelection", null, 0, 1, MComboAutoFilterConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMComboAutoFilterConfiguration_CellTextFunction(), this.getMCellTextFunction(), null, "cellTextFunction", null, 0, 1, MComboAutoFilterConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mFreeTextAutoFilterConfigurationEClass, MFreeTextAutoFilterConfiguration.class, "MFreeTextAutoFilterConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMFreeTextAutoFilterConfiguration_MatchType(), this.getMAutoFilterMatchType(), "matchType", null, 0, 1, MFreeTextAutoFilterConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mAutoFilterEntryEClass, MAutoFilterEntry.class, "MAutoFilterEntry", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMAutoFilterEntry_ResourceKey(), ecorePackage.getEString(), "resourceKey", null, 0, 1, MAutoFilterEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mTextAutoFilterEntryEClass, MTextAutoFilterEntry.class, "MTextAutoFilterEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mDefaultAutoFilterEntryEClass, MDefaultAutoFilterEntry.class, "MDefaultAutoFilterEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMDefaultAutoFilterEntry_Type(), this.getMDefaultAutoFilterEntryType(), "type", null, 0, 1, MDefaultAutoFilterEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mMetaDataEClass, MMetaData.class, "MMetaData", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMMetaData_Topic(), ecorePackage.getEString(), "topic", null, 0, 1, MMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mSimpleMetaDataEClass, MSimpleMetaData.class, "MSimpleMetaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMSimpleMetaData_MetaDataValue(), ecorePackage.getEString(), "metaDataValue", null, 0, 1, MSimpleMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(mFormatTypeEEnum, MFormatType.class, "MFormatType");
		addEEnumLiteral(mFormatTypeEEnum, MFormatType.NUMBER);
		addEEnumLiteral(mFormatTypeEEnum, MFormatType.DATE);

		initEEnum(mSelectionModeEEnum, MSelectionMode.class, "MSelectionMode");
		addEEnumLiteral(mSelectionModeEEnum, MSelectionMode.SINGLE_ROW);
		addEEnumLiteral(mSelectionModeEEnum, MSelectionMode.SINGLE_CELL);

		initEEnum(mAlignmentEEnum, MAlignment.class, "MAlignment");
		addEEnumLiteral(mAlignmentEEnum, MAlignment.LEFT);
		addEEnumLiteral(mAlignmentEEnum, MAlignment.CENTER);
		addEEnumLiteral(mAlignmentEEnum, MAlignment.RIGHT);

		initEEnum(mDefaultAutoFilterEntryTypeEEnum, MDefaultAutoFilterEntryType.class, "MDefaultAutoFilterEntryType");
		addEEnumLiteral(mDefaultAutoFilterEntryTypeEEnum, MDefaultAutoFilterEntryType.ALL);
		addEEnumLiteral(mDefaultAutoFilterEntryTypeEEnum, MDefaultAutoFilterEntryType.EMPTY);
		addEEnumLiteral(mDefaultAutoFilterEntryTypeEEnum, MDefaultAutoFilterEntryType.NOT_EMPTY);

		initEEnum(mAutoFilterMatchTypeEEnum, MAutoFilterMatchType.class, "MAutoFilterMatchType");
		addEEnumLiteral(mAutoFilterMatchTypeEEnum, MAutoFilterMatchType.SUBSTRING);

		initEEnum(mSortingBehaviorEEnum, MSortingBehavior.class, "MSortingBehavior");
		addEEnumLiteral(mSortingBehaviorEEnum, MSortingBehavior.UP_DOWN);
		addEEnumLiteral(mSortingBehaviorEEnum, MSortingBehavior.UP_DOWN_DEFAULT);

		// Create resource
		createResource(eNS_URI);
	}

} //GridPackageImpl
