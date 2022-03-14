package com.registration.validationrules.exception;

public class InvalidIdException extends RuntimeException{
	
private static final long serialVersionUID = -4941951798674759061L;
	
	private String description;
	
	public InvalidIdException(String message, String description) {
		super(message);
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

}
