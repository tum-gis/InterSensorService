package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.position;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Position1 {

	@JacksonXmlProperty (isAttribute = true)
	private String referenceFrame = "urn:ogc:def:crs:EPSG::4326";
	
	private Location location = new Location();

	public Position1() {
		
	}
	
	public Position1(String referenceFrame, Location location) {
		super();
		this.referenceFrame = referenceFrame;
		this.location = location;
	}

	public String getReferenceFrame() {
		return referenceFrame;
	}

	public void setReferenceFrame(String referenceFrame) {
		this.referenceFrame = referenceFrame;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
