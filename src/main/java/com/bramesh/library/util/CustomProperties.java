package com.bramesh.library.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.bramesh.config.EnvProperties;

import cucumber.api.java.Before;

public class CustomProperties {
	
	protected CompositeConfiguration properties = new CompositeConfiguration();
	
	@Before
	public void initializeProperties() throws IOException{
		String envName = System.getProperty("env");
		
		if(envName ==  null || envName.contains("${"))
			envName = "qa";
		
		File f = new File(EnvProperties.valueOf(envName.toLowerCase()).getPropertiesFileName());
		File appData = new File (EnvProperties.valueOf("applicationdata").getPropertiesFileName());
		
		try{
			properties.addConfiguration(new PropertiesConfiguration(f.getCanonicalPath()));
			properties.addConfiguration(new PropertiesConfiguration(f.getCanonicalPath()));
		}
		catch(ConfigurationException ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public String getPropertyValue(String propertyName){
		return (String) properties.getProperty(propertyName);
	}
	
	public String[] getPropertyValues(String propertyName){
		return properties.getStringArray(propertyName);
	}
	
	public void setPropertyValue(String propertyName, String propertyValue){
		properties.setProperty(propertyName, propertyValue);
	}

}
