package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	public Properties prop;
	//FileInputStream ip;
	public TestBase(){
		
		prop=new Properties();
		
		try {
			
			FileInputStream ip = new FileInputStream("D:\\my_newworkspace\\restapi\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		
		
	}
	
}
