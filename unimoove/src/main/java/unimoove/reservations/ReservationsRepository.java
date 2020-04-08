package unimoove.reservations;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends CrudRepository<Reservation, Long> {

	@Query("select r from Reservation r where r.trip.id = :idTrip")
	Page<Reservation> searchReservationsByIdTrip(@Param("idTrip") Long idTrip, Pageable page);
	
	@Query("select r from Reservation r where r.user.id = :idUser")
	Page<Reservation> searchUserReservations(@Param("idUser") Long idUser, Pageable page);

}
