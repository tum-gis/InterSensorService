package org.tum.gis.minisos.dataSourceConnection.openSensors.topics;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Topics {

	@JsonProperty("description")
	private String description;
	
	@JsonProperty("stats")
	private Stats stats;
	
	@JsonProperty("unit")
	private String unit;
	
	@JsonProperty("name")
	private String name;

	public Topics() {
		
	}
	
	

	public Topics(String description, Stats stats, String unit, String name) {
		super();
		this.description = description;
		this.stats = stats;
		this.unit = unit;
		this.name = name;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Stats getStats() {
		return stats;
	}



	public void setStats(Stats stats) {
		this.stats = stats;
	}



	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
