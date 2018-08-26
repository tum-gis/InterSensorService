package org.tum.gis.minisos.interfaces.sensorThingsApi;

import java.util.Arrays;
import java.util.List;

public class TestSensorThingsInterface {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "ObservedProperty";
		String str1 = str.replace("%20", " ");
		String str2 = str1.replace("%27", "'");
		List<String> list = Arrays.asList(str.split(" "));
		str = str.substring(0, 1).toLowerCase()+str.substring(1);
		System.out.println(str);
	}

}
