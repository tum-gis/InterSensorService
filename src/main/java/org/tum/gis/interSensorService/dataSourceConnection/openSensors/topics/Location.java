package org.tum.gis.interSensorService.dataSourceConnection.openSensors.topics;

public class Location {

	private Double lat;
	private Double lon;
	
	public Location() {
		
	}
	
	public Location(Double lat, Double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	
	
}
