package com.shipmentservice.service;

import java.util.Optional;

import com.shipmentservice.entity.ShipmentDetails;

public interface ShipmentService {

	ShipmentDetails createShipment(ShipmentDetails shipmentDetails);
	
	public ShipmentDetails getShipmentDetailsById(Long id); 
	
	public void deleteById(Long shipmentId);
	
	public ShipmentDetails updateShipment(Long shipmentId, ShipmentDetails shipmentDetails);
	
}
