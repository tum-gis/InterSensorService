package org.tum.gis.minisos.dataSourceConnection.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.minisos.dataSource.DataSource;
import org.tum.gis.minisos.dataSource.DataSourceService;
import org.tum.gis.minisos.observation.ObservationService;
import org.tum.gis.minisos.timeseries.TimeseriesService;

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
		
		DataSource dataSource = new DataSource(3,csvConnection);
		
		dataSourceService.addDataSource(dataSource);
		
		timeseriesService.addTimeseries(csvConnection);
		
		parseCsv(csvConnection);
		//should parse csv and create an ordered list of observation ( time,value for one timeseries id)
		// /timeseries/id/observation should refer to this list (queried by timeseries id and later, dates)
	}
	
	//parseCSV function
	
	//read csv location details, parse csv, create a list of observation 
	
	
	public void parseCsv(CsvConnection csvConnection) throws IOException {
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
	        		csvHeaderList = csvHeader.split(",");	      		
	        	
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
		                     .withSeparator(',')
		                     .build();
		             
		        	 csvToBean.setMappingStrategy(strategy);		             
		            
		            
		             List<CsvObservation> csvObservations = csvToBean.parse();
		             
		             for (CsvObservation csvObservation : csvObservations) {
		 				observationService.observationList.add(csvObservation);
		 			}
		             
	        	}
	        	
				
	        	
			
			}
		
	}
	
	
	
	
}
