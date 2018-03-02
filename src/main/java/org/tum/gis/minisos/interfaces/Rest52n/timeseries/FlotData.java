package org.tum.gis.minisos.interfaces.Rest52n.timeseries;

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
		List<Number> value1 = new ArrayList<>(); 
		List<Number> value2 = new ArrayList<>(); 
		List<Number> value3 = new ArrayList<>(); 
		
		value1.add(1509490824000L);
		value1.add(23.3);
		
		value2.add(1509490855000L);
		value2.add(24.3);
		
		value3.add(1509490887000L);
		value3.add(25.3);
		 
		 values.add(value1.toArray(new Number[0]));
		 values.add(value2.toArray(new Number[1]));
		 values.add(value3.toArray(new Number[2]));
		 
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
