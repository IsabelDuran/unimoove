package unimoove.places;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacesRepository extends CrudRepository<Place, Long>{
	@Query("select p from Place p where p.idPlace = :idPlace")
	public Place findByPlaceId(String idPlace);
}
