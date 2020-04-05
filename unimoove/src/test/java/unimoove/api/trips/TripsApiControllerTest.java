package unimoove.api.trips;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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

import unimoove.trips.Trip;
import unimoove.trips.TripsRepository;
import unimoove.users.User;
import unimoove.users.UsersRepository;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class TripsApiControllerTest {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	private static final int ROLE_USER = 1;
	private static final int GENDER_FEMALE = 1;

	@Autowired
	private MockMvc mvc;

	@Autowired
	private TripsRepository tripsRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Test
	@WithMockUser("isa")
	public void testAddTrip() throws Exception {
		Trip trip = null;
		try {
			User user = createUser();

			String creationRequest = "{\n" + "  \"arrivalPlace\": \"ESI\",\n"
					+ "  \"departureDateTime\": \"2017-07-21T19:32:28+02:00\",\n" + "  \"departurePlace\": \"CA\",\n"
					+ "  \"numberAvailableSeats\": 2,\n" + "  \"price\": 1\n" + "}";
			mvc.perform(post("/trips").contentType(MediaType.APPLICATION_JSON).content(creationRequest))
					.andExpect(status().isOk());
			Collection<Trip> trips = (Collection<Trip>) tripsRepository.findAll();
			trip = trips.iterator().next();
			assertThat(trips.size(), equalTo(1));
			assertThat(trip.getArrivalPlace(), equalTo("ESI"));
			assertThat(trip.getDepartureDateTime(), equalTo(OffsetDateTime.parse("2017-07-21T19:32:28+02:00")));
			assertThat(trip.getDeparturePlace(), equalTo("CA"));
			assertThat(trip.getNumberAvailableSeats(), equalTo(2));
			assertTrue(trip.getPrice().compareTo(new BigDecimal(1)) == 0);
		} finally {
			User user = usersRepository.findUserByUsernameWithTrips("isa");
			user.getTrips().clear();
			usersRepository.save(user);
			deleteTrip(trip);
			deleteUser("isa");
		}
	}

	@Test
	@WithMockUser("isa")
	public void testDeleteTrip() throws Exception {
		Trip trip = null;
		try {
			User user = createUser();
			trip = new Trip("CA", "ESI", OffsetDateTime.now(), 1, new BigDecimal(2), 0, user);
			Long idTrip = tripsRepository.save(trip).getId();
			mvc.perform(delete("/trips/" + idTrip)).andExpect(status().isOk());

			Collection<Trip> trips = (Collection<Trip>) tripsRepository.findAll();
			assertTrue(trips.isEmpty());

		} finally {
			User user = usersRepository.findUserByUsernameWithTrips("isa");
			user.getTrips().clear();
			usersRepository.save(user);
			deleteTrip(trip);
			deleteUser("isa");
		}
	}

	@Test
	@WithMockUser("isa")
	public void testModdifyArrivalPlace() throws Exception {
		Trip trip = null;
		try {
			User user = createUser();
			trip = new Trip("CA", "ESI", OffsetDateTime.now(), 1, new BigDecimal(2), 0, user);
			Long idTrip = tripsRepository.save(trip).getId();

			mvc.perform(put("/trips/" + idTrip + "/arrivalPlace").contentType(MediaType.APPLICATION_JSON)
					.content("{\"newPlace\": \"UCA\"}")).andExpect(status().isOk());

			Collection<Trip> trips = (Collection<Trip>) tripsRepository.findAll();
			trip = trips.iterator().next();

			assertThat(trip.getArrivalPlace(), equalTo("UCA"));

		} finally {
			User user = usersRepository.findUserByUsernameWithTrips("isa");
			user.getTrips().clear();
			usersRepository.save(user);
			deleteTrip(trip);
			deleteUser("isa");
		}
	}

	@Test
	@WithMockUser("isa")
	public void testModifyDepartureDateTime() throws Exception {
		Trip trip = null;
		try {
			User user = createUser();
			trip = new Trip("CA", "ESI", OffsetDateTime.now(), 1, new BigDecimal(2), 0, user);
			Long idTrip = tripsRepository.save(trip).getId();
			
			mvc.perform(put("/trips/" + idTrip + "/departureDateTime").contentType(MediaType.APPLICATION_JSON)
					.content("{\"newDepartureDateTime\": \"2017-07-21T19:32:28+02:00\"}")).andExpect(status().isOk());
			
			Collection<Trip> trips = (Collection<Trip>) tripsRepository.findAll();
			trip = trips.iterator().next();
			
			assertThat(trip.getDepartureDateTime(), equalTo(OffsetDateTime.parse("2017-07-21T19:32:28+02:00")));
			
		} finally {
			User user = usersRepository.findUserByUsernameWithTrips("isa");
			user.getTrips().clear();
			usersRepository.save(user);
			deleteTrip(trip);
			deleteUser("isa");
		}
	}
	
	@Test
	@WithMockUser("isa")
	public void testModifyDeparturePlace() throws Exception {
		Trip trip = null;
		try {
			User user = createUser();
			trip = new Trip("CA", "ESI", OffsetDateTime.now(), 1, new BigDecimal(2), 0, user);
			Long idTrip = tripsRepository.save(trip).getId();
			
			mvc.perform(put("/trips/" + idTrip + "/departurePlace")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"newPlace\": \"SF\"}")).andExpect(status().isOk());
			
			Collection<Trip> trips = (Collection<Trip>) tripsRepository.findAll();
			trip = trips.iterator().next();
			
			assertThat(trip.getDeparturePlace(), equalTo("SF"));
		} finally {
			User user = usersRepository.findUserByUsernameWithTrips("isa");
			user.getTrips().clear();
			usersRepository.save(user);
			deleteTrip(trip);
			deleteUser("isa");
		}
	}
	
	@Test
	@WithMockUser("isa")
	public void testModifyNumberAvailableSeats() throws Exception {
		Trip trip = null;
		try {
			User user = createUser();
			trip = new Trip("CA", "ESI", OffsetDateTime.now(), 1, new BigDecimal(2), 0, user);
			Long idTrip = tripsRepository.save(trip).getId();
			
			mvc.perform(put("/trips/" + idTrip + "/numberAvailableSeats")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"newNumberAvailableSeats\": 2}")).andExpect(status().isOk());
			
			Collection<Trip> trips = (Collection<Trip>) tripsRepository.findAll();
			trip = trips.iterator().next();
			
			assertThat(trip.getNumberAvailableSeats(), equalTo(2));
		} finally {
			User user = usersRepository.findUserByUsernameWithTrips("isa");
			user.getTrips().clear();
			usersRepository.save(user);
			deleteTrip(trip);
			deleteUser("isa");
		}
	}
	
	@Test
	@WithMockUser("isa")
	public void testSearchTrips() throws Exception {
		Trip trip = null;
		try {
			User user = createUser();
			trip = new Trip("CA", "ESI", OffsetDateTime.parse("2017-07-21T19:32:28+02:00"), 1, new BigDecimal(2), 0, user);
			tripsRepository.save(trip);
			
			mvc.perform(get("/trips").param("arrivalPlace", "ESI")
					.param("departureDateTime", "2017-07-21T19:32:28+02:00")
					.param("departurePlace", "CA")
					.param("page", "0")
					.param("size", "25"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("\"arrivalPlace\":\"ESI\"")))
			.andExpect(content().string(containsString("\"departureDateTime\":\"2017-07-21T19:32:28+02:00\"")))
			.andExpect(content().string(containsString("\"departurePlace\":\"CA\"")))
			.andExpect(content().string(containsString("\"totalPages\":1")))
			.andExpect(content().string(containsString("\"totalPages\":1")));
			
		} finally {
			User user = usersRepository.findUserByUsernameWithTrips("isa");
			user.getTrips().clear();
			usersRepository.save(user);
			deleteTrip(trip);
			deleteUser("isa");
		}
	}

	private User createUser() {
		User user = new User("Isabel", "Duran", "isa", "$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq",
				LocalDate.parse("10/05/1996", formatter), GENDER_FEMALE, ROLE_USER);

		usersRepository.save(user);
		return user;
	}

	private void deleteTrip(Trip trip) {
		if (trip != null)
			tripsRepository.delete(trip);
	}

	private void deleteUser(String username) {
		User user = usersRepository.findUserByUsername(username);
		if (user != null)
			usersRepository.delete(user);
	}
}
