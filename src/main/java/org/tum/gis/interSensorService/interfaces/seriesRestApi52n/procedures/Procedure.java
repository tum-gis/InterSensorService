package org.tum.gis.interSensorService.interfaces.seriesRestApi52n.procedures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.services.Services;



public class Procedure {

	private String id = "1";
	private String domainId = "Konigsplatz_Augsburg";
	private String label = "MiniSOS_Virtual_Sensor";
	private List<String> extras = new ArrayList<>(Arrays.asList("License"));
	public Services service = new Services();
	
	public Procedure() {
		
	}
	
	
	public Procedure(String id, String domainId, String label, List<String> extras, Services service) {
		super();
		this.id = id;
		this.domainId = domainId;
		this.label = label;
		this.extras = extras;
		this.service = service;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}


	public String getDomainId() {
		return domainId;
	}


	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}


	public List<String> getExtras() {
		return extras;
	}


	public void setExtras(List<String> extras) {
		this.extras = extras;
	}


	public Services getService() {
		return service;
	}


	public void setService(Services service) {
		this.service = service;
	}
	
	
}
