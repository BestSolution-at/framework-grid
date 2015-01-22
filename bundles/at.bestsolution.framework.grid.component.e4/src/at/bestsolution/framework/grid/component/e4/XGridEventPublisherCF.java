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
package at.bestsolution.framework.grid.component.e4;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.component.XGridEventPublisher;

/**
 * Context function to create {@link XGridEventPublisher} on request
 */
public class XGridEventPublisherCF extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		MPart mPart = context.get(MPart.class);
		return new XGridEventPublisherImpl(context.get(IEventBroker.class), mPart.getPersistedState().get("xgrid.eventprefix"), mPart.getPersistedState().get("xgrid.eventsynctype")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	static class XGridEventPublisherImpl implements XGridEventPublisher {
		private final IEventBroker broker;
		@Nullable
		private final String prefix;
		private final String syncType;

		public XGridEventPublisherImpl(IEventBroker broker, @Nullable String prefix, @Nullable String syncType) {
			this.broker = broker;
			this.prefix = prefix;
			this.syncType = syncType == null ? XGridEventPublisher.SYNC_TYPE_ASYNC : SYNC_TYPE_SYNC;
		}

		@Override
		public void publish(String topic, Object data) {
			String t = topic;

			if (prefix != null) {
				t = prefix + t;
			}

			if( XGridEventPublisher.SYNC_TYPE_ASYNC.equals(syncType) ) {
				broker.post(t, data);
			} else {
				broker.send(t, data);
			}
		}

	}
}
