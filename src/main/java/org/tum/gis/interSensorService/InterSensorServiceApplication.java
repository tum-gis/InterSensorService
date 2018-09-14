/*
 * InterSensor Service
 * http://www.intersensorservice.org/
 * 
 * Copyright 2018
 * Chair of Geoinformatics
 * Technical University of Munich, Germany
 * https://www.gis.bgu.tum.de/
 * 
 * The InterSensor Service has been developed by
 * Kanishk Chaturvedi and Thomas H. Kolbe
 * 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

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
