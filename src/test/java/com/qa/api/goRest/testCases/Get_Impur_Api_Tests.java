package com.qa.api.goRest.testCases;

import java.util.Map;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.api.goRest.restclient.RestClient;
import com.qa.api.goRest.util.Token;

import io.restassured.response.Response;

public class Get_Impur_Api_Tests {

	Map<Object , Object > token ;
	String userName ;
	String access_token ; 
	String baseURI = "https://api.imgur.com";
    String ClientID = "66f4918ab1b4d24";
	
	@BeforeMethod
	public void setUP() {
		token= Token.get_Access_Token();
		access_token = token.get("access_token").toString();
		userName = token.get("account_username").toString();
		
		System.out.println(access_token);
		System.out.println(userName);
	}

	@Test
	public void Get_Account_Block_Status () {

		Response response = RestClient.doGetRequest(baseURI, "/account/v1/"+userName+"/block", access_token,null, true ,null);
		response.statusCode();
		response.prettyPrint();
	}

	@Test
	public void get_Account_Image_Test() {
		
		Response response = RestClient.doGetRequest(baseURI, "/3/account/me/images", access_token, null, true ,null);
		response.statusCode();
		response.prettyPrint();
		
	}
	
	/*@Test
	public void get_Account_BAse() 
	{
		Response response = RestClient.doGetRequest(baseURI, "/3/account/"+userName+"", null , null, true ,null);
		response.statusCode();
		response.prettyPrint();
	}*/
	
	@Test
	public void get_Account_Blocks() {
		
		Response response = RestClient.doGetRequest(baseURI, "/3/account/me/block", access_token , null, true ,null);
		response.statusCode();
		response.prettyPrint();
	}
}
