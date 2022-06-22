package com.qa.api.goRest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
	
	
	// this method is used to convert java pojo to json string 
	
	public static String getSeraializedJSON(Object obj) {
		
		ObjectMapper mapper = new ObjectMapper() ;
		String jsonUser = null ;
		try {
			jsonUser = mapper.writeValueAsString(obj);
			System.out.println("the JSON payload for POST User" + jsonUser);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonUser ;
	}
	
	
	

}
