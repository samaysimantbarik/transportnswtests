package com.nsw.transportnsw.uitesting.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.nsw.transportnsw.services.inputreader.JsonReader;
import com.nsw.transportnsw.services.logger.Log;
import com.nsw.transportnsw.uitesting.webdrivermanager.DriverManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


public class WebHooks {
	
	@Autowired
	Log logger;

	@Autowired
	DriverManager webdriverManager;
	
	private WebDriver driver;

	final int IMPLICIT_WAIT= 30;
	final int PAGELOAD_WAIT= 30;
	

	@Before("@UI")
	public void setup(Scenario scenario) throws Exception {
		logger.info("Execution for :"+scenario.getName());
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGELOAD_WAIT, TimeUnit.SECONDS);
		
		webdriverManager.setDriver(driver);
		
	}
	
	@After("@UI")
	public void tearDown() {
		driver.quit();
	}

}
