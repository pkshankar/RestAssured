package com.qa.restassured.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import com.qa.javaobjects.JsonSuccessResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostConvertJsonToJavaObject {

	@SuppressWarnings("unchecked")
	@Test
	public void postTest() {

		RestAssured.baseURI = "http://restapi.demoqa.com";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject jObj = new JSONObject();
		jObj.put("FirstName", "TimY");
		jObj.put("LastName", "JobEs");
		jObj.put("UserName", "timjobs1");
		jObj.put("Password", "timj12");
		jObj.put("Email", "timj2obs@zmail.com");
		httpRequest.body(jObj.toJSONString());
		httpRequest.header("Content-Type", "application/json");
		Response response = httpRequest.post("/customer/register");

		/* DESERIALIZATION */
		JsonSuccessResponse jsonSuccessResponse = response.as(JsonSuccessResponse.class);
		System.out.println("SUCCESS CODE : " + jsonSuccessResponse.SuccessCode);
		System.out.println("MESSAGE : " + jsonSuccessResponse.Message);

	}

}
