package unimoove.trips;

import java.time.OffsetDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripsRepository extends CrudRepository<Trip, Long> {

	@Query("select t from Trip t WHERE t.departurePlace LIKE :departurePlace AND t.arrivalPlace LIKE :arrivalPlace AND t.departureDateTime >= :departureDateTime")
	public Page<Trip> searchTrips(@Param("departurePlace") String departurePlace,
			@Param("arrivalPlace") String arrivalPlace, @Param("departureDateTime") OffsetDateTime departureDateTime,
			Pageable page);

	@Query("select t from Trip t WHERE t.user.id = :user_id")
	public Page<Trip> searchUserTrip(@Param("user_id") Long userId, Pageable page);
}
