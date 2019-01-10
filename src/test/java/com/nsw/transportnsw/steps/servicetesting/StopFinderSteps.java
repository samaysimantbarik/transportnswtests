package com.nsw.transportnsw.steps.servicetesting;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nsw.transportnsw.services.inputreader.JsonReader;
import com.nsw.transportnsw.services.logger.Log;
import com.nsw.transportnsw.services.requestbuilder.RequestBuilder;
import com.nsw.transportnsw.services.requestobject.RequestObject;

public class StopFinderSteps {
	
	@Autowired
	Log logger;

	@Autowired
	RequestBuilder requestBuilder;

	@Autowired
	RequestObject requestObject;

	Response response;
	JSONObject record;

	@Given("Phileas is looking for a stop")
	public void phileas_is_looking_for_a_stop() throws Exception {
		System.out.println("Looking For a Stop");
		logger.info("Phileas is looking for a stop");

	}

	@When("he searches for {string}")
	public void he_searches_for(String stopName) {
        logger.info("he searches for "+stopName);
		requestObject.updateQueryParams("name_sf", stopName);
		
		response = requestBuilder.executeClient();

		System.out.println("Status Code--" + response.getStatusCode());
	}

	@Then("a stop named {string} is found")
	public void a_stop_named_is_found(String locationName) {
		logger.info("a stop named "+locationName+" is found");
		JSONObject responseBody = new JSONObject(response.asString());
		JSONArray locations = responseBody.getJSONArray("locations");
		Boolean found = false;

		for (int i = 0; i < locations.length(); i++) {

			if (locations.getJSONObject(i).getString("name").equals(locationName)) {
				Assert.assertTrue(true);
				record = locations.getJSONObject(i);
				found = true;
			}
		}
		if (!found) {
			Assert.assertFalse(true);
		}

	}

	@Then("the stop provides more than one mode of transport")
	public void the_stop_provides_more_than_one_mode_of_transport() {
		logger.info("the stop provides more than one mode of transport");
		Assert.assertTrue(record.getJSONArray("modes").length() > 1);
	}

}
