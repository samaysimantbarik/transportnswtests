package com.nsw.transportnsw.uitesting.webdrivermanager;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class DriverManager {
	
	WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	

}
