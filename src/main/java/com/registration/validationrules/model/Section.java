package com.registration.validationrules.model;

import java.util.List;

public class Section {
	private String sectionName;
	private Integer sectionOrder;
	private String logicFlow;
	private List<Field> fields;
	
	public Section() {
		// TODO Auto-generated constructor stub
	}

	public Section(String sectionName, Integer sectionOrder, String logicFlow, List<Field> fields) {
		this.sectionName = sectionName;
		this.sectionOrder = sectionOrder;
		this.logicFlow = logicFlow;
		this.fields = fields;
	}
	
	//  ["", ""];
	//  ["   , "]



	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getLogicFlow() {
		return logicFlow;
	}

	public void setLogicFlow(String logicFlow) {
		this.logicFlow = logicFlow;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public Integer getSectionOrder() {
		return sectionOrder;
	}

	public void setSectionOrder(Integer sectionOrder) {
		this.sectionOrder = sectionOrder;
	}

	@Override
	public String toString() {
		return "Section [sectionName=" + sectionName + ", sectionOrder=" + sectionOrder + ", logicFlow=" + logicFlow
				+ ", fields=" + fields + "]";
	}
	
	
	

}
