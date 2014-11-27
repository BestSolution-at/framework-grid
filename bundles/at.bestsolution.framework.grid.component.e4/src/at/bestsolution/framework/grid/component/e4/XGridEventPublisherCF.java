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
		return new XGridEventPublisherImpl(context.get(IEventBroker.class), mPart.getPersistedState().get("xgrid.eventprefix")); //$NON-NLS-1$
	}

	static class XGridEventPublisherImpl implements XGridEventPublisher {
		private final IEventBroker broker;
		@Nullable
		private final String prefix;

		public XGridEventPublisherImpl(IEventBroker broker, @Nullable String prefix) {
			this.broker = broker;
			this.prefix = prefix;
		}

		@Override
		public void publish(String topic, Object data) {
			if (prefix != null) {
				broker.send(prefix + "/" + topic, data); //$NON-NLS-1$
			} else {
				broker.send(topic, data);
			}
		}

	}
}
