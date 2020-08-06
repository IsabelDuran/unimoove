package unimoove.reservations;

import org.springframework.stereotype.Service;

import unimoove.api.reservations.ReservationCreationRequest;
import unimoove.api.reservations.ReservationPaginatedResponse;
import unimoove.api.reservations.ReservationStateChangeRequest;

@Service
public interface ReservationsService {
	public void addReservation(ReservationCreationRequest reservationCreationRequest) throws FullTripException;
	public void deleteReservation(Long idReservation);
	public ReservationPaginatedResponse getTripReservations(Long idTrip, Integer page, Integer size);
	public ReservationPaginatedResponse getUserReservations(String username, Integer page, Integer size);
	public void modifyReservationState(ReservationStateChangeRequest reservationStateChangeRequest, Long idReservation);
}
