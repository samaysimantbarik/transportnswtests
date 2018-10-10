package com.nsw.transportnsw.services.inputreader;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nsw.transportnsw.services.requestobject.RequestObject;

@Component
public class JsonReader {

	JSONObject scenariodata = new JSONObject();
	JSONArray featuredata = new JSONArray();

	@Autowired
	RequestObject requestObject;

	public JSONObject extractScenarioData(String scenarioName) throws Exception {
		Boolean testdatafound = false;
		for (int num_scenarios = 0; num_scenarios < featuredata.length(); num_scenarios++) {
			if (featuredata.getJSONObject(num_scenarios).getString("scenarioname").equals(scenarioName)) {
				scenariodata = featuredata.getJSONObject(num_scenarios);
				testdatafound = true;
			}
		}
		if (!testdatafound) {
			throw new Exception("Input not found for scenario:" + scenarioName);
		}
		return scenariodata;
	}

	public void readFile(String testfile) throws FileNotFoundException, IOException {
		File file = new File(testfile);
		String content = FileUtils.readFileToString(file, "utf-8");
		JSONObject tomJsonObject = new JSONObject(content);
		featuredata = (JSONArray) tomJsonObject.get("feature");
	}

	public void createRequestObject(String testfile, String scenarioName) throws Exception {
		readFile(testfile);
		extractScenarioData(scenarioName);
		HashMap<String, Object> queryParms = new HashMap<String, Object>();

		requestObject.setEndPoint(scenariodata.getString("endpoint"));
		requestObject.setMethodType(scenariodata.getString("method"));
		requestObject.setContentType(scenariodata.getString("contenttype"));

		JSONObject queryParamArry = scenariodata.getJSONObject("queryparams");
		Set<String> params = queryParamArry.keySet();
		for (String param : params) {
			queryParms.put(param, queryParamArry.get(param));

		}
		requestObject.setQueryParams(queryParms);

	}

}
