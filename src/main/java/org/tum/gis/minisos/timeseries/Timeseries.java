package org.tum.gis.minisos.timeseries;

import org.joda.time.DateTime;

public class Timeseries {

	private int id;
	private String name;
	private String description;
	private String dataSourceType;
	private DateTime firstObservation;
	private DateTime lastObservation;
	private String observationType;
	private String unitOfMeasure;
	
	public Timeseries() {
		
	}
	
	public Timeseries(int id, String name, String description, String dataSourceType, DateTime firstObservation,
			DateTime lastObservation, String observationType, String unitOfMeasure) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dataSourceType = dataSourceType;
		this.firstObservation = firstObservation;
		this.lastObservation = lastObservation;
		this.observationType = observationType;
		this.unitOfMeasure = unitOfMeasure;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public DateTime getFirstObservation() {
		return firstObservation;
	}

	public void setFirstObservation(DateTime firstObservation) {
		this.firstObservation = firstObservation;
	}

	public DateTime getLastObservation() {
		return lastObservation;
	}

	public void setLastObservation(DateTime lastObservation) {
		this.lastObservation = lastObservation;
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
