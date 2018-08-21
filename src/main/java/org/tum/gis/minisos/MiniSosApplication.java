package org.tum.gis.minisos;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tum.gis.minisos.initializer.Initializer;

@SpringBootApplication
public class MiniSosApplication {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		SpringApplication.run(MiniSosApplication.class, args);
		Initializer.httpPost();
		System.out.println("Starting my application");
	}
}
