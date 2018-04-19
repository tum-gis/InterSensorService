package org.tum.gis.minisos.dataSource.sensorThings;

import org.springframework.web.client.RestTemplate;
import org.tum.gis.minisos.dataSource.sensorThings.locations.Locations;
import org.tum.gis.minisos.dataSource.sensorThings.observations.Observations;




public class TestJsonObjects {

	public static void main(String[] args) {
		
		String a = "https://example.sensorup.com/v1.0";
		String b = "/Datastreams(";
		int c = 8774758;
		String d = ")/Observations?$top=2";
		
		String e = "-99";
		//String serviceUrl = "https://example.sensorup.com/v1.0/Datastreams(8774758)/Observations?$top=2";
		String serviceUrl = a+b+c+d;
		RestTemplate restTemplate = new RestTemplate();
		Observations observations = restTemplate.getForObject(serviceUrl, Observations.class); 
		
		//System.out.println(observations.getValue().get(0).getPhenomenonTime());
		int i = (12567/2000)+1;
		System.out.println(i);

	}

}
