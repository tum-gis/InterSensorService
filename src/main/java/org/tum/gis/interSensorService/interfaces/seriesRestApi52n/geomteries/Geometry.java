package org.tum.gis.interSensorService.interfaces.seriesRestApi52n.geomteries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Geometry {

	private String type = "Point";
	private List<Double> coordinates = new ArrayList<>(Arrays.asList(11.893749,49.3649674));
	
	public Geometry() {
		
	}
	
	public Geometry(String type, List<Double> coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Double> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	} 
}
