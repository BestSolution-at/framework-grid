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

import at.bestsolution.framework.grid.model.grid.GridPackage;
import at.bestsolution.framework.grid.model.grid.MAlignment;
import at.bestsolution.framework.grid.model.grid.MAutoFilterConfiguration;
import at.bestsolution.framework.grid.model.grid.MCellTextFunction;
import at.bestsolution.framework.grid.model.grid.MCellValueFunction;
import at.bestsolution.framework.grid.model.grid.MGrid;
import at.bestsolution.framework.grid.model.grid.MGridColumn;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MGrid Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridColumnImpl#getId <em>Id</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridColumnImpl#getGrid <em>Grid</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridColumnImpl#getTitleKey <em>Title Key</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridColumnImpl#getMinWidth <em>Min Width</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridColumnImpl#getMaxWidth <em>Max Width</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridColumnImpl#isAutoWidth <em>Auto Width</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridColumnImpl#getCellValueFunction <em>Cell Value Function</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridColumnImpl#getCellTextFunction <em>Cell Text Function</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridColumnImpl#getAlignment <em>Alignment</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.model.grid.impl.MGridColumnImpl#getAutoFilterConfiguration <em>Auto Filter Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MGridColumnImpl extends MinimalEObjectImpl.Container implements MGridColumn {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "  Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,\n  http://www.BestSolution.at\n \n  This file is part of framework-grid which was developed with funding\n  from DI Christoph Hermann - InformationsTechnologie Beratung Hermann\n  /Austria.\n \n  Licensed under the Apache License, Version 2.0 (the \"License\");\n  you may not use this file except in compliance with the License.\n  You may obtain a copy of the License at\n \n      http://www.apache.org/licenses/LICENSE-2.0\n\n  Unless required by applicable law or agreed to in writing, software\n  distributed under the License is distributed on an \"AS IS\" BASIS,\n  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n  See the License for the specific language governing permissions and\n  limitations under the License.\n";

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitleKey() <em>Title Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitleKey()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitleKey() <em>Title Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitleKey()
	 * @generated
	 * @ordered
	 */
	protected String titleKey = TITLE_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinWidth() <em>Min Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinWidth()
	 * @generated
	 * @ordered
	 */
	protected static final Integer MIN_WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinWidth() <em>Min Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinWidth()
	 * @generated
	 * @ordered
	 */
	protected Integer minWidth = MIN_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxWidth() <em>Max Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxWidth()
	 * @generated
	 * @ordered
	 */
	protected static final Integer MAX_WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxWidth() <em>Max Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxWidth()
	 * @generated
	 * @ordered
	 */
	protected Integer maxWidth = MAX_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #isAutoWidth() <em>Auto Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoWidth()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTO_WIDTH_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAutoWidth() <em>Auto Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoWidth()
	 * @generated
	 * @ordered
	 */
	protected boolean autoWidth = AUTO_WIDTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCellValueFunction() <em>Cell Value Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCellValueFunction()
	 * @generated
	 * @ordered
	 */
	protected MCellValueFunction cellValueFunction;

	/**
	 * The cached value of the '{@link #getCellTextFunction() <em>Cell Text Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCellTextFunction()
	 * @generated
	 * @ordered
	 */
	protected MCellTextFunction cellTextFunction;

	/**
	 * The default value of the '{@link #getAlignment() <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlignment()
	 * @generated
	 * @ordered
	 */
	protected static final MAlignment ALIGNMENT_EDEFAULT = MAlignment.LEFT;

	/**
	 * The cached value of the '{@link #getAlignment() <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlignment()
	 * @generated
	 * @ordered
	 */
	protected MAlignment alignment = ALIGNMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAutoFilterConfiguration() <em>Auto Filter Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoFilterConfiguration()
	 * @generated
	 * @ordered
	 */
	protected MAutoFilterConfiguration autoFilterConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MGridColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GridPackage.Literals.MGRID_COLUMN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_COLUMN__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MGrid getGrid() {
		if (eContainerFeatureID() != GridPackage.MGRID_COLUMN__GRID) return null;
		return (MGrid)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGrid(MGrid newGrid, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGrid, GridPackage.MGRID_COLUMN__GRID, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrid(MGrid newGrid) {
		if (newGrid != eInternalContainer() || (eContainerFeatureID() != GridPackage.MGRID_COLUMN__GRID && newGrid != null)) {
			if (EcoreUtil.isAncestor(this, newGrid))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGrid != null)
				msgs = ((InternalEObject)newGrid).eInverseAdd(this, GridPackage.MGRID__COLUMNS, MGrid.class, msgs);
			msgs = basicSetGrid(newGrid, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_COLUMN__GRID, newGrid, newGrid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitleKey() {
		return titleKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitleKey(String newTitleKey) {
		String oldTitleKey = titleKey;
		titleKey = newTitleKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_COLUMN__TITLE_KEY, oldTitleKey, titleKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getMinWidth() {
		return minWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinWidth(Integer newMinWidth) {
		Integer oldMinWidth = minWidth;
		minWidth = newMinWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_COLUMN__MIN_WIDTH, oldMinWidth, minWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getMaxWidth() {
		return maxWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxWidth(Integer newMaxWidth) {
		Integer oldMaxWidth = maxWidth;
		maxWidth = newMaxWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_COLUMN__MAX_WIDTH, oldMaxWidth, maxWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutoWidth() {
		return autoWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoWidth(boolean newAutoWidth) {
		boolean oldAutoWidth = autoWidth;
		autoWidth = newAutoWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_COLUMN__AUTO_WIDTH, oldAutoWidth, autoWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MCellValueFunction getCellValueFunction() {
		return cellValueFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCellValueFunction(MCellValueFunction newCellValueFunction, NotificationChain msgs) {
		MCellValueFunction oldCellValueFunction = cellValueFunction;
		cellValueFunction = newCellValueFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_COLUMN__CELL_VALUE_FUNCTION, oldCellValueFunction, newCellValueFunction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCellValueFunction(MCellValueFunction newCellValueFunction) {
		if (newCellValueFunction != cellValueFunction) {
			NotificationChain msgs = null;
			if (cellValueFunction != null)
				msgs = ((InternalEObject)cellValueFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GridPackage.MGRID_COLUMN__CELL_VALUE_FUNCTION, null, msgs);
			if (newCellValueFunction != null)
				msgs = ((InternalEObject)newCellValueFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GridPackage.MGRID_COLUMN__CELL_VALUE_FUNCTION, null, msgs);
			msgs = basicSetCellValueFunction(newCellValueFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_COLUMN__CELL_VALUE_FUNCTION, newCellValueFunction, newCellValueFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MCellTextFunction getCellTextFunction() {
		return cellTextFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCellTextFunction(MCellTextFunction newCellTextFunction, NotificationChain msgs) {
		MCellTextFunction oldCellTextFunction = cellTextFunction;
		cellTextFunction = newCellTextFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_COLUMN__CELL_TEXT_FUNCTION, oldCellTextFunction, newCellTextFunction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCellTextFunction(MCellTextFunction newCellTextFunction) {
		if (newCellTextFunction != cellTextFunction) {
			NotificationChain msgs = null;
			if (cellTextFunction != null)
				msgs = ((InternalEObject)cellTextFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GridPackage.MGRID_COLUMN__CELL_TEXT_FUNCTION, null, msgs);
			if (newCellTextFunction != null)
				msgs = ((InternalEObject)newCellTextFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GridPackage.MGRID_COLUMN__CELL_TEXT_FUNCTION, null, msgs);
			msgs = basicSetCellTextFunction(newCellTextFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_COLUMN__CELL_TEXT_FUNCTION, newCellTextFunction, newCellTextFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAlignment getAlignment() {
		return alignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlignment(MAlignment newAlignment) {
		MAlignment oldAlignment = alignment;
		alignment = newAlignment == null ? ALIGNMENT_EDEFAULT : newAlignment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_COLUMN__ALIGNMENT, oldAlignment, alignment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAutoFilterConfiguration getAutoFilterConfiguration() {
		return autoFilterConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAutoFilterConfiguration(MAutoFilterConfiguration newAutoFilterConfiguration, NotificationChain msgs) {
		MAutoFilterConfiguration oldAutoFilterConfiguration = autoFilterConfiguration;
		autoFilterConfiguration = newAutoFilterConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_COLUMN__AUTO_FILTER_CONFIGURATION, oldAutoFilterConfiguration, newAutoFilterConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoFilterConfiguration(MAutoFilterConfiguration newAutoFilterConfiguration) {
		if (newAutoFilterConfiguration != autoFilterConfiguration) {
			NotificationChain msgs = null;
			if (autoFilterConfiguration != null)
				msgs = ((InternalEObject)autoFilterConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GridPackage.MGRID_COLUMN__AUTO_FILTER_CONFIGURATION, null, msgs);
			if (newAutoFilterConfiguration != null)
				msgs = ((InternalEObject)newAutoFilterConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GridPackage.MGRID_COLUMN__AUTO_FILTER_CONFIGURATION, null, msgs);
			msgs = basicSetAutoFilterConfiguration(newAutoFilterConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GridPackage.MGRID_COLUMN__AUTO_FILTER_CONFIGURATION, newAutoFilterConfiguration, newAutoFilterConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GridPackage.MGRID_COLUMN__GRID:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGrid((MGrid)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GridPackage.MGRID_COLUMN__GRID:
				return basicSetGrid(null, msgs);
			case GridPackage.MGRID_COLUMN__CELL_VALUE_FUNCTION:
				return basicSetCellValueFunction(null, msgs);
			case GridPackage.MGRID_COLUMN__CELL_TEXT_FUNCTION:
				return basicSetCellTextFunction(null, msgs);
			case GridPackage.MGRID_COLUMN__AUTO_FILTER_CONFIGURATION:
				return basicSetAutoFilterConfiguration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GridPackage.MGRID_COLUMN__GRID:
				return eInternalContainer().eInverseRemove(this, GridPackage.MGRID__COLUMNS, MGrid.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GridPackage.MGRID_COLUMN__ID:
				return getId();
			case GridPackage.MGRID_COLUMN__GRID:
				return getGrid();
			case GridPackage.MGRID_COLUMN__TITLE_KEY:
				return getTitleKey();
			case GridPackage.MGRID_COLUMN__MIN_WIDTH:
				return getMinWidth();
			case GridPackage.MGRID_COLUMN__MAX_WIDTH:
				return getMaxWidth();
			case GridPackage.MGRID_COLUMN__AUTO_WIDTH:
				return isAutoWidth();
			case GridPackage.MGRID_COLUMN__CELL_VALUE_FUNCTION:
				return getCellValueFunction();
			case GridPackage.MGRID_COLUMN__CELL_TEXT_FUNCTION:
				return getCellTextFunction();
			case GridPackage.MGRID_COLUMN__ALIGNMENT:
				return getAlignment();
			case GridPackage.MGRID_COLUMN__AUTO_FILTER_CONFIGURATION:
				return getAutoFilterConfiguration();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GridPackage.MGRID_COLUMN__ID:
				setId((String)newValue);
				return;
			case GridPackage.MGRID_COLUMN__GRID:
				setGrid((MGrid)newValue);
				return;
			case GridPackage.MGRID_COLUMN__TITLE_KEY:
				setTitleKey((String)newValue);
				return;
			case GridPackage.MGRID_COLUMN__MIN_WIDTH:
				setMinWidth((Integer)newValue);
				return;
			case GridPackage.MGRID_COLUMN__MAX_WIDTH:
				setMaxWidth((Integer)newValue);
				return;
			case GridPackage.MGRID_COLUMN__AUTO_WIDTH:
				setAutoWidth((Boolean)newValue);
				return;
			case GridPackage.MGRID_COLUMN__CELL_VALUE_FUNCTION:
				setCellValueFunction((MCellValueFunction)newValue);
				return;
			case GridPackage.MGRID_COLUMN__CELL_TEXT_FUNCTION:
				setCellTextFunction((MCellTextFunction)newValue);
				return;
			case GridPackage.MGRID_COLUMN__ALIGNMENT:
				setAlignment((MAlignment)newValue);
				return;
			case GridPackage.MGRID_COLUMN__AUTO_FILTER_CONFIGURATION:
				setAutoFilterConfiguration((MAutoFilterConfiguration)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GridPackage.MGRID_COLUMN__ID:
				setId(ID_EDEFAULT);
				return;
			case GridPackage.MGRID_COLUMN__GRID:
				setGrid((MGrid)null);
				return;
			case GridPackage.MGRID_COLUMN__TITLE_KEY:
				setTitleKey(TITLE_KEY_EDEFAULT);
				return;
			case GridPackage.MGRID_COLUMN__MIN_WIDTH:
				setMinWidth(MIN_WIDTH_EDEFAULT);
				return;
			case GridPackage.MGRID_COLUMN__MAX_WIDTH:
				setMaxWidth(MAX_WIDTH_EDEFAULT);
				return;
			case GridPackage.MGRID_COLUMN__AUTO_WIDTH:
				setAutoWidth(AUTO_WIDTH_EDEFAULT);
				return;
			case GridPackage.MGRID_COLUMN__CELL_VALUE_FUNCTION:
				setCellValueFunction((MCellValueFunction)null);
				return;
			case GridPackage.MGRID_COLUMN__CELL_TEXT_FUNCTION:
				setCellTextFunction((MCellTextFunction)null);
				return;
			case GridPackage.MGRID_COLUMN__ALIGNMENT:
				setAlignment(ALIGNMENT_EDEFAULT);
				return;
			case GridPackage.MGRID_COLUMN__AUTO_FILTER_CONFIGURATION:
				setAutoFilterConfiguration((MAutoFilterConfiguration)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GridPackage.MGRID_COLUMN__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case GridPackage.MGRID_COLUMN__GRID:
				return getGrid() != null;
			case GridPackage.MGRID_COLUMN__TITLE_KEY:
				return TITLE_KEY_EDEFAULT == null ? titleKey != null : !TITLE_KEY_EDEFAULT.equals(titleKey);
			case GridPackage.MGRID_COLUMN__MIN_WIDTH:
				return MIN_WIDTH_EDEFAULT == null ? minWidth != null : !MIN_WIDTH_EDEFAULT.equals(minWidth);
			case GridPackage.MGRID_COLUMN__MAX_WIDTH:
				return MAX_WIDTH_EDEFAULT == null ? maxWidth != null : !MAX_WIDTH_EDEFAULT.equals(maxWidth);
			case GridPackage.MGRID_COLUMN__AUTO_WIDTH:
				return autoWidth != AUTO_WIDTH_EDEFAULT;
			case GridPackage.MGRID_COLUMN__CELL_VALUE_FUNCTION:
				return cellValueFunction != null;
			case GridPackage.MGRID_COLUMN__CELL_TEXT_FUNCTION:
				return cellTextFunction != null;
			case GridPackage.MGRID_COLUMN__ALIGNMENT:
				return alignment != ALIGNMENT_EDEFAULT;
			case GridPackage.MGRID_COLUMN__AUTO_FILTER_CONFIGURATION:
				return autoFilterConfiguration != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", titleKey: ");
		result.append(titleKey);
		result.append(", minWidth: ");
		result.append(minWidth);
		result.append(", maxWidth: ");
		result.append(maxWidth);
		result.append(", autoWidth: ");
		result.append(autoWidth);
		result.append(", alignment: ");
		result.append(alignment);
		result.append(')');
		return result.toString();
	}

} //MGridColumnImpl
