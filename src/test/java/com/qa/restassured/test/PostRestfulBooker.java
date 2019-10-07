package com.qa.restassured.test;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.javaobjects.RestfulBookerObjects;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRestfulBooker {

	@Test
	public void createToken() throws IOException {

		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		RequestSpecification httpRequest = RestAssured.given();
		RestfulBookerObjects obj = new RestfulBookerObjects("admin", "password123");
		// SERIALIZATION
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("C:\\Users\\pkshank\\eclipse-workspace\\RestAssured\\src\\main\\java\\com\\qa\\TestData\\RestfulBooker.json"), obj);
		httpRequest.body(mapper.writeValueAsString(obj));
		Response res = httpRequest.post();
		System.out.println(res.getStatusCode());
		
	}

}
