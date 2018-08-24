package org.tum.gis.minisos.interfaces.sensorThingsApi;

import java.util.Arrays;
import java.util.List;

public class TestSensorThingsInterface {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "A,B,C";
		
		List<String> list = Arrays.asList(str.split(","));
		
		System.out.println(list.get(1));
	}

}
