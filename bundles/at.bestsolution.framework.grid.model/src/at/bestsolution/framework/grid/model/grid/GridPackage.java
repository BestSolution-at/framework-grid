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
package at.bestsolution.framework.grid.model.grid;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see at.bestsolution.framework.grid.model.grid.GridFactory
 * @model kind="package"
 * @generated
 */
public interface GridPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "grid";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.bestsolution.at/framework/grid/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "grid";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GridPackage eINSTANCE = at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl.init();

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MResourceBundleImpl <em>MResource Bundle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MResourceBundleImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMResourceBundle()
	 * @generated
	 */
	int MRESOURCE_BUNDLE = 0;

	/**
	 * The feature id for the '<em><b>Locale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MRESOURCE_BUNDLE__LOCALE = 0;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MRESOURCE_BUNDLE__ENTRIES = 1;

	/**
	 * The number of structural features of the '<em>MResource Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MRESOURCE_BUNDLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>MResource Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MRESOURCE_BUNDLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MResourceBundleEntryImpl <em>MResource Bundle Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MResourceBundleEntryImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMResourceBundleEntry()
	 * @generated
	 */
	int MRESOURCE_BUNDLE_ENTRY = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MRESOURCE_BUNDLE_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MRESOURCE_BUNDLE_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>MResource Bundle Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MRESOURCE_BUNDLE_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>MResource Bundle Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MRESOURCE_BUNDLE_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MGridImpl <em>MGrid</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MGridImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMGrid()
	 * @generated
	 */
	int MGRID = 2;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID__COLUMNS = 0;

	/**
	 * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID__CONFIGURATIONS = 1;

	/**
	 * The feature id for the '<em><b>Default Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID__DEFAULT_CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID__RESOURCES = 3;

	/**
	 * The number of structural features of the '<em>MGrid</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>MGrid</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationSetImpl <em>MGrid Configuration Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationSetImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMGridConfigurationSet()
	 * @generated
	 */
	int MGRID_CONFIGURATION_SET = 3;

	/**
	 * The feature id for the '<em><b>View Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_CONFIGURATION_SET__VIEW_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>View Selection Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_CONFIGURATION_SET__VIEW_SELECTION_MODE = 1;

	/**
	 * The feature id for the '<em><b>Export Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_CONFIGURATION_SET__EXPORT_CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Default Sort Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_CONFIGURATION_SET__DEFAULT_SORT_COLUMN = 3;

	/**
	 * The feature id for the '<em><b>Grid</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_CONFIGURATION_SET__GRID = 4;

	/**
	 * The number of structural features of the '<em>MGrid Configuration Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_CONFIGURATION_SET_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>MGrid Configuration Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_CONFIGURATION_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationImpl <em>MGrid Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMGridConfiguration()
	 * @generated
	 */
	int MGRID_CONFIGURATION = 4;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_CONFIGURATION__COLUMNS = 0;

	/**
	 * The number of structural features of the '<em>MGrid Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>MGrid Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationColumnImpl <em>MGrid Configuration Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationColumnImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMGridConfigurationColumn()
	 * @generated
	 */
	int MGRID_CONFIGURATION_COLUMN = 5;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_CONFIGURATION_COLUMN__COLUMN = 0;

	/**
	 * The number of structural features of the '<em>MGrid Configuration Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_CONFIGURATION_COLUMN_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>MGrid Configuration Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_CONFIGURATION_COLUMN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MGridColumnImpl <em>MGrid Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MGridColumnImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMGridColumn()
	 * @generated
	 */
	int MGRID_COLUMN = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_COLUMN__ID = 0;

	/**
	 * The feature id for the '<em><b>Grid</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_COLUMN__GRID = 1;

	/**
	 * The feature id for the '<em><b>Title Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_COLUMN__TITLE_KEY = 2;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_COLUMN__WIDTH = 3;

	/**
	 * The feature id for the '<em><b>Min Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_COLUMN__MIN_WIDTH = 4;

	/**
	 * The feature id for the '<em><b>Max Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_COLUMN__MAX_WIDTH = 5;

	/**
	 * The feature id for the '<em><b>Auto Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_COLUMN__AUTO_WIDTH = 6;

	/**
	 * The feature id for the '<em><b>Cell Value Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_COLUMN__CELL_VALUE_FUNCTION = 7;

	/**
	 * The feature id for the '<em><b>Cell Text Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_COLUMN__CELL_TEXT_FUNCTION = 8;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_COLUMN__ALIGNMENT = 9;

	/**
	 * The feature id for the '<em><b>Auto Filter Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_COLUMN__AUTO_FILTER_CONFIGURATION = 10;

	/**
	 * The number of structural features of the '<em>MGrid Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_COLUMN_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>MGrid Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MGRID_COLUMN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MCellValueFunctionImpl <em>MCell Value Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MCellValueFunctionImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMCellValueFunction()
	 * @generated
	 */
	int MCELL_VALUE_FUNCTION = 7;

	/**
	 * The number of structural features of the '<em>MCell Value Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCELL_VALUE_FUNCTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>MCell Value Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCELL_VALUE_FUNCTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MPathCellValueFunctionImpl <em>MPath Cell Value Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MPathCellValueFunctionImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMPathCellValueFunction()
	 * @generated
	 */
	int MPATH_CELL_VALUE_FUNCTION = 8;

	/**
	 * The feature id for the '<em><b>Segments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPATH_CELL_VALUE_FUNCTION__SEGMENTS = MCELL_VALUE_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MPath Cell Value Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPATH_CELL_VALUE_FUNCTION_FEATURE_COUNT = MCELL_VALUE_FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>MPath Cell Value Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPATH_CELL_VALUE_FUNCTION_OPERATION_COUNT = MCELL_VALUE_FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MPathSegmentImpl <em>MPath Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MPathSegmentImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMPathSegment()
	 * @generated
	 */
	int MPATH_SEGMENT = 9;

	/**
	 * The number of structural features of the '<em>MPath Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPATH_SEGMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>MPath Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPATH_SEGMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MSimplePathSegmentImpl <em>MSimple Path Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MSimplePathSegmentImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMSimplePathSegment()
	 * @generated
	 */
	int MSIMPLE_PATH_SEGMENT = 10;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSIMPLE_PATH_SEGMENT__ATTRIBUTE_NAME = MPATH_SEGMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MSimple Path Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSIMPLE_PATH_SEGMENT_FEATURE_COUNT = MPATH_SEGMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>MSimple Path Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSIMPLE_PATH_SEGMENT_OPERATION_COUNT = MPATH_SEGMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MCellTextFunctionImpl <em>MCell Text Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MCellTextFunctionImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMCellTextFunction()
	 * @generated
	 */
	int MCELL_TEXT_FUNCTION = 11;

	/**
	 * The number of structural features of the '<em>MCell Text Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCELL_TEXT_FUNCTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>MCell Text Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCELL_TEXT_FUNCTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MLocalizedCellTextFunctionImpl <em>MLocalized Cell Text Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MLocalizedCellTextFunctionImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMLocalizedCellTextFunction()
	 * @generated
	 */
	int MLOCALIZED_CELL_TEXT_FUNCTION = 12;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MLOCALIZED_CELL_TEXT_FUNCTION__PATTERN = MCELL_TEXT_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MLocalized Cell Text Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MLOCALIZED_CELL_TEXT_FUNCTION_FEATURE_COUNT = MCELL_TEXT_FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>MLocalized Cell Text Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MLOCALIZED_CELL_TEXT_FUNCTION_OPERATION_COUNT = MCELL_TEXT_FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MAutoFilterConfigurationImpl <em>MAuto Filter Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MAutoFilterConfigurationImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMAutoFilterConfiguration()
	 * @generated
	 */
	int MAUTO_FILTER_CONFIGURATION = 13;

	/**
	 * The number of structural features of the '<em>MAuto Filter Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAUTO_FILTER_CONFIGURATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>MAuto Filter Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAUTO_FILTER_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MComboAutoFilterConfigurationImpl <em>MCombo Auto Filter Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MComboAutoFilterConfigurationImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMComboAutoFilterConfiguration()
	 * @generated
	 */
	int MCOMBO_AUTO_FILTER_CONFIGURATION = 14;

	/**
	 * The feature id for the '<em><b>Predefined Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCOMBO_AUTO_FILTER_CONFIGURATION__PREDEFINED_VALUES = MAUTO_FILTER_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Selection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCOMBO_AUTO_FILTER_CONFIGURATION__DEFAULT_SELECTION = MAUTO_FILTER_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Cell Text Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCOMBO_AUTO_FILTER_CONFIGURATION__CELL_TEXT_FUNCTION = MAUTO_FILTER_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>MCombo Auto Filter Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCOMBO_AUTO_FILTER_CONFIGURATION_FEATURE_COUNT = MAUTO_FILTER_CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>MCombo Auto Filter Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCOMBO_AUTO_FILTER_CONFIGURATION_OPERATION_COUNT = MAUTO_FILTER_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MFreeTextAutoFilterConfigurationImpl <em>MFree Text Auto Filter Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MFreeTextAutoFilterConfigurationImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMFreeTextAutoFilterConfiguration()
	 * @generated
	 */
	int MFREE_TEXT_AUTO_FILTER_CONFIGURATION = 15;

	/**
	 * The feature id for the '<em><b>Match Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MFREE_TEXT_AUTO_FILTER_CONFIGURATION__MATCH_TYPE = 0;

	/**
	 * The number of structural features of the '<em>MFree Text Auto Filter Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MFREE_TEXT_AUTO_FILTER_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>MFree Text Auto Filter Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MFREE_TEXT_AUTO_FILTER_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MAutoFilterEntryImpl <em>MAuto Filter Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MAutoFilterEntryImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMAutoFilterEntry()
	 * @generated
	 */
	int MAUTO_FILTER_ENTRY = 16;

	/**
	 * The feature id for the '<em><b>Resource Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAUTO_FILTER_ENTRY__RESOURCE_KEY = 0;

	/**
	 * The number of structural features of the '<em>MAuto Filter Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAUTO_FILTER_ENTRY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>MAuto Filter Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAUTO_FILTER_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MTextAutoFilterEntryImpl <em>MText Auto Filter Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MTextAutoFilterEntryImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMTextAutoFilterEntry()
	 * @generated
	 */
	int MTEXT_AUTO_FILTER_ENTRY = 17;

	/**
	 * The feature id for the '<em><b>Resource Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MTEXT_AUTO_FILTER_ENTRY__RESOURCE_KEY = MAUTO_FILTER_ENTRY__RESOURCE_KEY;

	/**
	 * The number of structural features of the '<em>MText Auto Filter Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MTEXT_AUTO_FILTER_ENTRY_FEATURE_COUNT = MAUTO_FILTER_ENTRY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>MText Auto Filter Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MTEXT_AUTO_FILTER_ENTRY_OPERATION_COUNT = MAUTO_FILTER_ENTRY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.impl.MDefaultAutoFilterEntryImpl <em>MDefault Auto Filter Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.impl.MDefaultAutoFilterEntryImpl
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMDefaultAutoFilterEntry()
	 * @generated
	 */
	int MDEFAULT_AUTO_FILTER_ENTRY = 18;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDEFAULT_AUTO_FILTER_ENTRY__TYPE = 0;

	/**
	 * The number of structural features of the '<em>MDefault Auto Filter Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDEFAULT_AUTO_FILTER_ENTRY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>MDefault Auto Filter Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDEFAULT_AUTO_FILTER_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.MSelectionMode <em>MSelection Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.MSelectionMode
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMSelectionMode()
	 * @generated
	 */
	int MSELECTION_MODE = 19;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.MAlignment <em>MAlignment</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.MAlignment
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMAlignment()
	 * @generated
	 */
	int MALIGNMENT = 20;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.MDefaultAutoFilterEntryType <em>MDefault Auto Filter Entry Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.MDefaultAutoFilterEntryType
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMDefaultAutoFilterEntryType()
	 * @generated
	 */
	int MDEFAULT_AUTO_FILTER_ENTRY_TYPE = 21;

	/**
	 * The meta object id for the '{@link at.bestsolution.framework.grid.model.grid.MAutoFilterMatchType <em>MAuto Filter Match Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.framework.grid.model.grid.MAutoFilterMatchType
	 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMAutoFilterMatchType()
	 * @generated
	 */
	int MAUTO_FILTER_MATCH_TYPE = 22;


	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MResourceBundle <em>MResource Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MResource Bundle</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MResourceBundle
	 * @generated
	 */
	EClass getMResourceBundle();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MResourceBundle#getLocale <em>Locale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Locale</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MResourceBundle#getLocale()
	 * @see #getMResourceBundle()
	 * @generated
	 */
	EAttribute getMResourceBundle_Locale();

	/**
	 * Returns the meta object for the containment reference '{@link at.bestsolution.framework.grid.model.grid.MResourceBundle#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Entries</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MResourceBundle#getEntries()
	 * @see #getMResourceBundle()
	 * @generated
	 */
	EReference getMResourceBundle_Entries();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MResourceBundleEntry <em>MResource Bundle Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MResource Bundle Entry</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MResourceBundleEntry
	 * @generated
	 */
	EClass getMResourceBundleEntry();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MResourceBundleEntry#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MResourceBundleEntry#getKey()
	 * @see #getMResourceBundleEntry()
	 * @generated
	 */
	EAttribute getMResourceBundleEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MResourceBundleEntry#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MResourceBundleEntry#getValue()
	 * @see #getMResourceBundleEntry()
	 * @generated
	 */
	EAttribute getMResourceBundleEntry_Value();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MGrid <em>MGrid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MGrid</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGrid
	 * @generated
	 */
	EClass getMGrid();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.framework.grid.model.grid.MGrid#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGrid#getColumns()
	 * @see #getMGrid()
	 * @generated
	 */
	EReference getMGrid_Columns();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.framework.grid.model.grid.MGrid#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configurations</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGrid#getConfigurations()
	 * @see #getMGrid()
	 * @generated
	 */
	EReference getMGrid_Configurations();

	/**
	 * Returns the meta object for the reference '{@link at.bestsolution.framework.grid.model.grid.MGrid#getDefaultConfiguration <em>Default Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Configuration</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGrid#getDefaultConfiguration()
	 * @see #getMGrid()
	 * @generated
	 */
	EReference getMGrid_DefaultConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.framework.grid.model.grid.MGrid#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGrid#getResources()
	 * @see #getMGrid()
	 * @generated
	 */
	EReference getMGrid_Resources();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet <em>MGrid Configuration Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MGrid Configuration Set</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridConfigurationSet
	 * @generated
	 */
	EClass getMGridConfigurationSet();

	/**
	 * Returns the meta object for the reference '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getViewConfiguration <em>View Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>View Configuration</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getViewConfiguration()
	 * @see #getMGridConfigurationSet()
	 * @generated
	 */
	EReference getMGridConfigurationSet_ViewConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getViewSelectionMode <em>View Selection Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>View Selection Mode</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getViewSelectionMode()
	 * @see #getMGridConfigurationSet()
	 * @generated
	 */
	EAttribute getMGridConfigurationSet_ViewSelectionMode();

	/**
	 * Returns the meta object for the reference '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getExportConfiguration <em>Export Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Export Configuration</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getExportConfiguration()
	 * @see #getMGridConfigurationSet()
	 * @generated
	 */
	EReference getMGridConfigurationSet_ExportConfiguration();

	/**
	 * Returns the meta object for the reference '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getDefaultSortColumn <em>Default Sort Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Sort Column</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getDefaultSortColumn()
	 * @see #getMGridConfigurationSet()
	 * @generated
	 */
	EReference getMGridConfigurationSet_DefaultSortColumn();

	/**
	 * Returns the meta object for the container reference '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getGrid <em>Grid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Grid</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getGrid()
	 * @see #getMGridConfigurationSet()
	 * @generated
	 */
	EReference getMGridConfigurationSet_Grid();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MGridConfiguration <em>MGrid Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MGrid Configuration</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridConfiguration
	 * @generated
	 */
	EClass getMGridConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.framework.grid.model.grid.MGridConfiguration#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridConfiguration#getColumns()
	 * @see #getMGridConfiguration()
	 * @generated
	 */
	EReference getMGridConfiguration_Columns();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationColumn <em>MGrid Configuration Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MGrid Configuration Column</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridConfigurationColumn
	 * @generated
	 */
	EClass getMGridConfigurationColumn();

	/**
	 * Returns the meta object for the reference '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationColumn#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridConfigurationColumn#getColumn()
	 * @see #getMGridConfigurationColumn()
	 * @generated
	 */
	EReference getMGridConfigurationColumn_Column();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MGridColumn <em>MGrid Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MGrid Column</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridColumn
	 * @generated
	 */
	EClass getMGridColumn();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridColumn#getId()
	 * @see #getMGridColumn()
	 * @generated
	 */
	EAttribute getMGridColumn_Id();

	/**
	 * Returns the meta object for the container reference '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getGrid <em>Grid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Grid</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridColumn#getGrid()
	 * @see #getMGridColumn()
	 * @generated
	 */
	EReference getMGridColumn_Grid();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getTitleKey <em>Title Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title Key</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridColumn#getTitleKey()
	 * @see #getMGridColumn()
	 * @generated
	 */
	EAttribute getMGridColumn_TitleKey();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridColumn#getWidth()
	 * @see #getMGridColumn()
	 * @generated
	 */
	EAttribute getMGridColumn_Width();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getMinWidth <em>Min Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Width</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridColumn#getMinWidth()
	 * @see #getMGridColumn()
	 * @generated
	 */
	EAttribute getMGridColumn_MinWidth();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getMaxWidth <em>Max Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Width</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridColumn#getMaxWidth()
	 * @see #getMGridColumn()
	 * @generated
	 */
	EAttribute getMGridColumn_MaxWidth();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getAutoWidth <em>Auto Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Width</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridColumn#getAutoWidth()
	 * @see #getMGridColumn()
	 * @generated
	 */
	EAttribute getMGridColumn_AutoWidth();

	/**
	 * Returns the meta object for the containment reference '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getCellValueFunction <em>Cell Value Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cell Value Function</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridColumn#getCellValueFunction()
	 * @see #getMGridColumn()
	 * @generated
	 */
	EReference getMGridColumn_CellValueFunction();

	/**
	 * Returns the meta object for the containment reference '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getCellTextFunction <em>Cell Text Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cell Text Function</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridColumn#getCellTextFunction()
	 * @see #getMGridColumn()
	 * @generated
	 */
	EReference getMGridColumn_CellTextFunction();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getAlignment <em>Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alignment</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridColumn#getAlignment()
	 * @see #getMGridColumn()
	 * @generated
	 */
	EAttribute getMGridColumn_Alignment();

	/**
	 * Returns the meta object for the containment reference '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getAutoFilterConfiguration <em>Auto Filter Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Auto Filter Configuration</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MGridColumn#getAutoFilterConfiguration()
	 * @see #getMGridColumn()
	 * @generated
	 */
	EReference getMGridColumn_AutoFilterConfiguration();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MCellValueFunction <em>MCell Value Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MCell Value Function</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MCellValueFunction
	 * @generated
	 */
	EClass getMCellValueFunction();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MPathCellValueFunction <em>MPath Cell Value Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MPath Cell Value Function</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MPathCellValueFunction
	 * @generated
	 */
	EClass getMPathCellValueFunction();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.framework.grid.model.grid.MPathCellValueFunction#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Segments</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MPathCellValueFunction#getSegments()
	 * @see #getMPathCellValueFunction()
	 * @generated
	 */
	EReference getMPathCellValueFunction_Segments();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MPathSegment <em>MPath Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MPath Segment</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MPathSegment
	 * @generated
	 */
	EClass getMPathSegment();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MSimplePathSegment <em>MSimple Path Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MSimple Path Segment</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MSimplePathSegment
	 * @generated
	 */
	EClass getMSimplePathSegment();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MSimplePathSegment#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MSimplePathSegment#getAttributeName()
	 * @see #getMSimplePathSegment()
	 * @generated
	 */
	EAttribute getMSimplePathSegment_AttributeName();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MCellTextFunction <em>MCell Text Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MCell Text Function</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MCellTextFunction
	 * @generated
	 */
	EClass getMCellTextFunction();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MLocalizedCellTextFunction <em>MLocalized Cell Text Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MLocalized Cell Text Function</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MLocalizedCellTextFunction
	 * @generated
	 */
	EClass getMLocalizedCellTextFunction();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MLocalizedCellTextFunction#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MLocalizedCellTextFunction#getPattern()
	 * @see #getMLocalizedCellTextFunction()
	 * @generated
	 */
	EAttribute getMLocalizedCellTextFunction_Pattern();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MAutoFilterConfiguration <em>MAuto Filter Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MAuto Filter Configuration</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MAutoFilterConfiguration
	 * @generated
	 */
	EClass getMAutoFilterConfiguration();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration <em>MCombo Auto Filter Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MCombo Auto Filter Configuration</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration
	 * @generated
	 */
	EClass getMComboAutoFilterConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration#getPredefinedValues <em>Predefined Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Predefined Values</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration#getPredefinedValues()
	 * @see #getMComboAutoFilterConfiguration()
	 * @generated
	 */
	EReference getMComboAutoFilterConfiguration_PredefinedValues();

	/**
	 * Returns the meta object for the reference '{@link at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration#getDefaultSelection <em>Default Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Selection</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration#getDefaultSelection()
	 * @see #getMComboAutoFilterConfiguration()
	 * @generated
	 */
	EReference getMComboAutoFilterConfiguration_DefaultSelection();

	/**
	 * Returns the meta object for the containment reference '{@link at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration#getCellTextFunction <em>Cell Text Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cell Text Function</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration#getCellTextFunction()
	 * @see #getMComboAutoFilterConfiguration()
	 * @generated
	 */
	EReference getMComboAutoFilterConfiguration_CellTextFunction();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MFreeTextAutoFilterConfiguration <em>MFree Text Auto Filter Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MFree Text Auto Filter Configuration</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MFreeTextAutoFilterConfiguration
	 * @generated
	 */
	EClass getMFreeTextAutoFilterConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MFreeTextAutoFilterConfiguration#getMatchType <em>Match Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Match Type</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MFreeTextAutoFilterConfiguration#getMatchType()
	 * @see #getMFreeTextAutoFilterConfiguration()
	 * @generated
	 */
	EAttribute getMFreeTextAutoFilterConfiguration_MatchType();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MAutoFilterEntry <em>MAuto Filter Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MAuto Filter Entry</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MAutoFilterEntry
	 * @generated
	 */
	EClass getMAutoFilterEntry();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MAutoFilterEntry#getResourceKey <em>Resource Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Key</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MAutoFilterEntry#getResourceKey()
	 * @see #getMAutoFilterEntry()
	 * @generated
	 */
	EAttribute getMAutoFilterEntry_ResourceKey();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MTextAutoFilterEntry <em>MText Auto Filter Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MText Auto Filter Entry</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MTextAutoFilterEntry
	 * @generated
	 */
	EClass getMTextAutoFilterEntry();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.framework.grid.model.grid.MDefaultAutoFilterEntry <em>MDefault Auto Filter Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MDefault Auto Filter Entry</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MDefaultAutoFilterEntry
	 * @generated
	 */
	EClass getMDefaultAutoFilterEntry();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.framework.grid.model.grid.MDefaultAutoFilterEntry#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MDefaultAutoFilterEntry#getType()
	 * @see #getMDefaultAutoFilterEntry()
	 * @generated
	 */
	EAttribute getMDefaultAutoFilterEntry_Type();

	/**
	 * Returns the meta object for enum '{@link at.bestsolution.framework.grid.model.grid.MSelectionMode <em>MSelection Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>MSelection Mode</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MSelectionMode
	 * @generated
	 */
	EEnum getMSelectionMode();

	/**
	 * Returns the meta object for enum '{@link at.bestsolution.framework.grid.model.grid.MAlignment <em>MAlignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>MAlignment</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MAlignment
	 * @generated
	 */
	EEnum getMAlignment();

	/**
	 * Returns the meta object for enum '{@link at.bestsolution.framework.grid.model.grid.MDefaultAutoFilterEntryType <em>MDefault Auto Filter Entry Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>MDefault Auto Filter Entry Type</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MDefaultAutoFilterEntryType
	 * @generated
	 */
	EEnum getMDefaultAutoFilterEntryType();

	/**
	 * Returns the meta object for enum '{@link at.bestsolution.framework.grid.model.grid.MAutoFilterMatchType <em>MAuto Filter Match Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>MAuto Filter Match Type</em>'.
	 * @see at.bestsolution.framework.grid.model.grid.MAutoFilterMatchType
	 * @generated
	 */
	EEnum getMAutoFilterMatchType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GridFactory getGridFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MResourceBundleImpl <em>MResource Bundle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MResourceBundleImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMResourceBundle()
		 * @generated
		 */
		EClass MRESOURCE_BUNDLE = eINSTANCE.getMResourceBundle();

		/**
		 * The meta object literal for the '<em><b>Locale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MRESOURCE_BUNDLE__LOCALE = eINSTANCE.getMResourceBundle_Locale();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MRESOURCE_BUNDLE__ENTRIES = eINSTANCE.getMResourceBundle_Entries();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MResourceBundleEntryImpl <em>MResource Bundle Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MResourceBundleEntryImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMResourceBundleEntry()
		 * @generated
		 */
		EClass MRESOURCE_BUNDLE_ENTRY = eINSTANCE.getMResourceBundleEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MRESOURCE_BUNDLE_ENTRY__KEY = eINSTANCE.getMResourceBundleEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MRESOURCE_BUNDLE_ENTRY__VALUE = eINSTANCE.getMResourceBundleEntry_Value();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MGridImpl <em>MGrid</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MGridImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMGrid()
		 * @generated
		 */
		EClass MGRID = eINSTANCE.getMGrid();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MGRID__COLUMNS = eINSTANCE.getMGrid_Columns();

		/**
		 * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MGRID__CONFIGURATIONS = eINSTANCE.getMGrid_Configurations();

		/**
		 * The meta object literal for the '<em><b>Default Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MGRID__DEFAULT_CONFIGURATION = eINSTANCE.getMGrid_DefaultConfiguration();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MGRID__RESOURCES = eINSTANCE.getMGrid_Resources();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationSetImpl <em>MGrid Configuration Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationSetImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMGridConfigurationSet()
		 * @generated
		 */
		EClass MGRID_CONFIGURATION_SET = eINSTANCE.getMGridConfigurationSet();

		/**
		 * The meta object literal for the '<em><b>View Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MGRID_CONFIGURATION_SET__VIEW_CONFIGURATION = eINSTANCE.getMGridConfigurationSet_ViewConfiguration();

		/**
		 * The meta object literal for the '<em><b>View Selection Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MGRID_CONFIGURATION_SET__VIEW_SELECTION_MODE = eINSTANCE.getMGridConfigurationSet_ViewSelectionMode();

		/**
		 * The meta object literal for the '<em><b>Export Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MGRID_CONFIGURATION_SET__EXPORT_CONFIGURATION = eINSTANCE.getMGridConfigurationSet_ExportConfiguration();

		/**
		 * The meta object literal for the '<em><b>Default Sort Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MGRID_CONFIGURATION_SET__DEFAULT_SORT_COLUMN = eINSTANCE.getMGridConfigurationSet_DefaultSortColumn();

		/**
		 * The meta object literal for the '<em><b>Grid</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MGRID_CONFIGURATION_SET__GRID = eINSTANCE.getMGridConfigurationSet_Grid();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationImpl <em>MGrid Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMGridConfiguration()
		 * @generated
		 */
		EClass MGRID_CONFIGURATION = eINSTANCE.getMGridConfiguration();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MGRID_CONFIGURATION__COLUMNS = eINSTANCE.getMGridConfiguration_Columns();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationColumnImpl <em>MGrid Configuration Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MGridConfigurationColumnImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMGridConfigurationColumn()
		 * @generated
		 */
		EClass MGRID_CONFIGURATION_COLUMN = eINSTANCE.getMGridConfigurationColumn();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MGRID_CONFIGURATION_COLUMN__COLUMN = eINSTANCE.getMGridConfigurationColumn_Column();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MGridColumnImpl <em>MGrid Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MGridColumnImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMGridColumn()
		 * @generated
		 */
		EClass MGRID_COLUMN = eINSTANCE.getMGridColumn();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MGRID_COLUMN__ID = eINSTANCE.getMGridColumn_Id();

		/**
		 * The meta object literal for the '<em><b>Grid</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MGRID_COLUMN__GRID = eINSTANCE.getMGridColumn_Grid();

		/**
		 * The meta object literal for the '<em><b>Title Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MGRID_COLUMN__TITLE_KEY = eINSTANCE.getMGridColumn_TitleKey();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MGRID_COLUMN__WIDTH = eINSTANCE.getMGridColumn_Width();

		/**
		 * The meta object literal for the '<em><b>Min Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MGRID_COLUMN__MIN_WIDTH = eINSTANCE.getMGridColumn_MinWidth();

		/**
		 * The meta object literal for the '<em><b>Max Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MGRID_COLUMN__MAX_WIDTH = eINSTANCE.getMGridColumn_MaxWidth();

		/**
		 * The meta object literal for the '<em><b>Auto Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MGRID_COLUMN__AUTO_WIDTH = eINSTANCE.getMGridColumn_AutoWidth();

		/**
		 * The meta object literal for the '<em><b>Cell Value Function</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MGRID_COLUMN__CELL_VALUE_FUNCTION = eINSTANCE.getMGridColumn_CellValueFunction();

		/**
		 * The meta object literal for the '<em><b>Cell Text Function</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MGRID_COLUMN__CELL_TEXT_FUNCTION = eINSTANCE.getMGridColumn_CellTextFunction();

		/**
		 * The meta object literal for the '<em><b>Alignment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MGRID_COLUMN__ALIGNMENT = eINSTANCE.getMGridColumn_Alignment();

		/**
		 * The meta object literal for the '<em><b>Auto Filter Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MGRID_COLUMN__AUTO_FILTER_CONFIGURATION = eINSTANCE.getMGridColumn_AutoFilterConfiguration();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MCellValueFunctionImpl <em>MCell Value Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MCellValueFunctionImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMCellValueFunction()
		 * @generated
		 */
		EClass MCELL_VALUE_FUNCTION = eINSTANCE.getMCellValueFunction();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MPathCellValueFunctionImpl <em>MPath Cell Value Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MPathCellValueFunctionImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMPathCellValueFunction()
		 * @generated
		 */
		EClass MPATH_CELL_VALUE_FUNCTION = eINSTANCE.getMPathCellValueFunction();

		/**
		 * The meta object literal for the '<em><b>Segments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MPATH_CELL_VALUE_FUNCTION__SEGMENTS = eINSTANCE.getMPathCellValueFunction_Segments();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MPathSegmentImpl <em>MPath Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MPathSegmentImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMPathSegment()
		 * @generated
		 */
		EClass MPATH_SEGMENT = eINSTANCE.getMPathSegment();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MSimplePathSegmentImpl <em>MSimple Path Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MSimplePathSegmentImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMSimplePathSegment()
		 * @generated
		 */
		EClass MSIMPLE_PATH_SEGMENT = eINSTANCE.getMSimplePathSegment();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MSIMPLE_PATH_SEGMENT__ATTRIBUTE_NAME = eINSTANCE.getMSimplePathSegment_AttributeName();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MCellTextFunctionImpl <em>MCell Text Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MCellTextFunctionImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMCellTextFunction()
		 * @generated
		 */
		EClass MCELL_TEXT_FUNCTION = eINSTANCE.getMCellTextFunction();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MLocalizedCellTextFunctionImpl <em>MLocalized Cell Text Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MLocalizedCellTextFunctionImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMLocalizedCellTextFunction()
		 * @generated
		 */
		EClass MLOCALIZED_CELL_TEXT_FUNCTION = eINSTANCE.getMLocalizedCellTextFunction();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MLOCALIZED_CELL_TEXT_FUNCTION__PATTERN = eINSTANCE.getMLocalizedCellTextFunction_Pattern();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MAutoFilterConfigurationImpl <em>MAuto Filter Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MAutoFilterConfigurationImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMAutoFilterConfiguration()
		 * @generated
		 */
		EClass MAUTO_FILTER_CONFIGURATION = eINSTANCE.getMAutoFilterConfiguration();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MComboAutoFilterConfigurationImpl <em>MCombo Auto Filter Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MComboAutoFilterConfigurationImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMComboAutoFilterConfiguration()
		 * @generated
		 */
		EClass MCOMBO_AUTO_FILTER_CONFIGURATION = eINSTANCE.getMComboAutoFilterConfiguration();

		/**
		 * The meta object literal for the '<em><b>Predefined Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MCOMBO_AUTO_FILTER_CONFIGURATION__PREDEFINED_VALUES = eINSTANCE.getMComboAutoFilterConfiguration_PredefinedValues();

		/**
		 * The meta object literal for the '<em><b>Default Selection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MCOMBO_AUTO_FILTER_CONFIGURATION__DEFAULT_SELECTION = eINSTANCE.getMComboAutoFilterConfiguration_DefaultSelection();

		/**
		 * The meta object literal for the '<em><b>Cell Text Function</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MCOMBO_AUTO_FILTER_CONFIGURATION__CELL_TEXT_FUNCTION = eINSTANCE.getMComboAutoFilterConfiguration_CellTextFunction();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MFreeTextAutoFilterConfigurationImpl <em>MFree Text Auto Filter Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MFreeTextAutoFilterConfigurationImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMFreeTextAutoFilterConfiguration()
		 * @generated
		 */
		EClass MFREE_TEXT_AUTO_FILTER_CONFIGURATION = eINSTANCE.getMFreeTextAutoFilterConfiguration();

		/**
		 * The meta object literal for the '<em><b>Match Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MFREE_TEXT_AUTO_FILTER_CONFIGURATION__MATCH_TYPE = eINSTANCE.getMFreeTextAutoFilterConfiguration_MatchType();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MAutoFilterEntryImpl <em>MAuto Filter Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MAutoFilterEntryImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMAutoFilterEntry()
		 * @generated
		 */
		EClass MAUTO_FILTER_ENTRY = eINSTANCE.getMAutoFilterEntry();

		/**
		 * The meta object literal for the '<em><b>Resource Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAUTO_FILTER_ENTRY__RESOURCE_KEY = eINSTANCE.getMAutoFilterEntry_ResourceKey();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MTextAutoFilterEntryImpl <em>MText Auto Filter Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MTextAutoFilterEntryImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMTextAutoFilterEntry()
		 * @generated
		 */
		EClass MTEXT_AUTO_FILTER_ENTRY = eINSTANCE.getMTextAutoFilterEntry();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.impl.MDefaultAutoFilterEntryImpl <em>MDefault Auto Filter Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.impl.MDefaultAutoFilterEntryImpl
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMDefaultAutoFilterEntry()
		 * @generated
		 */
		EClass MDEFAULT_AUTO_FILTER_ENTRY = eINSTANCE.getMDefaultAutoFilterEntry();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MDEFAULT_AUTO_FILTER_ENTRY__TYPE = eINSTANCE.getMDefaultAutoFilterEntry_Type();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.MSelectionMode <em>MSelection Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.MSelectionMode
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMSelectionMode()
		 * @generated
		 */
		EEnum MSELECTION_MODE = eINSTANCE.getMSelectionMode();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.MAlignment <em>MAlignment</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.MAlignment
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMAlignment()
		 * @generated
		 */
		EEnum MALIGNMENT = eINSTANCE.getMAlignment();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.MDefaultAutoFilterEntryType <em>MDefault Auto Filter Entry Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.MDefaultAutoFilterEntryType
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMDefaultAutoFilterEntryType()
		 * @generated
		 */
		EEnum MDEFAULT_AUTO_FILTER_ENTRY_TYPE = eINSTANCE.getMDefaultAutoFilterEntryType();

		/**
		 * The meta object literal for the '{@link at.bestsolution.framework.grid.model.grid.MAutoFilterMatchType <em>MAuto Filter Match Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.framework.grid.model.grid.MAutoFilterMatchType
		 * @see at.bestsolution.framework.grid.model.grid.impl.GridPackageImpl#getMAutoFilterMatchType()
		 * @generated
		 */
		EEnum MAUTO_FILTER_MATCH_TYPE = eINSTANCE.getMAutoFilterMatchType();

	}

} //GridPackage
