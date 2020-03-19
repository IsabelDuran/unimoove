package unimoove.users;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UsersServiceImpl implements UsersService {
	private static final int ROLE_USER = 1;
	private UsersRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private UserMapper userMapper;

	@Autowired
	public UsersServiceImpl(UsersRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.userMapper = userMapper;
	}

	@Override
	@Transactional
	public void registerUser(UserRegistrationRequest registrationRequest) throws UniqueUsernameException {
		User newUser = userMapper.userRegistrationRequestToUser(registrationRequest);
		newUser.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
		newUser.setRole(ROLE_USER);
		try {
			userRepository.save(newUser);
		} catch (DataIntegrityViolationException exception) {
			throw new UniqueUsernameException("Username already exists");
		}

	}

	@Override
	@Transactional
	public UserResponse getUserByUsername(String username) throws EntityNotFoundException {
		User user = findUserByUsername(username);

		return userMapper.userToUserResponse(user);
	}

	@Override
	@Transactional
	public void deleteUser(String username) {
		User user = userRepository.findUserByUsername(username);
		if (user == null)
			throw new IllegalArgumentException("El usuario " + username + " no ha sido encontrado");

		userRepository.delete(user);
	}

	@Override
	@Transactional
	public void modifyUserBirthdate(UserBirthdateChangeRequest userBirthdateChangeRequest, String username) {
		User user = findUserByUsername(username);

		user.setBirthdate(userBirthdateChangeRequest.getNewBirthdate());
		userRepository.save(user);
	}

	@Override
	@Transactional
	public void modifyUserGender(UserGenderChangeRequest userGenderChangeRequest, String username) {
		User user = findUserByUsername(username);

		user.setGender(userGenderChangeRequest.getNewGender());
		userRepository.save(user);
	}

	@Override
	@Transactional
	public void modifyUserLastname(UserLastnameChangeRequest userLastnameChangeRequest, String username) {
		User user = findUserByUsername(username);

		user.setLastname(userLastnameChangeRequest.getNewLastname());
		userRepository.save(user);

	}

	@Override
	@Transactional
	public void modifyUserName(UserNameChangeRequest userNameChangeRequest, String username) {
		User user = findUserByUsername(username);

		user.setName(userNameChangeRequest.getNewName());
		userRepository.save(user);

	}

	@Override
	@Transactional
	public void modifyUserPassword(UserPasswordChangeRequest userPasswordChangeRequest, String username) {
		User user = findUserByUsername(username);

		user.setPassword(passwordEncoder.encode(userPasswordChangeRequest.getNewPassword()));
		userRepository.save(user);
		
	}
	
	@Override
	@Transactional
	public void modifyUserUsername(UserUsernameChangeRequest usernameChangeRequest, String username) throws UniqueUsernameException {
		User user = findUserByUsername(username);

		user.setUsername(usernameChangeRequest.getNewUsername());
		try {
			userRepository.save(user);
		} catch (DataIntegrityViolationException exception) {
			throw new UniqueUsernameException("Username already exists");
		}
		
	}
	
	private User findUserByUsername(String username) {
		User user = userRepository.findUserByUsername(username);
		if (user == null)
			throw new EntityNotFoundException("Usuario no encontrado");
		return user;
	}

}
