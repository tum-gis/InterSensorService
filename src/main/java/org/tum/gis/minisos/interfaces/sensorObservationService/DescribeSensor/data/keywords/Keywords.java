package org.tum.gis.minisos.interfaces.sensorObservationService.DescribeSensor.data.keywords;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Keywords {


	
	private List<Keyword> KeywordList;

	public Keywords() {
		
	}
	
	public Keywords(List<Keyword> keywordList) {
		super();
		KeywordList = keywordList;
	}

	public List<Keyword> getKeywordList() {
		return KeywordList;
	}

	public void setKeywordList(List<Keyword> keywordList) {
		KeywordList = keywordList;
	}
	
	
}
