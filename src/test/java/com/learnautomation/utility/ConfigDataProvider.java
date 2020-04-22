package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class ConfigDataProvider {
	
	public Properties pro;
	
	public ConfigDataProvider(){//Constructor to initialize to variable and objects
	
	File src=new File("./Config/Config.properties");
	
	try {
		FileInputStream fis=new FileInputStream(src);
		
		  pro=new Properties();
		 
		 pro.load(fis);
	} catch (Exception e) {
		System.out.println("not able to load config file "+e.getMessage());
	} 
	}
	
	public String getBrowser(){
		
	 return	pro.getProperty("Browser");
	}
	public String getStagingurl(){
		
		 return	pro.getProperty("StagingURL");
		}
	public String getQAURL(){
		
		 return	pro.getProperty("QAURL");
		}
	public String getDatafromConfig(String keytoSearch){
		
		 return	pro.getProperty(keytoSearch);
		}
}

