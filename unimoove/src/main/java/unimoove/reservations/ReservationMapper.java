package unimoove.reservations;

import org.mapstruct.Mapper;

import unimoove.api.reservations.ReservationResponse;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
	
	public ReservationResponse reservationToReservationResponse(Reservation reservation);
}
