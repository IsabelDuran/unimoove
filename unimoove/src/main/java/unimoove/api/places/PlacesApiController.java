package unimoove.api.places;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
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
import unimoove.places.PlacesService;

@Controller
public class PlacesApiController implements PlacesApi {

	private static final Logger log = LoggerFactory.getLogger(PlacesApiController.class);

	private final HttpServletRequest request;

	private PlacesService placesService;

	@Autowired
	public PlacesApiController(HttpServletRequest request, PlacesService placesService) {
		super();
		this.request = request;
		this.placesService = placesService;
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	public ResponseEntity<Void> addPlace(
			@ApiParam(value = "Place to add") @Valid @RequestBody PlaceCreationRequest body)
			throws ConstraintViolationException {
		placesService.addPlace(body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> deletePLace(
			@ApiParam(value = "By passing in the appropriate place ID, you can delete the place.", required = true) @PathVariable("idPlace") String idPlace) {
		placesService.deletePlace(idPlace);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<PlaceResponse> getPlace(
			@ApiParam(value = "By passing in the appropriate place ID, you can get the place.", required = true) @PathVariable("idPlace") String idPlace) {
		return new ResponseEntity<PlaceResponse>(placesService.getPlace(idPlace), HttpStatus.OK);
	}

	public ResponseEntity<Void> modifyPlaceCategory(
			@ApiParam(value = "", required = true) @PathVariable("idPlace") String idPlace,
			@ApiParam(value = "The place's new category") @Valid @RequestBody PlaceCategoryChangeRequest body) {
		placesService.modifyPlaceCategory(body, idPlace);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> modifyPlaceId(
			@ApiParam(value = "", required = true) @PathVariable("idPlace") String idPlace,
			@ApiParam(value = "The place's new ID") @Valid @RequestBody PlaceIdChangeRequest body) {
		placesService.modifyPlaceId(body, idPlace);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> modifyPlaceName(
			@ApiParam(value = "", required = true) @PathVariable("idPlace") String idPlace,
			@ApiParam(value = "The place's new name") @Valid @RequestBody PlaceNameChangeRequest body) {
		placesService.modifyPlaceName(body, idPlace);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<PlacePaginatedResponse> searchPlace(
			@ApiParam(value = "the place to be searched") @Valid @RequestParam(value = "name", required = false, defaultValue = "") String name,
			@ApiParam(value = "the number of the page") @Valid @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@ApiParam(value = "the number of element per page") @Valid @RequestParam(value = "size", required = false, defaultValue = "25") Integer size) {

		return new ResponseEntity<PlacePaginatedResponse>(placesService.searchPlaces(name, page, size), HttpStatus.OK);
	}

}
