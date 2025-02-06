package org.utility;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Builder extends UtilityClass {
	
	
	public static RequestSpecification getRequestSpecBuilder(){
		
	
		
		PrintStream p = null;
		
		if(p==null){
		
			
		 try {
			 
			p = new PrintStream("log.txt");
			
		
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		
		}
			
		}
	
		RequestSpecBuilder r = new RequestSpecBuilder();
		
		r.setBaseUri(getProperty("BaseURI"));
		
		r.setContentType(ContentType.JSON);
		
		r.addFilter(RequestLoggingFilter.logRequestTo(p));
		
		r.addFilter(ResponseLoggingFilter.logResponseTo(p));
		
		return r.build();
		
		
	}
	
	
	public static void getResponseSpecBuilder(int code) {
		
		
		ResponseSpecBuilder re = new ResponseSpecBuilder();
		
		re.expectStatusCode(code);
		
		
	}
	
	
	public static int getResponseCode(Response r){
		
		
		return r.getStatusCode();
	}
	

	public static String getResponseBody(Response r){
		
		
		return r.getBody().asString();
	}

}
