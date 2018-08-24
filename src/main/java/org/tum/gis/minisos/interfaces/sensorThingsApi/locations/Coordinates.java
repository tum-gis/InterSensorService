package org.tum.gis.minisos.interfaces.sensorThingsApi.locations;

import java.util.ArrayList;
import java.util.List;

public class Coordinates {

	private List<Double> coordinates = new ArrayList<>();

	public Coordinates() {
		
	}
	
	public Coordinates(List<Double> coordinates) {
		super();
		this.coordinates = coordinates;
	}

	public List<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}
	
	
}
