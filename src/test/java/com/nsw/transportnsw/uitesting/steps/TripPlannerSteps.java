package com.nsw.transportnsw.uitesting.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.nsw.transportnsw.services.logger.Log;
import com.nsw.transportnsw.uitesting.pages.HomePage;
import com.nsw.transportnsw.uitesting.webdrivermanager.DriverManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TripPlannerSteps {

	HomePage homePage;
	
	@Autowired
	Log logger;

	@Autowired
	DriverManager webdriverManager;
	
	WebDriver driver;

	@Given("Phileas is planning a trip")
	public void phileas_is_planning_a_trip() {
		logger.info("In Given");
		driver=webdriverManager.getDriver();
		driver.get("https://transportnsw.info/trip");
		homePage= new HomePage(driver);

	}

	@When("he executes a trip plan from {string} to {string}")
	public void he_executes_a_trip_plan_from_to(String startLocation, String destLocation) {
		logger.info("Executing step: Planning trip");
		homePage.planTrip(startLocation, destLocation);

	}

	@Then("a list of trips should be provided")
	public void a_list_of_trips_should_be_provided() {
		int num_trips_available = homePage.getNumberOfResultsDisplayed();
		logger.info("Number of trips:"+num_trips_available);
		Assert.assertTrue(num_trips_available > 0);
	}
}
