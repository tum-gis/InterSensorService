package org.tum.gis.interSensorService.testForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.tum.gis.interSensorService.dataSourceConnection.thingspeak.ThingspeakConnection;
import org.tum.gis.interSensorService.dataSourceConnection.thingspeak.ThingspeakService;

@Controller
public class GreetingController {

	@Autowired
	private ThingspeakService thingspeakService;
	
	@GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new ThingspeakConnection());
        //return "greeting";
		return null;
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute ThingspeakConnection thingspeakConnection) {
    //	thingspeakService.addDataSource(thingspeakConnection);
    	return null;
    	//return "result";
    }
    
}
