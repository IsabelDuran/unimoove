package unimoove.authentication;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import io.jsonwebtoken.Clock;
import unimoove.api.authentication.LoginRequest;
import unimoove.api.authentication.LoginResponse;
import unimoove.users.User;
import unimoove.users.UsersRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	private UsersRepository usersRepository;
	private PasswordEncoder passwordEncoder;
	private Clock clock = DefaultClock.INSTANCE;

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	@Autowired
	public AuthenticationServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
		super();
		this.usersRepository = usersRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public LoginResponse loginUser(LoginRequest loginRequest) throws UnsuccessfulLoginException {
		User user = usersRepository.findUserByUsername(loginRequest.getUsername());
		if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
			String token = Jwts.builder().setSubject(user.getUsername())
					.setExpiration(new Date(clock.now().getTime() + expiration * 1000))
					.signWith(SignatureAlgorithm.HS256, secret).compact();
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setApiKey(token);
			return loginResponse;
		}
		else throw new UnsuccessfulLoginException("Unsuccessful Login");
	}

}
