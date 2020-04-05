package unimoove.places;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacesRepository extends CrudRepository<Place, Long>{
	@Query("select p from Place p where p.idPlace = :idPlace")
	public Place findByPlaceId(String idPlace);
	
	@Query("select p from Place p where p.name LIKE :name")
	public Page<Place> searchTrips(@Param("name") String name, Pageable page);
}
