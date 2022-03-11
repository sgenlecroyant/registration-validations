package com.registration.validationrules.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(InvalidUsernameException.class)
	public ResponseEntity<Object> handleInvalidUsername(InvalidUsernameException e, WebRequest request) {

		// build the response of the exception
		ExceptionResponse response = new ExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST, e.getDescription(),
				request.getDescription(false));
		// return the response inside the ResponseEntity
		return new ResponseEntity<Object>(response, response.getStatusCode());
	}

}
