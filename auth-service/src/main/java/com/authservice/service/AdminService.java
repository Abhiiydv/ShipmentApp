package com.authservice.service;

import com.authservice.entity.ShipmentDetails;

public interface AdminService {

	
	ShipmentDetails saveShipment(ShipmentDetails shipmentDetails);
	
	void deleteShipment(Long shipmentId);
	
	ShipmentDetails updateShipmentDetails(ShipmentDetails s, Long shipmentId);
	
	
	
}
