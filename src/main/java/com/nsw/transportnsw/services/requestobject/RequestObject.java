package com.nsw.transportnsw.services.requestobject;

import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.restassured.specification.RequestSpecification;

@Component
public class RequestObject {

	private String baseUri;
	private String endPoint;
	private String methodType;
	

	private String contentType;
	public HashMap<String, Object> queryParams = new HashMap<String, Object>();

	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public String getBaseUri() {
		return baseUri;
	}

	public void setBaseUri(String baseUri) {
		this.baseUri = baseUri;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public HashMap<String, Object> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(HashMap<String, Object> queryParams) {
		this.queryParams = queryParams;
	}

	public void updateQueryParams(String key, Object value) {
		this.queryParams.put(key, value);
	}
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
