/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,
 * http://www.BestSolution.at
 *
 * This file is part of framework-grid which was developed with funding
 * from DI Christoph Hermann - InformationsTechnologie Beratung Hermann
 * /Austria.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package at.bestsolution.framework.grid.emf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jdt.annotation.NonNull;

import at.bestsolution.framework.grid.XGridContentProvider;

/**
 * Provides the list content to the grid
 *
 * @param <R>
 *            the content type
 * @since 1.0
 */
public class EListGridContentProvider<@NonNull R> implements XGridContentProvider<R> {

	private List<ContentChangeListener<R>> listenerList = new ArrayList<ContentChangeListener<R>>();
	@NonNull
	final EObject parent;
	@NonNull
	final EReference reference;

	private @NonNull final EList<R> data;
	private @NonNull final Adapter adapter;

	/**
	 * @param parent
	 *            list of elements to be provided
	 * @param reference
	 *            reference to get the {@link EList} from parent
	 */
	@SuppressWarnings({ "unchecked", "null" })
	public EListGridContentProvider(@NonNull EObject parent, @NonNull EReference reference) {
		if (!parent.eClass().getEAllReferences().contains(reference)) {
			throw new IllegalArgumentException(reference + " is not contained in EClass " + parent.eClass()); //$NON-NLS-1$
		}
		if (!reference.isMany()) {
			throw new IllegalArgumentException(reference + " is not a many feature"); //$NON-NLS-1$
		}
		this.parent = parent;
		this.reference = reference;
		this.data = (EList<R>) parent.eGet(reference);
		adapter = new XGridEListAdapter();
		parent.eAdapters().add(adapter);
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public @NonNull R getElementAt(int index) throws IndexOutOfBoundsException {
		return data.get(index);
	}

	@Override
	public void addChangeListener(ContentChangeListener<@NonNull R> listener) {
		listenerList.add(listener);
	}

	@Override
	public void removeChangeListener(ContentChangeListener<@NonNull R> listener) {
		listenerList.remove(listener);
	}

	void notifyListeners(@NonNull ContentChangeType type, @NonNull List<@NonNull R> values) {
		@SuppressWarnings("null")
		@NonNull
		List<@NonNull R> unmodifiableList = Collections.unmodifiableList(values);
		@SuppressWarnings("unchecked")
		ContentChangeListener<R>[] listeners = listenerList.toArray(new ContentChangeListener[listenerList.size()]);
		for (ContentChangeListener<R> listener : listeners) {
			listener.contentChanged(type, unmodifiableList);
		}
	}

	private class XGridEListAdapter extends EContentAdapter {
		public XGridEListAdapter() {
		}

		@SuppressWarnings("unchecked")
		@Override
		public void notifyChanged(Notification notification) {
			if (notification.getNotifier() == parent) {
				if (notification.getFeature() == reference) {
					switch (notification.getEventType()) {
					case Notification.ADD:
						@SuppressWarnings("null")
						@NonNull
						List<@NonNull R> listAdd = Arrays.asList((R) notification.getNewValue());
						notifyListeners(ContentChangeType.ADD, listAdd);
						break;
					case Notification.ADD_MANY:
						@SuppressWarnings("null")
						@NonNull
						List<@NonNull R> listAddMany = (List<R>) notification.getNewValue();
						notifyListeners(ContentChangeType.ADD, listAddMany);
						break;
					case Notification.REMOVE:
						@SuppressWarnings("null")
						@NonNull
						List<@NonNull R> listRemove = Arrays.asList((R) notification.getOldValue());
						notifyListeners(ContentChangeType.REMOVE, listRemove);
						break;
					case Notification.REMOVE_MANY:
						@SuppressWarnings("null")
						@NonNull
						List<@NonNull R> listRemoveMany = (List<R>) notification.getOldValue();
						notifyListeners(ContentChangeType.REMOVE, listRemoveMany);
						break;
					default:
						// ignore other modifications
					}
				}
			} else {
				// notifier may be any object in the content tree
				Object changedObject = notification.getNotifier();
				while (changedObject != null) {
					if (reference.getEReferenceType().getInstanceClass().isAssignableFrom(changedObject.getClass())) {
						@SuppressWarnings("null")
						final @NonNull List<@NonNull R> asList = Arrays.asList((R) changedObject);
						notifyListeners(ContentChangeType.MODIFY, asList);
					}
					if (changedObject instanceof EObject) {
						changedObject = ((EObject) changedObject).eContainer();
					} else {
						changedObject = null;
					}
				}
			}
		}
	}
}
