package com.qa.restassured.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.util.TestUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredPost {

	@DataProvider
	public Iterator<String[]> getData() throws IOException {

		ArrayList<String[]> al = TestUtil.getDataExcel("testdata",
				"C:\\Users\\pkshank\\eclipse-workspace\\RestAssured\\src\\main\\java\\com\\qa\\TestData\\PostTestData_RestAssured.xlsx");

		return al.iterator();

	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "getData")
	public void restAssuredPostTest(String fName, String lName, String uName, String pwd, String email) throws IOException {

//		ArrayList<String[]> al = TestUtil.getDataExcel("testdata",
//				"C:\\Users\\pkshank\\eclipse-workspace\\RestAssured\\src\\main\\java\\com\\qa\\TestData\\PostTestData_RestAssured.xlsx");

		//for (int i = 0; i < al.size(); i++) {
			RestAssured.baseURI = "http://restapi.demoqa.com";
			RequestSpecification httpRequest = RestAssured.given();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("FirstName", fName);
			jsonObject.put("LastName", lName);
			jsonObject.put("UserName", uName);
			jsonObject.put("Password", pwd);
			jsonObject.put("Email", email);
			httpRequest.body(jsonObject.toJSONString());
			httpRequest.header("httpRequest", "application/json");
			Response response = httpRequest.post("/customer/register");
			System.out.println("RESPONSE CODE IS : " + response.getStatusCode());
			System.out.println("RESPONSE IS : " + response.getBody().asString());
			System.out.println("RESPONSE HEADERS ARE : " + response.getHeaders());

			System.out.println("***********************************************");
		//}

	}

}
