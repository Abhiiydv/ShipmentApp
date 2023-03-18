package com.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authservice.entity.ShipmentDetails;
import com.authservice.service.external.APIClient;

@Service
public class AdminServiceImpl implements AdminService{

	
	@Autowired
	private APIClient apiClient;
	
	@Override
	public ShipmentDetails saveShipment(ShipmentDetails shipmentDetails) {
		// TODO Auto-generated method stub
		ShipmentDetails savedshipmet = apiClient.saveShipment(shipmentDetails);
		return savedshipmet;
	}
	
	@Override
	public void deleteShipment(Long shipmentId) {
		// TODO Auto-generated method stub
		apiClient.deleteShipment(shipmentId);
	}
	
	@Override
	public ShipmentDetails updateShipmentDetails(ShipmentDetails s, Long shipmentId) {
		// TODO Auto-generated method stub
		ShipmentDetails s1 = apiClient.updateShipment(s, shipmentId);
		return s1;
	}
	
	
}
