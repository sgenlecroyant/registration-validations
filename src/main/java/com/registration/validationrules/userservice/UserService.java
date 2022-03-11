package com.registration.validationrules.userservice;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.validationrules.entity.User;
import com.registration.validationrules.requestmodel.UserRequestFields;
import com.registration.validationrules.validationservice.UserRegistrationValidationService;

@Service
public class UserService {
	
	@Autowired
	private UserRegistrationValidationService validationService;
	
	String firstName = null;
	String lastName = null;
	String email = null;
	String telephoneNumber = null;
	String signinName = null;
	String displayName = null;
	String dealerId = null;
	String companyId = null;
	String businessCaseAccess = null;
	String businessCaseReason = null;
	String state = null;
	String country = null;
	String role = null;
	Integer internalId = 0;
	String postalCode = null;
	
	public User buildUserBean(
			UserRequestFields request, List<String> roles, String clientId, String catrecId, String cwsId, String username) {
		
		if(request.getFieldName().equalsIgnoreCase("role")) {
			this.validationService.validateUserRole(request.getFieldValue(), roles);
			if(request.getFieldName().equalsIgnoreCase("role")) {
				role = request.getFieldValue();
			}
		}
		
		
		if (request.getFieldName().equalsIgnoreCase("firstName")) {
			firstName = request.getFieldValue();
			System.out.println("firstName: ".toUpperCase()+ ""+firstName);
		}
		if (request.getFieldName().equalsIgnoreCase("lastName")) {
			lastName = request.getFieldValue();
			System.out.println("lastName: ".toUpperCase()+ ""+lastName);
		}
		if (request.getFieldName().equalsIgnoreCase("email")) {
			email = request.getFieldValue();
			System.out.println("email: ".toUpperCase()+ ""+email);
		}

		if (request.getFieldName().equalsIgnoreCase("telephoneNumber")) {
			telephoneNumber = request.getFieldValue();
			System.out.println("phoneNumber: ".toUpperCase()+ ""+telephoneNumber);
		}
		if (request.getFieldName().equalsIgnoreCase("signinName")) {
			signinName = request.getFieldValue();
		}
		
		if (request.getFieldName().equalsIgnoreCase("displayName")) {
			displayName = request.getFieldValue();
		}
		
		if (request.getFieldName().equalsIgnoreCase("dealerId")) {
			dealerId = request.getFieldValue();
		}
		if (request.getFieldName().equalsIgnoreCase("companyId")) {
			companyId = request.getFieldValue();
		}
		if (request.getFieldName().equalsIgnoreCase("businessCaseAccess")) {
			businessCaseAccess = request.getFieldValue();
		}
		if (request.getFieldName().equalsIgnoreCase("businessCaseReason")) {
			businessCaseReason = request.getFieldValue();
		}
		if (request.getFieldName().equalsIgnoreCase("state")) {
			state = request.getFieldValue();
		}
		if (request.getFieldName().equalsIgnoreCase("country")) {
			country = request.getFieldValue();
		}
//		if (request.getFieldName().equalsIgnoreCase("role")) {
//			role = request.getFieldValue();
//		}
		if (request.getFieldName().equalsIgnoreCase("internalId")) {
			String interId = request.getFieldValue();
			try {
				int integerInterId = Integer.parseInt(interId);
				internalId = integerInterId;
			} catch (NumberFormatException exception) {
				throw new RuntimeException("The Internal ID should be a number");
			}

		}

		if (request.getFieldName().equalsIgnoreCase("postalCode")) {
			postalCode = request.getFieldValue();
		}
		
		// build the user instance
		User user = new User(username, internalId, catrecId, clientId, email, cwsId, telephoneNumber, signinName,
				lastName, firstName, displayName, dealerId, companyId, businessCaseAccess, businessCaseReason,
				state, country, role, postalCode);
		user.setCreateDate(Date.valueOf(LocalDate.now()));
		user.setModifiedDate(Date.valueOf(LocalDate.now()));
		if(user.getGuid() == null) {
			user.setGuid(UUID.randomUUID().toString());
		}
		return user;
	}
	
	public User acquireExistingUserDetails(User existingUser) {
		User user = new User(
				existingUser.getUserName(), 
				existingUser.getInternalId(), 
				existingUser.getCatrecId(), 
				existingUser.getClientId(), 
				existingUser.getEmail(), 
				existingUser.getCwsId(), 
				existingUser.getTelephoneNumber(), 
				existingUser.getSigninName(), 
				existingUser.getLastName(), 
				existingUser.getFirstName(), 
				existingUser.getDisplayName(), 
				existingUser.getDealerId(), 
				existingUser.getCompanyId(), 
				existingUser.getBusinessCaseAccess(), 
				existingUser.getBusinessCaseReason(), 
				existingUser.getState(), 
				existingUser.getCountry(), 
				existingUser.getRole(),  
				existingUser.getPostalCode());
		System.out.println("existing user id: " +existingUser.getGuid());
		user.setGuid(existingUser.getGuid());
		user.setCreateDate(existingUser.getCreateDate());
		user.setModifiedDate(Date.valueOf(LocalDate.now()));
		return user;
	}

}
