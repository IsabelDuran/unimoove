package unimoove.trips;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import unimoove.api.trips.TripCreationRequest;
import unimoove.api.trips.TripResponse;

@Mapper(componentModel = "spring")
public interface TripMapper {
	
	@Mapping(target = "state", ignore = true)
	@Mapping(target = "user", ignore = true)
	@Mapping(target = "reservations", ignore = true)
	public Trip tripCreationRequestToTrip(TripCreationRequest tripCreationRequest);
	
	public TripResponse tripToTripResponse(Trip trip);
}
