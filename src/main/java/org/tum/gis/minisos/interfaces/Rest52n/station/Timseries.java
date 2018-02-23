package org.tum.gis.minisos.interfaces.Rest52n.station;

import java.util.HashMap;

public class Timseries {
	
	private static HashMap<String, TimeseriesCollection> t = new HashMap<>();
	
	static {
		t.put("1", new TimeseriesCollection());
	}
	//private TimeseriesCollection timeseriesCollection = new TimeseriesCollection();

	public Timseries() {
		
	}
	
	


	public Timseries(HashMap<String, TimeseriesCollection> t) {
		super();
		this.t = t;
	}




	/*public HashMap<String, TimeseriesCollection> getMapper() {
		return mapper;
	}*/
	
	public  TimeseriesCollection getT1() {
		return t.get("1");
	}


	/*public void setMapper(HashMap<String, TimeseriesCollection> t) {
		this.t = t;
	}*/
	
	/*public Timseries(TimeseriesCollection timeseriesCollection) {
		super();
		//this.timeseriesCollection = timeseriesCollection;
	}*/

	
	/*public TimeseriesCollection getTimeseriesCollection() {
		mapper.put("1", new TimeseriesCollection());		
		return mapper.get("1");
	}*/

	//public void setTimeseriesCollection(TimeseriesCollection timeseriesCollection) {
		//this.timeseriesCollection = timeseriesCollection;
	//}
	
	
}
