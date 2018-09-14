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

package org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.interSensorService.dataSource.DataSourceService;
import org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.keywords.Keyword;
import org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.outputs.Output;
import org.tum.gis.interSensorService.interfaces.sensorObservationService.DescribeSensor.data.outputs.Outputs;
import org.tum.gis.interSensorService.observation.ObservationService;
import org.tum.gis.interSensorService.timeseries.TimeseriesService;

@Service
public class DescribeSensorService {

	@Autowired
	private ObservationService observationService;
	
	@Autowired
	private DataSourceService dataSourceService;
	
	@Autowired
	private TimeseriesService timeseriesService;
	
	public DescribeSensorResponse getDescribeSensorResponse() {
		DescribeSensorResponse describeSensorResponse = new DescribeSensorResponse();
		
		
		List<Output> outputList = new ArrayList<>();
		
		Output output = new Output();
		
		output.setName(timeseriesService.timeseriesList.get(0).getObservationProperty());
		output.getQuantity().setDefinition(timeseriesService.timeseriesList.get(0).getObservationProperty());
		output.getQuantity().getUom().setCode(timeseriesService.timeseriesList.get(0).getUnitOfMeasure());
		outputList.add(output);
		
		List<Keyword> keywordList =  new ArrayList<>();
		Keyword keyword1 = new Keyword();
		Keyword keyword2 = new Keyword();
		Keyword keyword3 = new Keyword();
		Keyword keyword4 = new Keyword();
		Keyword keyword5 = new Keyword();
	
		
		keyword2.setKeyword(timeseriesService.timeseriesList.get(0).getObservationProperty());
		keywordList.add(keyword2);
		
		
		keyword4.setKeyword(dataSourceService.getDataSource(1).getDataSourceConnection().getName());
		keywordList.add(keyword4);
		
		keyword5.setKeyword(dataSourceService.getDataSource(1).getDataSourceConnection().getConnectionType());
		keywordList.add(keyword5);
		
		describeSensorResponse.getDescription().getSensorDescription().getData().getSensorML().getMember().getSystem().getOutputs().setOutputList(outputList);
		describeSensorResponse.getDescription().getSensorDescription().getData().getSensorML().getMember().getSystem().getKeywords().setKeywordList(keywordList);
		return describeSensorResponse;
	}
}
