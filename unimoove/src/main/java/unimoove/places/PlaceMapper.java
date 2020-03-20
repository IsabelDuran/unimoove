package unimoove.places;

import org.mapstruct.Mapper;

import unimoove.api.places.PlaceCreationRequest;
import unimoove.api.places.PlaceResponse;

@Mapper(componentModel = "spring")
public interface PlaceMapper {
	Place placeCreationRequestToPlace(PlaceCreationRequest placeCreationRequest);
	PlaceResponse placeToPlaceResponse(Place place);
}
