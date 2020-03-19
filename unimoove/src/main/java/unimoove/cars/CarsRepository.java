package unimoove.cars;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends CrudRepository<Car, Long> {
	@Query("select c from Car c where c.plate = :plate")
	public Car findByPlate(@Param("plate") String plate);
}
