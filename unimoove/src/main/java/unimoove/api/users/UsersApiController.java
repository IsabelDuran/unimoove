package unimoove.api;

import unimoove.api.dto.CarBrandChangeRequest;
import unimoove.api.dto.CarCreationRequest;
import unimoove.api.dto.CarModelChangeRequest;
import unimoove.api.dto.CarResponse;
import unimoove.api.dto.ReservationPaginatedResponse;
import unimoove.api.dto.TripPaginatedResponse;
import unimoove.api.dto.UserBirthdateChangeRequest;
import unimoove.api.dto.UserEmailChangeRequest;
import unimoove.api.dto.UserGenderChangeRequest;
import unimoove.api.dto.UserLastnameChangeRequest;
import unimoove.api.dto.UserNameChangeRequest;
import unimoove.api.dto.UserPaginatedResponse;
import unimoove.api.dto.UserPasswordChangeRequest;
import unimoove.api.dto.UserRegistrationRequest;
import unimoove.api.dto.UserResponse;
import unimoove.api.dto.UserRoleChangeRequest;
import unimoove.api.dto.UserUsernameChangeRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T21:29:59.978+01:00[Europe/Madrid]")
@Controller
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addCar(@ApiParam(value = "",required=true) @PathVariable("username") String username
,@ApiParam(value = "Car to add"  )  @Valid @RequestBody CarCreationRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> addUser(@ApiParam(value = "User to add"  )  @Valid @RequestBody UserRegistrationRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteCar(@ApiParam(value = "",required=true) @PathVariable("username") String username
,@ApiParam(value = "By passing in the appropriate car plate, you can delete the car.",required=true) @PathVariable("plate") String plate
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteUser(@ApiParam(value = "By passing in the appropriate username, you can delete the user.",required=true) @PathVariable("username") String username
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UserResponse> getUser(@ApiParam(value = "By passing in the appropriate username, you can get the user.",required=true) @PathVariable("username") String username
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UserResponse>(objectMapper.readValue("{\n  \"birthdate\" : \"2000-01-23\",\n  \"role\" : \"user\",\n  \"gender\" : \"male\",\n  \"name\" : \"John\",\n  \"username\" : \"johndoe\",\n  \"lastname\" : \"Doe\"\n}", UserResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyCarBrand(@ApiParam(value = "",required=true) @PathVariable("username") String username
,@ApiParam(value = "By passing in the appropriate car plate, you can modify the car.",required=true) @PathVariable("plate") String plate
,@ApiParam(value = "The car's new brand"  )  @Valid @RequestBody CarBrandChangeRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyCarModel(@ApiParam(value = "",required=true) @PathVariable("username") String username
,@ApiParam(value = "By passing in the appropriate car plate, you can modify the car.",required=true) @PathVariable("plate") String plate
,@ApiParam(value = "The car's new model"  )  @Valid @RequestBody CarModelChangeRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyUserBirthdate(@ApiParam(value = "",required=true) @PathVariable("username") String username
,@ApiParam(value = "The new user's birthdate"  )  @Valid @RequestBody UserBirthdateChangeRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyUserEmail(@ApiParam(value = "",required=true) @PathVariable("username") String username
,@ApiParam(value = "The new user's email"  )  @Valid @RequestBody UserEmailChangeRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyUserGender(@ApiParam(value = "",required=true) @PathVariable("username") String username
,@ApiParam(value = "The new user's gender"  )  @Valid @RequestBody UserGenderChangeRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyUserLastname(@ApiParam(value = "",required=true) @PathVariable("username") String username
,@ApiParam(value = "The new user's lastname"  )  @Valid @RequestBody UserLastnameChangeRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyUserName(@ApiParam(value = "",required=true) @PathVariable("username") String username
,@ApiParam(value = "The new user's name"  )  @Valid @RequestBody UserNameChangeRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyUserPassword(@ApiParam(value = "",required=true) @PathVariable("username") String username
,@ApiParam(value = "The new user's password"  )  @Valid @RequestBody UserPasswordChangeRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyUserRole(@ApiParam(value = "",required=true) @PathVariable("username") String username
,@ApiParam(value = "The new user's role"  )  @Valid @RequestBody UserRoleChangeRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyUserUsername(@ApiParam(value = "",required=true) @PathVariable("username") String username
,@ApiParam(value = "The new user's username"  )  @Valid @RequestBody UserUsernameChangeRequest body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ReservationPaginatedResponse> obtainReservations(@ApiParam(value = "",required=true) @PathVariable("username") String username
,@ApiParam(value = "the number of the page") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "the number of element per page") @Valid @RequestParam(value = "size", required = false) Integer size
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ReservationPaginatedResponse>(objectMapper.readValue("{\n  \"pages\" : [ {\n    \"trip\" : {\n      \"price\" : 1.0,\n      \"arrivalPlace\" : \"ESI\",\n      \"departureDateTime\" : \"2017-07-21T17:32:28Z\",\n      \"id\" : 1,\n      \"state\" : \"Avalible\",\n      \"departurePlace\" : \"CA\"\n    },\n    \"reservationId\" : 1,\n    \"dateTimeReservation\" : \"2017-07-21T17:32:28Z\",\n    \"status\" : \"pending\"\n  }, {\n    \"trip\" : {\n      \"price\" : 1.0,\n      \"arrivalPlace\" : \"ESI\",\n      \"departureDateTime\" : \"2017-07-21T17:32:28Z\",\n      \"id\" : 1,\n      \"state\" : \"Avalible\",\n      \"departurePlace\" : \"CA\"\n    },\n    \"reservationId\" : 1,\n    \"dateTimeReservation\" : \"2017-07-21T17:32:28Z\",\n    \"status\" : \"pending\"\n  } ],\n  \"paginationInfo\" : {\n    \"totalPages\" : 0,\n    \"totalElements\" : 6\n  }\n}", ReservationPaginatedResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ReservationPaginatedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ReservationPaginatedResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TripPaginatedResponse> obtainTrips(@ApiParam(value = "",required=true) @PathVariable("username") String username
,@ApiParam(value = "the number of the page") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "the number of element per page") @Valid @RequestParam(value = "size", required = false) Integer size
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TripPaginatedResponse>(objectMapper.readValue("{\n  \"pages\" : [ {\n    \"price\" : 1.0,\n    \"arrivalPlace\" : \"ESI\",\n    \"numberAvailableSeats\" : 2,\n    \"departureDateTime\" : \"2017-07-21T17:32:28Z\",\n    \"id\" : 1,\n    \"state\" : \"Avalible\",\n    \"departurePlace\" : \"CA\"\n  }, {\n    \"price\" : 1.0,\n    \"arrivalPlace\" : \"ESI\",\n    \"numberAvailableSeats\" : 2,\n    \"departureDateTime\" : \"2017-07-21T17:32:28Z\",\n    \"id\" : 1,\n    \"state\" : \"Avalible\",\n    \"departurePlace\" : \"CA\"\n  } ],\n  \"paginationInfo\" : {\n    \"totalPages\" : 0,\n    \"totalElements\" : 6\n  }\n}", TripPaginatedResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TripPaginatedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TripPaginatedResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<CarResponse>> searchCar(@ApiParam(value = "",required=true) @PathVariable("username") String username
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<CarResponse>>(objectMapper.readValue("[ {\n  \"plate\" : \"9268 BAR\",\n  \"model\" : \"Marea Weekend\",\n  \"brand\" : \"Fiat\",\n  \"seats\" : 5\n}, {\n  \"plate\" : \"9268 BAR\",\n  \"model\" : \"Marea Weekend\",\n  \"brand\" : \"Fiat\",\n  \"seats\" : 5\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<CarResponse>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<CarResponse>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<UserPaginatedResponse>> searchUser(@ApiParam(value = "the username to be searched") @Valid @RequestParam(value = "username", required = false) String username
,@ApiParam(value = "the number of the page") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "the number of element per page") @Valid @RequestParam(value = "size", required = false) Integer size
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<UserPaginatedResponse>>(objectMapper.readValue("[ {\n  \"pages\" : [ {\n    \"birthdate\" : \"2000-01-23\",\n    \"role\" : \"user\",\n    \"gender\" : \"male\",\n    \"name\" : \"John\",\n    \"username\" : \"johndoe\",\n    \"lastname\" : \"Doe\"\n  }, {\n    \"birthdate\" : \"2000-01-23\",\n    \"role\" : \"user\",\n    \"gender\" : \"male\",\n    \"name\" : \"John\",\n    \"username\" : \"johndoe\",\n    \"lastname\" : \"Doe\"\n  } ],\n  \"paginationInfo\" : {\n    \"totalPages\" : 0,\n    \"totalElements\" : 6\n  }\n}, {\n  \"pages\" : [ {\n    \"birthdate\" : \"2000-01-23\",\n    \"role\" : \"user\",\n    \"gender\" : \"male\",\n    \"name\" : \"John\",\n    \"username\" : \"johndoe\",\n    \"lastname\" : \"Doe\"\n  }, {\n    \"birthdate\" : \"2000-01-23\",\n    \"role\" : \"user\",\n    \"gender\" : \"male\",\n    \"name\" : \"John\",\n    \"username\" : \"johndoe\",\n    \"lastname\" : \"Doe\"\n  } ],\n  \"paginationInfo\" : {\n    \"totalPages\" : 0,\n    \"totalElements\" : 6\n  }\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<UserPaginatedResponse>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<UserPaginatedResponse>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
