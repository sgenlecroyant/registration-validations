package com.registration.validationrules.requestmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserRequestFields {
	
	@JsonProperty(value = "fieldName")
	private String fieldName;
	@JsonProperty(value = "fieldValue")
	private String fieldValue;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	@Override
	public String toString() {
		return "UserRequestFields [fieldName=" + fieldName + ", fieldValue=" + fieldValue + "]";
	}
	
	
	
	

}
