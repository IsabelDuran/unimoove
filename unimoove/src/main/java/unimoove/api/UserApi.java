/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.19-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package unimoove.api;

import unimoove.api.dto.ReservationPaginatedResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T23:33:47.450+01:00[Europe/Madrid]")
@Api(value = "user", description = "the user API")
public interface UserApi {

    Logger log = LoggerFactory.getLogger(UserApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Obtains the trips reserved by the user", nickname = "obtainReservations", notes = "", response = ReservationPaginatedResponse.class, authorizations = {
        @Authorization(value = "ApiKeyAuth")    }, tags={ "Reservations", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The search was successfull", response = ReservationPaginatedResponse.class),
        @ApiResponse(code = 401, message = "The requested page needs a username and a password"),
        @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/user/reservations/{username}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<ReservationPaginatedResponse> obtainReservations(@ApiParam(value = "",required=true) @PathVariable("username") String username
,@ApiParam(value = "the number of the page") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "the number of element per page") @Valid @RequestParam(value = "size", required = false) Integer size
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"pages\" : [ {\n    \"trip\" : {\n      \"price\" : 1.0,\n      \"arrivalPlace\" : \"ESI\",\n      \"departureDateTime\" : \"2017-07-21T17:32:28Z\",\n      \"id\" : 1,\n      \"state\" : 0,\n      \"departurePlace\" : \"CA\"\n    },\n    \"reservationId\" : 1,\n    \"dateTimeReservation\" : \"2017-07-21T17:32:28Z\",\n    \"status\" : 0\n  }, {\n    \"trip\" : {\n      \"price\" : 1.0,\n      \"arrivalPlace\" : \"ESI\",\n      \"departureDateTime\" : \"2017-07-21T17:32:28Z\",\n      \"id\" : 1,\n      \"state\" : 0,\n      \"departurePlace\" : \"CA\"\n    },\n    \"reservationId\" : 1,\n    \"dateTimeReservation\" : \"2017-07-21T17:32:28Z\",\n    \"status\" : 0\n  } ],\n  \"paginationInfo\" : {\n    \"totalPages\" : 0,\n    \"totalElements\" : 6\n  }\n}", ReservationPaginatedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UserApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
