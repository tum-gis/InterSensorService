package org.tum.gis.minisos.interfaces.sensorThingsApi.things;

import org.tum.gis.minisos.interfaces.sensorThingsApi.things.properties.Properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Thing {

	
	
	@JsonProperty("@iot.id")
	private int id;
	@JsonProperty("@iot.selfLink")
	private String selfLink;
	
	private String description;
	private String name;
	private Properties properties;
	
	@JsonProperty("Datastreams@iot.navigationLink")
	private String datastreams;
	
	@JsonProperty("HistoricalLocations@iot.navigationLink")
	private String historicalLocations;
	
	@JsonProperty("Locations@iot.navigationLink")
	private String locations;

	public Thing() {
		
	}
	
	public Thing(int id, String selfLink, String description, String name, Properties properties, String datastreams,
			String historicalLocations, String locations) {
		super();
		this.id = id;
		this.selfLink = selfLink;
		this.description = description;
		this.name = name;
		this.properties = properties;
		this.datastreams = datastreams;
		this.historicalLocations = historicalLocations;
		this.locations = locations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSelfLink() {
		return selfLink;
	}

	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
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

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getDatastreams() {
		return datastreams;
	}

	public void setDatastreams(String datastreams) {
		this.datastreams = datastreams;
	}

	public String getHistoricalLocations() {
		return historicalLocations;
	}

	public void setHistoricalLocations(String historicalLocations) {
		this.historicalLocations = historicalLocations;
	}

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	
	
	
}
