package at.bestsolution.framework.grid.e4.sample;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import at.bestsolution.framework.grid.XGridContentProvider;
import at.bestsolution.framework.grid.component.XGridContentProviderProvider;
import at.bestsolution.framework.grid.emf.EListGridContentProvider;
import at.bestsolution.framework.grid.personsample.model.person.PersonPackage;

public class SampleContentProviderProvider implements XGridContentProviderProvider {

	@Override
	public boolean applies(String descriptor) {
		if( descriptor.equals("sample:platform:/plugin/at.bestsolution.framework.grid.e4.sample/sampledata/sampleData.xmi") ) {
			return true;
		}
		return false;
	}

	@Override
	public <R> XGridContentProvider<R> getContentProvider(String descriptor) {
		URI uri = URI.createURI(descriptor.substring("sample:".length()));
		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(uri, true);
		return new EListGridContentProvider<R>(resource.getContents().get(0),PersonPackage.Literals.ROOT__PERSONS);
	}

}
