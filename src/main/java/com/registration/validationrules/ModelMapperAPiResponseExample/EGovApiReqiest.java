package com.registration.validationrules.ModelMapperAPiResponseExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.registration.validationrules.model.ApplicationRegistrationMetadatResponse;

@RestController
public class EGovApiReqiest {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
//	@GetMapping(value = "/register/{client_id}")
//	public ApplicationRegistrationMetadatResponse getTodoById(@PathVariable Integer client_id) {
//		
//		ResponseEntity<ApplicationRegistrationMetadatResponse> responseEntity = this.restTemplate.getForEntity("the-e-gov-api-endpoint/"+client_id, ApplicationRegistrationMetadatResponse.class);
//		
//		ApplicationRegistrationMetadatResponse response = responseEntity.getBody();
//		
//		return response;
//	}

}
