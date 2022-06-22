package com.qa.api.dunzo.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static  io.restassured.RestAssured.*;
import java.util.HashMap;

public class Post_Api_Test {

	@Test
	public void post_User_Test() {

		// => https://reqres.in/api/users

		RestAssured.baseURI = "https://reqres.in";

		HashMap<String , String > hmap = new HashMap<String , String >();
		hmap.put("name", "waran");
		hmap.put("job", "Testing");

		Response response = given().header("Content-Type","application/json").log().all().body(hmap)
				.when()
				.post("/api/users")
				.then().log().all()
				.assertThat().statusCode(201).extract().response();

		//response.prettyPrint();
		
		String res = response.body().asString();
		
		JsonPath js = new JsonPath(res);
		
		System.out.println(js.getString("name"));

		Assert.assertEquals(js.getString("name"), "waran"  );
		
		

	}
	
	
}
