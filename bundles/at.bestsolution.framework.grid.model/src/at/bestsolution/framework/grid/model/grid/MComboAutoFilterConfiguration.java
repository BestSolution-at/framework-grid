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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MCombo Auto Filter Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration#getPredefinedValues <em>Predefined Values</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration#getDefaultSelection <em>Default Selection</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration#getCellTextFunction <em>Cell Text Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMComboAutoFilterConfiguration()
 * @model
 * @generated
 */
public interface MComboAutoFilterConfiguration extends MAutoFilterConfiguration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * Returns the value of the '<em><b>Predefined Values</b></em>' containment reference list.
	 * The list contents are of type {@link at.bestsolution.framework.grid.model.grid.MAutoFilterEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Values</em>' containment reference list.
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMComboAutoFilterConfiguration_PredefinedValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<MAutoFilterEntry> getPredefinedValues();

	/**
	 * Returns the value of the '<em><b>Default Selection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Selection</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Selection</em>' reference.
	 * @see #setDefaultSelection(MAutoFilterEntry)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMComboAutoFilterConfiguration_DefaultSelection()
	 * @model
	 * @generated
	 */
	MAutoFilterEntry getDefaultSelection();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration#getDefaultSelection <em>Default Selection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Selection</em>' reference.
	 * @see #getDefaultSelection()
	 * @generated
	 */
	void setDefaultSelection(MAutoFilterEntry value);

	/**
	 * Returns the value of the '<em><b>Cell Text Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell Text Function</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cell Text Function</em>' containment reference.
	 * @see #setCellTextFunction(MCellTextFunction)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMComboAutoFilterConfiguration_CellTextFunction()
	 * @model containment="true"
	 * @generated
	 */
	MCellTextFunction getCellTextFunction();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration#getCellTextFunction <em>Cell Text Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cell Text Function</em>' containment reference.
	 * @see #getCellTextFunction()
	 * @generated
	 */
	void setCellTextFunction(MCellTextFunction value);

} // MComboAutoFilterConfiguration
