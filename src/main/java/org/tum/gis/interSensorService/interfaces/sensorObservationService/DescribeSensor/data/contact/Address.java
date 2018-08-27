package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.contact;

public class Address {

	private String deliveryPoint = "Arcisstrasse 21";
	private String city = "Munich";
	private String postalCode = "80333";
	private String country = "Germany";
	private String electronicMailAddress = "kanishk.chaturvedi@tum.de";
	
	public Address() {
		
	}
	
	public Address(String deliveryPoint, String city, String postalCode, String country, String electronicMailAddress) {
		super();
		this.deliveryPoint = deliveryPoint;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
		this.electronicMailAddress = electronicMailAddress;
	}
	public String getDeliveryPoint() {
		return deliveryPoint;
	}
	public void setDeliveryPoint(String deliveryPoint) {
		this.deliveryPoint = deliveryPoint;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getElectronicMailAddress() {
		return electronicMailAddress;
	}
	public void setElectronicMailAddress(String electronicMailAddress) {
		this.electronicMailAddress = electronicMailAddress;
	}
	
	
}
