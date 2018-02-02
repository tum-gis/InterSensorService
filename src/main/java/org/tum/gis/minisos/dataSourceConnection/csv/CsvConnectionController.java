package org.tum.gis.minisos.dataSourceConnection.csv;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsvConnectionController {

	@Autowired
	private CsvConnectionService csvConnectionService;
	
	@RequestMapping(method=RequestMethod.POST, value="/datasources")
	public void addDataSource(@RequestBody CsvConnection csvConnection) throws IOException {		
		csvConnectionService.addDataSource(csvConnection);
	}
}
