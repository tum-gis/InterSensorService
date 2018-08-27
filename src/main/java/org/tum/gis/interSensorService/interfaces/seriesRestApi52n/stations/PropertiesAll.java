package org.tum.gis.interSensorService.interfaces.seriesRestApi52n.stations;

import java.util.HashMap;
import java.util.Map;

import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.timeseries.TimeseriesIdentifier;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.timeseries.TimeseriesIdentifierCollection;

public class PropertiesAll {

	//private TimeseriesIdentifier timeseries = new TimeseriesIdentifier();
	private Map<String, TimeseriesIdentifierCollection> timeseries = new HashMap<>();
	private String id = "2";
	private String label = "InterSensorService_Virtual_Sensor";
	
	public PropertiesAll() {
		
	}

	public PropertiesAll(Map<String, TimeseriesIdentifierCollection> timeseries, String id, String label) {
		super();
		this.timeseries = timeseries;
		this.id = id;
		this.label = label;
	}

	public Map<String, TimeseriesIdentifierCollection> getTimeseries() {
		return timeseries;
	}

	public void setTimeseries(Map<String, TimeseriesIdentifierCollection> timeseries) {
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
	
	/*public PropertiesAll(TimeseriesIdentifier timeseries, String id, String label) {
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
	}*/
	
	
	
	
}
