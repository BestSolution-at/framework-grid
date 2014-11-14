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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see at.bestsolution.framework.grid.model.grid.GridPackage
 * @generated
 */
public class GridAdapterFactory extends AdapterFactoryImpl {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GridPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GridAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GridPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GridSwitch<Adapter> modelSwitch =
		new GridSwitch<Adapter>() {
			@Override
			public Adapter caseMResourceBundle(MResourceBundle object) {
				return createMResourceBundleAdapter();
			}
			@Override
			public Adapter caseMResourceBundleEntry(MResourceBundleEntry object) {
				return createMResourceBundleEntryAdapter();
			}
			@Override
			public Adapter caseMGrid(MGrid object) {
				return createMGridAdapter();
			}
			@Override
			public Adapter caseMGridConfigurationSet(MGridConfigurationSet object) {
				return createMGridConfigurationSetAdapter();
			}
			@Override
			public Adapter caseMGridConfiguration(MGridConfiguration object) {
				return createMGridConfigurationAdapter();
			}
			@Override
			public Adapter caseMGridConfigurationColumn(MGridConfigurationColumn object) {
				return createMGridConfigurationColumnAdapter();
			}
			@Override
			public Adapter caseMGridColumn(MGridColumn object) {
				return createMGridColumnAdapter();
			}
			@Override
			public Adapter caseMCellValueFunction(MCellValueFunction object) {
				return createMCellValueFunctionAdapter();
			}
			@Override
			public Adapter caseMPathCellValueFunction(MPathCellValueFunction object) {
				return createMPathCellValueFunctionAdapter();
			}
			@Override
			public Adapter caseMPathSegment(MPathSegment object) {
				return createMPathSegmentAdapter();
			}
			@Override
			public Adapter caseMSimplePathSegment(MSimplePathSegment object) {
				return createMSimplePathSegmentAdapter();
			}
			@Override
			public Adapter caseMCellTextFunction(MCellTextFunction object) {
				return createMCellTextFunctionAdapter();
			}
			@Override
			public Adapter caseMFormattedCellTextFunction(MFormattedCellTextFunction object) {
				return createMFormattedCellTextFunctionAdapter();
			}
			@Override
			public Adapter caseMPattern(MPattern object) {
				return createMPatternAdapter();
			}
			@Override
			public Adapter caseMStringPattern(MStringPattern object) {
				return createMStringPatternAdapter();
			}
			@Override
			public Adapter caseMReferencePattern(MReferencePattern object) {
				return createMReferencePatternAdapter();
			}
			@Override
			public Adapter caseMAutoFilterConfiguration(MAutoFilterConfiguration object) {
				return createMAutoFilterConfigurationAdapter();
			}
			@Override
			public Adapter caseMComboAutoFilterConfiguration(MComboAutoFilterConfiguration object) {
				return createMComboAutoFilterConfigurationAdapter();
			}
			@Override
			public Adapter caseMFreeTextAutoFilterConfiguration(MFreeTextAutoFilterConfiguration object) {
				return createMFreeTextAutoFilterConfigurationAdapter();
			}
			@Override
			public Adapter caseMAutoFilterEntry(MAutoFilterEntry object) {
				return createMAutoFilterEntryAdapter();
			}
			@Override
			public Adapter caseMTextAutoFilterEntry(MTextAutoFilterEntry object) {
				return createMTextAutoFilterEntryAdapter();
			}
			@Override
			public Adapter caseMDefaultAutoFilterEntry(MDefaultAutoFilterEntry object) {
				return createMDefaultAutoFilterEntryAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MResourceBundle <em>MResource Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MResourceBundle
	 * @generated
	 */
	public Adapter createMResourceBundleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MResourceBundleEntry <em>MResource Bundle Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MResourceBundleEntry
	 * @generated
	 */
	public Adapter createMResourceBundleEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MGrid <em>MGrid</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MGrid
	 * @generated
	 */
	public Adapter createMGridAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationSet <em>MGrid Configuration Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MGridConfigurationSet
	 * @generated
	 */
	public Adapter createMGridConfigurationSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MGridConfiguration <em>MGrid Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MGridConfiguration
	 * @generated
	 */
	public Adapter createMGridConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MGridConfigurationColumn <em>MGrid Configuration Column</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MGridConfigurationColumn
	 * @generated
	 */
	public Adapter createMGridConfigurationColumnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MGridColumn <em>MGrid Column</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MGridColumn
	 * @generated
	 */
	public Adapter createMGridColumnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MCellValueFunction <em>MCell Value Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MCellValueFunction
	 * @generated
	 */
	public Adapter createMCellValueFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MPathCellValueFunction <em>MPath Cell Value Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MPathCellValueFunction
	 * @generated
	 */
	public Adapter createMPathCellValueFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MPathSegment <em>MPath Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MPathSegment
	 * @generated
	 */
	public Adapter createMPathSegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MSimplePathSegment <em>MSimple Path Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MSimplePathSegment
	 * @generated
	 */
	public Adapter createMSimplePathSegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MCellTextFunction <em>MCell Text Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MCellTextFunction
	 * @generated
	 */
	public Adapter createMCellTextFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MFormattedCellTextFunction <em>MFormatted Cell Text Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MFormattedCellTextFunction
	 * @generated
	 */
	public Adapter createMFormattedCellTextFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MPattern <em>MPattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MPattern
	 * @generated
	 */
	public Adapter createMPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MStringPattern <em>MString Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MStringPattern
	 * @generated
	 */
	public Adapter createMStringPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MReferencePattern <em>MReference Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MReferencePattern
	 * @generated
	 */
	public Adapter createMReferencePatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MAutoFilterConfiguration <em>MAuto Filter Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MAutoFilterConfiguration
	 * @generated
	 */
	public Adapter createMAutoFilterConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration <em>MCombo Auto Filter Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MComboAutoFilterConfiguration
	 * @generated
	 */
	public Adapter createMComboAutoFilterConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MFreeTextAutoFilterConfiguration <em>MFree Text Auto Filter Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MFreeTextAutoFilterConfiguration
	 * @generated
	 */
	public Adapter createMFreeTextAutoFilterConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MAutoFilterEntry <em>MAuto Filter Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MAutoFilterEntry
	 * @generated
	 */
	public Adapter createMAutoFilterEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MTextAutoFilterEntry <em>MText Auto Filter Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MTextAutoFilterEntry
	 * @generated
	 */
	public Adapter createMTextAutoFilterEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.bestsolution.framework.grid.model.grid.MDefaultAutoFilterEntry <em>MDefault Auto Filter Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.bestsolution.framework.grid.model.grid.MDefaultAutoFilterEntry
	 * @generated
	 */
	public Adapter createMDefaultAutoFilterEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GridAdapterFactory
