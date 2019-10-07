package com.qa.javaobjects;

public class RestfulBookerObjects {

	public static String username;
	public static String password;
	
	public RestfulBookerObjects(String username, String password) {
		
		this.username=username;
		this.password=password;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}
	
	
	
}
