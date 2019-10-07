package com.qa.restassured.test;

import org.testng.annotations.Test;

import com.qa.TestData.TestData;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetFormulaOneInfo {

	
	@Test
	public void getCircuitInfo() {

		RestAssured.baseURI = "http://ergast.com";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/api/f1/" + TestData.raceYear + "/circuits.json");
		System.out.println(response.getStatusCode());
		JsonPath jPath = response.jsonPath();
		System.out.println(jPath.getString("MRData.CircuitTable.Circuits[2].Location.country"));
	}

}
