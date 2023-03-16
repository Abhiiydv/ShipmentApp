package com.shipmentservice.exception;

import lombok.Data;

@Data
public class ShipmentNotFoundException extends RuntimeException{
    private String errorCode;

    public ShipmentNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}