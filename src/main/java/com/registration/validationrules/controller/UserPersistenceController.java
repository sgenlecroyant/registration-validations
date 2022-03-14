
package com.registration.validationrules.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.registration.validationrules.entity.User;
import com.registration.validationrules.exception.InvalidIdException;
import com.registration.validationrules.exception.UserNotFoundException;
import com.registration.validationrules.model.ApplicationRegistrationMetadatResponse;
import com.registration.validationrules.model.Field;
import com.registration.validationrules.model.Section;
import com.registration.validationrules.model.Source;
import com.registration.validationrules.model.validationRules;
import com.registration.validationrules.repos.UserRepo;
import com.registration.validationrules.requestmodel.UserRequest;
import com.registration.validationrules.requestmodel.UserRequestFields;
import com.registration.validationrules.userservice.UserService;
import com.registration.validationrules.validationservice.UserRegistrationValidationService;
import com.registration.validationrules.validationservice.userRequesValidation.UserRequestValidatorService;

@RestController
public class UserPersistenceController {

	private static final String NULL_USERNAME_MSG = "username is not accepted";
	private static final String NULL_USERNAME_DESC = "the username is required";
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserRegistrationValidationService validationService;

	@Autowired
	private UserRequestValidatorService userRequestValidatorService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo userRepo;

	@GetMapping(value = "/register/{client_id}")
	private ApplicationRegistrationMetadatResponse getApplicationRegistrationMetadatResponse(
			@PathVariable String client_id) {

		String regexPattern = "(^[a-zA-Z0-9-_.']+@[a-zA-Z0-9-_.']+.[a-zA-Z]+$)|(^[a-zA-Z0-9-_.#$&+']{3,320}$)";

		Source source = new Source("B2C", List.of("Registeration", "Helios"));
		List<String> dropdpwn = List.of("Standard", "Admin");
		validationRules validationRules = new validationRules(true, 1, 50, regexPattern, dropdpwn);
		List<Field> fields = List
				.of(new Field("firstName", "first name", "text", "text", 1, "contact", 1, 1, source, validationRules));

		Section section = new Section("contact", 1, "register", fields);

		ApplicationRegistrationMetadatResponse response = new ApplicationRegistrationMetadatResponse("Fleet management",
				"Fleet management", List.of(section));
		return response;
	}

	@PostMapping(value = "/users")
	public ResponseEntity<User> createUser(@RequestBody(required = false) UserRequest userRequest) {
		String client_id = UUID.randomUUID().toString();
		String url = "http://localhost:8080/register/" + client_id;
		ResponseEntity<ApplicationRegistrationMetadatResponse> responseEntity = this.restTemplate.getForEntity(url,
				ApplicationRegistrationMetadatResponse.class);
		ApplicationRegistrationMetadatResponse metadatResponse = responseEntity.getBody();
		List<UserRequestFields> userRequestFields = userRequest.getFields();

		String clientId = userRequest.getClientId();
		String catrecId = userRequest.getCatrecId();
		String cwsId = userRequest.getCwsId();
		String username = userRequest.getUsername();

		// validate IDs
		boolean areIdsValid = this.userRequestValidatorService.validateIds(clientId, catrecId, cwsId);
		System.out.println("client_id: " + client_id + "catrecId:" + catrecId + "cwsId: " + cwsId);
		if (!areIdsValid) {
			throw new InvalidIdException("Invalid ID", "No ID should be NULL or EMPTY");
		}

		List<Section> sections = metadatResponse.getSections();

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

		User user = null;

		for (int i = 0; i < sections.size(); i++) {
			Section section = sections.get(i);

			for (int j = 0; j < section.getFields().size(); j++) {
				Field field = section.getFields().get(j);

				validationRules validationRules = field.getValidationRules();

				for (int k = 0; k < userRequestFields.size(); k++) {
					UserRequestFields request = userRequestFields.get(k);

					if (validationRules.getIsMondatory()) {

						this.validationService.validateFieldName.apply(request.getFieldName());

						this.validationService.validateFieldValue(request.getFieldValue(),
								validationRules.getMinLength(), validationRules.getMaxLength());
					}
					System.out.println(request);
//					if(request.getFieldName().equalsIgnoreCase("role")) {
//						this.validationService.validateUserRole(request.getFieldValue(), validationRules.getDropdown());
//						if(request.getFieldName().equalsIgnoreCase("role")) {
//							role = request.getFieldValue();
//						}
//					}
//					
//					
//					if (request.getFieldName().equalsIgnoreCase("firstName")) {
//						firstName = request.getFieldValue();
//						System.out.println("firstName: ".toUpperCase()+ ""+firstName);
//					}
//					if (request.getFieldName().equalsIgnoreCase("lastName")) {
//						lastName = request.getFieldValue();
//						System.out.println("lastName: ".toUpperCase()+ ""+lastName);
//					}
//					if (request.getFieldName().equalsIgnoreCase("email")) {
//						email = request.getFieldValue();
//						System.out.println("email: ".toUpperCase()+ ""+email);
//					}
//
//					if (request.getFieldName().equalsIgnoreCase("telephoneNumber")) {
//						telephoneNumber = request.getFieldValue();
//						System.out.println("phoneNumber: ".toUpperCase()+ ""+telephoneNumber);
//					}
//					if (request.getFieldName().equalsIgnoreCase("signinName")) {
//						signinName = request.getFieldValue();
//					}
//					
//					if (request.getFieldName().equalsIgnoreCase("displayName")) {
//						displayName = request.getFieldValue();
//					}
//					
//					if (request.getFieldName().equalsIgnoreCase("dealerId")) {
//						dealerId = request.getFieldValue();
//					}
//					if (request.getFieldName().equalsIgnoreCase("companyId")) {
//						companyId = request.getFieldValue();
//					}
//					if (request.getFieldName().equalsIgnoreCase("businessCaseAccess")) {
//						businessCaseAccess = request.getFieldValue();
//					}
//					if (request.getFieldName().equalsIgnoreCase("businessCaseReason")) {
//						businessCaseReason = request.getFieldValue();
//					}
//					if (request.getFieldName().equalsIgnoreCase("state")) {
//						state = request.getFieldValue();
//					}
//					if (request.getFieldName().equalsIgnoreCase("country")) {
//						country = request.getFieldValue();
//					}
////					if (request.getFieldName().equalsIgnoreCase("role")) {
////						role = request.getFieldValue();
////					}
//					if (request.getFieldName().equalsIgnoreCase("internalId")) {
//						String interId = request.getFieldValue();
//						try {
//							int integerInterId = Integer.parseInt(interId);
//							internalId = integerInterId;
//						} catch (NumberFormatException exception) {
//							throw new RuntimeException("The Internal ID should be a number");
//						}
//
//					}
////					if(request.getFieldName().equalsIgnoreCase("internalId")) {
////						internalId = Integer.parseInt(request.getFieldValue());
////					}
////
//					if (request.getFieldName().equalsIgnoreCase("postalCode")) {
//						postalCode = request.getFieldValue();
//					}
//
//					// build the user instance
//					user = new User(username, internalId, catrecId, clientId, email, cwsId, telephoneNumber, signinName,
//							lastName, firstName, displayName, dealerId, companyId, businessCaseAccess, businessCaseReason,
//							state, country, role, postalCode);
//					user.setCreateDate(Date.valueOf(LocalDate.now()));
//					user.setModifiedDate(Date.valueOf(LocalDate.now()));
					user = this.userService.buildUserBean(request, validationRules.getDropdown(), clientId, catrecId,
							cwsId, username, validationRules.getRegex());

				}
			}
		}
		this.userRepo.save(user);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PatchMapping(value = "/users/update/{guid}")
	public ResponseEntity<User> updateUser(@RequestBody UserRequest userRequest, @PathVariable String guid) {
		Optional<User> findByGuid = this.userRepo.findByGuid(guid);
		if (findByGuid.isEmpty()) {
			throw new UserNotFoundException("there is no user with such GUID: " + guid, "Provide the correct ID");
		}

		String client_id = UUID.randomUUID().toString();
		String url = "http://localhost:8080/register/" + client_id;
		ResponseEntity<ApplicationRegistrationMetadatResponse> responseEntity = this.restTemplate.getForEntity(url,
				ApplicationRegistrationMetadatResponse.class);
		ApplicationRegistrationMetadatResponse metadatResponse = responseEntity.getBody();
		List<UserRequestFields> userRequestFields = userRequest.getFields();

		List<Section> sections = metadatResponse.getSections();

		User user = findByGuid.get();
		User userToSave = null;

//		boolean areIdsValid = this.userRequestValidatorService.validateIds(user.getClientId(),
//				user.getCatrecId(), user.getCwsId());
		boolean areIdsValid = this.userRequestValidatorService.validateIds(userRequest.getClientId(),
				userRequest.getCatrecId(), userRequest.getCwsId());

		if (!areIdsValid) {
			throw new InvalidIdException("Invalid ID", "No ID should be NULL or EMPTY");
		}

		for (int i = 0; i < sections.size(); i++) {
			Section section = sections.get(i);

			for (int j = 0; j < section.getFields().size(); j++) {
				Field field = section.getFields().get(j);

				validationRules validationRules = field.getValidationRules();

				for (int k = 0; k < userRequestFields.size(); k++) {
					UserRequestFields request = userRequestFields.get(k);
					if (validationRules.getIsMondatory()) {

						this.validationService.validateFieldName.apply(request.getFieldName());

						this.validationService.validateFieldValue(request.getFieldValue(),
								validationRules.getMinLength(), validationRules.getMaxLength());
					}

					//
					User updatedDetails = this.userService.buildUserBean(request, validationRules.getDropdown(),
							user.getClientId(), guid, user.getCwsId(), user.getUserName(), validationRules.getRegex());
					userToSave = this.userService.acquireExistingUserDetails(updatedDetails);
				}
			}
		}
		String id = findByGuid.get().getGuid();
		userToSave.setGuid(id);
		this.userRepo.save(userToSave);
		return new ResponseEntity<User>(userToSave, HttpStatus.OK);
	}

}
