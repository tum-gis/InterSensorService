package org.tum.gis.interSensorService.interfaces.seriesRestApi52n.timeseries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlotData {
	
	
	private List<Number[]> values = new ArrayList<>();
	
	 private Map<String, List<Number[]>> referenceValues;
	
	 public FlotData() {
	       // referenceValues = new HashMap<>();
	    }
	 
	 
	 
	 public FlotData(List<Number[]> values, Map<String, List<Number[]>> referenceValues) {
		super();
		this.values = values;
		this.referenceValues = referenceValues;
	}



	public List<Number[]> getValues() {				 
		 return values;
	}
	public void setValues(List<Number[]> values) {
		this.values = values;
	}
	public Map<String, List<Number[]>> getReferenceValues() {
		return referenceValues;
	}
	public void setReferenceValues(Map<String, List<Number[]>> referenceValues) {
		this.referenceValues = referenceValues;
	}
	 
	 
}
