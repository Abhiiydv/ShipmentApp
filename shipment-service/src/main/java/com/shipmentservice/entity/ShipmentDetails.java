package com.shipmentservice.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(name = "shipmentsequence", initialValue = 1001)
public class ShipmentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipmentsequence")
	private Long shipment_id;
	
	private String source;
	
	private String destination;
	
	private LocalDate dateOfDispatch;
	
	private LocalDate dateOfReceiving;
	
	private String country;
	
	private String currentLocation;
	
	private String currentStatus;
	
	private String senderName;
	
	private String senderAddress;
	
	private String phone;
	
	private String receiverName;
	
	private String receiverAddress;
	
	private String detailsOfPackage;
	
	private String modeOfTransport;
	
	private Double weight;
	
	private Integer quantity;
	
	private Integer ammount;
 
	
}
