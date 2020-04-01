package unimoove.trips;

import org.springframework.stereotype.Service;

import unimoove.api.trips.TripArrivalPlaceChangeRequest;
import unimoove.api.trips.TripCreationRequest;
import unimoove.api.trips.TripDepartureDateTimeChangeRequest;
import unimoove.api.trips.TripDeparturePlaceChangeRequest;
import unimoove.api.trips.TripNumberAvailableSeatsChangeRequest;
import unimoove.api.trips.TripPaginatedResponse;

@Service
public interface TripsService {
	public void addTrip(TripCreationRequest tripCreationRequest);
	public void deleteTrip(String idTrip);
	public void modifyTripArrivalPlace(TripArrivalPlaceChangeRequest tripArrivalPlaceChangeRequest, String idTrip);
	public void modifyTripDepartureDateTime(TripDepartureDateTimeChangeRequest tripDepartureDateTimeChangeRequest, String idTrip);
	public void modifyTripDeparturePlace(TripDeparturePlaceChangeRequest tripDeparturePlaceChangeRequest, String idTrip);
	public void modifyTripNumberAvailableSeats(TripNumberAvailableSeatsChangeRequest tripNumberAvailableSeatsChangeRequest, String idTrip);
	public TripPaginatedResponse searchTrips(String departurePlace, String arrivalPlace, String departureDateTime, Integer page, Integer size);
	public TripPaginatedResponse obtainUserTrips(String username, Integer page, Integer size);
}
