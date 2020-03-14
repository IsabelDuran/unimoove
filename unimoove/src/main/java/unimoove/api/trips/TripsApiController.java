package unimoove.api.trips;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.io.IOException;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-14T00:59:07.824+01:00[Europe/Madrid]")
@Controller
public class TripsApiController implements TripsApi {

    private static final Logger log = LoggerFactory.getLogger(TripsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TripsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<Void> addTrip(@ApiParam(value = "Trip to add"  )  @Valid @RequestBody TripCreationRequest body
) {
        request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteTrip(@ApiParam(value = "By passing in the appropriate trip ID, you can delete the trip.",required=true) @PathVariable("idTrip") String idTrip
) {
        request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyTripArrivalPlace(@ApiParam(value = "",required=true) @PathVariable("idTrip") String idTrip
,@ApiParam(value = "The trip's new arrival place"  )  @Valid @RequestBody TripArrivalPlaceChangeRequest body
) {
        request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyTripDepartureDateTime(@ApiParam(value = "",required=true) @PathVariable("idTrip") String idTrip
,@ApiParam(value = "The trip's new departure date and time"  )  @Valid @RequestBody TripDepartureDateTimeChangeRequest body
) {
        request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyTripDeparturePlace(@ApiParam(value = "",required=true) @PathVariable("idTrip") String idTrip
,@ApiParam(value = "The trip's new departure place"  )  @Valid @RequestBody TripDeparturePlaceChangeRequest body
) {
        request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> modifyTripNumberAvailableSeats(@ApiParam(value = "",required=true) @PathVariable("idTrip") String idTrip
,@ApiParam(value = "The trip's new number of available seats"  )  @Valid @RequestBody TripNumberAvailableSeatsChangeRequest body
) {
        request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TripPaginatedResponse> searchTrips(@ApiParam(value = "the departure place for the trip") @Valid @RequestParam(value = "departurePlace", required = false) String departurePlace
,@ApiParam(value = "the arrival place for the trip") @Valid @RequestParam(value = "arrivalPlace", required = false) String arrivalPlace
,@ApiParam(value = "the departure time for the trip") @Valid @RequestParam(value = "departureDateTime", required = false) String departureDateTime
,@ApiParam(value = "the number of the page") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "the number of element per page") @Valid @RequestParam(value = "size", required = false) Integer size
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TripPaginatedResponse>(objectMapper.readValue("{\n  \"pages\" : [ {\n    \"price\" : 1.0,\n    \"arrivalPlace\" : \"ESI\",\n    \"numberAvailableSeats\" : 2,\n    \"departureDateTime\" : \"2017-07-21T17:32:28Z\",\n    \"id\" : 1,\n    \"state\" : 0,\n    \"departurePlace\" : \"CA\"\n  }, {\n    \"price\" : 1.0,\n    \"arrivalPlace\" : \"ESI\",\n    \"numberAvailableSeats\" : 2,\n    \"departureDateTime\" : \"2017-07-21T17:32:28Z\",\n    \"id\" : 1,\n    \"state\" : 0,\n    \"departurePlace\" : \"CA\"\n  } ],\n  \"paginationInfo\" : {\n    \"totalPages\" : 0,\n    \"totalElements\" : 6\n  }\n}", TripPaginatedResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TripPaginatedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TripPaginatedResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
