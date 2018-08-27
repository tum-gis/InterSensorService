package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.outputs;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Outputs {

	@JacksonXmlElementWrapper(useWrapping=false)
	@JacksonXmlProperty (localName = "Output")
	private List<Output> outputList =  new ArrayList<>();

	public Outputs() {
		
	}
	public Outputs(List<Output> outputList) {
		super();
		this.outputList = outputList;
	}

	public List<Output> getOutputList() {
		return outputList;
	}

	public void setOutputList(List<Output> outputList) {
		this.outputList = outputList;
	}
	
	
}
