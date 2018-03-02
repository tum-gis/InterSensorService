package org.tum.gis.minisos.interfaces.Rest52n.station;

public class TimeseriesCollection {

	private Phenomenon phenomenon = new Phenomenon();
	private Procedure procedure = new Procedure();
	private Category category = new Category();
	private Offering offering = new Offering();
	private Feature feature = new Feature();
	private Service service = new Service();
	
	public TimeseriesCollection() {
		
	}
	
	public TimeseriesCollection(Phenomenon phenomenon, Procedure procedure, Category category, Offering offering,
			Feature feature, Service service) {
		super();
		this.phenomenon = phenomenon;
		this.procedure = procedure;
		this.category = category;
		this.offering = offering;
		this.feature = feature;
		this.service = service;
	}

	public Phenomenon getPhenomenon() {
		return phenomenon;
	}

	public void setPhenomenon(Phenomenon phenomenon) {
		this.phenomenon = phenomenon;
	}

	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	/*public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Offering getOffering() {
		return offering;
	}

	public void setOffering(Offering offering) {
		this.offering = offering;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}*/

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	
	
}
