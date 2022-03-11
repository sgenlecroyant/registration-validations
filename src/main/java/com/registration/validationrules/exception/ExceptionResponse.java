package com.registration.validationrules.exception;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
	
	private String message;
	private HttpStatus statusCode;
	private String description;
	private String webRequestDescription;
	
	public ExceptionResponse(String message, HttpStatus statusCode, String description, String webRequestDescription) {
		this.message = message;
		this.statusCode = statusCode;
		this.description = description;
		this.webRequestDescription = webRequestDescription;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebRequestDescription() {
		return webRequestDescription;
	}

	public void setWebRequestDescription(String webRequestDescription) {
		this.webRequestDescription = webRequestDescription;
	}
	
	
	

}
