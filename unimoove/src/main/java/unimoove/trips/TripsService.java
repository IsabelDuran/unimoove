package unimoove.trips;

import org.springframework.stereotype.Service;

import unimoove.api.reservations.ReservationPaginatedResponse;
import unimoove.api.trips.TripArrivalPlaceChangeRequest;
import unimoove.api.trips.TripCreationRequest;
import unimoove.api.trips.TripDepartureDateTimeChangeRequest;
import unimoove.api.trips.TripDeparturePlaceChangeRequest;
import unimoove.api.trips.TripNumberAvailableSeatsChangeRequest;
import unimoove.api.trips.TripPaginatedResponse;
import unimoove.api.trips.TripStatusChangeRequest;

@Service
public interface TripsService {
	public void addTrip(TripCreationRequest tripCreationRequest);
	public void deleteTrip(Long idTrip);
	public void modifyTripArrivalPlace(TripArrivalPlaceChangeRequest tripArrivalPlaceChangeRequest, Long idTrip);
	public void modifyTripDepartureDateTime(TripDepartureDateTimeChangeRequest tripDepartureDateTimeChangeRequest, Long idTrip);
	public void modifyTripDeparturePlace(TripDeparturePlaceChangeRequest tripDeparturePlaceChangeRequest, Long idTrip);
	public void modifyTripNumberAvailableSeats(TripNumberAvailableSeatsChangeRequest tripNumberAvailableSeatsChangeRequest, Long idTrip);
	public void modifyTripStatus(TripStatusChangeRequest tripStatusChangeRequest, Long idTrip);
	public TripPaginatedResponse searchTrips(String departurePlace, String arrivalPlace, String departureDateTime, Integer page, Integer size);
	public TripPaginatedResponse obtainUserTrips(String username, Integer page, Integer size);
}
