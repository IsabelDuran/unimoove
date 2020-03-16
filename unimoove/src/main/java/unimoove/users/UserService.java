package unimoove.users;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import unimoove.api.users.UserRegistrationRequest;
import unimoove.api.users.UserResponse;

@Service
public interface UserService {	
	public Boolean registerUser(UserRegistrationRequest registrationRequest) throws UniqueUsernameException;
	public UserResponse getUserByUsername(String username) throws EntityNotFoundException;
	public Boolean deleteUser(String username) throws IllegalArgumentException;
}
