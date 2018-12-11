package com.bramesh.library.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bramesh.config.SharedDriver;
import com.bramesh.config.WaitTimeConfig;

public class CustomWait {
	
	private final WebDriver webDriver;
	public WebDriverWait explicitWait;
	
	public CustomWait(SharedDriver driver){
		this.webDriver =  driver;
		this.explicitWait = new WebDriverWait(webDriver,WaitTimeConfig.EXPLICITWAIT.getWaitTime());
	}
	
	public boolean waitForTitle(String expectedTitle){
		boolean titleMatch = false;
		try{
//			titleMatch = explicitWait.until(ExpectedConditions.titleIs(expectedTitle));
			explicitWait.until(ExpectedConditions.titleIs(expectedTitle));
		}
		return titleMatch;
	}

}
