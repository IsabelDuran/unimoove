package unimoove.api.places;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import unimoove.places.Place;
import unimoove.places.PlacesRepository;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlacesApiControllerTest {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private PlacesRepository placesRepository;

	@Test
	public void testAddPlace() throws Exception {
		try {
			String creationRequest = "{\n" + 
					"  \"category\": 0,\n" + 
					"  \"idPlace\": \"PR\",\n" + 
					"  \"name\": \"Puerto Real\"\n" + 
					"}";
			mvc.perform(post("/places")
					.contentType(MediaType.APPLICATION_JSON).content(creationRequest)).andExpect(status().isOk());
			Place place = new Place("PR", "Puerto Real", 0);
			Place resultPlace = placesRepository.findByPlaceId("PR");
			
			assertThat(resultPlace.getIdPlace(), is(place.getIdPlace()));
			assertThat(resultPlace.getName(), is(place.getName()));
			assertThat(resultPlace.getCategory(), is(place.getCategory()));
		} finally {
			deletePlace("PR");
		}
	}

	@Test
	public void testCantAddTwoPlacesWithSameId() throws Exception {
		try {
			placesRepository.save(new Place("PR", "Puerto Real", 0));
			
			String creationRequest = "{\n" + 
					"  \"category\": 0,\n" + 
					"  \"idPlace\": \"PR\",\n" + 
					"  \"name\": \"Puerto Real\"\n" + 
					"}";
			mvc.perform(post("/places")
					.contentType(MediaType.APPLICATION_JSON).content(creationRequest)).andExpect(status().is(409));
			
		} finally {
			deletePlace("PR");
		}
	}
	
	@Test
	public void testDeletePlace() throws Exception {
		try {
			placesRepository.save(new Place("PR", "Puerto Real", 0));
			
			mvc.perform(delete("/places/PR")).andExpect(status().isOk());
			assertTrue(placesRepository.findByPlaceId("PR") == null);
		} finally {
			deletePlace("PR");
		}
	}
	
	@Test 
	public void testModifyPlaceName() throws Exception {
		try {
			placesRepository.save(new Place("PR", "Puerto Reel", 0));
			
			mvc.perform(put("/places/PR/name")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"newName\": \"Puerto Real\"}")).andExpect(status().isOk());
			Place place = placesRepository.findByPlaceId("PR");
			assertThat(place.getName(), is("Puerto Real"));
		} finally {
			deletePlace("PR");
		}
	}
	
	@Test 
	public void testModifyPlaceId() throws Exception {
		try {
			placesRepository.save(new Place("PT", "Puerto Real", 0));
			
			mvc.perform(put("/places/PT/idPlace")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"newPlaceId\": \"PR\"}")).andExpect(status().isOk());
			Place place = placesRepository.findByPlaceId("PR");
			assertThat(place.getIdPlace(), is("PR"));
			
		} finally {
			deletePlace("PR");
		}
	}
	
	@Test 
	public void tesModifyPlaceCategory() throws Exception {
		try {
			placesRepository.save(new Place("PR", "Puerto Real", 1));
			mvc.perform(put("/places/PR/category")
					.contentType(MediaType.APPLICATION_JSON).content("{\"newCategory\": 0}")).andExpect(status().isOk());
			Place place = placesRepository.findByPlaceId("PR");
			assertThat(place.getCategory(), is(0));
		} finally {
			deletePlace("PR");
		}
	}
	
	private void deletePlace(String idPlace) {
		Place place = placesRepository.findByPlaceId(idPlace);
		if(place != null)
			placesRepository.delete(place);
		
	}
	
}
