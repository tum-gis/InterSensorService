package org.tum.gis.minisos.interfaces.seriesRestApi52n.stations;

import org.tum.gis.minisos.interfaces.seriesRestApi52n.timeseries.TimeseriesIdentifier;

public class PropertiesAll {

	private TimeseriesIdentifier timeseries = new TimeseriesIdentifier();
	private String id = "2";
	private String label = "Konigsplatz_Augsburg";
	
	public PropertiesAll() {
		
	}
	
	public PropertiesAll(TimeseriesIdentifier timeseries, String id, String label) {
		super();
		this.timeseries = timeseries;
		this.id = id;
		this.label = label;
	}
	public TimeseriesIdentifier getTimeseries() {
		return timeseries;
	}
	public void setTimeseries(TimeseriesIdentifier timeseries) {
		this.timeseries = timeseries;
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
	
	
}
