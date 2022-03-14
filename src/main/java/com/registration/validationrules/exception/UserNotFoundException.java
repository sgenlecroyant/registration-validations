package com.registration.validationrules.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -4941951798674759061L;
	
	private String description;
	
	public UserNotFoundException(String message, String description) {
		super(message);
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

}
