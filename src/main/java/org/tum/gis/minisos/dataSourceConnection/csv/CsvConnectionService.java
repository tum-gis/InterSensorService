package org.tum.gis.minisos.dataSourceConnection.csv;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.tum.gis.minisos.dataSource.DataSource;
import org.tum.gis.minisos.dataSource.DataSourceService;

@Service
public class CsvConnectionService {

	private DataSourceService dataSourceService;
	
	public void addDataSource(CsvConnection csvConnection) {
		System.out.println("Step2:"+csvConnection.getId());
		DataSource data3 = new DataSource(3,csvConnection);
		System.out.println("Step3:"+data3.getId());
		dataSourceService.addDataSource(data3);
		
	}

}
