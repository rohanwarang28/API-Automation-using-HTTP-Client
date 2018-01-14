package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	public void get(String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpGet getUrl=new HttpGet(url);
		CloseableHttpResponse httpResponse=httpClient.execute(getUrl);
		
		
		//get status code
		int statusCode=httpResponse.getStatusLine().getStatusCode();
		System.out.println("status code -->"+statusCode);
		
		
		String response=EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
		JSONObject jsonResponse=new JSONObject(response);
		
		System.out.println("JSON response --->"+jsonResponse);
		
		
		Header header[]=httpResponse.getAllHeaders();
		HashMap<String, String> allHeaders=new HashMap<String, String>();
		
		for(Header header1:header) {
			allHeaders.put(header1.getName(), header1.getValue());
		}
		
		
		System.out.println("All headers"+allHeaders);
		
	}
	
	
}
