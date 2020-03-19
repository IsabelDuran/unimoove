package unimoove.users;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import unimoove.api.users.UserBirthdateChangeRequest;
import unimoove.api.users.UserGenderChangeRequest;
import unimoove.api.users.UserLastnameChangeRequest;
import unimoove.api.users.UserNameChangeRequest;
import unimoove.api.users.UserPasswordChangeRequest;
import unimoove.api.users.UserRegistrationRequest;
import unimoove.api.users.UserResponse;
import unimoove.api.users.UserUsernameChangeRequest;

@Service
public interface UsersService {	
	public void registerUser(UserRegistrationRequest registrationRequest) throws UniqueUsernameException;
	public UserResponse getUserByUsername(String username) throws EntityNotFoundException;
	public void deleteUser(String username) throws IllegalArgumentException;
	public void modifyUserBirthdate(UserBirthdateChangeRequest userBirthdateChangeRequest, String username);
	public void modifyUserGender(UserGenderChangeRequest userGenderChangeRequest, String username);
	public void modifyUserLastname(UserLastnameChangeRequest userLastnameChangeRequest, String username);
	public void modifyUserName(UserNameChangeRequest userNameChangeRequest, String username);
	public void modifyUserPassword(UserPasswordChangeRequest userPasswordChangeRequest, String username);
	public void modifyUserUsername(UserUsernameChangeRequest usernameChangeRequest, String username) throws UniqueUsernameException;
}
