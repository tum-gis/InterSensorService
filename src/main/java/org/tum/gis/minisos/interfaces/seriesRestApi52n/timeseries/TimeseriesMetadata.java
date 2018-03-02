package org.tum.gis.minisos.interfaces.seriesRestApi52n.timeseries;

import org.tum.gis.minisos.interfaces.seriesRestApi52n.stations.Stations;

public class TimeseriesMetadata {

	private String id = "1";
	private String label = "temperature, MiniSOS" ;
	private FirstValue firstValue = new FirstValue();
	private LastValue lastValue = new LastValue();
	private String uom = "unit";
	private Stations station = new Stations();
	
	public TimeseriesMetadata() {
		
	}
	
	public TimeseriesMetadata(String id, String label, FirstValue firstValue, LastValue lastValue, String uom,
			Stations station) {
		super();
		this.id = id;
		this.label = label;
		this.firstValue = firstValue;
		this.lastValue = lastValue;
		this.uom = uom;
		this.station = station;
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
	public FirstValue getFirstValue() {
		return firstValue;
	}
	public void setFirstValue(FirstValue firstValue) {
		this.firstValue = firstValue;
	}
	public LastValue getLastValue() {
		return lastValue;
	}
	public void setLastValue(LastValue lastValue) {
		this.lastValue = lastValue;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public Stations getStation() {
		return station;
	}
	public void setStation(Stations station) {
		this.station = station;
	}
	
	
}
