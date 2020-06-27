package unimoove.api.users;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import unimoove.cars.Car;
import unimoove.cars.CarsRepository;
import unimoove.trips.Trip;
import unimoove.trips.TripsRepository;
import unimoove.users.User;
import unimoove.users.UsersRepository;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersApiControllerTest {

	private static final int ROLE_USER = 1;
	private static final int GENDER_FEMALE = 1;
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

	@Autowired
	private MockMvc mvc;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private CarsRepository carRepository;

	@Autowired
	private TripsRepository tripsRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	public void testAddUser() throws Exception {

		try {
			String registrationRequest = "{\n" + 
					"  \"birthdate\": \"1999-02-11\",\n" + 
					"  \"email\": \"isa@example.com\",\n" + 
					"  \"gender\": 1,\n" + 
					"  \"lastname\": \"Duran\",\n" + 
					"  \"name\": \"Isabel\",\n" + 
					"  \"password\": 1234,\n" + 
					"  \"role\": 1,\n" + 
					"  \"username\": \"isa\"\n" + 
					"}";
			mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(registrationRequest))
					.andExpect(status().isOk());

			User user = new User("Isabel", "Duran", "isa",
					"$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq", "isa@example.com",
					LocalDate.parse("11/02/1999", formatter), GENDER_FEMALE, ROLE_USER);

			User resultUser = usersRepository.findUserByUsername("isa");
			assertThat(resultUser.getName(), equalTo(user.getName()));
			assertThat(resultUser.getLastname(), equalTo(user.getLastname()));
			assertThat(resultUser.getUsername(), equalTo(user.getUsername()));
			assertTrue(passwordEncoder.matches("1234", resultUser.getPassword()));
			assertThat(resultUser.getBirthdate(), equalTo(user.getBirthdate()));
			assertThat(resultUser.getGender(), equalTo(user.getGender()));
			assertThat(resultUser.getEmail(), equalTo(user.getEmail()));
		} finally {
			deleteUser("isa");
		}

	}

	@Test
	@WithMockUser("isa")
	public void testModifyUserName() throws Exception {
		try {
			User user = new User("Isabel", "Duran", "isa",
					"$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq", "isa@example.com",
					LocalDate.parse("16/08/2000", formatter), GENDER_FEMALE, ROLE_USER);

			usersRepository.save(user).getEmail();

			mvc.perform(
					put("/users/isa/name").contentType(MediaType.APPLICATION_JSON).content("{ \"newName\": \"Pepa\" }"))
					.andExpect(status().isOk());
			User resultUser = usersRepository.findUserByUsername("isa");
			assertThat(resultUser.getName(), equalTo("Pepa"));

		} finally {
			deleteUser("isa");
		}

	}

	@Test
	@WithMockUser("isa")
	public void testModifyUserLastname() throws Exception {

		try {
			User user = new User("Isabel", "Duran", "isa",
					"$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq", "isa@example.com",
					LocalDate.parse("16/08/2000", formatter), GENDER_FEMALE, ROLE_USER);

			usersRepository.save(user);

			mvc.perform(put("/users/isa/lastname").contentType(MediaType.APPLICATION_JSON)
					.content("{ \"newLastname\": \"Diaz\" }")).andExpect(status().isOk());
			User userResult = usersRepository.findUserByUsername("isa");
			assertThat(userResult.getLastname(), equalTo("Diaz"));

		} finally {
			deleteUser("isa");
		}

	}

	@Test
	@WithMockUser("isa")
	public void testModifyUserBirthdate() throws Exception {

		try {
			User user = new User("Isabel", "Duran", "isa",
					"$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq", "isa@example.com",
					LocalDate.parse("16/08/2000", formatter), GENDER_FEMALE, ROLE_USER);

			usersRepository.save(user);
			mvc.perform(put("/users/isa/birthdate").contentType(MediaType.APPLICATION_JSON)
					.content("{ \"newBirthdate\": \"1996-05-10\" }")).andExpect(status().isOk());
			User resultUser = usersRepository.findUserByUsername("isa");
			assertThat(resultUser.getBirthdate(), equalTo(LocalDate.parse("10/05/1996", formatter)));

		} finally {
			deleteUser("isa");
		}
	}

	@Test
	@WithMockUser("isa")
	public void testModifyUserGender() throws Exception {
		try {
			User user = new User("Isabel", "Duran", "isa",
					"$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq", "isa@example.com",
					LocalDate.parse("16/08/2000", formatter), GENDER_FEMALE, ROLE_USER);

			usersRepository.save(user);
			mvc.perform(
					put("/users/isa/gender").contentType(MediaType.APPLICATION_JSON).content("{ \"newGender\": 0 }"))
					.andExpect(status().isOk());
			User resultUser = usersRepository.findUserByUsername("isa");
			assertThat(resultUser.getGender(), equalTo(0));

		} finally {
			deleteUser("isa");
		}
	}

	@Test
	@WithMockUser("isa")
	public void testModifyUserEmail() throws Exception {
		try {
			User user = new User("Isabel", "Duran", "isa",
					"$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq", "isa@example.com",
					LocalDate.parse("16/08/2000", formatter), GENDER_FEMALE, ROLE_USER);
			usersRepository.save(user);
			mvc.perform(
					put("/users/isa/email")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{ \"newEmail\": \"isabel@example.com\" }"))
					.andExpect(status().isOk());
			User resultUser = usersRepository.findUserByUsername("isa");
			assertThat(resultUser.getEmail(), equalTo("isabel@example.com"));

		} finally {
			deleteUser("isa");
		}
	}

	@Test
	@WithMockUser("isa")
	public void testModifyUserPassword() throws Exception {

		try {
			User user = new User("Isabel", "Duran", "isa",
					"$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq", "isa@example.com",
					LocalDate.parse("16/08/2000", formatter), GENDER_FEMALE, ROLE_USER);

			usersRepository.save(user);
			mvc.perform(put("/users/isa/password").contentType(MediaType.APPLICATION_JSON)
					.content("{ \"newPassword\": \"4321\" }")).andExpect(status().isOk());
			User resultUser = usersRepository.findUserByUsername("isa");
			assertTrue(passwordEncoder.matches("4321", resultUser.getPassword()));

		} finally {
			deleteUser("isa");
		}

	}

//	@Test
//	public void testModifyUserRole() throws Exception {
//		mvc.perform(put("/users/isa/role")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content("{ \"newRole\": 0 }")).andExpect(status().isOk());
//		User resultUser = usersRepository.findUserByUsername("isa");
//		assertThat(resultUser.getRole(), equalTo(0));
//	}

	@Test
	@WithMockUser("isa")
	public void testModifyUserUsername() throws Exception {

		try {
			User user = new User("Isabel", "Duran", "isa",
					"$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq", "isa@example.com",
					LocalDate.parse("16/08/2000", formatter), GENDER_FEMALE, ROLE_USER);

			usersRepository.save(user);
			mvc.perform(put("/users/isa/username").contentType(MediaType.APPLICATION_JSON)
					.content("{ \"newUsername\": \"paca\" }")).andExpect(status().isOk());
			User resultUser = usersRepository.findUserByUsername("paca");
			assertThat(resultUser.getUsername(), equalTo("paca"));

		} finally {
			deleteUser("paca");
			deleteUser("isa");
		}
	}

	@Test
	@WithMockUser("paca")
	public void testModifyUserUsernameWrong() throws Exception {

		try {
			User userA = new User("Isabel", "Duran", "isa",
					"$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq", "isa@example.com",
					LocalDate.parse("10/05/1996", formatter), GENDER_FEMALE, ROLE_USER);

			usersRepository.save(userA);

			User userB = new User("Francisca", "Diaz", "paca",
					"$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq", "paca@example.com",
					LocalDate.parse("10/05/1966", formatter), GENDER_FEMALE, ROLE_USER);

			usersRepository.save(userB);

			mvc.perform(put("/users/paca/username").contentType(MediaType.APPLICATION_JSON)
					.content("{ \"newUsername\": \"isa\" }")).andExpect(status().is(409));

		} finally {
			deleteUser("isa");
			deleteUser("paca");
		}
	}

	@Test
	@WithMockUser
	public void testAddCar() throws Exception {
		try {
			User user = new User("Isabel", "Duran", "isa",
					"$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq", "isa@example.com",
					LocalDate.parse("16/08/2000", formatter), GENDER_FEMALE, ROLE_USER);

			usersRepository.save(user);

			String carRegistrationRequest = "{  \"brand\": \"Fiat\", \"model\": \"Marea Weekend\", \"plate\": \"9268BAR\", \"seats\": 5}";
			mvc.perform(post("/users/isa/cars").contentType(MediaType.APPLICATION_JSON).content(carRegistrationRequest))
					.andExpect(status().isOk());

			Car car = new Car("9268BAR", "Fiat", "Marea Weekend", 5);
			Car resultCar = carRepository.findByPlate("9268BAR");

			assertThat(resultCar.getPlate(), equalTo(car.getPlate()));
			assertThat(resultCar.getBrand(), equalTo(car.getBrand()));
			assertThat(resultCar.getModel(), equalTo(car.getModel()));
			assertThat(resultCar.getSeats(), equalTo(car.getSeats()));

		} finally {
			deleteUser("isa");
			deleteCar("9268BAR");
		}
	}

	@Test
	@WithMockUser
	public void testModifyCarBrand() throws Exception {
		try {
			User user = usersRepository.save(
					new User("Isabel", "Duran", "isa", "$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq",
							"isa@example.com", LocalDate.parse("10/05/1996", formatter), GENDER_FEMALE, ROLE_USER));
			user.setCars(new HashSet<Car>());

			Car car = carRepository.save(new Car("9268BAR", "Fiat", "Marea", 5));
			user.getCars().add(car);
			usersRepository.save(user);

			mvc.perform(put("/users/isa/cars/9268BAR/brand").contentType(MediaType.APPLICATION_JSON)
					.content("{ \"newBrand\": \"Ford\" }")).andExpect(status().isOk());
			Car resultCar = carRepository.findByPlate("9268BAR");
			assertThat(resultCar.getBrand(), equalTo("Ford"));

		} finally {
			deleteUser("isa");
			deleteCar("9268BAR");
		}
	}

	@Test
	@WithMockUser
	public void testModifyCarModel() throws Exception {
		try {
			User user = usersRepository.save(
					new User("Isabel", "Duran", "isa", "$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq",
							"isa@example.com", LocalDate.parse("10/05/1996", formatter), GENDER_FEMALE, ROLE_USER));
			user.setCars(new HashSet<Car>());

			Car car = carRepository.save(new Car("9268BAR", "Fiat", "Marea", 5));
			user.getCars().add(car);
			usersRepository.save(user);
			mvc.perform(put("/users/isa/cars/9268BAR/model").contentType(MediaType.APPLICATION_JSON)
					.content("{ \"newModel\": \"Fiesta\"}")).andExpect(status().isOk());
			Car resultCar = carRepository.findByPlate("9268BAR");
			assertThat(resultCar.getModel(), equalTo("Fiesta"));

		} finally {
			deleteUser("isa");
			deleteCar("9268BAR");
		}
	}

	@Test
	@WithMockUser
	public void testThatWhenAUserIsDeletedTheirCarsAreDeleted() throws Exception {
		try {
			User user = usersRepository.save(
					new User("Isabel", "Duran", "isa", "$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq",
							"isa@example.com", LocalDate.parse("10/05/1996", formatter), GENDER_FEMALE, ROLE_USER));
			user.setCars(new HashSet<Car>());

			Car carA = carRepository.save(new Car("9268BAR", "Fiat", "Marea", 5));
			user.getCars().add(carA);

			Car carB = carRepository.save(new Car("1111CAC", "Ford", "Fiesta", 5));
			user.getCars().add(carB);

			usersRepository.save(user);

			mvc.perform(delete("/users/isa")).andExpect(status().isOk());
			assertTrue(usersRepository.findUserByUsername("isa") == null);
			assertTrue(carRepository.findByPlate("9268BAR") == null);
			assertTrue(carRepository.findByPlate("1111CCC") == null);

		} finally {
			deleteUser("isa");
			deleteCar("9268BAR");
			deleteCar("1111CCC");
		}
	}

	@Test
	@WithMockUser
	public void testThatAUserCantHaveMoreThan5Cars() throws Exception {
		try {
			User user = usersRepository.save(
					new User("Isabel", "Duran", "isa", "$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq",
							"isa@example.com", LocalDate.parse("10/05/1996", formatter), GENDER_FEMALE, ROLE_USER));
			user.setCars(new HashSet<Car>());

			Car carA = carRepository.save(new Car("9268BAR", "Fiat", "Marea", 5));
			user.getCars().add(carA);

			Car carB = carRepository.save(new Car("0001BOB", "Peugot", "208", 5));
			user.getCars().add(carB);

			Car carC = carRepository.save(new Car("1244JPG", "Citröen", "C4", 5));
			user.getCars().add(carC);

			Car carD = carRepository.save(new Car("1478PEP", "Seat", "León", 5));
			user.getCars().add(carD);

			Car carE = carRepository.save(new Car("5678JPG", "Opel", "Corsa", 7));
			user.getCars().add(carE);

			usersRepository.save(user);

			String carRegistrationRequest = "{  \"brand\": \"Fiat\", \"model\": \"Marea Weekend\", \"plate\": \"9632BOB\", \"seats\": 5}";
			mvc.perform(post("/users/isa/cars").contentType(MediaType.APPLICATION_JSON).content(carRegistrationRequest))
					.andExpect(status().is(409));

		} finally {
			deleteUser("isa");
			deleteCar("9268BAR");
			deleteCar("0001BOB");
			deleteCar("1244JPG");
			deleteCar("1478PEP");
			deleteCar("5678JPG");
			deleteCar("9632BOB");
		}
	}

	@Test
	@WithMockUser
	public void testCantAddTwoCarsWithSamePlate() throws Exception {
		try {
			User user = usersRepository.save(
					new User("Isabel", "Duran", "isa", "$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq",
							"isa@example.com", LocalDate.parse("10/05/1996", formatter), GENDER_FEMALE, ROLE_USER));
			user.setCars(new HashSet<Car>());

			Car carA = carRepository.save(new Car("9268BAR", "Fiat", "Marea", 5));
			user.getCars().add(carA);

			usersRepository.save(user);

			String carRegistrationRequest = "{  \"brand\": \"Fiat\", \"model\": \"Marea Weekend\", \"plate\": \"9268BAR\", \"seats\": 5}";
			mvc.perform(post("/users/isa/cars").contentType(MediaType.APPLICATION_JSON).content(carRegistrationRequest))
					.andExpect(status().is(409));

		} finally {
			deleteUser("isa");
			deleteCar("9268BAR");
		}
	}

	@Test
	@WithMockUser
	public void testCantAddTwoUsersWithSameUsername() throws Exception {
		try {
			User user = usersRepository.save(
					new User("Isabel", "Duran", "isa", "$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq",
							"isa@example.com", LocalDate.parse("10/05/1996", formatter), GENDER_FEMALE, ROLE_USER));

			String registrationRequest = "{\n" + 
					"  \"birthdate\": \"1999-01-01\",\n" + 
					"  \"email\": \"isa@example.com\",\n" + 
					"  \"gender\": 0,\n" + 
					"  \"lastname\": \"Duran\",\n" + 
					"  \"name\": \"Isabel\",\n" + 
					"  \"password\": 1234,\n" + 
					"  \"role\": 1,\n" + 
					"  \"username\": \"isa\"\n" + 
					"}";
			mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(registrationRequest))
					.andExpect(status().is(409));

		} finally {
			deleteUser("isa");
		}
	}

	@Test
	@WithMockUser("isa")
	public void testGetUserTrips() throws Exception {
		Trip trip = null;
		try {
			User user = new User("Isabel", "Duran", "isa",
					"$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq", "isa@example.com",
					LocalDate.parse("16/08/2000", formatter), GENDER_FEMALE, ROLE_USER);

			usersRepository.save(user);
			trip = new Trip("CA", "ESI", OffsetDateTime.parse("2017-07-21T19:32:28+02:00"), 1, new BigDecimal(2), 0,
					user);
			tripsRepository.save(trip);

			mvc.perform(get("/users/isa/trips").param("page", "0").param("size", "25")).andExpect(status().isOk())
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

	private void deleteUser(String username) {
		User user = usersRepository.findUserByUsername(username);
		if (user != null)
			usersRepository.delete(user);
	}

	private void deleteCar(String plate) {
		Car car = carRepository.findByPlate(plate);
		if (car != null)
			carRepository.delete(car);
	}

	private void deleteTrip(Trip trip) {
		if (trip != null)
			tripsRepository.delete(trip);
	}

}