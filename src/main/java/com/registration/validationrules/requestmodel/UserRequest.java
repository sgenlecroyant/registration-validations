package com.registration.validationrules.requestmodel;

import java.util.List;

import lombok.Data;

@Data
public class UserRequest {
	
	private String clientId;
	private String catrecId;
	private String cwsId;
	private String username;
	private List<UserRequestFields> fields;
	
	
	public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public String getCatrecId() {
		return catrecId;
	}


	public void setCatrecId(String catrecId) {
		this.catrecId = catrecId;
	}


	public String getCwsId() {
		return cwsId;
	}


	public void setCwsId(String cwsId) {
		this.cwsId = cwsId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public List<UserRequestFields> getFields() {
		return fields;
	}


	public void setFields(List<UserRequestFields> fields) {
		this.fields = fields;
	}


	@Override
	public String toString() {
		return "UserRequest [clientId=" + clientId + ", catrecId=" + catrecId + ", cwsId=" + cwsId + ", username="
				+ username + ", fields=" + fields + "]";
	}
	
//	public UserRequest() {
//		// fieldName
//		// fieldValue
//		
//		// one object will have 2 values
//		
//		// but capturing the string as requestBody does not make sense, it can give headaches 
//		// to parse it for object.
//	}
	
	
	
}
