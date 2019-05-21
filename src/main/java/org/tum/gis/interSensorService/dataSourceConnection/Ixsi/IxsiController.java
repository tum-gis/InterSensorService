package org.tum.gis.interSensorService.dataSourceConnection.Ixsi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IxsiController {

	@Autowired
	private IxsiService ixsiService;
	
	@CrossOrigin()
	@RequestMapping(method=RequestMethod.POST, value="/ixsi")
	public void addDataSource(@RequestBody IxsiConnection ixsiConnection) {
		ixsiService.addDataSource(ixsiConnection);
	}
}
