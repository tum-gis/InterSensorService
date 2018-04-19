package org.tum.gis.minisos.dataSource.sensorThings.things;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Things {

	private String description;
	private String name;
	
	@JsonProperty("properties")
	private Properties propeties;
	
	public Things() {
		
	}
	
	public Things(String description, String name, Properties propeties) {
		super();
		this.description = description;
		this.name = name;
		this.propeties = propeties;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Properties getPropeties() {
		return propeties;
	}
	public void setPropeties(Properties propeties) {
		this.propeties = propeties;
	}
	
	
}
