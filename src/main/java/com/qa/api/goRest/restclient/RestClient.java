package com.qa.api.goRest.restclient;
import java.util.Map;

import com.qa.api.goRest.util.TestUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public  class RestClient {

	//this class having all the HTTP methods where we can fetch our response by calling the method 
	// HTTP Methods = Post, Get, PUT and Delete 

	/**
	 * 
	 * @param baseURI
	 * @param basePath
	 * @param token
	 * @param params
	 * @param log
	 * @param contentType
	 * @return this method returning response from GET call 
	 */
	public static  Response doGetRequest(String baseURI ,String basePath ,String token, Map<String ,String > params , boolean log , String contentType) {

		if(setBaseURI(baseURI)) {
			RequestSpecification request =createRequest( contentType,token,log, params);
			return getResponse( "GET" ,request ,basePath ) ;
		}
		return null ;
	}

	/**
	 * 
	 * @param baseURI
	 * @param basePath
	 * @param token
	 * @param params
	 * @param log
	 * @param contentType
	 * @param obj
	 * @return
	 */

	public static Response doPostRequest
	(String baseURI ,String basePath ,String token , Map<String ,String > params , boolean log , String contentType , Object obj) {

		if (setBaseURI(baseURI)) {
			RequestSpecification request = createRequest(contentType, token ,log, params  );
			String jSONPayload = TestUtil.getSeraializedJSON(obj);
			request.body(jSONPayload);
			return getResponse("POST", request, basePath);
		}

		return null ; 
	}

	private static boolean setBaseURI(String baseURI) {

		if ( baseURI.isEmpty() || baseURI==null) {
			System.out.println("Please Pass the base URI -- invalid baseURI ");
			return false ;
		}
		try {
			RestAssured.baseURI = baseURI ;
			return true ;	 
		}
		catch ( Exception e ) {
			System.out.println("Exception at setting up in baseURI  ");
			return false ;
		}
	}

	private static RequestSpecification createRequest(String contentType , String token ,boolean log , Map<String ,String > params ) {

		RequestSpecification request ;

		//Specify the Logs 
		if(log) {
			request = RestAssured.given().log().all();
		}
		else {
			request = RestAssured.given();
		}

		//make a Condition for Authorization Headers 
		if (token != null) {
			request.headers("Authorization","Bearer "+token);
		}
		
		/*if (ClientID !=null ) {
			request.header("Authorization","Client-ID "+ClientID);
		}*/
		
		//Make Condition for QueryParams
		if (!(params==null)) {
			request.queryParams(params);
			
		}

		//Make Condition for ContentType 
		if(contentType !=null) {
			if(contentType.equalsIgnoreCase("JSON")) {
				request.contentType(ContentType.JSON);
			}
			else if (contentType.equalsIgnoreCase("XML")) {
				request.contentType(ContentType.XML);
			}
		}
		
		return request ;
	}

	private static Response getResponse(String httpMethod , RequestSpecification request , String basePath){

		return executeApi(httpMethod, request, basePath);

	}

	private static Response executeApi(String httpMethod , RequestSpecification request , String basePath) {

		Response response = null ;

		switch (httpMethod) {
		case "GET": 
			response =request.get(basePath);
			break;
		case "POST" : 
			response =request.get(basePath);
			break ;
		case "PUT" : 
			response =request.get(basePath);
			break ;
		case "DELETE" : 
			response =request.get(basePath);
			break ;

		default:
			System.out.println("Please Pass the correct HTTP Method ");
			break;

		}
		return response ;
	}

}



