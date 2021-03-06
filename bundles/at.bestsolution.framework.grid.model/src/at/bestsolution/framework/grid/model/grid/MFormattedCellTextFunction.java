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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MFormatted Cell Text Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MFormattedCellTextFunction#getFormatType <em>Format Type</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MFormattedCellTextFunction#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMFormattedCellTextFunction()
 * @model
 * @generated
 */
public interface MFormattedCellTextFunction extends MCellTextFunction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * Returns the value of the '<em><b>Format Type</b></em>' attribute.
	 * The literals are from the enumeration {@link at.bestsolution.framework.grid.model.grid.MFormatType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format Type</em>' attribute.
	 * @see at.bestsolution.framework.grid.model.grid.MFormatType
	 * @see #setFormatType(MFormatType)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMFormattedCellTextFunction_FormatType()
	 * @model
	 * @generated
	 */
	MFormatType getFormatType();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MFormattedCellTextFunction#getFormatType <em>Format Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format Type</em>' attribute.
	 * @see at.bestsolution.framework.grid.model.grid.MFormatType
	 * @see #getFormatType()
	 * @generated
	 */
	void setFormatType(MFormatType value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' containment reference.
	 * @see #setPattern(MPattern)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMFormattedCellTextFunction_Pattern()
	 * @model containment="true"
	 * @generated
	 */
	MPattern getPattern();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MFormattedCellTextFunction#getPattern <em>Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' containment reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(MPattern value);

} // MFormattedCellTextFunction
