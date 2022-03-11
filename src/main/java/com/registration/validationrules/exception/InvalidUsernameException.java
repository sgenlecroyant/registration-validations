package com.registration.validationrules.exception;

public class InvalidUsernameException extends RuntimeException{
	
	private String description;
	public InvalidUsernameException(String message, String description) {
		super(message);
		this.description = description;
	}
	public String getDescription() {
		return description;
	}

}
