/**
 * 
 */
package org.tum.gis.minisos.dataSourceConnection.thingspeak;

/**
 * @author kchaturvedi
 *
 */
public class Feed {

	private String created_at;
	private double field1;
	
	public Feed() {
		
	}
	
	public Feed(String created_at, double field1) {
		super();
		this.created_at = created_at;
		this.field1 = field1;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public double getField1() {
		return field1;
	}
	public void setField1(double field1) {
		this.field1 = field1;
	}
	
	
	
	
}
