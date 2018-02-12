/**
 * 
 */
package org.tum.gis.minisos.dataSourceConnection.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.minisos.dataSource.DataSource;
import org.tum.gis.minisos.dataSource.DataSourceService;
import org.tum.gis.minisos.observation.Observation;
import org.tum.gis.minisos.observation.ObservationListManager;
import org.tum.gis.minisos.observation.ObservationService;
import org.tum.gis.minisos.timeseries.TimeseriesService;
import org.tum.gis.minisos.util.IdSequenceManager;

/**
 * @author kchaturvedi
 *
 */
@Service
public class JdbcService {

	@Autowired
	private JdbcRepository jdbcRepository;
	
	@Autowired
	private DataSourceService dataSourceService;
	
	@Autowired
	private TimeseriesService timeseriesService;
	
	@Autowired
	private ObservationService observationService;
	
	public void addDataSource(JdbcConnection jdbcConnection) {
		
		int flag = 0;
		int dataSourceId = 1;
		
		for (int i=0; i<dataSourceService.datasources.size(); i++) {
			if(jdbcConnection.getName().equals(dataSourceService.datasources.get(i).getDataSourceConnection().getName())) {
				flag = 1;
				dataSourceId = dataSourceService.datasources.get(i).getId();
				break;
			}
		}
		
		if (flag==1) {
			int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
			timeseriesService.addTimeseries(timeseriesId,dataSourceId,jdbcConnection);
			parseJdbc(timeseriesId,jdbcConnection);
		}
		else {
			dataSourceId = IdSequenceManager.DataSourceSequence();
			DataSource dataSource = new DataSource(dataSourceId,jdbcConnection);
			dataSourceService.addDataSource(dataSource);
			
			int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
			timeseriesService.addTimeseries(timeseriesId,dataSourceId,jdbcConnection);
			parseJdbc(timeseriesId,jdbcConnection);
		}
	}
	
	public void parseJdbc(int timeseriesId, JdbcConnection jdbcConnection) {
		List<JdbcObservation> jdbcObservationList = new ArrayList<>();
		List<Observation> observationList2 = new ArrayList<>();
		
		jdbcRepository.findAll()
		.forEach(jdbcObservationList::add);
		
		for (JdbcObservation jdbcObservation : jdbcObservationList) {
			observationList2.add(jdbcObservation);
		}
		
		 ObservationListManager observationListManager = new ObservationListManager(timeseriesId,observationList2);
         observationService.observationList.add(observationListManager);
	}
	
	
	public List<JdbcObservation> getAllObservation(){
		List<JdbcObservation> obs = new ArrayList<>();
		jdbcRepository.findAll()
		.forEach(obs::add);
		return obs;
	}
}
