package com.registration.validationrules.exception;

public class IllegalFieldValueException extends IllegalArgumentException{

	private static final long serialVersionUID = 1L;
	private String description;
	
	public IllegalFieldValueException(String message, String description) {
		super(message);
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	

}
