package com.registration.validationrules.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Data
@Setter
@Getter
//@ToString
@Entity
@Table(name = "users")
public class User implements Serializable	 {
	

	@Id
	private String guid;
	private String userName;
	private int internalId;
	private String catrecId;
	private String clientId;
	private String email;  //0
	private String cwsId;
	private String telephoneNumber;  //3
	private String signinName;  //4
	private String lastName;  //2
	private String firstName; //1
	private String displayName;  //5
	private String dealerId; //6
	private String companyId;  //7
	private String businessCaseAccess;  //8
	private String businessCaseReason;  //9
	private String state;  //10
	private String country;  //11
	private String role;
	@CreationTimestamp
	private Date createDate;
	@CreationTimestamp
	private Date modifiedDate;
	private String postalCode;  //12
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String userName, int internalId, String catrecId, String clientId, String email, String cwsId,
			String telephoneNumber, String signinName, String lastName, String firstName, String displayName,
			String dealerId, String companyId, String businessCaseAccess, String businessCaseReason, String state,
			String country, String role, String postalCode) {
		this.userName = userName;
		this.internalId = internalId;
		this.catrecId = catrecId;
		this.clientId = clientId;
		this.email = email;
		this.cwsId = cwsId;
		this.telephoneNumber = telephoneNumber;
		this.signinName = signinName;
		this.lastName = lastName;
		this.firstName = firstName;
		this.displayName = displayName;
		this.dealerId = dealerId;
		this.companyId = companyId;
		this.businessCaseAccess = businessCaseAccess;
		this.businessCaseReason = businessCaseReason;
		this.state = state;
		this.country = country;
		this.role = role;
		this.postalCode = postalCode;
	}




	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getGuid() {
		return guid;
	}


	public void setGuid(String guid) {
		this.guid = guid;
	}

	

	public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public int getInternalId() {
		return internalId;
	}


	public void setInternalId(int internalId) {
		this.internalId = internalId;
	}


	public String getCatrecId() {
		return catrecId;
	}


	public void setCatrecId(String catrecId) {
		this.catrecId = catrecId;
	}
	
	


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCwsId() {
		return cwsId;
	}


	public void setCwsId(String cwsId) {
		this.cwsId = cwsId;
	}


	public String getTelephoneNumber() {
		return telephoneNumber;
	}


	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}


	public String getSigninName() {
		return signinName;
	}


	public void setSigninName(String signinName) {
		this.signinName = signinName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	public String getDealerId() {
		return dealerId;
	}


	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}


	public String getCompanyId() {
		return companyId;
	}


	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}


	public String getBusinessCaseAccess() {
		return businessCaseAccess;
	}


	public void setBusinessCaseAccess(String businessCaseAccess) {
		this.businessCaseAccess = businessCaseAccess;
	}


	public String getBusinessCaseReason() {
		return businessCaseReason;
	}


	public void setBusinessCaseReason(String businessCaseReason) {
		this.businessCaseReason = businessCaseReason;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}


	@Override
	public String toString() {
		return "User [userName=" + userName + ", guid=" + guid + ", internalId=" + internalId + ", catrecId=" + catrecId
				+ ", clientId=" + clientId + ", email=" + email + ", cwsId=" + cwsId + ", telephoneNumber="
				+ telephoneNumber + ", signinName=" + signinName + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", displayName=" + displayName + ", dealerId=" + dealerId + ", companyId=" + companyId
				+ ", businessCaseAccess=" + businessCaseAccess + ", businessCaseReason=" + businessCaseReason
				+ ", state=" + state + ", country=" + country + ", createDate=" + createDate + ", modifiedDate="
				+ modifiedDate + ", postalCode=" + postalCode + "]";
	}
	
	

}
