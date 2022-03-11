package com.registration.validationrules.validationservice;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class UserRegistrationValidationService {
	
	public Function<String, Boolean> validateFieldName = (fieldName) -> {
		
		if(fieldName == null) {
			throw new RuntimeException("the fieldName should never be null");
		}else if(fieldName.isEmpty()) {
			throw new RuntimeException("the fieldName should never be empty");
		}else {
			return true;
		}
	};
	
	public boolean validateFieldValue(String fieldValue, int minLength, int maxLength) {
		if(fieldValue == null) {
			throw new RuntimeException("The fieldValue should never be null");
		}else if(fieldValue.isEmpty()) {
			throw new RuntimeException("The fieldValue should never be empty");
		}else {
			if(fieldValue.length() < minLength && fieldValue.length() > maxLength) {
				throw new RuntimeException("the fieldValue should not have less than " +minLength+ " or more than " +maxLength+ " characters long!");
			}else {
				return true;
			}
		}
	}
	
	public boolean validateUserRole(String userRole, List<String> roles) {
		if(userRole == null) {
			throw new RuntimeException("The role should never be null");
		}else if(userRole.isEmpty()) {
			throw new RuntimeException("The role should never be empty");
		}else {
			roles.stream()
					.filter((role) -> role.equalsIgnoreCase(userRole))
					.findFirst()
					.orElseThrow(() -> new RuntimeException("unrecognized role: " +userRole));
		}
		return true;
	}
	
	public boolean validateEmail(String email, String regexPattern) {
		
		System.out.println("validating email ...");
		Pattern compiledPattern = Pattern.compile(regexPattern);
		
		Matcher patternMatcher = compiledPattern.matcher(email);
		System.out.println("Email Valifator: "+patternMatcher.matches());
		return patternMatcher.matches();
	}

}
