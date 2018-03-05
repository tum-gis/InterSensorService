package org.tum.gis.minisos.interfaces.seriesRestApi52n.timeseries;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlotSeries {

	FlotData flotData;

	public FlotSeries() {
		
	}
	
	public FlotSeries(FlotData flotData) {
		super();
		this.flotData = flotData;
	}

	@JsonProperty("1")
	public FlotData getFlotData() {	
		return flotData;
	}

	public void setFlotData(FlotData flotData) {
		this.flotData = flotData;
	}
	
	
	
}
