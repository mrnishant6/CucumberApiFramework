package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {
	RequestSpecification res ;
	ResponseSpecification resp;
	Response response;
	TestDataBuild dataBuild = new TestDataBuild();
	static String place_id;
	
	
	@Given("Add Place Payload with {string} {string} {string} {string}")
	public void add_place_payload(String name, String lang, String address, String phoneNumber) throws IOException {
	    res  = given().spec(requestSpecification()).body(dataBuild.AppPlacePayload(name,lang,address,phoneNumber));
	  			
	  
	    
	}






	@When("User calls {string} with {string} http method")
	public void user_calls_with_http_method(String resource, String method) {
	    APIResources ar = APIResources.valueOf(resource);
		System.out.println(ar.getResource());
		
		if(method.equalsIgnoreCase("POST"))
			response  = res.when().post(ar.getResource());
		
		else if(method.equals("GET"))
			response  = res.when().post(ar.getResource());
	}

	@Then("API call should be successfull with status code as {int}")
	public void api_call_should_be_successfull_with_status_code_as(Integer  statusCode) {
	    assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body should be {string}")
	public void in_response_body_should_be(String ExpectedKey, String ExpectedValue) {
	    assertEquals(getJsonPath(response,ExpectedKey), ExpectedValue);
	    
	}
	

	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedname, String callMethod) throws IOException {
	
	    place_id= getJsonPath(response,"place_id");
		res  = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_method(callMethod, "GET");
		String actualName = getJsonPath(response,"name");
		assertEquals(actualName,expectedname);
	}



	@Given("DeletePlace Paylod")
	public void delete_place_paylod() throws IOException {
	    res = given().spec(requestSpecification()).body(dataBuild.deletePlacePayload(place_id));
	}









}
