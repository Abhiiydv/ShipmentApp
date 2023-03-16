package com.shipmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shipmentservice.entity.ShipmentDetails;

@Repository
public interface ShipmentRepository extends JpaRepository<ShipmentDetails, Long>{

	
}
