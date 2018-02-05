package org.tum.gis.minisos.dataSourceConnection.csv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.minisos.dataSource.DataSource;
import org.tum.gis.minisos.dataSource.DataSourceService;
import org.tum.gis.minisos.observation.ObservationService;
import org.tum.gis.minisos.timeseries.TimeseriesService;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

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
	
	public void parseCsv(CsvConnection csvConnection) throws IOException{
		try(
				//test comment again
				Reader reader = Files.newBufferedReader(Paths.get(csvConnection.getFileLocation()));
				//Reader reader = Files.newBufferedReader(Paths.get(csvConnection));
				){
			CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CsvObservation.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(1)
                    .build();
			
			List<CsvObservation> csvObservations = csvToBean.parse();
			
			for (CsvObservation csvObservation : csvObservations) {
				observationService.observationList.add(csvObservation);
			}
			
			
			
		}
	
	}
	

}
