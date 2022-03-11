package com.registration.validationrules.model;

import java.util.List;

public class Source {
	private String master;
	private List<String> copy;
	
	public Source() {
		// TODO Auto-generated constructor stub
	}
	
	public Source(String master, List<String> copy) {
		this.master = master;
		this.copy = copy;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public List<String> getCopy() {
		return copy;
	}

	public void setCopy(List<String> copy) {
		this.copy = copy;
	}
	
	
	
	

}
