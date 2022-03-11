package com.registration.validationrules.validationservice.userRequesValidation;

import org.springframework.stereotype.Service;

@Service
public class UserRequestValidatorService {
	
	public boolean validateIds(String clientId, String catrecId, String cwsId) {
		
		return clientId != null && !clientId.isEmpty()
				&& catrecId != null && !catrecId.isEmpty()
				&& cwsId != null && !cwsId.isEmpty();
	}

}
