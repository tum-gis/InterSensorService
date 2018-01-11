package org.tum.gis.minisos.dataSourceConnection.csv;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.minisos.dataSource.DataSource;
import org.tum.gis.minisos.dataSource.DataSourceService;

@Service
public class CsvConnectionService {

	@Autowired
	private DataSourceService dataSourceService;
	
	public void addDataSource(CsvConnection csvConnection) {	
		
		DataSource dataSource = new DataSource(3,csvConnection);
		
		dataSourceService.addDataSource(dataSource);
		
	}

}
