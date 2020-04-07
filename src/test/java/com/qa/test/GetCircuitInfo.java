package com.qa.test;

import java.util.Arrays;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetCircuitInfo {
	
	@Test
	public void getInfo() {
		
		RestAssured.baseURI = "http://ergast.com";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/api/f1/1966/circuits.json");
		//System.out.println("STATUS CODE : " + response.getStatusCode());
		Headers headers = response.getHeaders();
		//System.out.println("RESPONSE HEADERS " + headers);
		//System.out.println("RESPONSE BODY : " + response.getBody().asString());
		JsonPath jPath = response.jsonPath();
		//System.out.println("MR DATA : " + jPath.getJsonObject("MRData"));
		String str = jPath.get("MRData.CircuitTable.Circuits.circuitId").toString();
//		str = str.replace("[", "").replace("]", "");
//		//System.out.println(str);
//		String strArr[] = str.split(",");
//		System.out.println(Arrays.asList(strArr).contains("brands_hatc"));
		System.out.println(jPath.get("MRData.CircuitTable.Circuits.Location"));
	}

}
