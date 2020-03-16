package unimoove.users;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import unimoove.api.users.UserRegistrationRequest;
import unimoove.api.users.UserResponse;

@Service
public class UsersServiceImpl implements UserService {
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
	public Boolean registerUser(UserRegistrationRequest registrationRequest) throws UniqueUsernameException {
		User newUser = userMapper.userRegistrationRequestToUser(registrationRequest);
		newUser.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
		newUser.setRole(ROLE_USER);
		try {
			userRepository.save(newUser);
		} catch (DataIntegrityViolationException exception) {
			throw new UniqueUsernameException("Username already exists");
		}

		return true;
	}

	@Override
	public UserResponse getUserByUsername(String username) throws EntityNotFoundException {
		User user = userRepository.findUserByUsername(username);
		if (user == null)
			throw new EntityNotFoundException("Usuario no encontrado");

		return userMapper.userToUserResponse(user);
	}

	@Override
	public Boolean deleteUser(String username){
		User user = userRepository.findUserByUsername(username); 
		if(user == null)
			throw new IllegalArgumentException("Usuario no encontrado");
		
		userRepository.delete(user);
		return true;
	}

}
