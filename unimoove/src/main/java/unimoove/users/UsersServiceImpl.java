package unimoove.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import unimoove.api.users.UserRegistrationRequest;

@Service
public class UsersServiceImpl implements UserService {
	private static final int ROLE_USER = 1;
	private UsersRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UsersServiceImpl(UsersRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Boolean registerUser(UserRegistrationRequest registrationRequest) throws UniqueUsernameException {
		User newUser = new User(registrationRequest.getName(),
								registrationRequest.getLastname(),
								registrationRequest.getUsername(),
								passwordEncoder.encode(registrationRequest.getPassword()),
								registrationRequest.getBirthdate(),
								registrationRequest.getGender(),
								ROLE_USER);
		try {
			userRepository.save(newUser);
		} catch (DataIntegrityViolationException exception) {
			throw new UniqueUsernameException("Username already exists");
		}
		
		return true;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = userRepository.findUserByUsername(username);
		return user;
	}
	
	
}
