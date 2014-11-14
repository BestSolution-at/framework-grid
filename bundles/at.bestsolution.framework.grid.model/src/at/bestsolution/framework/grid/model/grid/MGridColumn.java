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
 * A representation of the model object '<em><b>MGrid Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getId <em>Id</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getGrid <em>Grid</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getTitleKey <em>Title Key</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getMinWidth <em>Min Width</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getMaxWidth <em>Max Width</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGridColumn#isAutoWidth <em>Auto Width</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getCellValueFunction <em>Cell Value Function</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getCellTextFunction <em>Cell Text Function</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getAlignment <em>Alignment</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getAutoFilterConfiguration <em>Auto Filter Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridColumn()
 * @model
 * @generated
 */
public interface MGridColumn extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridColumn_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Grid</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link at.bestsolution.framework.grid.model.grid.MGrid#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grid</em>' container reference.
	 * @see #setGrid(MGrid)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridColumn_Grid()
	 * @see at.bestsolution.framework.grid.model.grid.MGrid#getColumns
	 * @model opposite="columns" transient="false"
	 * @generated
	 */
	MGrid getGrid();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getGrid <em>Grid</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grid</em>' container reference.
	 * @see #getGrid()
	 * @generated
	 */
	void setGrid(MGrid value);

	/**
	 * Returns the value of the '<em><b>Title Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title Key</em>' attribute.
	 * @see #setTitleKey(String)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridColumn_TitleKey()
	 * @model
	 * @generated
	 */
	String getTitleKey();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getTitleKey <em>Title Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title Key</em>' attribute.
	 * @see #getTitleKey()
	 * @generated
	 */
	void setTitleKey(String value);

	/**
	 * Returns the value of the '<em><b>Min Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Width</em>' attribute.
	 * @see #setMinWidth(Integer)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridColumn_MinWidth()
	 * @model
	 * @generated
	 */
	Integer getMinWidth();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getMinWidth <em>Min Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Width</em>' attribute.
	 * @see #getMinWidth()
	 * @generated
	 */
	void setMinWidth(Integer value);

	/**
	 * Returns the value of the '<em><b>Max Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Width</em>' attribute.
	 * @see #setMaxWidth(Integer)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridColumn_MaxWidth()
	 * @model
	 * @generated
	 */
	Integer getMaxWidth();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getMaxWidth <em>Max Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Width</em>' attribute.
	 * @see #getMaxWidth()
	 * @generated
	 */
	void setMaxWidth(Integer value);

	/**
	 * Returns the value of the '<em><b>Auto Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Width</em>' attribute.
	 * @see #setAutoWidth(boolean)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridColumn_AutoWidth()
	 * @model
	 * @generated
	 */
	boolean isAutoWidth();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#isAutoWidth <em>Auto Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Width</em>' attribute.
	 * @see #isAutoWidth()
	 * @generated
	 */
	void setAutoWidth(boolean value);

	/**
	 * Returns the value of the '<em><b>Cell Value Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell Value Function</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cell Value Function</em>' containment reference.
	 * @see #setCellValueFunction(MCellValueFunction)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridColumn_CellValueFunction()
	 * @model containment="true"
	 * @generated
	 */
	MCellValueFunction getCellValueFunction();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getCellValueFunction <em>Cell Value Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cell Value Function</em>' containment reference.
	 * @see #getCellValueFunction()
	 * @generated
	 */
	void setCellValueFunction(MCellValueFunction value);

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
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridColumn_CellTextFunction()
	 * @model containment="true"
	 * @generated
	 */
	MCellTextFunction getCellTextFunction();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getCellTextFunction <em>Cell Text Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cell Text Function</em>' containment reference.
	 * @see #getCellTextFunction()
	 * @generated
	 */
	void setCellTextFunction(MCellTextFunction value);

	/**
	 * Returns the value of the '<em><b>Alignment</b></em>' attribute.
	 * The literals are from the enumeration {@link at.bestsolution.framework.grid.model.grid.MAlignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alignment</em>' attribute.
	 * @see at.bestsolution.framework.grid.model.grid.MAlignment
	 * @see #setAlignment(MAlignment)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridColumn_Alignment()
	 * @model
	 * @generated
	 */
	MAlignment getAlignment();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getAlignment <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alignment</em>' attribute.
	 * @see at.bestsolution.framework.grid.model.grid.MAlignment
	 * @see #getAlignment()
	 * @generated
	 */
	void setAlignment(MAlignment value);

	/**
	 * Returns the value of the '<em><b>Auto Filter Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Filter Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Filter Configuration</em>' containment reference.
	 * @see #setAutoFilterConfiguration(MAutoFilterConfiguration)
	 * @see at.bestsolution.framework.grid.model.grid.GridPackage#getMGridColumn_AutoFilterConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	MAutoFilterConfiguration getAutoFilterConfiguration();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.model.grid.MGridColumn#getAutoFilterConfiguration <em>Auto Filter Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Filter Configuration</em>' containment reference.
	 * @see #getAutoFilterConfiguration()
	 * @generated
	 */
	void setAutoFilterConfiguration(MAutoFilterConfiguration value);

} // MGridColumn
