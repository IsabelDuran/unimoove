package unimoove.api.trips;

import java.util.Optional;

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

import io.swagger.annotations.ApiParam;
import unimoove.trips.TripsService;

@Controller
public class TripsApiController implements TripsApi {

	private static final Logger log = LoggerFactory.getLogger(TripsApiController.class);

	private final HttpServletRequest request;

	private TripsService tripsService;

	@Autowired
	public TripsApiController(HttpServletRequest request, TripsService tripsService) {
		super();
		this.request = request;
		this.tripsService = tripsService;
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	public ResponseEntity<Void> addTrip(@ApiParam(value = "Trip to add") @Valid @RequestBody TripCreationRequest body) {
		tripsService.addTrip(body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> deleteTrip(
			@ApiParam(value = "By passing in the appropriate trip ID, you can delete the trip.", required = true) @PathVariable("idTrip") String idTrip) {
		tripsService.deleteTrip(idTrip);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> modifyTripArrivalPlace(
			@ApiParam(value = "", required = true) @PathVariable("idTrip") String idTrip,
			@ApiParam(value = "The trip's new arrival place") @Valid @RequestBody TripArrivalPlaceChangeRequest body) {
		tripsService.modifyTripArrivalPlace(body, idTrip);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> modifyTripDepartureDateTime(
			@ApiParam(value = "", required = true) @PathVariable("idTrip") String idTrip,
			@ApiParam(value = "The trip's new departure date and time") @Valid @RequestBody TripDepartureDateTimeChangeRequest body) {
		tripsService.modifyTripDepartureDateTime(body, idTrip);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> modifyTripDeparturePlace(
			@ApiParam(value = "", required = true) @PathVariable("idTrip") String idTrip,
			@ApiParam(value = "The trip's new departure place") @Valid @RequestBody TripDeparturePlaceChangeRequest body) {
		tripsService.modifyTripDeparturePlace(body, idTrip);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> modifyTripNumberAvailableSeats(
			@ApiParam(value = "", required = true) @PathVariable("idTrip") String idTrip,
			@ApiParam(value = "The trip's new number of available seats") @Valid @RequestBody TripNumberAvailableSeatsChangeRequest body) {
		tripsService.modifyTripNumberAvailableSeats(body, idTrip);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<TripPaginatedResponse> searchTrips(
			@ApiParam(value = "the departure place for the trip") @Valid @RequestParam(value = "departurePlace", required = false) String departurePlace,
			@ApiParam(value = "the arrival place for the trip") @Valid @RequestParam(value = "arrivalPlace", required = false) String arrivalPlace,
			@ApiParam(value = "the departure time for the trip") @Valid @RequestParam(value = "departureDateTime", required = false) String departureDateTime,
			@ApiParam(value = "the number of the page") @Valid @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@ApiParam(value = "the number of element per page") @Valid @RequestParam(value = "size", required = false, defaultValue = "25") Integer size) {
		
		return new ResponseEntity<TripPaginatedResponse>(tripsService.searchTrips(departurePlace, arrivalPlace, departureDateTime, page, size), HttpStatus.OK);
	}

}
