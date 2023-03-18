package com.authservice.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentDetails {

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
