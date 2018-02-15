/**
 * 
 */
package org.tum.gis.minisos.interfaces.SosOM;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author kchaturvedi
 *
 */
@XmlRootElement
public class ObservationData {

	private String phenomenonTime;
	private double value;
	
	public ObservationData() {
		
	}
	
	public ObservationData(String phenomenonTime, double value) {
		super();
		this.phenomenonTime = phenomenonTime;
		this.value = value;
	}

	public String getPhenomenonTime() {
		return phenomenonTime;
	}

	public void setPhenomenonTime(String phenomenonTime) {
		this.phenomenonTime = phenomenonTime;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
}
