/**
 * 
 */
package org.tum.gis.minisos.interfaces.seriesRestApi52n;

import java.util.List;

/**
 * @author kchaturvedi
 *
 */
public class ListObservation52n {

	private List<Observation52n> values;

	public ListObservation52n() {
		
	}
	
	public ListObservation52n(List<Observation52n> values) {
		super();
		this.values = values;
	}

	public List<Observation52n> getValues() {
		return values;
	}

	public void setValues(List<Observation52n> values) {
		this.values = values;
	}
	
	
}
