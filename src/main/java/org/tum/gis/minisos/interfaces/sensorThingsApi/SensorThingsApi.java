package org.tum.gis.minisos.interfaces.sensorThingsApi;

import java.util.List;

public class SensorThingsApi {

	private List<SensorThingsNode> value;

	public SensorThingsApi() {
		
	}
	
	public SensorThingsApi(List<SensorThingsNode> value) {
		super();
		this.value = value;
	}

	public List<SensorThingsNode> getValue() {
		return value;
	}

	public void setValue(List<SensorThingsNode> value) {
		this.value = value;
	}
	
	
	
	
}
