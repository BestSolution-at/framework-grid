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
package at.bestsolution.framework.grid.component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.Property;
import at.bestsolution.framework.grid.XGrid;
import at.bestsolution.framework.grid.XGrid.Selection;
import at.bestsolution.framework.grid.XGridCell;
import at.bestsolution.framework.grid.XGridContentProvider;
import at.bestsolution.framework.grid.XGridMetaData;
import at.bestsolution.framework.grid.XGridTable;
import at.bestsolution.framework.grid.component.XGridTableConfigurator.XConfiguredGridTable;

/**
 * Grid component configured through a dependency injection container
 *
 * @param <O>
 *            the domain type
 */
public final class XGridTableComponent<O> {
	private XConfiguredGridTable<O> configuredGrid;
	private XGridTableConfiguration configuration;
	private XGridContentProvider<O> contentProvider;
	private XGridEventPublisher publisher;
	private XGridTable<O> grid;
	private XGridTableConfigurator configurator;

	/**
	 * Initialize the component
	 *
	 * @param factory
	 *            the factory to create the grid
	 * @param configurator
	 *            the configurator to use
	 * @param publisher
	 *            the publisher for grid informations
	 */
	@PostConstruct
	public final void init(@NonNull XGridFactory factory, @NonNull XGridTableConfigurator configurator,
			@NonNull XGridEventPublisher publisher) {
		this.publisher = publisher;
		this.configurator = configurator;
		grid = factory.createGridTable();

		if (configuration != null) {
			configure();
		}
	}

	private void handleSelectionChanged(Property<Selection<@NonNull O, @NonNull O>> property, Selection<@NonNull O, @NonNull O> oldValue,
			Selection<@NonNull O, @NonNull O> newValue) {
		publisher.publish(XGridEventPublisher.SELECTION_CHANGED, newValue);
		if (newValue != null) {
			if (grid.selectionModeProperty().get() == XGrid.SelectionMode.SINGLE_CELL) {
				@NonNull
				Selection<@NonNull O, XGridCell<@NonNull O, Object>> selection = newValue.asCellSelection();
				for (XGridCell<@NonNull O, Object> c : selection.asList()) {
					for (XGridMetaData d : c.getMetaData()) {
						publisher.publish(d.getTopic(), d);
					}
				}
			} else {
				for (XGridMetaData d : newValue.getMetaData()) {
					publisher.publish(d.getTopic(), d);
				}
			}
		}
	}

	private void configure() {
		configuredGrid = configurator.configure(grid, configuration);
		grid.contentProviderProperty().set(contentProvider);
		grid.selectionProperty().addChangeListener(this::handleSelectionChanged);
	}

	/**
	 * @return the control
	 */
	public @Nullable XGridTable<O> getControl() {
		return grid;
	}

	/**
	 * Reconfigure the grid with a new configuration
	 *
	 * @param configuration
	 *            the new configuration
	 */
	@Inject
	@org.eclipse.e4.core.di.annotations.Optional
	public final void reconfigure(@NonNull XGridTableConfiguration configuration) {
		this.configuration = configuration;
		if (grid != null) {
			if (configuredGrid == null) {
				configure();
			}
			configuredGrid.reconfigure(configuration);
		}
	}

	/**
	 * Set a new content provider
	 *
	 * @param contentProvider
	 *            the new content provider
	 */
	@Inject
	@org.eclipse.e4.core.di.annotations.Optional
	public final void updateContent(@NonNull XGridContentProvider<O> contentProvider) {
		this.contentProvider = contentProvider;
		if (configuredGrid != null) {
			grid.contentProviderProperty().set(contentProvider);
		}
	}
}
