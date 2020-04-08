package unimoove.api.reservations;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import unimoove.reservations.Reservation;
import unimoove.reservations.ReservationsRepository;
import unimoove.trips.Trip;
import unimoove.trips.TripsRepository;
import unimoove.users.User;
import unimoove.users.UsersRepository;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationsApiControllerTest {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	private static final int ROLE_USER = 1;
	private static final int GENDER_FEMALE = 1;
	private static final int STATUS_PENDING = 0;

	@Autowired
	private MockMvc mvc;

	@Autowired
	private TripsRepository tripsRepository;

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private ReservationsRepository reservationsRepository;
	
	@Test
	@WithMockUser("isa")
	public void testAddReservation() throws Exception {
		Trip trip = null;
		Reservation reservation = null;
		try {
			User user = createUser();
			trip = new Trip("CA", "ESI", OffsetDateTime.now(), 1, new BigDecimal(2), 0, user);
			Long idTrip = tripsRepository.save(trip).getId();
			
			mvc.perform(post("/reservations")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"idTrip\": " + idTrip +"}"))
			.andExpect(status().isOk());
			
			Collection<Reservation> reservations = (Collection<Reservation>) reservationsRepository.findAll();
			reservation = reservations.iterator().next();
			
			assertThat(reservation.getStatus(), equalTo(0));
			assertThat(reservation.getTrip().getId(), equalTo(trip.getId()));
			
		} finally {
			tripsRepository.save(trip);
			User user = usersRepository.findUserByUsernameWithTrips("isa");
			user.getTrips().clear();
			usersRepository.save(user);
			user = usersRepository.findUserByUsernameWithReservations("isa");
			user.getReservations().clear();
			usersRepository.save(user);
			deleteReservation(reservation);
			deleteTrip(trip);
			deleteUser("isa");
		}
	}
	
	@Test
	@WithMockUser("isa")
	public void testDeleteReservation() throws Exception {
		Trip trip = null;
		Reservation reservation = null;
		try {
			User user = createUser();
			trip = new Trip("CA", "ESI", OffsetDateTime.now(), 1, new BigDecimal(2), 0, user);
			tripsRepository.save(trip).getId();
			reservation = new Reservation(OffsetDateTime.now(), STATUS_PENDING, trip);
			Long idReservation = reservationsRepository.save(reservation).getId();
			mvc.perform(delete("/reservations/" + idReservation)).andExpect(status().isOk());
			
			Collection<Reservation> reservations = (Collection<Reservation>) reservationsRepository.findAll();
			
			assertThat(reservations.isEmpty(), equalTo(true));
			
		} finally {
			tripsRepository.save(trip);
			User user = usersRepository.findUserByUsernameWithTrips("isa");
			user.getTrips().clear();
			usersRepository.save(user);
			user = usersRepository.findUserByUsernameWithReservations("isa");
			user.getReservations().clear();
			usersRepository.save(user);
			deleteReservation(reservation);
			deleteTrip(trip);
			deleteUser("isa");
		}
	}
	
	private User createUser() {
		User user = new User("Isabel", "Duran", "isa", "$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq", 
				"isa@example.com",
				LocalDate.parse("10/05/1996", formatter), GENDER_FEMALE, ROLE_USER);

		usersRepository.save(user);
		return user;
	}
	
	private void deleteReservation(Reservation reservation) {
		if(reservation != null)
			reservationsRepository.delete(reservation);
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
