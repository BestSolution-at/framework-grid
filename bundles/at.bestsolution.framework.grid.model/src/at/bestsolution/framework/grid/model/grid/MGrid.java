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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MGrid</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGrid#getColumns <em>Columns</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGrid#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGrid#getDefaultConfiguration <em>Default Configuration</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGrid#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGrid()
 * @model
 * @generated
 */
public interface MGrid extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link at.bestsolution.framework.grid.model.grid.MGridColumn}.
	 * It is bidirectional and its opposite is '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getGrid <em>Grid</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGrid_Columns()
	 * @see at.bestsolution.framework.grid.model.grid.MGridColumn#getGrid
	 * @model opposite="grid" containment="true"
	 * @generated
	 */
	EList<MGridColumn> getColumns();

	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet}.
	 * It is bidirectional and its opposite is '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getGrid <em>Grid</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' containment reference list.
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGrid_Configurations()
	 * @see at.bestsolution.framework.grid.model.grid.MGridConfigurationSet#getGrid
	 * @model opposite="grid" containment="true"
	 * @generated
	 */
	EList<MGridConfigurationSet> getConfigurations();

	/**
	 * Returns the value of the '<em><b>Default Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Configuration</em>' reference.
	 * @see #setDefaultConfiguration(MGridConfigurationSet)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGrid_DefaultConfiguration()
	 * @model
	 * @generated
	 */
	MGridConfigurationSet getDefaultConfiguration();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGrid#getDefaultConfiguration <em>Default Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Configuration</em>' reference.
	 * @see #getDefaultConfiguration()
	 * @generated
	 */
	void setDefaultConfiguration(MGridConfigurationSet value);

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link at.bestsolution.framework.grid.model.grid.MResourceBundle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGrid_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<MResourceBundle> getResources();

} // MGrid
