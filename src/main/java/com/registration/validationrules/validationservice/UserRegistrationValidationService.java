package com.registration.validationrules.validationservice;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.registration.validationrules.exception.IllegalFieldNameException;
import com.registration.validationrules.exception.IllegalFieldValueException;

@Service
public class UserRegistrationValidationService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Function<String, Boolean> validateFieldName = (fieldName) -> {
		
		if(fieldName == null) {
			throw new IllegalFieldNameException("Null FieldName", "the fieldName should never be NULL");
		}else if(fieldName.isEmpty()) {
			throw new IllegalFieldNameException("Empty FieldName", "the fieldName should never be NULL");
		}else {
			return true;
		}
	};
	
	public boolean validateFieldValue(String fieldValue, int minLength, int maxLength) {
		if(fieldValue == null) {
			throw new IllegalFieldValueException("Null FieldValue", "provide the required value, No FieldValue should be NULL");
		}else if(fieldValue.isEmpty()) {
			throw new IllegalFieldValueException("Empty FieldValue", "provide the required value, No FieldValue should be EMPTY");
		}else {
			if(fieldValue.length() < minLength || fieldValue.length() > maxLength) {
				throw new IllegalFieldValueException(
						"Too short or too long field value characters long",
						"the fieldValue should not have less than " +minLength+ " or more than " +maxLength+ " characters long!");
			}else {
				return true;
			}
		}
	}
	
	public boolean validateUserRole(String userRole, List<String> roles) {
		if(userRole == null) {
			throw new IllegalFieldValueException("the user role value is null", "the user role should never be null");
		}else if(userRole.isEmpty()) {
			throw new IllegalFieldValueException("the user role value is empty", "the user role should never be empty");
		}else {
			roles.stream()
					.filter((role) -> role.equalsIgnoreCase(userRole))
					.findFirst()
					.orElseThrow(() -> new IllegalFieldValueException("unrecognized user role: "+userRole, "the user role should be either Standard or Admin"));
		}
		return true;
	}
	
	public boolean validateEmail(String email, String regexPattern) {
		
		System.out.println("validating email ...");
		Pattern patternFinder = Pattern.compile(regexPattern);
		
		Matcher patternMatcher = patternFinder.matcher(email);
		System.out.println("Email Valifator: "+patternMatcher.matches());
		return patternMatcher.matches();
	}

}
