package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		StepDefination sd = new StepDefination();
		
		if(StepDefination.place_id  == null) {
		sd.add_place_payload("Nishant", "Java", "WTCD", "09876534201");
		sd.user_calls_with_http_method("AddPlace", "POST");
		sd.verify_place_id_created_maps_to_using("Nishant", "getPlace");
		}
		
		
	}

}
