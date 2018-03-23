package org.tum.gis.minisos.interfaces.sensorObservationService.GetObservation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class OM_Observation {

	@JacksonXmlProperty (isAttribute = true)
	private String id = "o_abcd";
	
	private Type type = new Type();	
	private PhenomenonTime phenomenonTime = new PhenomenonTime();
	private ResultTime resultTime = new ResultTime();
	private Procedure procedure = new Procedure();
	private ObservedProperty observedProperty = new ObservedProperty();
	private FeatureOfInterest featureOfInterest = new FeatureOfInterest();
	@JacksonXmlText
	private Result result = new Result();
	
	public OM_Observation() {
		
	}

	public OM_Observation(String id, Type type, PhenomenonTime phenomenonTime, ResultTime resultTime,
			Procedure procedure, ObservedProperty observedProperty, FeatureOfInterest featureOfInterest,
			Result result) {
		super();
		this.id = id;
		this.type = type;
		this.phenomenonTime = phenomenonTime;
		this.resultTime = resultTime;
		this.procedure = procedure;
		this.observedProperty = observedProperty;
		this.featureOfInterest = featureOfInterest;
		this.result = result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public PhenomenonTime getPhenomenonTime() {
		return phenomenonTime;
	}

	public void setPhenomenonTime(PhenomenonTime phenomenonTime) {
		this.phenomenonTime = phenomenonTime;
	}

	public ResultTime getResultTime() {
		return resultTime;
	}

	public void setResultTime(ResultTime resultTime) {
		this.resultTime = resultTime;
	}

	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	public ObservedProperty getObservedProperty() {
		return observedProperty;
	}

	public void setObservedProperty(ObservedProperty observedProperty) {
		this.observedProperty = observedProperty;
	}

	public FeatureOfInterest getFeatureOfInterest() {
		return featureOfInterest;
	}

	public void setFeatureOfInterest(FeatureOfInterest featureOfInterest) {
		this.featureOfInterest = featureOfInterest;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
	
	
}
