package org.tum.gis.interSensorService.timeseries;

import org.joda.time.DateTime;

public class Timeseries {

	private int id;
	private int dataSourceId;
	private String name;
	private String description;
	private String dataSourceType;
	private String firstObservation;
	private String lastObservation;
	private String observationProperty;
	private String observationType;
	private String unitOfMeasure;
	
	public Timeseries() {
		
	}
	
	public Timeseries(int id, int dataSourceId, String name, String description, String dataSourceType, String firstObservation,
			String lastObservation, String observationProperty, String observationType, String unitOfMeasure) {
		super();
		this.id = id;
		this.dataSourceId = dataSourceId;
		this.name = name;
		this.description = description;
		this.dataSourceType = dataSourceType;
		this.firstObservation = firstObservation;
		this.lastObservation = lastObservation;
		this.observationProperty = observationProperty;
		this.observationType = observationType;
		this.unitOfMeasure = unitOfMeasure;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	public int getDataSourceId() {
		return dataSourceId;
	}

	public void setDataSourceId(int dataSourceId) {
		this.dataSourceId = dataSourceId;
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

	public String getDataSourceType() {
		return dataSourceType;
	}

	public void setDataSourceType(String dataSourceType) {
		this.dataSourceType = dataSourceType;
	}

	public String getFirstObservation() {
		return firstObservation;
	}

	public void setFirstObservation(String firstObservation) {
		this.firstObservation = firstObservation;
	}

	public String getLastObservation() {
		return lastObservation;
	}

	public void setLastObservation(String lastObservation) {
		this.lastObservation = lastObservation;
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
