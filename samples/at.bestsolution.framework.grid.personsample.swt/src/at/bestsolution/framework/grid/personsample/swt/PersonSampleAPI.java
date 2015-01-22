package at.bestsolution.framework.grid.personsample.swt;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import at.bestsolution.framework.grid.DefaultXGridCellMetaData;
import at.bestsolution.framework.grid.DefaultXGridRowMetaData;
import at.bestsolution.framework.grid.ListGridContentProvider;
import at.bestsolution.framework.grid.XCellSelection;
import at.bestsolution.framework.grid.XGridCell;
import at.bestsolution.framework.grid.XGridColumn;
import at.bestsolution.framework.grid.XGridTable;
import at.bestsolution.framework.grid.personsample.model.person.Person;
import at.bestsolution.framework.grid.personsample.model.person.PersonFactory;
import at.bestsolution.framework.grid.swt.SWTGridTable;

public class PersonSampleAPI {
	private static List<Person> getPersonList() {
		List<Person> l = new ArrayList<>();

		{
			Person p = PersonFactory.eINSTANCE.createPerson();
			p.setFirstname("Tom");
			p.setLastname("Schindl");
			try {
				p.setBirthdate(new SimpleDateFormat("yyyy-MM-dd").parse("1979-05-01"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			l.add(p);
		}

		return l;
	}

	public static void main(String[] args) {
		Display d = new Display();
		Shell s = new Shell();
		s.setLayout(new FillLayout());

		XGridTable<Person> t = new SWTGridTable<>(s, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		t.metaDataFunctionProperty().set(
				r -> Collections.singletonList(new DefaultXGridRowMetaData<Person>(r, "Person Object", "persongrid/person")));

		{
			XGridColumn<Person, String> c = t.createColumn("firstname", p -> p.getFirstname());
			c.labelProperty().set("Firstname");
			c.metaDataFunctionProperty().set(
					( rv, cv ) -> Collections.singletonList(
							new DefaultXGridCellMetaData<Person>(rv, cv, "Person Firstname", "persongrid/person/firstname")));
		}

		{
			XGridColumn<Person, String> c = t.createColumn("lastname", p -> p.getLastname());
			c.labelProperty().set("Lastname");
		}

		{
			DateFormat f = DateFormat.getDateInstance();
			XGridColumn<Person, Date> c = t.createColumn("birthday", p -> p.getBirthdate());
			c.textFunctionProperty().set((p,b) -> f.format(b));
			c.labelProperty().set("Birthday");
		}

		t.contentProviderProperty().set(new ListGridContentProvider<Person>(getPersonList()));
		t.selectionProperty().addChangeListener( (p,o,n) -> {
			if( n != null ) {
				System.out.println(n.getRowMetaData());
				if( n instanceof XCellSelection<?> ) {
					XCellSelection<Person> cn = (XCellSelection<Person>) n;
					for( XGridCell<Person, ?>  c : cn.getCells() ) {
						System.out.println(c.getCellMetaData());
					}
				} else {
					System.out.println(n);
				}
			}
		});


		s.open();

		while( ! s.isDisposed() ) {
			if( ! d.readAndDispatch() ) {
				d.sleep();
			}
		}
	}
}
