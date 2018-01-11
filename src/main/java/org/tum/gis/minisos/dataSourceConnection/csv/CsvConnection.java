package org.tum.gis.minisos.dataSourceConnection.csv;

import org.tum.gis.minisos.dataSourceConnection.DataSourceConnection;

public class CsvConnection extends DataSourceConnection {

	private String fileLocation;
	private int timeColumn;
	private int valueColumn;
	
	public CsvConnection() {
		
	}
	public CsvConnection(int id, 
						String name, 
						String description, 
						String connectionType,
						String observationType,			
						String unitOfMeasure, 
						String fileLocation, 
						int timeColumn, 
						int valueColumn) {
		
		super(	id, 
				name, 
				description, 
				connectionType, 
				observationType, 
				unitOfMeasure);
		
		this.fileLocation = fileLocation;
		this.timeColumn = timeColumn;
		this.valueColumn = valueColumn;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public int getTimeColumn() {
		return timeColumn;
	}

	public void setTimeColumn(int timeColumn) {
		this.timeColumn = timeColumn;
	}

	public int getValueColumn() {
		return valueColumn;
	}

	public void setValueColumn(int valueColumn) {
		this.valueColumn = valueColumn;
	}
	
	
	
}
