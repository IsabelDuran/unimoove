package unimoove.places;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;

import unimoove.api.places.PlaceCategoryChangeRequest;
import unimoove.api.places.PlaceCreationRequest;
import unimoove.api.places.PlaceIdChangeRequest;
import unimoove.api.places.PlaceNameChangeRequest;
import unimoove.api.places.PlaceResponse;

@Service
public interface PlacesService {
	public void addPlace(PlaceCreationRequest placeCreationRequest) throws ConstraintViolationException;
	public PlaceResponse getPlace(String placeId);
	public void deletePlace(String placeId);
	public void modifyPlaceId(PlaceIdChangeRequest placeIdChangeRequest, String placeId);
	public void modifyPlaceName(PlaceNameChangeRequest placeNameChangeRequest, String placeId);
	public void modifyPlaceCategory(PlaceCategoryChangeRequest placeCategoryChangeRequest, String placeId);
}
