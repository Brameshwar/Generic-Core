package com.bramesh.config;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import cucumber.api.Scenario;

public class EventHandler implements WebDriverEventListener{

	public Scenario scenario;


	@Before
	public void init(Scenario scenario){
	this.scenario=scenario;
	}
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
	}
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
	}
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
	}
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
	}
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
	}
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
	}
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
}
