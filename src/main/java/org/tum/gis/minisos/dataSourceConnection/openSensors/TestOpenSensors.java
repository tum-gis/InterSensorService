package org.tum.gis.minisos.dataSourceConnection.openSensors;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.tum.gis.minisos.dataSourceConnection.openSensors.observations.Observations;
import org.tum.gis.minisos.dataSourceConnection.openSensors.topics.Topics;


public class TestOpenSensors {

	public static void main(String[] args) throws URISyntaxException {
		// TODO Auto-generated method stub

		String baseUrl = "https://api.opensensors.io/v1";
		String topicName = "/orgs/icri/qeop/nsc/BAT1";
		String start = "2017-01-24T23:00:00";
		String end = "2018-04-19T00:00:00";
		String authKey = "5bc93dcc-6bf6-4cae-9ea3-a325587d6443";
		
		
		String start1;
		start1 = start.replaceAll("\\+","%2B");
		//start.replaceAll(regex, replacement)
		String end1;
		end1 = end.replaceAll("\\+","%2B");
		
	
		
		String serviceUrl = baseUrl+"/messages/topic/"+topicName+"?api-key="+authKey+"&start-date="+start1+"&end-date="+end1;
		System.out.println(serviceUrl);
		URI uri = new URI(serviceUrl);
		System.out.println(uri);
		RestTemplate restTemplate = new RestTemplate();
		Observations observations = restTemplate.getForObject(uri, Observations.class);
		//Topics topics = restTemplate.getForObject(uri, Topics.class); 
		
		System.out.println(observations.getMessages().get(0).getDate());
		System.out.println(observations.getMessages().get(0).getValue());
	}
	

}
