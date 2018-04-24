package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.minisos.dataSource.DataSourceService;
import org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.data.keywords.Keyword;
import org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.data.outputs.Output;
import org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.data.outputs.Outputs;
import org.tum.gis.minisos.observation.ObservationService;
import org.tum.gis.minisos.timeseries.TimeseriesService;

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
