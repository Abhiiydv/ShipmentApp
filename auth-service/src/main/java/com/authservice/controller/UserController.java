package com.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authservice.entity.ShipmentDetails;
import com.authservice.service.UserService;
import com.authservice.service.external.APIClient;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/shipment/{id}")
	public ResponseEntity<ShipmentDetails> getShipment(@PathVariable("id") Long id){
		System.out.println("user controller.....");
		ShipmentDetails shipmentDetails = userService.getShipmentById(id);
		if(shipmentDetails == null) {
			System.out.println("no data");
		}
		System.out.println(shipmentDetails);
		return new ResponseEntity<ShipmentDetails>(shipmentDetails,HttpStatus.OK);
		
		
	}
	
	
}
