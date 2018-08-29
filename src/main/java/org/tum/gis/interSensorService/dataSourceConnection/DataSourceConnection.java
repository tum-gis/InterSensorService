package org.tum.gis.interSensorService.dataSourceConnection;

public class DataSourceConnection {
	
	private String name;
	private String description;
	private String connectionType;
	private String observationProperty;
	private String observationType;
	private String unitOfMeasure;
	
	public DataSourceConnection() {
		
	}
	
	public DataSourceConnection(int id, String name, String description, String connectionType, String observationProperty, String observationType,
			String unitOfMeasure) {
		super();
		//this.id = id;
		this.name = name;
		this.description = description;
		this.connectionType = connectionType;
		this.observationProperty = observationProperty;
		this.observationType = observationType;
		this.unitOfMeasure = unitOfMeasure;
	}


	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getConnectionType() {
		return connectionType;
	}


	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}
	
	


	public String getObservationProperty() {
		return observationProperty;
	}

	public void setObservationProperty(String observationProperty) {
		this.observationProperty = observationProperty;
	}

	public String getObservationType() {
		return observationType;
	}


	public void setObservationType(String observationType) {
		this.observationType = observationType;
	}


	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}


	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	
	

}
