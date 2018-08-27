package org.tum.gis.interSensorService;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tum.gis.interSensorService.initializer.Initializer;

@SpringBootApplication
public class InterSensorServiceApplication {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		SpringApplication.run(InterSensorServiceApplication.class, args);
		Initializer.httpPost();
		System.out.println("Starting my application");
	}
}
