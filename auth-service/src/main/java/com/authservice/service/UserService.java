package com.authservice.service;

import java.util.Optional;

import com.authservice.entity.ShipmentDetails;
import com.authservice.entity.User;

public interface UserService {

	User createUser(User user);
	
	Optional<User> findByUsername(String username);
	
	ShipmentDetails getShipmentById(Long id);
}
