package org.tum.gis.minisos.dataSourceConnection.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.minisos.dataSource.DataSource;
import org.tum.gis.minisos.dataSource.DataSourceService;
import org.tum.gis.minisos.observation.Observation;
import org.tum.gis.minisos.observation.ObservationListManager;
import org.tum.gis.minisos.observation.ObservationService;
import org.tum.gis.minisos.timeseries.TimeseriesService;
import org.tum.gis.minisos.util.DateTimeComparison;
import org.tum.gis.minisos.util.IdSequenceManager;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

@Service
public class CsvConnectionService {

	@Autowired
	private DataSourceService dataSourceService;
	
	@Autowired
	private TimeseriesService timeseriesService;
	
	@Autowired
	private ObservationService observationService;
	
	public void addDataSource(CsvConnection csvConnection) throws IOException {	
		
		//Add a new dataSourceConnection
		//if datasource with name is not available, add a new data source with unique id; else don't insert
		
		//check if dataSourceService.datasources contains the object with same name or not
		
		// if not, then generate a new sequence and insert a datasource
		
		int flag = 0;
		int dataSourceId = 1;
		for (int i=0; i<dataSourceService.datasources.size(); i++) {			
			if(csvConnection.getName().equals(dataSourceService.datasources.get(i).getDataSourceConnection().getName()))  {
				flag = 1;
				dataSourceId = dataSourceService.datasources.get(i).getId();
				break;
			}			
		}
		
		if (flag==1) {
			//get dataSourceID and create timeseries
			int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
			timeseriesService.addTimeseries(timeseriesId,dataSourceId,csvConnection);
			parseCsv(timeseriesId, csvConnection);
			
		}else {
			//create datasource with new id and then create timeseries
			dataSourceId = IdSequenceManager.DataSourceSequence();
			DataSource dataSource = new DataSource(dataSourceId,csvConnection);
			dataSourceService.addDataSource(dataSource);
			
			int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
			timeseriesService.addTimeseries(timeseriesId,dataSourceId,csvConnection);
			parseCsv(timeseriesId, csvConnection);
		}
		//DataSource dataSource = new DataSource(3,csvConnection);
		
		
		
		//dataSourceService.addDataSource(dataSource);
		
		//insert a new timeseries with unique id
		//timeseriesService.addTimeseries(csvConnection);
		
		//parseCsv(csvConnection);
		//should parse csv and create an ordered list of observation ( time,value for one timeseries id)
		// /timeseries/id/observation should refer to this list (queried by timeseries id and later, dates)
	}
	
	//parseCSV function
	
	//read csv location details, parse csv, create a list of observation 
	
	
	public void parseCsv(int timeseriesId, CsvConnection csvConnection) throws IOException {
		int timeColumn = csvConnection.getTimeColumn();
		int valueColumn = csvConnection.getValueColumn();
		String fileLocation = csvConnection.getFileLocation();
		
		
		try(
				BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));  
				Reader reader = Files.newBufferedReader(Paths.get(fileLocation));
				
			){
			
				//Store Header values in an array. It is used for fetching appropriate header columns
				String[] csvHeaderList;
				String csvHeader = bufferedReader.readLine();
	        	if (csvHeader != null) {
	        		csvHeaderList = csvHeader.split(csvConnection.getSeparator());	      		
	        	
	        		Map<String, String> mapping = new HashMap<String, String>();
	        		
	        		mapping.put(csvHeaderList[timeColumn], "time");
		        	mapping.put(csvHeaderList[valueColumn], "value");
		        	
		        	HeaderColumnNameTranslateMappingStrategy<CsvObservation> strategy = new HeaderColumnNameTranslateMappingStrategy<CsvObservation>();
		        	strategy.setType(CsvObservation.class);
		        	strategy.setColumnMapping(mapping);
		        	
		        	 CsvToBean csvToBean = new CsvToBeanBuilder(reader)
		             		 .withType(CsvObservation.class)
		                     .withMappingStrategy(strategy)		                     
		                     .withIgnoreLeadingWhiteSpace(true)
		                     .withSeparator(csvConnection.getSeparator().charAt(0))
		                     .build();
		             
		        	 csvToBean.setMappingStrategy(strategy);		             
		            
		            
		        	 
		             List<CsvObservation> csvObservations = csvToBean.parse();
		             
		             List<Observation> observationList1 = new ArrayList<>();
		             
		             //ObservationListManager observationListManager = new ObservationListManager(timeseriesId,csvObservations);
		             
		             //observationService.observationList.add(timeseriesId,csvObservations);
		             
		             //observationService.observationListManager.add(timeseriesId,csvObservations)
		             for (CsvObservation csvObservation : csvObservations) {
		            	 //apply sorting here
		 				observationList1.add(csvObservation);
		 				
		 				//Collections.sort(observationList1, new DateTimeComparison());
		 			}
		             
		             ObservationListManager observationListManager = new ObservationListManager(timeseriesId,observationList1);
		             observationService.observationList.add(observationListManager);
	        	}
	        	
				
	        	
			
			}
		
	}
	
	
	
	
}
