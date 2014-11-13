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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MGrid Configuration Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getViewConfiguration <em>View Configuration</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getViewSelectionMode <em>View Selection Mode</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getExportConfiguration <em>Export Configuration</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getDefaultSortColumn <em>Default Sort Column</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getGrid <em>Grid</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridConfigurationSet()
 * @model
 * @generated
 */
public interface MGridConfigurationSet extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * Returns the value of the '<em><b>View Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Configuration</em>' reference.
	 * @see #setViewConfiguration(MGridConfiguration)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridConfigurationSet_ViewConfiguration()
	 * @model
	 * @generated
	 */
	MGridConfiguration getViewConfiguration();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getViewConfiguration <em>View Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Configuration</em>' reference.
	 * @see #getViewConfiguration()
	 * @generated
	 */
	void setViewConfiguration(MGridConfiguration value);

	/**
	 * Returns the value of the '<em><b>View Selection Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link at.bestsolution.framework.grid.model.grid.MSelectionMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Selection Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Selection Mode</em>' attribute.
	 * @see at.bestsolution.framework.grid.model.grid.MSelectionMode
	 * @see #setViewSelectionMode(MSelectionMode)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridConfigurationSet_ViewSelectionMode()
	 * @model
	 * @generated
	 */
	MSelectionMode getViewSelectionMode();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getViewSelectionMode <em>View Selection Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Selection Mode</em>' attribute.
	 * @see at.bestsolution.framework.grid.model.grid.MSelectionMode
	 * @see #getViewSelectionMode()
	 * @generated
	 */
	void setViewSelectionMode(MSelectionMode value);

	/**
	 * Returns the value of the '<em><b>Export Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Configuration</em>' reference.
	 * @see #setExportConfiguration(MGridConfiguration)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridConfigurationSet_ExportConfiguration()
	 * @model
	 * @generated
	 */
	MGridConfiguration getExportConfiguration();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getExportConfiguration <em>Export Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Configuration</em>' reference.
	 * @see #getExportConfiguration()
	 * @generated
	 */
	void setExportConfiguration(MGridConfiguration value);

	/**
	 * Returns the value of the '<em><b>Default Sort Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Sort Column</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Sort Column</em>' reference.
	 * @see #setDefaultSortColumn(MGridColumn)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridConfigurationSet_DefaultSortColumn()
	 * @model
	 * @generated
	 */
	MGridColumn getDefaultSortColumn();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getDefaultSortColumn <em>Default Sort Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Sort Column</em>' reference.
	 * @see #getDefaultSortColumn()
	 * @generated
	 */
	void setDefaultSortColumn(MGridColumn value);

	/**
	 * Returns the value of the '<em><b>Grid</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link at.bestsolution.framework.grid.model.grid.MGrid#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grid</em>' container reference.
	 * @see #setGrid(MGrid)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridConfigurationSet_Grid()
	 * @see at.bestsolution.framework.grid.model.grid.MGrid#getConfigurations
	 * @model opposite="configurations" transient="false"
	 * @generated
	 */
	MGrid getGrid();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getGrid <em>Grid</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grid</em>' container reference.
	 * @see #getGrid()
	 * @generated
	 */
	void setGrid(MGrid value);

} // MGridConfigurationSet
