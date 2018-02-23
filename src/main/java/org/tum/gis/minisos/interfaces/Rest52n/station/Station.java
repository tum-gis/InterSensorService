/**
 * 
 */
package org.tum.gis.minisos.interfaces.Rest52n.station;

/**
 * @author kchaturvedi
 *
 */
public class Station {

	private String type = "Feature";
	private String id = "2";
	private Properties properties = new Properties();
	private Geometry geometry = new Geometry();
	
	
	public Station() {
		
	}
	
	public Station(String type, String id, Properties properties, Geometry geometry) {
		super();
		this.type = type;
		this.id = id;
		this.properties = properties;
		this.geometry = geometry;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Properties getProperties() {
		return properties;
	}


	public void setProperties(Properties properties) {
		this.properties = properties;
	}


	public Geometry getGeometry() {
		return geometry;
	}


	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	
	
	
}
