package org.tum.gis.minisos.interfaces.Rest52n.timeseries;

public class FlotSeries {

	FlotData t1 = new FlotData();

	public FlotSeries() {
		
	}
	
	public FlotSeries(FlotData t1) {
		super();
		this.t1 = t1;
	}

	public FlotData getT1() {
		return t1;
	}

	public void setT1(FlotData t1) {
		this.t1 = t1;
	}
	
	
	
}
