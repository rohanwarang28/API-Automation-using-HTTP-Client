package com.qa.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

public class ApiTests extends TestBase {

	

	RestClient restClient;
	String serviceUrl;
	String apiUrl;
	TestBase testBase;
	CloseableHttpResponse httpResponse;
	

	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException {
		testBase=new TestBase();
		 serviceUrl=prop.getProperty("serviceURL");
		 apiUrl=prop.getProperty("apiUrl");
			
	}
	
	@Test
	public void apiTest() throws ClientProtocolException, IOException {
		restClient=new RestClient();
		
		httpResponse= restClient.get(serviceUrl+apiUrl);
		
		
		
		//get status code
				int statusCode=httpResponse.getStatusLine().getStatusCode();
				System.out.println("status code -->"+statusCode);
				Assert.assertEquals(statusCode, 200);
								
				
				String response=EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
				JSONObject jsonResponse=new JSONObject(response);
				
				System.out.println("JSON response --->"+jsonResponse);
				
				
				Header header[]=httpResponse.	getAllHeaders();
				HashMap<String, String> allHeaders=new HashMap<String, String>();
				
				for(Header header1:header) {
					allHeaders.put(header1.getName(), header1.getValue());
				}
				
				System.out.println("All headers --->"+allHeaders);
				
				
				//single value assertions
				String per_page=TestUtil.getValueByJPath(jsonResponse, "/per_page");
				System.out.println("Per page value-->"+per_page);
				
				//single value assertions
				String total=TestUtil.getValueByJPath(jsonResponse, "/total");
				System.out.println("total value-->"+total);
				
				//single value assertions
				String id=TestUtil.getValueByJPath(jsonResponse, "/data[0]/id");
				String firstname=TestUtil.getValueByJPath(jsonResponse, "/data[0]/first_name");
				String lastname=TestUtil.getValueByJPath(jsonResponse, "/data[0]/last_name");
				String avatar=TestUtil.getValueByJPath(jsonResponse, "/data[0]/avatar");
				
				System.out.println("ID value-->"+id);
				Assert.assertEquals(id, "1");
				
				
				System.out.println("First Name value-->"+firstname);
				Assert.assertEquals(firstname,"George");
				
				
				System.out.println("Last Name value-->"+lastname);
				Assert.assertEquals(lastname,"Bluth");
				
				System.out.println("Avatar value-->"+avatar);
				Assert.assertEquals(avatar,"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
				
	}
	
	
	
	
}
