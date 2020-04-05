package unimoove.api.places;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
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
	@WithMockUser
	public void testAddPlace() throws Exception {
		try {
			String creationRequest = "{\n" + "  \"category\": 0,\n" + "  \"idPlace\": \"PR\",\n"
					+ "  \"name\": \"Puerto Real\"\n" + "}";
			mvc.perform(post("/places").contentType(MediaType.APPLICATION_JSON).content(creationRequest))
					.andExpect(status().isOk());
			Place place = new Place("PR", "Puerto Real", 0);
			Place resultPlace = placesRepository.findByPlaceId("PR");

			assertThat(resultPlace.getIdPlace(), equalTo(place.getIdPlace()));
			assertThat(resultPlace.getName(), equalTo(place.getName()));
			assertThat(resultPlace.getCategory(), equalTo(place.getCategory()));
		} finally {
			deletePlace("PR");
		}
	}

	@Test
	@WithMockUser
	public void testCantAddTwoPlacesWithSameId() throws Exception {
		try {
			placesRepository.save(new Place("PR", "Puerto Real", 0));

			String creationRequest = "{\n" + "  \"category\": 0,\n" + "  \"idPlace\": \"PR\",\n"
					+ "  \"name\": \"Puerto Real\"\n" + "}";
			mvc.perform(post("/places").contentType(MediaType.APPLICATION_JSON).content(creationRequest))
					.andExpect(status().is(409));

		} finally {
			deletePlace("PR");
		}
	}

	@Test
	@WithMockUser
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
	@WithMockUser
	public void testModifyPlaceName() throws Exception {
		try {
			placesRepository.save(new Place("PR", "Puerto Reel", 0));

			mvc.perform(put("/places/PR/name").contentType(MediaType.APPLICATION_JSON)
					.content("{\"newName\": \"Puerto Real\"}")).andExpect(status().isOk());
			Place place = placesRepository.findByPlaceId("PR");
			assertThat(place.getName(), equalTo("Puerto Real"));
		} finally {
			deletePlace("PR");
		}
	}

	@Test
	@WithMockUser
	public void testModifyPlaceId() throws Exception {
		try {
			placesRepository.save(new Place("PT", "Puerto Real", 0));

			mvc.perform(put("/places/PT/idPlace").contentType(MediaType.APPLICATION_JSON)
					.content("{\"newPlaceId\": \"PR\"}")).andExpect(status().isOk());
			Place place = placesRepository.findByPlaceId("PR");
			assertThat(place.getIdPlace(), equalTo("PR"));

		} finally {
			deletePlace("PR");
		}
	}

	@Test
	@WithMockUser
	public void tesModifyPlaceCategory() throws Exception {
		try {
			placesRepository.save(new Place("PR", "Puerto Real", 1));
			mvc.perform(
					put("/places/PR/category").contentType(MediaType.APPLICATION_JSON).content("{\"newCategory\": 0}"))
					.andExpect(status().isOk());
			Place place = placesRepository.findByPlaceId("PR");
			assertThat(place.getCategory(), equalTo(0));
		} finally {
			deletePlace("PR");
		}
	}

	@Test
	@WithMockUser
	public void testGetPlace() throws Exception {
		try {
			placesRepository.save(new Place("PR", "Puerto Real", 1));
			mvc.perform(get("/places/PR")).andExpect(status().isOk())
					.andExpect(content().string(containsString("\"name\":\"Puerto Real\"")))
					.andExpect(content().string(containsString("\"category\":1")));
		} finally {
			deletePlace("PR");
		}
	}

	@Test
	@WithMockUser
	public void testSearchPlace() throws Exception {
		try {
			placesRepository.save(new Place("PR", "Puerto Real", 1));
			mvc.perform(get("/places")
					.param("name", "Puerto Real")
					.param("page", "0")
					.param("size", "25"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("\"idPlace\":\"PR\"")))
				.andExpect(content().string(containsString("\"name\":\"Puerto Real\"")))
				.andExpect(content().string(containsString("\"category\":1")))
				.andExpect(content().string(containsString("\"totalPages\":1")))
				.andExpect(content().string(containsString("\"totalElements\":1")));;
		} finally {
			deletePlace("PR");
		}
	}

	private void deletePlace(String idPlace) {
		Place place = placesRepository.findByPlaceId(idPlace);
		if (place != null)
			placesRepository.delete(place);

	}

}
