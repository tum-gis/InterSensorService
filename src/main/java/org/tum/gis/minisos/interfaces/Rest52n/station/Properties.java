/**
 * 
 */
package org.tum.gis.minisos.interfaces.Rest52n.station;

/**
 * @author kchaturvedi
 *
 */
public class Properties {

	private Timseries timeseries = new Timseries();
	private String id = "2";
	private String label = "Konigsplatz_Augsburg";
	
	public Properties() {
		
	}
	
	public Properties(String id, String label) {
		super();
		this.timeseries = timeseries;
		this.id = id;
		this.label = label;
	}
	
	
	
	public Timseries getTimeseries() {
		return timeseries;
	}

	public void setTimeseries(Timseries timeseries) {
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
