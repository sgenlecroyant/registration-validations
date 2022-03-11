package com.registration.validationrules.model;

public class Field {
	
	private String fieldName;
	private String label;
	private String fieldType;
	private String uiControlType;
	private Integer fieldOreder;
	private String groupName;
	private Integer pageNumber;
	private Integer groupOrder;
	private Source source;
	private validationRules validationRules;
	
	public Field() {
		// TODO Auto-generated constructor stub
	}
	
	public Field(String fieldName, String label, String fieldType, String uiControlType, Integer fieldOreder,
			String groupName, Integer pageNumber, Integer groupOrder, Source source,
			com.registration.validationrules.model.validationRules validationRules) {

		this.fieldName = fieldName;
		this.label = label;
		this.fieldType = fieldType;
		this.uiControlType = uiControlType;
		this.fieldOreder = fieldOreder;
		this.groupName = groupName;
		this.pageNumber = pageNumber;
		this.groupOrder = groupOrder;
		this.source = source;
		this.validationRules = validationRules;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getUiControlType() {
		return uiControlType;
	}

	public void setUiControlType(String uiControlType) {
		this.uiControlType = uiControlType;
	}

	public Integer getFieldOreder() {
		return fieldOreder;
	}

	public void setFieldOreder(Integer fieldOreder) {
		this.fieldOreder = fieldOreder;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getGroupOrder() {
		return groupOrder;
	}

	public void setGroupOrder(Integer groupOrder) {
		this.groupOrder = groupOrder;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public validationRules getValidationRules() {
		return validationRules;
	}

	public void setValidationRules(validationRules validationRules) {
		this.validationRules = validationRules;
	}
	
	
	
	

}
