package unimoove.api;

import javax.persistence.EntityNotFoundException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import unimoove.api.utils.ApiError;
import unimoove.users.UniqueUsernameException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	// other exception handlers

	@ExceptionHandler(DataIntegrityViolationException.class)
	protected ResponseEntity<Object> handleConstraintViolation(DataIntegrityViolationException ex) {
		ApiError response = new ApiError(HttpStatus.CONFLICT);
		response.setMessage(ex.getMessage());
		return buildResponseEntity(response);
	}

	@ExceptionHandler(UniqueUsernameException.class)
	protected ResponseEntity<Object> handleConstraintViolation(UniqueUsernameException ex) {
		ApiError response = new ApiError(HttpStatus.CONFLICT);
		response.setMessage(ex.getMessage());
		return buildResponseEntity(response);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage("Validation error");
		apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
		apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
		return buildResponseEntity(apiError);
	}
	

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EntityNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Object> handleIllegalArgumentException(
    		IllegalArgumentException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}