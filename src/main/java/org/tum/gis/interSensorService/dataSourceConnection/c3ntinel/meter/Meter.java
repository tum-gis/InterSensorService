package org.tum.gis.interSensorService.dataSourceConnection.c3ntinel.meter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meter {

	private String name;
	private String details;
	private String meterType;
	private String utilityType;
	private String referenceNumber;
	private String serialNumber;
	private String postalCode;
	private String floorArea;
	
	@JsonProperty("location")
	private Location location;

	
	public Meter() {
		
	}
	
	public Meter(String name, String details, String meterType, String utilityType, String referenceNumber,
			String serialNumber, String postalCode, String floorArea, Location location) {
		super();
		this.name = name;
		this.details = details;
		this.meterType = meterType;
		this.utilityType = utilityType;
		this.referenceNumber = referenceNumber;
		this.serialNumber = serialNumber;
		this.postalCode = postalCode;
		this.floorArea = floorArea;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getMeterType() {
		return meterType;
	}

	public void setMeterType(String meterType) {
		this.meterType = meterType;
	}

	public String getUtilityType() {
		return utilityType;
	}

	public void setUtilityType(String utilityType) {
		this.utilityType = utilityType;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(String floorArea) {
		this.floorArea = floorArea;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	
	
	
	

}
