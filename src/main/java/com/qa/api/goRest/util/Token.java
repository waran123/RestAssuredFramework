package com.qa.api.goRest.util;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

public class Token {

	@Test
	public static Map<Object, Object> get_Access_Token() {

		HashMap <String,String> formparams = new HashMap<String,String>();

		formparams.put("refresh_token","39a17fdfc1fd914d2a9651aa74c8a4013044ab01");
		formparams.put("client_id","66f4918ab1b4d24");
		formparams.put("client_secret","3d45304d1fba70f9f67bc28993ed6e6c36f2f32f");
		formparams.put("grant_type","refresh_token");

		JsonPath json_Access_Token = given().formParams(formparams)
				.when()
				.post("https://api.imgur.com/oauth2/token")
				.then().extract().response().jsonPath();

		json_Access_Token.getMap("");

		json_Access_Token.prettyPrint();
		
		return json_Access_Token.getMap("");


	}
}
