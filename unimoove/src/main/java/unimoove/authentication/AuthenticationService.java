package unimoove.authentication;

import org.springframework.stereotype.Service;

import unimoove.api.authentication.LoginRequest;
import unimoove.api.authentication.LoginResponse;

@Service
public interface AuthenticationService {
	public LoginResponse loginUser(LoginRequest loginRequest) throws UnsuccessfulLoginException;
}
