package com.bramesh.config;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.bramesh.library.util.CustomProperties;
import com.bramesh.library.util.DateUtil;
import com.bramesh.library.util.ExcelUtil;
import com.bramesh.support.Encryption;
import com.bramesh.testdata.GenericRunTime;

import cucumber.api.Scenario;

public class Hooks {
	private SharedDriver driver;
	private final CustomProperties properties;
	private final Encryption encryption;
	private final DateUtil dateUtil;
	private final GenericRunTime genericRunTime;
	private static String screenshotPath;
	private final ExcelUtil excelUtil;

	public Hooks(SharedDriver driver, CustomProperties properties, Encryption encryption, DateUtil dateUtil,
			GenericRunTime genericRunTime, ExcelUtil excelUtil) {
		this.driver = driver;
		this.properties = properties;
		this.encryption = encryption;
		this.dateUtil = dateUtil;
		this.genericRunTime = genericRunTime;
		this.excelUtil = excelUtil;
	}

	@After
	public void embedScreenshot(Scenario scenario) {
		if (properties.getPropertyValue("SaveScreenshotsForPassedTests").equalsIgnoreCase("true")) {
			try {
				File f = new File("." + properties.getPropertyValue("screenShotLocation"));
				f.mkdirs();
				String screenShotLocation = f.getCanonicalPath();

				Pattern pattern = Pattern.compile("<testcaseid>(.*?)</testcaseid>");
				Matcher matcher = pattern.matcher(scenario.getName());

				String testCaseId = "";

				if (matcher.find())
					testCaseId = matcher.group(1);

				String fileName = "";

				if (!testCaseId.equals(""))
					fileName = testCaseId + ".png";
				else {
					fileName = scenario.getName().replaceAll("[ ',</>", "") + ".png";
					if (fileName.length() > 20) {
						fileName = fileName.substring(0, 20);
						fileName = fileName + ".png";
					}
				}
				screenshotPath = screenShotLocation + "/" + fileName;
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(screenshotPath));
				stream.write(screenshot);
				scenario.embed(screenshot, "image/png");
				stream.close();
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			} catch (Exception e) {

			}
		}
	}

}
