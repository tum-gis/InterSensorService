package org.tum.gis.minisos.dataSourceConnection.c3ntinel.meter;

public class Location {

	private double latitude;
	private double longitude;
	
	
	public Location() {
		
	}
	
	public Location(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
}
