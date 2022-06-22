package com.qa.api.goRest.testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.goRest.pojo.User;
import com.qa.api.goRest.restclient.RestClient;
import com.qa.api.goRest.util.ExcelUtil;

import io.restassured.response.Response;

public class PostApiTests {

	String baseURI = "https://gorest.co.in";
	String basePath = "/public/v2/users";
	String token = " f2afff85f19f26bf42f5b695cc2904e6d6712a2cec99ade15e6b10b821f1235f";

	@Test 
	public void post_User_Test() {
		
		User user = new User("Abina", "PON", "Female", "POnAbina01@gmail.com", "active");

		Response response = RestClient.doPostRequest(baseURI, basePath, token , null, true, "JSON", user) ;

		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());

	}
 
	@DataProvider
	public Object[][] get_User_Data() throws EncryptedDocumentException, IOException {
		
		Object userData[][] = ExcelUtil.getTestData("TestData");
		return userData ;
	}
	
	@Test (dataProvider = "get_User_Data")
	public void post_User_Test_with_ExcelData(String name , String lastName , String gender , String email  , String status ) {

		User user = new User(name , lastName ,gender , email ,status );

		Response response = RestClient.doPostRequest(baseURI, basePath, token, null, true, "JSON", user) ;

		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());

	}
	
	
}
