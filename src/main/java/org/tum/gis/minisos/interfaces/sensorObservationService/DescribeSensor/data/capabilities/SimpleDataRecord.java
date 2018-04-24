package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.data.capabilities;

public class SimpleDataRecord {

	private Field field = new Field();

	public SimpleDataRecord() {
		
	}
	
	public SimpleDataRecord(Field field) {
		super();
		this.field = field;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}
	
	
}
