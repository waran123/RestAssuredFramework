package com.qa.api.goRest.testCases;
import java.util.HashMap;

import org.testng.annotations.Test;
import com.qa.api.goRest.restclient.RestClient;
import io.restassured.response.Response;

public class GetApiTests {

	String baseURI = "https://gorest.co.in";
	String basePath = "/public/v2/users";
	String token = " f2afff85f19f26bf42f5b695cc2904e6d6712a2cec99ade15e6b10b821f1235f";

	@Test
	public void get_All_User_Test() {

		Response response = RestClient.doGetRequest( baseURI, basePath, token,  null, true, "JSON");

		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}
	
	@Test
	public void get_Specific_User_Test () {

		//Response response = RestClient.doGetRequest( baseURI, basePath, token, null, true, "JSON");

		HashMap <String , String> params = new HashMap<String , String>() ;
		params.put("name", "Gangesh Kaul");
		params.put("Gender", "male");

		Response response = RestClient.doGetRequest( baseURI, basePath, token, params, true, "JSON");
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}

}
