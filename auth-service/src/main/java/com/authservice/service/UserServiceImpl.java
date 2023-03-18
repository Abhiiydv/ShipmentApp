package com.authservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authservice.entity.ShipmentDetails;
import com.authservice.entity.User;
import com.authservice.repository.UserRepository;
import com.authservice.service.external.APIClient;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private APIClient apiClient;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		if (user.getUserName() != null && user.getPassword()!=null &&user.getRole()!=null)
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userRepo.save(user);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUserName(username);
	}
	
	@Override
	public ShipmentDetails getShipmentById(Long id) {
		// TODO Auto-generated method stub
		ShipmentDetails s = apiClient.getShipment(id);
		return s;
	}
	
}
