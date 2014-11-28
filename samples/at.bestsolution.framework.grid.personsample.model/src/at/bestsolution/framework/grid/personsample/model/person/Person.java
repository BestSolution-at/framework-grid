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
package at.bestsolution.framework.grid.personsample.model.person;

import java.util.Date;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.bestsolution.framework.grid.personsample.model.person.Person#getFirstname <em>Firstname</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.personsample.model.person.Person#getLastname <em>Lastname</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.personsample.model.person.Person#getGender <em>Gender</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.personsample.model.person.Person#getPartner <em>Partner</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.personsample.model.person.Person#getMarried <em>Married</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.personsample.model.person.Person#getBirthdate <em>Birthdate</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.personsample.model.person.Person#getWeight <em>Weight</em>}</li>
 *   <li>{@link at.bestsolution.framework.grid.personsample.model.person.Person#getAddress <em>Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.bestsolution.framework.grid.personsample.model.person.PersonPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends EObject {
	/**
	 * Returns the value of the '<em><b>Firstname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Firstname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Firstname</em>' attribute.
	 * @see #setFirstname(String)
	 * @see at.bestsolution.framework.grid.personsample.model.person.PersonPackage#getPerson_Firstname()
	 * @model unique="false"
	 * @generated
	 */
	String getFirstname();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.personsample.model.person.Person#getFirstname <em>Firstname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Firstname</em>' attribute.
	 * @see #getFirstname()
	 * @generated
	 */
	void setFirstname(String value);

	/**
	 * Returns the value of the '<em><b>Lastname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lastname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lastname</em>' attribute.
	 * @see #setLastname(String)
	 * @see at.bestsolution.framework.grid.personsample.model.person.PersonPackage#getPerson_Lastname()
	 * @model unique="false"
	 * @generated
	 */
	String getLastname();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.personsample.model.person.Person#getLastname <em>Lastname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lastname</em>' attribute.
	 * @see #getLastname()
	 * @generated
	 */
	void setLastname(String value);

	/**
	 * Returns the value of the '<em><b>Gender</b></em>' attribute.
	 * The literals are from the enumeration {@link at.bestsolution.framework.grid.personsample.model.person.Gender}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gender</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gender</em>' attribute.
	 * @see at.bestsolution.framework.grid.personsample.model.person.Gender
	 * @see #setGender(Gender)
	 * @see at.bestsolution.framework.grid.personsample.model.person.PersonPackage#getPerson_Gender()
	 * @model unique="false"
	 * @generated
	 */
	Gender getGender();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.personsample.model.person.Person#getGender <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gender</em>' attribute.
	 * @see at.bestsolution.framework.grid.personsample.model.person.Gender
	 * @see #getGender()
	 * @generated
	 */
	void setGender(Gender value);

	/**
	 * Returns the value of the '<em><b>Partner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partner</em>' reference.
	 * @see #setPartner(Person)
	 * @see at.bestsolution.framework.grid.personsample.model.person.PersonPackage#getPerson_Partner()
	 * @model
	 * @generated
	 */
	Person getPartner();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.personsample.model.person.Person#getPartner <em>Partner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner</em>' reference.
	 * @see #getPartner()
	 * @generated
	 */
	void setPartner(Person value);

	/**
	 * Returns the value of the '<em><b>Married</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Married</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Married</em>' attribute.
	 * @see #setMarried(Boolean)
	 * @see at.bestsolution.framework.grid.personsample.model.person.PersonPackage#getPerson_Married()
	 * @model unique="false"
	 * @generated
	 */
	Boolean getMarried();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.personsample.model.person.Person#getMarried <em>Married</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Married</em>' attribute.
	 * @see #getMarried()
	 * @generated
	 */
	void setMarried(Boolean value);

	/**
	 * Returns the value of the '<em><b>Birthdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Birthdate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Birthdate</em>' attribute.
	 * @see #setBirthdate(Date)
	 * @see at.bestsolution.framework.grid.personsample.model.person.PersonPackage#getPerson_Birthdate()
	 * @model unique="false"
	 * @generated
	 */
	Date getBirthdate();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.personsample.model.person.Person#getBirthdate <em>Birthdate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Birthdate</em>' attribute.
	 * @see #getBirthdate()
	 * @generated
	 */
	void setBirthdate(Date value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(Double)
	 * @see at.bestsolution.framework.grid.personsample.model.person.PersonPackage#getPerson_Weight()
	 * @model unique="false"
	 * @generated
	 */
	Double getWeight();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.personsample.model.person.Person#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(Double value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' containment reference.
	 * @see #setAddress(Address)
	 * @see at.bestsolution.framework.grid.personsample.model.person.PersonPackage#getPerson_Address()
	 * @model containment="true"
	 * @generated
	 */
	Address getAddress();

	/**
	 * Sets the value of the '{@link at.bestsolution.framework.grid.personsample.model.person.Person#getAddress <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' containment reference.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(Address value);

} // Person
