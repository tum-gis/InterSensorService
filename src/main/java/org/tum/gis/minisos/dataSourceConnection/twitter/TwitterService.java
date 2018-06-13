package org.tum.gis.minisos.dataSourceConnection.twitter;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.support.URIBuilder;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;
import org.tum.gis.minisos.dataSource.DataSource;
import org.tum.gis.minisos.dataSource.DataSourceService;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.SeriesRestApiService;
import org.tum.gis.minisos.observation.Observation;
import org.tum.gis.minisos.observation.ObservationService;
import org.tum.gis.minisos.timeseries.TimeseriesService;
import org.tum.gis.minisos.util.IdSequenceManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class TwitterService {

	@Autowired
	private DataSourceService dataSourceService;
	
	@Autowired
	private TimeseriesService timeseriesService;
	
	@Autowired
	private ObservationService observationService;
	
	@Autowired
	private SeriesRestApiService seriesRestApiService;
	
	public void addDataSource(TwitterConnection twitterConnection) {
		int dataSourceId = IdSequenceManager.DataSourceSequence();
		int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
		
		DataSource dataSource = new DataSource(dataSourceId,twitterConnection);
		dataSourceService.addDataSource(dataSource);
		
		timeseriesService.addTimeseries(timeseriesId,dataSourceId,twitterConnection);
		validateTwitterConnection(timeseriesId,twitterConnection);
		//seruesRestAPI is not supported currently
	}
	
	public void validateTwitterConnection(int timeseriesId, TwitterConnection twitterConnection) {
		//do nothing
	}
	
	public List<Observation> parseTwitter (int timeseriesId, TwitterConnection twitterConnection) throws JsonProcessingException, IOException{
		
		List<Observation> observationList = new ArrayList<>();
		
		
		Twitter twitter = new TwitterTemplate( 	twitterConnection.getApiKey(),
												twitterConnection.getApiSecret(),
												twitterConnection.getAccessToken(),
												twitterConnection.getAccessTokenSecret());
		
		//Example Twitter search request
		//https://api.twitter.com/1.1/search/tweets.json?q=&geocode=51.543463,-0.016520,1km&include_entities=0&count=100"
		String baseUrl = twitterConnection.getBaseUrl();
		String searchString = twitterConnection.getSearchString();
		if(searchString == null) {
			searchString = "";
		}
		
		String queryParam = "?"+
							"q="+searchString+
							"&geocode="+twitterConnection.getLatitude()+","+twitterConnection.getLongitude()+","+twitterConnection.getRadius()+"km"+
							"&include_entities=0"+
							"&count=100";
		String tweetUrl = baseUrl + queryParam;
		URI tweetUri = URIBuilder.fromUri(tweetUrl).build();
		String tweetResponse = twitter.restOperations().getForObject(tweetUri, String.class);
		
		
		//Converting tweet text response to JSON response for better querying
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonTextResponse = mapper.readTree(tweetResponse);
		JsonNode JsonTweetResponse = jsonTextResponse.get("statuses");
		
		
		//new Json array to capture result tweets
		ArrayNode resultTweetsList = mapper.createArrayNode();
		
		
		
		for (int i=0;i<JsonTweetResponse.size();i++) {
			//for all the captured tweets, check if the geo-tagged cooridanates are available for the tweet or not
			if (!JsonTweetResponse.get(i).get("geo").isNull()) {
				ObjectNode resultTweet = mapper.createObjectNode();
				
				//Capture all relevant information from a tweet in a json object
				resultTweet.put("tweet_id", JsonTweetResponse.get(i).get("id").asText());
				resultTweet.put("created_at", JsonTweetResponse.get(i).get("created_at").asText());
				resultTweet.put("text", JsonTweetResponse.get(i).get("text").asText());
				resultTweet.put("location", JsonTweetResponse.get(i).get("place").get("full_name"));
				resultTweet.put("coordinates", JsonTweetResponse.get(i).get("geo").get("coordinates"));
				resultTweet.put("tweetUrl", "https://twitter.com/anyuser/status/"+JsonTweetResponse.get(i).get("id"));
				
				TwitterObservation twitterObservation  = new TwitterObservation();
				twitterObservation.setTime(JsonTweetResponse.get(i).get("created_at").asText());
				twitterObservation.setStrValue(resultTweet.toString());
				observationList.add(twitterObservation);
				//resultTweetsList.add(resultTweet);
				
				//Twitter API responds with maximum 100 tweets in one request
				//In order to capture all available Tweets, the API supports pagination using "next_result" parameter
				
				//Check whether the response contains "next_result" parameter and iterate until the last page is retrieved		
			}
		}
		
		while(jsonTextResponse.get("search_metadata").has("next_results")) {
			queryParam = jsonTextResponse.get("search_metadata").get("next_results").asText();
			tweetUrl = baseUrl + queryParam;
			
			tweetUri = URIBuilder.fromUri(tweetUrl).build();
			tweetResponse = twitter.restOperations().getForObject(tweetUri, String.class);
			
			jsonTextResponse = mapper.readTree(tweetResponse);
			JsonTweetResponse = jsonTextResponse.get("statuses");
			
			resultTweetsList = mapper.createArrayNode();
			
			for (int i=0;i<JsonTweetResponse.size();i++) {
				//for all the captured tweets, check if the geo-tagged cooridanates are available for the tweet or not
				if (!JsonTweetResponse.get(i).get("geo").isNull()) {
					ObjectNode resultTweet = mapper.createObjectNode();
					
					//Capture all relevant information from a tweet in a json object
					resultTweet.put("tweet_id", JsonTweetResponse.get(i).get("id").asText());
					resultTweet.put("created_at", JsonTweetResponse.get(i).get("created_at").asText());
					resultTweet.put("text", JsonTweetResponse.get(i).get("text").asText());
					resultTweet.put("location", JsonTweetResponse.get(i).get("place").get("full_name"));
					resultTweet.put("coordinates", JsonTweetResponse.get(i).get("geo").get("coordinates"));
					resultTweet.put("tweetUrl", "https://twitter.com/anyuser/status/"+JsonTweetResponse.get(i).get("id"));
					
					TwitterObservation twitterObservation  = new TwitterObservation();
					twitterObservation.setTime(JsonTweetResponse.get(i).get("created_at").asText());
					twitterObservation.setStrValue(resultTweet.toString());
					observationList.add(twitterObservation);
					//resultTweetsList.add(resultTweet);
			
				}
			}
		}
		
		
		return observationList;	
	}
}
