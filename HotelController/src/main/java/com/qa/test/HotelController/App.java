package com.qa.test.HotelController;

import org.junit.*;

import com.google.common.hash.HashCode;
import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.*;

//toString is actually toJSONString, ToString is just overwritten


public class App {

@Test

//method to post

public void PostMethod() {

String Link = "http://localhost:8090/example/v1/hotels/";

RestAssured.baseURI = Link;

RequestSpecification request = RestAssured.given();

//keys and values with JSON

JSONObject requestParams = new JSONObject();

requestParams.put("city", "Acity");
requestParams.put("description", "New");
requestParams.put("name", "Findout");
requestParams.put("rating", 2);

//print out to console
System.out.println(requestParams.toString());

request.header("Content-Type", "application/json");
request.body(requestParams.toString());

//response is retrieved from link
Response response = request.post(Link); 

//status code is made an integer variable and printed to console
int statusCode = response.getStatusCode();
System.out.println("Post status code: " + statusCode);

}


@AfterClass

//method to get (retrieve)

public static void  GetMethod() {   

RestAssured.baseURI = "http://localhost:8090/example/v1/hotels?page=0&size=100";

RequestSpecification httpRequest = RestAssured.given();
Response response = httpRequest.request(Method.GET);

int statusCode = response.getStatusCode();
System.out.println("Get status code: " + statusCode);

String responseBody = response.getBody().asString();

JSONObject responseBodyJSON = new JSONObject(responseBody);
System.out.println(responseBodyJSON);


JSONArray responseBodyJSONArray = (JSONArray) responseBodyJSON.get("content");
System.out.println(responseBodyJSONArray);

//print elements from responseBodyJSONArray

for (int i = 0; i <= responseBodyJSONArray.length(); i++) {

System.out.println(responseBodyJSONArray.getJSONObject(i));
System.out.println(responseBodyJSONArray.getJSONObject(i).getInt("id"));

}

}



@Test

//method to delete

public void DeleteMethod() {

String BaseLink = "http://localhost:8090/example/v1/hotels/";
//change ID here
String IDtoDelete = "11";
String Link = BaseLink + IDtoDelete;

RestAssured.baseURI = Link;

RequestSpecification request = RestAssured.given();
request.header("Content-Type", "application/json");
Response response = request.delete(Link);

int statusCode = response.getStatusCode();
System.out.println("Delete status code: " + statusCode);

}



@Test


//method to put (update)

public void PutMethod() {

String BaseLink = "http://localhost:8090/example/v1/hotels/";

//change ID here

String IDtoDelete = "9";

String Link = BaseLink + IDtoDelete;

RestAssured.baseURI = Link;

RequestSpecification request = RestAssured.given();


JSONObject requestParams = new JSONObject();

requestParams.put("city", "Manchester");
requestParams.put("description", "Rainy");
requestParams.put("id", IDtoDelete);
requestParams.put("name", "Whats a name");
requestParams.put("rating", 5);

request.header("Content-Type", "application/json");
request.body(requestParams.toString());

Response response = request.put(Link); 

int statusCode = response.getStatusCode();

System.out.println("Put status code: " + statusCode);

}

}