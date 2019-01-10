package com.nsw.transportnsw.steps.uitesting;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

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

	final int IMPLICIT_WAIT = 45;
	final int PAGELOAD_WAIT = 80;

	@Before("@UI")
	public void setup(Scenario scenario) throws Exception {
		logger.info("Execution for :" + scenario.getName());

		String execEnvironment = System.getProperty("ENVIRONMENT");
		System.out.println("env :" + execEnvironment);
		if (execEnvironment.equalsIgnoreCase("local")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else {
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("idleTimeout", 1000);
			caps.setCapability("recordVideo", false);
			caps.setCapability("name", scenario.getName());
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
		}

		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGELOAD_WAIT, TimeUnit.SECONDS);

		webdriverManager.setDriver(driver);

	}

	@After("@UI")
	public void tearDown() {
		driver.quit();
	}

}
