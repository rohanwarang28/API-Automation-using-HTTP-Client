package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class ApiTests extends TestBase {

	

	RestClient restClient;
	String serviceUrl;
	String apiUrl;
	TestBase testBase;
	
	

	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException {
		testBase=new TestBase();
		 serviceUrl=prop.getProperty("serviceURL");
		 apiUrl=prop.getProperty("apiUrl");
			
	}
	
	@Test
	public void apiTest() throws ClientProtocolException, IOException {
		restClient=new RestClient();
		restClient.get(serviceUrl+apiUrl);
		
	}
	
	
	
	
}
