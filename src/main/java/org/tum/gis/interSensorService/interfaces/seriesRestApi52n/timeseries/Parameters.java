package org.tum.gis.interSensorService.interfaces.seriesRestApi52n.timeseries;

import org.springframework.beans.factory.annotation.Autowired;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.SeriesRestApiService;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.categories.Category;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.features.Feature;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.offerings.Offering;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.phenomena.Phenomenon;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.procedures.Procedure;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.services.Services;

public class Parameters {

	@Autowired
	private SeriesRestApiService seriesRestApiService;
	
	private Phenomenon phenomenon;
	private Procedure procedure ;
	private Category category ;
	private Offering offering ;
	private Feature feature ;
	private Services services;
	
	public Parameters() {
		
	}
	
	public Parameters(Phenomenon phenomenon, Procedure procedure, Category category, Offering offering, Feature feature,
			Services services) {
		super();
		this.phenomenon = phenomenon;
		this.procedure = procedure;
		this.category = category;
		this.offering = offering;
		this.feature = feature;
		this.services = services;
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
	public Category getCategory() {
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
	}
	public Services getServices() {
		return services;
	}
	public void setServices(Services services) {
		this.services = services;
	}
	
	
}
