package unimoove.api.users;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import unimoove.users.User;
import unimoove.users.UsersRepository;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersApiControllerTest {

	private static final int ROLE_USER = 1;
	private static final int GENDER_FEMALE = 1;
	private static String currentUsername;

	@Autowired
	private MockMvc mvc;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Before
	public void before() throws Exception {
		addUser();
		currentUsername = "isa";
	}

	@Test
	public void testAddUser() throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = "16/08/2000";

		// convert String to LocalDate
		LocalDate localDate = LocalDate.parse(date, formatter);

		User user = new User("Isabel", "Duran", "isa", "$2y$11$QheqQcllDhUDCxpR7GXcE.Dh8BBGZZFft.ljptQtb6iZs9DGyLvnq",
				localDate, GENDER_FEMALE, ROLE_USER);

		User resultUser = usersRepository.findUserByUsername("isa");
		assertThat(resultUser.getName(), is(user.getName()));
		assertThat(resultUser.getLastname(), is(user.getLastname()));
		assertThat(resultUser.getUsername(), is(user.getUsername()));
		assertTrue(passwordEncoder.matches("1234", resultUser.getPassword()));
		assertThat(resultUser.getBirthdate(), is(user.getBirthdate()));
		assertThat(resultUser.getGender(), is(user.getGender()));
	}

	private void addUser() throws Exception {
		String registrationRequest = "{\n" + "  \"birthdate\": \"2000-08-16\",\n" + "  \"gender\": 1,\n"
				+ "  \"lastname\": \"Duran\",\n" + "  \"name\": \"Isabel\",\n" + "  \"password\": \"1234\",\n"
				+ "  \"role\": 1,\n" + "  \"username\": \"isa\"\n" + "}";
		mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(registrationRequest))
				.andExpect(status().isOk());
	}

	@Test
	public void testModifyUserName() throws Exception {
		mvc.perform(
				put("/users/isa/name")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"newName\": \"Pepa\" }")).andExpect(status().isOk());
		User resultUser = usersRepository.findUserByUsername("isa");
		assertThat(resultUser.getName(), is("Pepa"));

	}

	@Test
	public void testModifyUserLastname() throws Exception {
		mvc.perform(put("/users/isa/lastname")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"newLastname\": \"Diaz\" }")).andExpect(status().isOk());
		User userResult = usersRepository.findUserByUsername("isa");
		assertThat(userResult.getLastname(), is("Diaz"));

	}
	
	@Test
	public void testModifyUserBirthdate() throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		mvc.perform(put("/users/isa/birthdate")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"newBirthdate\": \"1996-05-10\" }")).andExpect(status().isOk());
		User resultUser = usersRepository.findUserByUsername("isa");
		assertThat(resultUser.getBirthdate(), is(LocalDate.parse("10/05/1996", formatter)));
	}
	
	@Test
	public void testModifyUserGender() throws Exception {
		mvc.perform(put("/users/isa/gender")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"newGender\": 0 }")).andExpect(status().isOk());
		User resultUser = usersRepository.findUserByUsername("isa");
		assertThat(resultUser.getGender(), is(0));
	}
	
	@Test
	public void testModifyUserPassword() throws Exception {
		mvc.perform(put("/users/isa/password")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"newPassword\": \"4321\" }")).andExpect(status().isOk());
		User resultUser = usersRepository.findUserByUsername("isa");
		assertTrue(passwordEncoder.matches("4321", resultUser.getPassword()));
		
	}
	
//	@Test
//	public void testModifyUserRole() throws Exception {
//		mvc.perform(put("/users/isa/role")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content("{ \"newRole\": 0 }")).andExpect(status().isOk());
//		User resultUser = usersRepository.findUserByUsername("isa");
//		assertThat(resultUser.getRole(), is(0));
//	}
	
	@Test
	public void testModifyUserUsername() throws Exception {
		currentUsername = "paca";
		mvc.perform(put("/users/isa/username")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"newUsername\": \"paca\" }")).andExpect(status().isOk());
		User resultUser = usersRepository.findUserByUsername("paca");
		assertThat(resultUser.getUsername(), is("paca"));
	}
	
	@Test
	public void testModifyUserUsernameWrong() throws Exception {
		mvc.perform(put("/users/paca/username")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"newUsername\": \"isa\" }")).andExpect(status().is4xxClientError());
	}
	
	
	
	@After
	public void after() {
		usersRepository.delete(usersRepository.findUserByUsername(currentUsername));
	}

}