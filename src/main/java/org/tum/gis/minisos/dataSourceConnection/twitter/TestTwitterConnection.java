package org.tum.gis.minisos.dataSourceConnection.twitter;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


import org.springframework.social.support.URIBuilder;
import org.springframework.social.twitter.api.GeoCode;
import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.SearchParameters.ResultType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
public class TestTwitterConnection {

	public static void main(String[] args) throws JsonProcessingException, IOException {
		// TODO Auto-generated method stub

		//Twitter Authorization Details
		Twitter twitter = new TwitterTemplate("GnYN7GGuOtRXJHe3DfkLpte6F",
				"o3wO1UNUySGld9lXoQMvFWpAKPd8VAkTHu2bEV1b4QkLyjLGXq",
				"38715440-q3dLLeHRS2OqQRl0gwijUvlsBipIdxrcUHnK1SK8o",
				"q191jEc1ibF8psoh4QbAIflK8sTarJDVGD6s5iTyXfNTT");
		
		System.out.println(twitter);

		//Setting Parameters for required location
		GeoCode geoCode = new GeoCode(48.16,11.57,2);
		SearchParameters parameters = new SearchParameters(null);
		parameters.geoCode(geoCode);
		
		
		parameters.count(100);
		parameters.resultType(ResultType.RECENT);
		
		
		int searchResultCount; 
		long lowestTweetId = Long.MAX_VALUE;
		
		
		String baseUrl = "https://api.twitter.com/1.1/search/tweets.json";
		String queryParam = "?q=&geocode=48.14336,11.57552,1km&include_entities=0&count=100";
		//String tweetUrl = baseUrl + queryParam;
		
		String tweetUrl = "https://api.twitter.com/1.1/statuses/show/1007250912006557696.json";
		
		//String tweetUrl = "https://api.twitter.com/1.1/search/tweets.json?q=&geocode=51.54347,-0.01652,1km&include_entities=0&count=100";
		//String tweetUrl  = "https://api.twitter.com/1.1/search/tweets.json?max_id=1006451989750927359&q=munich&include_entities=1";
		URI finalUrl = URIBuilder.fromUri(tweetUrl).build();
		String search = twitter.restOperations().getForObject(finalUrl, String.class);
		
		System.out.println(search);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonTextResponse = mapper.readTree(search);
		
		JsonNode jsonTweetList = jsonTextResponse.get("statuses");
		ArrayNode resultTweetList = mapper.createArrayNode();
		
		for (int i=0;i<jsonTweetList.size();i++) {
			if (!jsonTweetList.get(i).get("geo").isNull()) {
				
				ObjectNode resultTweet = mapper.createObjectNode();
				resultTweet.put("tweet_id", jsonTweetList.get(i).get("id"));
				resultTweet.put("created_at", jsonTweetList.get(i).get("created_at").asText());
				resultTweet.put("text", jsonTweetList.get(i).get("text").asText());
				resultTweet.put("location", jsonTweetList.get(i).get("place").get("full_name"));
				resultTweet.put("coordinates", jsonTweetList.get(i).get("geo").get("coordinates"));
				
				resultTweetList.add(resultTweet);
				//System.out.println(jsonTweetList.get(i));
				/*System.out.println(jsonTweetList.get(i).get("created_at"));
				System.out.println(jsonTweetList.get(i).get("id"));
				System.out.println(jsonTweetList.get(i).get("text"));
				System.out.println(jsonTweetList.get(i).get("place").get("full_name"));
				System.out.println(jsonTweetList.get(i).get("geo").get("coordinates"));*/
			}
		}
		//System.out.println(jsonTweetList);
		//System.out.println(jsonTextResponse.get("search_metadata").get("next_results"));
		
		while (jsonTextResponse.get("search_metadata").has("next_results")) {
			queryParam = jsonTextResponse.get("search_metadata").get("next_results").asText();
			tweetUrl = baseUrl + queryParam;
			
			finalUrl = URIBuilder.fromUri(tweetUrl).build();
			search = twitter.restOperations().getForObject(finalUrl, String.class);
			
			mapper = new ObjectMapper();
			jsonTextResponse = mapper.readTree(search);
			
			jsonTweetList = jsonTextResponse.get("statuses");
			
			
			for (int i=0;i<jsonTweetList.size();i++) {
				if (!jsonTweetList.get(i).get("geo").isNull()) {
					ObjectNode resultTweet = mapper.createObjectNode();
					resultTweet.put("tweet_id", jsonTweetList.get(i).get("id"));
					resultTweet.put("created_at", jsonTweetList.get(i).get("created_at").asText());
					resultTweet.put("text", jsonTweetList.get(i).get("text").asText());
					resultTweet.put("location", jsonTweetList.get(i).get("place").get("full_name"));
					resultTweet.put("coordinates", jsonTweetList.get(i).get("geo").get("coordinates"));
					
					resultTweetList.add(resultTweet);
					
					/*System.out.println(jsonTweetList.get(i).get("created_at"));
					System.out.println(jsonTweetList.get(i).get("geo"));*/
				}
			}
			
			//System.out.println(jsonTextResponse.get("statuses").size());
			//System.out.println(jsonTextResponse.get("search_metadata").get("next_results"));
		}
		
		String resultTweetAll = resultTweetList.toString();
		System.out.println(resultTweetList.size());
		System.out.println(resultTweetList.get(0));
		System.out.println(resultTweetList.get(1));
		System.out.println(resultTweetList.get(2));
		System.out.println(resultTweetList.get(3));
		System.out.println(resultTweetList.get(4));
		System.out.println(resultTweetList.get(5));
		System.out.println(resultTweetList.get(6));
		
		/*do {
			
			List<Tweet> tweetList = twitter.searchOperations().search(parameters).getTweets();
			searchResultCount = twitter.searchOperations().search(parameters).getTweets().size();
		
			
			
			for (int i=0;i<tweetList.size();i++) {
				long tweetId = tweetList.get(i).getId();
				if(tweetList.get(i).getUser().isGeoEnabled()) {
					System.out.println(i+","+tweetList.get(i).getUser().isGeoEnabled());
				
				//For each Tweet ID, check if geolocation exists
				String tweetUrl = "https://api.twitter.com/1.1/statuses/show.json?id="+tweetId;
				URI finalUrl = URIBuilder.fromUri(tweetUrl).build();
				String search = twitter.restOperations().getForObject(finalUrl, String.class);
				ObjectMapper mapper = new ObjectMapper();
				JsonNode jsonTextResponse = mapper.readTree(search);
				if(!jsonTextResponse.get("geo").isNull()) {
					//String returnedTweet = jsonTextResponse.get("geo").get;
					System.out.println(jsonTextResponse.get("geo"));
				}
				}
				if(tweetId<lowestTweetId) {
					lowestTweetId = tweetId;
					parameters.maxId(lowestTweetId);
				}
				
			}
		} while (searchResultCount != 0 && searchResultCount % 100 == 0);*/
		
		
		//System.out.println(twitter.searchOperations().search(s1).getTweets().get(0).getInReplyToScreenName());
		//System.out.println(tweetList.size());
		//System.out.println(twitter.searchOperations().search("Munich", 200));
		//System.out.println(twitter.geoOperations().getPlace("1004424817074896899"));
		/*List<String> queriedTweet = new ArrayList<>();
		for (int i=0;i<tweetList.size();i++) {
			long tweetId = tweetList.get(i).getId();
			parameters.maxId(tweetId);
			String tweetUrl = "https://api.twitter.com/1.1/statuses/show.json?id="+tweetId;
			URI finalUrl = URIBuilder.fromUri(tweetUrl).build();
			String search = twitter.restOperations().getForObject(finalUrl, String.class);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonTextResponse = mapper.readTree(search);*/
			
			/*if(!jsonTextResponse.get("geo").isNull()) {
				String returnedTweet = jsonTextResponse.get("geo").asText();
				queriedTweet.add(returnedTweet);
				System.out.println(jsonTextResponse.get("geo"));
				System.out.println(jsonTextResponse.get("geo").asText());
				//System.out.println(jsonTextResponse.get("geo"));
			}*/
		//}
		//System.out.println(queriedTweet.size());
		//MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		//parameters.set("q","Munich");
		//parameters.set("result_type", "recent");
		//URI url =  URIBuilder.fromUri("https://api.twitter.com/1.1/statuses/show.json?id=1004474342602887169").build();
		
		//String data= twitter.restOperations().getForObject(url, String.class);
		//String search = twitter.restOperations().getForObject(url, String.class);
		//System.out.println(search);
	
		//System.out.println(parameters.getSinceId()+"---"+parameters.getMaxId());
	}
}
