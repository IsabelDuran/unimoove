package unimoove.api.reservations;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;
import unimoove.reservations.FullTripException;
import unimoove.reservations.ReservationsService;

@Controller
public class ReservationsApiController implements ReservationsApi {

	private static final Logger log = LoggerFactory.getLogger(ReservationsApiController.class);
	
	private ReservationsService reservationsService;

	@Autowired
	public ReservationsApiController(ReservationsService reservationsService) {
		super();
		this.reservationsService = reservationsService;
	}

	public ResponseEntity<Void> addReservation(
			@ApiParam(value = "Reservation to add") @Valid @RequestBody ReservationCreationRequest body) throws FullTripException {
		reservationsService.addReservation(body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}


	public ResponseEntity<Void> deleteReservation(
			@ApiParam(value = "By passing in the appropriate reservation ID, you can delete the reservation.", required = true) @PathVariable("idReservation") String idReservation) {
		reservationsService.deleteReservation(idReservation);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> modifyReservationStatus(String idReservation, @Valid ReservationStateChangeRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

}
