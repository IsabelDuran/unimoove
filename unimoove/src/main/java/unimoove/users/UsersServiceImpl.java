package unimoove.users;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import unimoove.api.utils.PaginationInfo;

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
	public void modifyUserUsername(UserUsernameChangeRequest usernameChangeRequest, String username)
			throws UniqueUsernameException {
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

	@Override
	@Transactional
	public UserPaginatedResponse searchUsersByUsername(String username, Integer page, Integer size) {
		Page<User> matchedUsers = userRepository.searchUserWithUsername(username, PageRequest.of(page, size));

		List<UserResponse> userResponses = matchedUsers.map(user -> userMapper.userToUserResponse(user)).stream()
				.collect(Collectors.toList());
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalElements(matchedUsers.getNumberOfElements());
		paginationInfo.setTotalPages(matchedUsers.getTotalPages());

		UserPaginatedResponse userPaginatedResponse = new UserPaginatedResponse();
		userPaginatedResponse.setPages(userResponses);
		userPaginatedResponse.setPaginationInfo(paginationInfo);

		return userPaginatedResponse;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = userRepository.findUserByUsername(username);
		if (userDetails == null)
			throw new UsernameNotFoundException("El usuario " + username + " no se ha encontrado.");

		return userDetails;
	}

	@Override
	@Transactional
	public void modifyUserEmail(UserEmailChangeRequest userEmailChangeRequest, String username) {
		User user = findUserByUsername(username);

		user.setEmail(userEmailChangeRequest.getNewEmail());
		userRepository.save(user);

	}

	@Override
	@Transactional
	public User findUserById(Long id) {
		return userRepository.findById(id).orElse(null);

	}

	@Override
	@Transactional
	public UserResponse getUserById(Long idUser) throws EntityNotFoundException {
		User user = userRepository.findById(idUser).orElse(null);
		if(user == null)
			throw new EntityNotFoundException("Usuario no encontrado");

		return userMapper.userToUserResponse(user);
	}

}
