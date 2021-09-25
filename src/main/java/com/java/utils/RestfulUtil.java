package com.java.utils;

import java.net.MalformedURLException;
import java.net.URL;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestfulUtil {

	
	public Response rest(String url) throws MalformedURLException {
		Response response = RestAssured.given().when().get(new URL(url));
		return response;
	}
	
	public static void main(String[] args) {
		RestfulUtil restfulUtil = new RestfulUtil();
		Response response;
		try {
			response = restfulUtil.rest("http://api.douban.com/v2/book/1220562");
			System.out.println(response);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
