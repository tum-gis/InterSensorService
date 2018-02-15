package org.tum.gis.minisos.dataSource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataSourceController {

	@Autowired
	private DataSourceService dataSourceService;
	
	@RequestMapping(value = "/datasources", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<DataSource> getAllDataSources(){
		return dataSourceService.getAllDataSources();
	}
	
	@RequestMapping(value = "/datasources/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public DataSource getDataSource(@PathVariable int id) {
		return dataSourceService.getDataSource(id);
	}
	
	
	/*@RequestMapping(method=RequestMethod.POST, value="/datasources")
	public void addDataSource(@RequestBody DataSource dataSource) {
		dataSourceService.addDataSource(dataSource);
	}*/
}
