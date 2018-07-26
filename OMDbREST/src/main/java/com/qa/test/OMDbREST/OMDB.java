package com.qa.test.HotelController;

import org.junit.*;

import com.google.common.hash.HashCode;
import com.qa.test.HotelController.JSONArray;
import com.qa.test.HotelController.JSONObject;
import com.qa.test.omdb.Given;
import com.qa.test.omdb.Then;
import com.qa.test.omdb.ValidatableResponse;
import com.qa.test.omdb.When;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.*;


public class App {

	RequestSpecification request;
	Response response;
	ValidatableResponse json;

// Scenario: Testing a status code
		
	request = given().contentType(ContentType.JSON);

	response = request.when().get("http://www.omdbapi.com/?apikey=686776bf&t=IT");
	
	int statusCode;
	
	json = response.then().statusCode;


}