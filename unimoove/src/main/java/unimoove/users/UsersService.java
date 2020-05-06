package unimoove.users;

import javax.persistence.EntityNotFoundException;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import unimoove.api.users.UserBirthdateChangeRequest;
import unimoove.api.users.UserEmailChangeRequest;
import unimoove.api.users.UserGenderChangeRequest;
import unimoove.api.users.UserLastnameChangeRequest;
import unimoove.api.users.UserNameChangeRequest;
import unimoove.api.users.UserPaginatedResponse;
import unimoove.api.users.UserPasswordChangeRequest;
import unimoove.api.users.UserRegistrationRequest;
import unimoove.api.users.UserResponse;
import unimoove.api.users.UserUsernameChangeRequest;

@Service
public interface UsersService extends UserDetailsService{	
	public User findUserById(Long id);
	public UserResponse getUserById(Long idUser) throws EntityNotFoundException;
	public void registerUser(UserRegistrationRequest registrationRequest) throws UniqueUsernameException;
	public UserResponse getUserByUsername(String username) throws EntityNotFoundException;
	public void deleteUser(String username) throws IllegalArgumentException;
	public void modifyUserBirthdate(UserBirthdateChangeRequest userBirthdateChangeRequest, String username);
	public void modifyUserGender(UserGenderChangeRequest userGenderChangeRequest, String username);
	public void modifyUserLastname(UserLastnameChangeRequest userLastnameChangeRequest, String username);
	public void modifyUserName(UserNameChangeRequest userNameChangeRequest, String username);
	public void modifyUserPassword(UserPasswordChangeRequest userPasswordChangeRequest, String username);
	public void modifyUserUsername(UserUsernameChangeRequest usernameChangeRequest, String username) throws UniqueUsernameException;
	public void modifyUserEmail(UserEmailChangeRequest userEmailChangeRequest, String username) throws UniqueEmailException;
	public UserPaginatedResponse searchUsersByUsername(String username, Integer page, Integer size);
}
