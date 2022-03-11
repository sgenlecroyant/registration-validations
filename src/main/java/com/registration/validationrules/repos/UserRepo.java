package com.registration.validationrules.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.validationrules.entity.User;

public interface UserRepo extends JpaRepository<User, String>{
	
	public boolean existsByUserName(String userName);
	public Optional<User> findByGuid(String guid);



}
