package unimoove.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
	
	@Query("select u from User u where u.username = :username")
	public User findUserByUsername(@Param("username") String username);
	
	@Query("select u from User u LEFT JOIN FETCH u.cars c where u.username = :username")
	public User findUserByUsernameWithCars(@Param("username") String username);
	
	@Query("select u from User u LEFT JOIN FETCH u.trips c where u.username = :username")
	public User findUserByUsernameWithTrips(@Param("username") String username);
	
	@Query("select u from User u where u.username LIKE :username")
	public Page<User> searchUserWithUsername(@Param("username") String username, Pageable page);
}
