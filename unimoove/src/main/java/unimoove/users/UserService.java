package unimoove.users;

import org.springframework.stereotype.Service;

import unimoove.api.users.UserRegistrationRequest;

@Service
public interface UserService {	
	public Boolean registerUser(UserRegistrationRequest registrationRequest) throws UniqueUsernameException;
	public User getUserByUsername(String username);
}
