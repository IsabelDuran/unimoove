package unimoove.reservations;

import org.springframework.stereotype.Service;

import unimoove.api.reservations.ReservationCreationRequest;

@Service
public interface ReservationsService {
	public void addReservation(ReservationCreationRequest reservationCreationRequest);
	public void deleteReservation(String idReservation);
}
