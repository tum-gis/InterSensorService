package org.tum.gis.minisos.interfaces.Rest52n.timeseries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tum.gis.minisos.interfaces.Rest52n.station.TimeseriesCollection;
import org.tum.gis.minisos.interfaces.Rest52n.stations.Stations;

public class Timeseries {

	private String id = "t1";
	private String label = "temperature, MiniSOS";
	private List<String> extras =  new ArrayList<>(Arrays.asList("license","renderingHints","statusIntervals")) ;
	private List<String> referenceValues =  new ArrayList<>(Arrays.asList("")) ;
	private TimeValue firstValue = new TimeValue(1518786000000L,0.1);
	private TimeValue lastValue = new TimeValue(1518786000000L,0.1);
	private String uom = "unit";
	private Stations station = new Stations();
	private TimeseriesCollection parameters = new TimeseriesCollection();
	
	public Timeseries() {
		
	}
	
	public Timeseries(String id, String label, List<String> extras, List<String> referenceValues, TimeValue firstValue,
			TimeValue lastValue, String uom, Stations station, TimeseriesCollection parameters) {
		super();
		this.id = id;
		this.label = label;
		this.extras = extras;
		this.referenceValues = referenceValues;
		this.firstValue = firstValue;
		this.lastValue = lastValue;
		this.uom = uom;
		this.station = station;
		this.parameters = parameters;
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

	/*public List<String> getExtras() {
		return extras;
	}

	public void setExtras(List<String> extras) {
		this.extras = extras;
	}

	public List<String> getReferenceValues() {
		return referenceValues;
	}

	public void setReferenceValues(List<String> referenceValues) {
		this.referenceValues = referenceValues;
	}*/

	public TimeValue getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(TimeValue firstValue) {
		this.firstValue = firstValue;
	}

	public TimeValue getLastValue() {
		return lastValue;
	}

	public void setLastValue(TimeValue lastValue) {
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

	/*public TimeseriesCollection getParameters() {
		return parameters;
	}

	public void setParameters(TimeseriesCollection parameters) {
		this.parameters = parameters;
	}*/
	
	
	
}
