package org.tum.gis.minisos.dataSourceConnection.csv;

import org.tum.gis.minisos.dataSourceConnection.DataSourceConnection;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CsvConnection extends DataSourceConnection {

	private String fileLocation;
	private String separator;
	private int timeBeginColumn;
	private int timeEndColumn;
	private int valueColumn;
	private int venueColumn;
	private double latitude;
	private double longitude;
	private String searchVenue;
	
	public CsvConnection() {
		
	}
	public CsvConnection(int id, 
						String name, 
						String description, 
						String connectionType,
						String observationProperty,
						String observationType,			
						String unitOfMeasure, 
						String fileLocation,
						String separator,
						int timeBeginColumn, 
						int timeEndColumn,
						int valueColumn,
						int venueColumn,
						double latitude,
						double longitude,
						String searchVenue) {
		
		super(	id, 
				name, 
				description, 
				connectionType, 
				observationProperty,
				observationType, 
				unitOfMeasure);
		
		this.fileLocation = fileLocation;
		this.separator = separator;
		this.timeBeginColumn = timeBeginColumn;
		this.timeEndColumn = timeEndColumn;
		this.valueColumn = valueColumn;
		this.venueColumn = venueColumn;
		this.latitude = latitude;
		this.longitude = longitude;
		this.searchVenue = searchVenue;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	
	
	public String getSeparator() {
		return separator;
	}
	public void setSeparator(String separator) {
		this.separator = separator;
	}
	
	

	public int getTimeBeginColumn() {
		return timeBeginColumn;
	}
	public void setTimeBeginColumn(int timeBeginColumn) {
		this.timeBeginColumn = timeBeginColumn;
	}
	public int getTimeEndColumn() {
		return timeEndColumn;
	}
	public void setTimeEndColumn(int timeEndColumn) {
		this.timeEndColumn = timeEndColumn;
	}
	public int getVenueColumn() {
		return venueColumn;
	}
	public void setVenueColumn(int venueColumn) {
		this.venueColumn = venueColumn;
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
	public int getValueColumn() {
		return valueColumn;
	}

	public void setValueColumn(int valueColumn) {
		this.valueColumn = valueColumn;
	}
	public String getSearchVenue() {
		return searchVenue;
	}
	public void setSearchVenue(String searchVenue) {
		this.searchVenue = searchVenue;
	}
	
	
	
}
