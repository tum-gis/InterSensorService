package org.tum.gis.minisos.dataSourceConnection;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsvObjectController {

	@Autowired
	private CSVReadAndParseToBean csvReadAndParseToBean;
	
	@RequestMapping("/csv")
	public List<CSVObject> getCsvObjects() throws IOException{
		return csvReadAndParseToBean.getObservation();
	}
}
