package com.authservice.service.external;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.authservice.entity.ShipmentDetails;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

@FeignClient(url = "http://localhost:9091",value = "SHIPMENT-SERVICE")
public interface APIClient {

	@GetMapping("/{id}")
    public ShipmentDetails getShipment(@PathVariable("id") Long id );
    
	@PostMapping("/create-shipment")
	public ShipmentDetails saveShipment( @RequestBody ShipmentDetails s);

	@DeleteMapping("/delete/{id}")
	public void deleteShipment(@PathVariable("id") Long id);
	
	@PutMapping("/update-shipment/{id}")
	public ShipmentDetails updateShipment(@RequestBody ShipmentDetails s,@PathVariable("id") Long id);
}
