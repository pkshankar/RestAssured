package com.qa.restassured.test;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OpenWeatherMapGet {

	@Test
	public void getWeatherDetailsTest() {

		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/delhi";
		//RestAssured.baseURI="https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Delhi");
		//Response response = httpRequest.request(Method.GET, "/api/users?page=2");
		System.out.println("RESPONSE BODY IS : " +response.getBody().asString());
		System.out.println("RESPONSE CODE IS : " +response.getStatusCode());
		System.out.println("RESPONSE LINE IS : " +response.getStatusLine());
		Headers headers = response.getHeaders();
		System.out.println("RESPONSE HEADERS ARE " +headers);
		System.out.println("CONTENT TYPE : " +response.getHeader("content-type"));
		JsonPath jsonPathValue = response.jsonPath();
		System.out.println("JSON PATH : " +jsonPathValue.get("data"));
		

	}

}
