package com.registration.validationrules.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonPropertyOrder(value = {isMondatory""})
public class validationRules {
	
	private boolean isMondatory;
	private Integer minLength;
	private Integer maxLength;
	private String regex;
	private List<String> dropdown;
	
	public validationRules(){
		
	}
	
	public validationRules(boolean isMondatory, Integer minLength, Integer maxLength, String regex,
			List<String> dropdown) {
		this.isMondatory = isMondatory;
		this.minLength = minLength;
		this.maxLength = maxLength;
		this.regex = regex;
		this.dropdown = dropdown;
	}

	public boolean getIsMondatory() {
		return isMondatory;
	}

	public void setIsMondatory(boolean isMondatory) {
		this.isMondatory = isMondatory;
	}

	public Integer getMinLength() {
		return minLength;
	}

	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public List<String> getDropdown() {
		return dropdown;
	}

	public void setDropdown(List<String> dropdown) {
		this.dropdown = dropdown;
	}

	@Override
	public String toString() {
		return "validationRules [isMondatory=" + isMondatory + ", minLength=" + minLength + ", maxLength=" + maxLength
				+ ", regex=" + regex + ", dropdown=" + dropdown + "]";
	}
	
	
	
	
}
