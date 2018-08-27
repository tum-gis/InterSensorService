package org.tum.gis.interSensorService;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tum.gis.interSensorService.initializer.Initializer;
import org.tum.gis.interSensorService.util.SpringHost;

@SpringBootApplication
public class InterSensorServiceApplication {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		SpringApplication.run(InterSensorServiceApplication.class, args);
		Initializer.httpPost();
		String rootUrl = "http://"+SpringHost.getHostAddress()+":"+SpringHost.getPort()+"/inter-sensor-service/";
		System.out.println("Congratulations!! The InterSensor Service has successfully been inititated for your data source.");
		System.out.println("Please start using the service using the link: "+ rootUrl);
	}
}
