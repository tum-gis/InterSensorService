package org.tum.gis.minisos.interfaces.seriesRestApi52n.timeseries;

import org.tum.gis.minisos.interfaces.seriesRestApi52n.phenomena.Phenomenon;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.procedures.Procedure;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.services.Service;

public class TimeseriesIdentifierCollection {

	private Phenomenon phenomenon = new Phenomenon();
	private Procedure procedure = new Procedure();
	private Service service = new Service();
	
	public TimeseriesIdentifierCollection() {
		
	}
	
	public TimeseriesIdentifierCollection(Phenomenon phenomenon, Procedure procedure, Service service) {
		super();
		this.phenomenon = phenomenon;
		this.procedure = procedure;
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
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
	
}
