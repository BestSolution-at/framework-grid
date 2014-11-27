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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.jdt.annotation.NonNull;

import at.bestsolution.framework.grid.component.XGridContentProviderProvider;
import at.bestsolution.framework.grid.component.XGridContentProviderProviderLookup;
import at.bestsolution.framework.grid.component.XGridTableConfiguration;
import at.bestsolution.framework.grid.component.XGridTableConfigurationProvider;
import at.bestsolution.framework.grid.component.XGridTableConfigurationProviderLookup;
import at.bestsolution.framework.grid.component.XGridTableConfigurator;
import at.bestsolution.framework.grid.component.XGridTableConfiguratorLookup;

/**
 * Collect various OSGi-Services
 */
public class OSGiServiceCollector implements XGridTableConfiguratorLookup, XGridContentProviderProviderLookup, XGridTableConfigurationProviderLookup {
	private List<XGridTableConfigurationProvider> providerList = new ArrayList<>();
	private List<XGridTableConfigurator> configuratorList = new ArrayList<>();
	private List<XGridContentProviderProvider> contentProviderList = new ArrayList<>();

	/**
	 * Register provider
	 *
	 * @param provider
	 *            a provider
	 */
	public void addXGridTableConfigurationProvider(XGridTableConfigurationProvider provider) {
		synchronized (providerList) {
			providerList.add(provider);
		}
	}

	/**
	 * Unregister a provider
	 *
	 * @param provider
	 *            a provider
	 */
	public void removeXGridTableConfigurationProvider(XGridTableConfigurationProvider provider) {
		synchronized (providerList) {
			providerList.remove(provider);
		}
	}

	/**
	 * Register a configurator
	 *
	 * @param configurator
	 *            a configurator
	 */
	public void addXGridTableConfigurator(XGridTableConfigurator configurator) {
		synchronized (configuratorList) {
			configuratorList.add(configurator);
		}
	}

	/**
	 * Unregister a configurator
	 *
	 * @param configurator
	 *            a configurator
	 */
	public void removeXGridTableConfigurator(XGridTableConfigurator configurator) {
		synchronized (configuratorList) {
			configuratorList.remove(configurator);
		}
	}

	/**
	 * Register a provider
	 *
	 * @param provider
	 *            a provider
	 */
	public void addXGridContentProviderProvider(XGridContentProviderProvider provider) {
		synchronized (contentProviderList) {
			contentProviderList.add(provider);
		}
	}

	/**
	 * Unregister a provider
	 *
	 * @param provider
	 *            a provider
	 */
	public void removeXGridContentProviderProvider(XGridContentProviderProvider provider) {
		synchronized (contentProviderList) {
			contentProviderList.remove(provider);
		}
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull Optional<XGridTableConfigurationProvider> getTableConfigurationProvider(String descriptor) {
		return providerList.stream().filter((p) -> p.applies(descriptor)).findFirst();
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull Optional<XGridContentProviderProvider> getContentProvider(String descriptor) {
		return contentProviderList.stream().filter((p) -> p.applies(descriptor)).findFirst();
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull Optional<XGridTableConfigurator> getTableConfigurator(XGridTableConfiguration configuration) {
		return configuratorList.stream().filter((p) -> p.applies(configuration)).findFirst();
	}

}
