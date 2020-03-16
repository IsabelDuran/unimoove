package unimoove.api.users;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import unimoove.api.reservations.ReservationPaginatedResponse;
import unimoove.api.trips.TripPaginatedResponse;
import unimoove.users.UniqueUsernameException;
import unimoove.users.User;
import unimoove.users.UserMapper;
import unimoove.users.UserService;

@Controller
public class UsersApiController implements UsersApi {

	private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

	private final ObjectMapper objectMapper;

	private UserService userService;

	private final HttpServletRequest request;

	@Autowired
	public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request, UserService userService) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.userService = userService;
	}

	@Override
	public Optional<ObjectMapper> getObjectMapper() {
		return Optional.ofNullable(objectMapper);
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	public ResponseEntity<Void> addCar(@ApiParam(value = "", required = true) @PathVariable("username") String username,
			@ApiParam(value = "Car to add") @Valid @RequestBody CarCreationRequest body) {
		request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> addUser(
			@ApiParam(value = "User to add") @Valid @RequestBody UserRegistrationRequest body)
			throws UniqueUsernameException {
		userService.registerUser(body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> deleteCar(
			@ApiParam(value = "", required = true) @PathVariable("username") String username,
			@ApiParam(value = "By passing in the appropriate car plate, you can delete the car.", required = true) @PathVariable("plate") String plate) {
		request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> deleteUser(
			@ApiParam(value = "By passing in the appropriate username, you can delete the user.", required = true) @PathVariable("username") String username)
			throws IllegalArgumentException {
		userService.deleteUser(username);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<UserResponse> getUser(
			@ApiParam(value = "By passing in the appropriate username, you can get the user.", required = true) @PathVariable("username") String username)
			throws EntityNotFoundException {
		return new ResponseEntity<UserResponse>(userService.getUserByUsername(username), HttpStatus.OK);
	}

	public ResponseEntity<Void> modifyCarBrand(
			@ApiParam(value = "", required = true) @PathVariable("username") String username,
			@ApiParam(value = "By passing in the appropriate car plate, you can modify the car.", required = true) @PathVariable("plate") String plate,
			@ApiParam(value = "The car's new brand") @Valid @RequestBody CarBrandChangeRequest body) {
		request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> modifyCarModel(
			@ApiParam(value = "", required = true) @PathVariable("username") String username,
			@ApiParam(value = "By passing in the appropriate car plate, you can modify the car.", required = true) @PathVariable("plate") String plate,
			@ApiParam(value = "The car's new model") @Valid @RequestBody CarModelChangeRequest body) {
		request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> modifyUserBirthdate(
			@ApiParam(value = "", required = true) @PathVariable("username") String username,
			@ApiParam(value = "The new user's birthdate") @Valid @RequestBody UserBirthdateChangeRequest body) {
		request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> modifyUserEmail(
			@ApiParam(value = "", required = true) @PathVariable("username") String username,
			@ApiParam(value = "The new user's email") @Valid @RequestBody UserEmailChangeRequest body) {
		request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> modifyUserGender(
			@ApiParam(value = "", required = true) @PathVariable("username") String username,
			@ApiParam(value = "The new user's gender") @Valid @RequestBody UserGenderChangeRequest body) {
		request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> modifyUserLastname(
			@ApiParam(value = "", required = true) @PathVariable("username") String username,
			@ApiParam(value = "The new user's lastname") @Valid @RequestBody UserLastnameChangeRequest body) {
		request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> modifyUserName(
			@ApiParam(value = "", required = true) @PathVariable("username") String username,
			@ApiParam(value = "The new user's name") @Valid @RequestBody UserNameChangeRequest body) {
		request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> modifyUserPassword(
			@ApiParam(value = "", required = true) @PathVariable("username") String username,
			@ApiParam(value = "The new user's password") @Valid @RequestBody UserPasswordChangeRequest body) {
		request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> modifyUserRole(
			@ApiParam(value = "", required = true) @PathVariable("username") String username,
			@ApiParam(value = "The new user's role") @Valid @RequestBody UserRoleChangeRequest body) {
		request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> modifyUserUsername(
			@ApiParam(value = "", required = true) @PathVariable("username") String username,
			@ApiParam(value = "The new user's username") @Valid @RequestBody UserUsernameChangeRequest body) {
		request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ReservationPaginatedResponse> obtainReservations(
			@ApiParam(value = "", required = true) @PathVariable("username") String username,
			@ApiParam(value = "the number of the page") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "the number of element per page") @Valid @RequestParam(value = "size", required = false) Integer size) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ReservationPaginatedResponse>(objectMapper.readValue(
						"{\n  \"pages\" : [ {\n    \"trip\" : {\n      \"price\" : 1.0,\n      \"arrivalPlace\" : \"ESI\",\n      \"departureDateTime\" : \"2017-07-21T17:32:28Z\",\n      \"id\" : 1,\n      \"state\" : 0,\n      \"departurePlace\" : \"CA\"\n    },\n    \"reservationId\" : 1,\n    \"dateTimeReservation\" : \"2017-07-21T17:32:28Z\",\n    \"status\" : 0\n  }, {\n    \"trip\" : {\n      \"price\" : 1.0,\n      \"arrivalPlace\" : \"ESI\",\n      \"departureDateTime\" : \"2017-07-21T17:32:28Z\",\n      \"id\" : 1,\n      \"state\" : 0,\n      \"departurePlace\" : \"CA\"\n    },\n    \"reservationId\" : 1,\n    \"dateTimeReservation\" : \"2017-07-21T17:32:28Z\",\n    \"status\" : 0\n  } ],\n  \"paginationInfo\" : {\n    \"totalPages\" : 0,\n    \"totalElements\" : 6\n  }\n}",
						ReservationPaginatedResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ReservationPaginatedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ReservationPaginatedResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<TripPaginatedResponse> obtainTrips(
			@ApiParam(value = "", required = true) @PathVariable("username") String username,
			@ApiParam(value = "the number of the page") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "the number of element per page") @Valid @RequestParam(value = "size", required = false) Integer size) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<TripPaginatedResponse>(objectMapper.readValue(
						"{\n  \"pages\" : [ {\n    \"price\" : 1.0,\n    \"arrivalPlace\" : \"ESI\",\n    \"numberAvailableSeats\" : 2,\n    \"departureDateTime\" : \"2017-07-21T17:32:28Z\",\n    \"id\" : 1,\n    \"state\" : 0,\n    \"departurePlace\" : \"CA\"\n  }, {\n    \"price\" : 1.0,\n    \"arrivalPlace\" : \"ESI\",\n    \"numberAvailableSeats\" : 2,\n    \"departureDateTime\" : \"2017-07-21T17:32:28Z\",\n    \"id\" : 1,\n    \"state\" : 0,\n    \"departurePlace\" : \"CA\"\n  } ],\n  \"paginationInfo\" : {\n    \"totalPages\" : 0,\n    \"totalElements\" : 6\n  }\n}",
						TripPaginatedResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<TripPaginatedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<TripPaginatedResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<CarResponse>> searchCar(
			@ApiParam(value = "", required = true) @PathVariable("username") String username) {

		return new ResponseEntity<List<CarResponse>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<UserPaginatedResponse>> searchUser(
			@ApiParam(value = "the username to be searched") @Valid @RequestParam(value = "username", required = false) String username,
			@ApiParam(value = "the number of the page") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "the number of element per page") @Valid @RequestParam(value = "size", required = false) Integer size) {

		return new ResponseEntity<List<UserPaginatedResponse>>(HttpStatus.NOT_IMPLEMENTED);
	}

}
