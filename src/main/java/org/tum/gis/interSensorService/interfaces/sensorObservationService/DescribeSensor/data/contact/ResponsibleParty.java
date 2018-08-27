package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.contact;

public class ResponsibleParty {

	private String individualName = "Kanishk Chaturvedi";
	private String organizationName = "Technical University of Munich";
	private String positionName = "Research Associate";
	private ContactInfo contactInfo = new ContactInfo();
	private Address address = new Address();
	private OnlineResource onlineResource = new OnlineResource();
	
	public ResponsibleParty() {
		
	}
	
	public ResponsibleParty(String individualName, String organizationName, String positionName,
			ContactInfo contactInfo, Address address, OnlineResource onlineResource) {
		super();
		this.individualName = individualName;
		this.organizationName = organizationName;
		this.positionName = positionName;
		this.contactInfo = contactInfo;
		this.address = address;
		this.onlineResource = onlineResource;
	}
	public String getIndividualName() {
		return individualName;
	}
	public void setIndividualName(String individualName) {
		this.individualName = individualName;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public OnlineResource getOnlineResource() {
		return onlineResource;
	}
	public void setOnlineResource(OnlineResource onlineResource) {
		this.onlineResource = onlineResource;
	}
	
	
}
