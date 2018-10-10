package com.nsw.transportnsw.services.requestbuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nsw.transportnsw.services.logger.Log;
import com.nsw.transportnsw.services.requestobject.RequestObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Component
public class RequestBuilder {
	@Autowired
	Log logger;

	@Autowired
	RequestObject requestObject;

	public RequestSpecification request;
	private Response response;

	private void buildrequest() {
		logger.info("Building request object");
		String baseUri = null != (baseUri = System.getProperty("baseuri")) ? baseUri : "https://transportnsw.info";
		System.out.println("baseuri: " + baseUri);
		request = RestAssured.with().baseUri(baseUri).basePath(requestObject.getEndPoint()).accept(ContentType.JSON);
		request.given().queryParams(requestObject.getQueryParams());
	}

	public Response executeClient() {
		buildrequest();
		logger.info("Method Type:"+requestObject.getMethodType().toString());
		switch (requestObject.getMethodType().toString()) {

		case ("get"):
			response = request.when().get();
			break;

		case ("post"):
			System.out.println("To be Implemented");

		}

		return response;
	}

}
