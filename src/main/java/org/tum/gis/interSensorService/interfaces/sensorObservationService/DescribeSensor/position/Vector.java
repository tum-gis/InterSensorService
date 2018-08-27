package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.position;

public class Vector {

	private Coordinate coordinatex = new Coordinate();
	private Coordinate coordinatey = new Coordinate();
	private Coordinate coordinatez = new Coordinate();

	public Vector() {
		
	}
	
	

	public Vector(Coordinate coordinatex, Coordinate coordinatey, Coordinate coordinatez) {
		super();
		this.coordinatex = coordinatex;
		this.coordinatey = coordinatey;
		this.coordinatez = coordinatez;
	}



	public Coordinate getCoordinatex() {
		coordinatex.setName("easting");
		coordinatex.getQuantity().setAxisID("x");
		coordinatex.getQuantity().getUom().setCode("degree");
		coordinatex.getQuantity().setValue(0.012025);
		return coordinatex;
	}

	public void setCoordinatex(Coordinate coordinatex) {
		this.coordinatex = coordinatex;
	}



	public Coordinate getCoordinatey() {
		coordinatey.setName("northing");
		coordinatey.getQuantity().setAxisID("y");
		coordinatey.getQuantity().getUom().setCode("degree");
		coordinatey.getQuantity().setValue(51.538395);
		return coordinatey;
	}



	public void setCoordinatey(Coordinate coordinatey) {
		this.coordinatey = coordinatey;
	}



	public Coordinate getCoordinatez() {
		coordinatez.setName("altitude");
		coordinatez.getQuantity().setAxisID("z");
		coordinatez.getQuantity().getUom().setCode("m");
		coordinatez.getQuantity().setValue(0.0);
		return coordinatez;
	}



	public void setCoordinatez(Coordinate coordinatez) {
		this.coordinatez = coordinatez;
	}
	
	
}
