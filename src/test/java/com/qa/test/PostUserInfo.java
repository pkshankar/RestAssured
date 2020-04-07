package com.qa.test;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostUserInfo {
	
	
	@Test
	public void createUser() throws JsonProcessingException {
		
		RestAssured.baseURI="https://gorest.co.in/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		request.header("Authorization","Bearer 7_7bk8nRTMj2mI9UbmtNLVmunksMPAfWcBYv");
		ObjectMapper mapper = new ObjectMapper();
		createUserPojo createUser = new createUserPojo();
		createUser.setFirst_name("MARK");
		createUser.setLast_name("PETER");
		createUser.setGender("male");
		createUser.setEmail("markpeter3@email.com");
		createUser.setStatus("active");
		String jstring = mapper.writeValueAsString(createUser);
		request.body(jstring);
		Response response = request.post("/public-api/users");
		//System.out.println("STATUS CODE : " + response.getStatusCode());
		System.out.println(response.body().asString());
	}

}
