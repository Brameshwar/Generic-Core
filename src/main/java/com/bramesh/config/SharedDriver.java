package com.bramesh.config;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import cucumber.api.Scenario;

public class SharedDriver extends EventFiringWebDriver{
	
	private final EventHandler handler;
	
	private static final WebDriver REAL_DRIVER;
	static String browserName= System.getProperty("browserName");

	static{
		if(browserName==null||browserName.equals(""))
			browserName="ie";
		if(browserName.equalsIgnoreCase("chrome")){
			ChromeOptions chromeOptions= new ChromeOptions();
			chromeOptions.addArguments("disable-extensions");
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("disable-infobars");
			DesiredCapabilities capabilities=DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			capabilities.setCapability("pageLoadStrategy", "none");
			
			REAL_DRIVER= new ChromeDriver(capabilities);
		}
		else{
			DesiredCapabilities capabilities=DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			REAL_DRIVER= new InternetExplorerDriver(capabilities);
		}
	}
	
	public Scenario scenario;
	private static final Thread CLOSE_THREAD= new Thread(){
		@Override
		public void run(){
			REAL_DRIVER.quit();
			Runtime.getRuntime().gc();
		}
	};
	
	static{
		Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
	}
	
	public SharedDriver(EventHandler handler) {
		super(REAL_DRIVER);
		this.handler=handler;
		super.register(handler);
	}
	@Override
	public void close(){
		if(Thread.currentThread()!=CLOSE_THREAD && REAL_DRIVER.getWindowHandles().size()==1)
			throw new UnsupportedOperationException("You shouldn't close this WebDriver. It's shared and will close when JVM exits");
	super.close();
	}
	
	@Before
	public void deleteAllCookiesAndSetTimeOuts(){
		manage().timeouts().pageLoadTimeout(WaitTimeConfig.PAGELOADWAIT.getWaitTime(), TimeUnit.SECONDS);
		manage().timeouts().implicitlyWait(WaitTimeConfig.IMPLICITWAIT.getWaitTime(), TimeUnit.SECONDS);
		manage().window().maximize();
		manage().deleteAllCookies();
	}
	
	@Before
	public void Initialize(Scenario scenario){
		this.scenario=scenario;
	}
	
	@After
	public void unregisterEvents(){
		super.unregister(handler);
	}
	
	
	
}
