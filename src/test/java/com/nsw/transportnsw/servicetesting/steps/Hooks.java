package com.nsw.transportnsw.servicetesting.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nsw.transportnsw.services.inputreader.JsonReader;
import com.nsw.transportnsw.services.logger.Log;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class Hooks {

	@Autowired
	Log logger;
	
	@Autowired
	JsonReader reader;

	final String  testDataFile = "src/test/resources/testdata/input.json";

	@Before("@API")
	public void setup(Scenario scenario) throws Exception {
		logger.info("--------Hook for rest api test-----");
		logger.info("Running Scenario: "+scenario);
		logger.info("------------------------------------");
		reader.createRequestObject(testDataFile,scenario.getName());
		logger.info("Creating Request Object");
	}

}
