package com.qa.test.OMDbCuc;

import static org.junit.Assert.*;


import org.junit.Test;


import cucumber.api.java.Before; 
import cucumber.api.java.After; 


import cucumber.api.java.en.Given; 
import cucumber.api.java.en.Then; 
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import static org.junit.Assert.assertEquals; 

public class OMDB {
	
	RequestSpecification request;
	Response response;
	ValidatableResponse json;

// Scenario: Testing a status code
		
	@Given("^a film exists with the Title IT$")
	public void a_film_exists_with_the_Title_IT() {
	request = given().contentType(ContentType.JSON);
	}

	@When("^a_user_retrieves_the_film_by_the_title_IT$")
	public void a_user_retrieves_the_film_by_the_title_IT() {
	response = request.when().get("http://www.omdbapi.com/?apikey=686776bf&t=IT");
	}

	@Then("^the status code reads 200$")
	public void the_status_code_reads(int statusCode) {
	json = response.then().statusCode(200);
	}
	
}