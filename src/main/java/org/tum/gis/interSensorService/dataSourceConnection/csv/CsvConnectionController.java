package org.tum.gis.interSensorService.dataSourceConnection.csv;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsvConnectionController {

	@Autowired
	private CsvConnectionService csvConnectionService;
	
	@RequestMapping(method=RequestMethod.POST, value="/csv")
	public void addDataSource(@RequestBody CsvConnection csvConnection) throws IOException, ParseException {		
		csvConnectionService.addDataSource(csvConnection);
	}
}
