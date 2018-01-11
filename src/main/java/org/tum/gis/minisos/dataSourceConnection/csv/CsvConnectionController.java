package org.tum.gis.minisos.dataSourceConnection.csv;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsvConnectionController {

	private CsvConnectionService csvConnectionService;
	
	@RequestMapping(method=RequestMethod.POST, value="/datasources")
	public void addDataSource(@RequestBody CsvConnection csvConnection) {
		System.out.println(csvConnection.getId());
		csvConnectionService.addDataSource(csvConnection);
	}
}
