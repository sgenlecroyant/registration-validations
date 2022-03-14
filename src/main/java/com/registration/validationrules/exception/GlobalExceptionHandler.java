package com.registration.validationrules.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	@ExceptionHandler(IllegalFieldValueException.class)
	public ResponseEntity<ExceptionResponse> handleIllegalFieldValue(IllegalFieldValueException ex, WebRequest request){
		
		ExceptionResponse response = 
				new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, ex.getDescription(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(response, response.getStatusCode());
	}
	
	@ExceptionHandler(IllegalFieldNameException.class)
	public ResponseEntity<ExceptionResponse> handleIllegalFieldName(IllegalFieldNameException ex, WebRequest request){
		
		ExceptionResponse response = 
				new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, ex.getDescription(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(response, response.getStatusCode());
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
		
		ExceptionResponse response = 
				new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, ex.getDescription(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(response, response.getStatusCode());
	}
	
	
	
	@ExceptionHandler(InvalidIdException.class)
	public ResponseEntity<ExceptionResponse> handleInvalidIdException(InvalidIdException ex, WebRequest request){
		System.out.println("handling data integrity exception");
		ExceptionResponse response = 
				new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, ex.getDescription(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(response, response.getStatusCode());
	}

	
	

}
