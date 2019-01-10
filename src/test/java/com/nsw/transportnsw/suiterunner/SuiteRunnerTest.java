package com.nsw.transportnsw.suiterunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber-json-report/report.json"}, features = {
				"src/test/resources/features" }, glue = { "com/nsw/transportnsw" }
          ,tags= {"@UI"}
		)
public class SuiteRunnerTest{
}