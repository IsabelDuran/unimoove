package unimoove.api;

import unimoove.api.dto.ReservationPaginatedResponse;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T21:12:55.470+01:00[Europe/Madrid]")
@Controller
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
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

}
