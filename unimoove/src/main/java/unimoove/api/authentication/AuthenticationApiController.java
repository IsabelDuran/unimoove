package unimoove.api.authentication;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;
import unimoove.authentication.AuthenticationService;
import unimoove.authentication.UnsuccessfulLoginException;

@Controller
public class AuthenticationApiController implements AuthenticationApi {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationApiController.class);

	private AuthenticationService authenticationService;

	@Autowired
	public AuthenticationApiController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	public ResponseEntity<LoginResponse> userLogin(
			@ApiParam(value = "The user's username and password") @Valid @RequestBody LoginRequest body) throws UnsuccessfulLoginException {
		return new ResponseEntity<LoginResponse>(authenticationService.loginUser(body), HttpStatus.OK);
	}

}
