package com.qa.restassured.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GoRest {

	String accessToken = "9tms9x_ejVmAxTrC9GxY1vjfg_vW2SiJh9NM";

	@Test
	public void getUserInfo() {

		RestAssured.baseURI="https://gorest.co.in/";
		RequestSpecification req = RestAssured.given().log().all();
		req.queryParam("access-token", "9tms9x_ejVmAxTrC9GxY1vjfg_vW2SiJh9NM");
		Response res = req.get("public-api/users");
		//System.out.println(res.prettyPrint());
		JsonPath jPath = res.jsonPath();
		jPath.get("_meta");
		//System.out.println(jPath.get("totalCount"));
	}

}
