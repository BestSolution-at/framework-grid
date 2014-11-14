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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see at.bestsolution.framework.grid.model.grid.GridPackage
 * @generated
 */
public interface GridFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GridFactory eINSTANCE = at.bestsolution.framework.grid.model.grid.impl.GridFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>MResource Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MResource Bundle</em>'.
	 * @generated
	 */
	MResourceBundle createMResourceBundle();

	/**
	 * Returns a new object of class '<em>MResource Bundle Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MResource Bundle Entry</em>'.
	 * @generated
	 */
	MResourceBundleEntry createMResourceBundleEntry();

	/**
	 * Returns a new object of class '<em>MGrid</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MGrid</em>'.
	 * @generated
	 */
	MGrid createMGrid();

	/**
	 * Returns a new object of class '<em>MGrid Configuration Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MGrid Configuration Set</em>'.
	 * @generated
	 */
	MGridConfigurationSet createMGridConfigurationSet();

	/**
	 * Returns a new object of class '<em>MGrid Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MGrid Configuration</em>'.
	 * @generated
	 */
	MGridConfiguration createMGridConfiguration();

	/**
	 * Returns a new object of class '<em>MGrid Configuration Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MGrid Configuration Column</em>'.
	 * @generated
	 */
	MGridConfigurationColumn createMGridConfigurationColumn();

	/**
	 * Returns a new object of class '<em>MGrid Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MGrid Column</em>'.
	 * @generated
	 */
	MGridColumn createMGridColumn();

	/**
	 * Returns a new object of class '<em>MPath Cell Value Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MPath Cell Value Function</em>'.
	 * @generated
	 */
	MPathCellValueFunction createMPathCellValueFunction();

	/**
	 * Returns a new object of class '<em>MSimple Path Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MSimple Path Segment</em>'.
	 * @generated
	 */
	MSimplePathSegment createMSimplePathSegment();

	/**
	 * Returns a new object of class '<em>MFormatted Cell Text Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MFormatted Cell Text Function</em>'.
	 * @generated
	 */
	MFormattedCellTextFunction createMFormattedCellTextFunction();

	/**
	 * Returns a new object of class '<em>MString Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MString Pattern</em>'.
	 * @generated
	 */
	MStringPattern createMStringPattern();

	/**
	 * Returns a new object of class '<em>MReference Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MReference Pattern</em>'.
	 * @generated
	 */
	MReferencePattern createMReferencePattern();

	/**
	 * Returns a new object of class '<em>MCombo Auto Filter Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MCombo Auto Filter Configuration</em>'.
	 * @generated
	 */
	MComboAutoFilterConfiguration createMComboAutoFilterConfiguration();

	/**
	 * Returns a new object of class '<em>MFree Text Auto Filter Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MFree Text Auto Filter Configuration</em>'.
	 * @generated
	 */
	MFreeTextAutoFilterConfiguration createMFreeTextAutoFilterConfiguration();

	/**
	 * Returns a new object of class '<em>MText Auto Filter Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MText Auto Filter Entry</em>'.
	 * @generated
	 */
	MTextAutoFilterEntry createMTextAutoFilterEntry();

	/**
	 * Returns a new object of class '<em>MDefault Auto Filter Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MDefault Auto Filter Entry</em>'.
	 * @generated
	 */
	MDefaultAutoFilterEntry createMDefaultAutoFilterEntry();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GridPackage getGridPackage();

} //GridFactory
