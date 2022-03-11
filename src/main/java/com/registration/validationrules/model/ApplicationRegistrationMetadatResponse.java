package com.registration.validationrules.model;

import java.util.List;

public class ApplicationRegistrationMetadatResponse {
	
	private String appName;
	private String appDescription;
	private List<Section> sections;
	
	public ApplicationRegistrationMetadatResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public ApplicationRegistrationMetadatResponse(String appName, String appDescription,  List<Section> sections) {
		this.appName = appName;
		this.appDescription = appDescription;
		this.sections = sections;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppDescription() {
		return appDescription;
	}

	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}

	public  List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	
	
	
	

}
