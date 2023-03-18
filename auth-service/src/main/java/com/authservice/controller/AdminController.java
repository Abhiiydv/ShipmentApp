package com.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authservice.entity.ShipmentDetails;
import com.authservice.service.AdminService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/admin")
public class AdminController {

	
	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/saveshipment")
	public ResponseEntity<ShipmentDetails> createshipment(@RequestBody ShipmentDetails s){
		ShipmentDetails s2 = adminService.saveShipment(s);
		return new ResponseEntity<ShipmentDetails>(s2,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ShipmentDetails> deleteShipment(@PathVariable Long id){
		adminService.deleteShipment(id);
		return new ResponseEntity<ShipmentDetails>(HttpStatus.OK);
	}
	
	@PutMapping("/updateshipment/{id}")
	public ResponseEntity<ShipmentDetails> updateShipment(@RequestBody ShipmentDetails s, @PathVariable Long id){
		ShipmentDetails s2 = adminService.updateShipmentDetails(s, id);
		return new ResponseEntity<ShipmentDetails>(s2,HttpStatus.OK);
	}
}
