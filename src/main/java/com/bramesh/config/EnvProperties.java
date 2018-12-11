package com.bramesh.config;

public enum EnvProperties {

	dev("src/test/java/com/bramesh/testdata/DevEnv.properties"),
	qa("src/test/java/com/bramesh/testdata/QAEnv.properties"),
	uat("src/test/java/com/bramesh/testdata/UATEnv.properties"),
	testdatafolder("src/test/java/com/bramesh/testdata"),
	applicationdata("src/test/java/com/bramesh/testdata/ApplicationData.properties");
	
	private String EnvProperties;
	private EnvProperties(String EnvProperties){
		this.EnvProperties=EnvProperties;
	}
	
	public String getPropertiesFileName(){
		return EnvProperties;
	}
}
