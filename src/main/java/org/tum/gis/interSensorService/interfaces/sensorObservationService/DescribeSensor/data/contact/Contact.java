package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.contact;

public class Contact {

	private ContactList contactList = new ContactList();

	public Contact() {
		
	}
	
	public Contact(ContactList contactList) {
		super();
		this.contactList = contactList;
	}

	public ContactList getContactList() {
		return contactList;
	}

	public void setContactList(ContactList contactList) {
		this.contactList = contactList;
	} 
	
	
}
