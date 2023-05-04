package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace AppPlacePayload(String name, String lang, String address, String phoneNumber) {
	    AddPlace ap = new AddPlace();
	    ap.setAccuracy(50);
	    ap.setAddress(address);
	    ap.setLanguage(lang);
	    ap.setName(name);
	    ap.setPhone_number(phoneNumber);
	    ap.setWebsite("http://google.com");
	    List<String> myList = new ArrayList<String>();
	    myList.add("education");
	    myList.add("API");
	    ap.setTypes(myList);
	    Location l = new Location();
	    l.setLat(-38.383494);
	    l.setLng(33.427362);
	    ap.setLocation(l);
	    return ap;
	}
	
	
	public String deletePlacePayload(String placeId) {
		return "{\"place_id\": \""+placeId+"\"}";
	}
	

}
