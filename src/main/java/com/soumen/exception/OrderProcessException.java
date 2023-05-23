package com.soumen.exception;

/*
* This class is responsible for handling Exceptions
 */
public class OrderProcessException extends RuntimeException{
    private String errorCode = "ORDER-PROCESS-ERROR400";

    public OrderProcessException(String message) {
        super(message);
    }

    public OrderProcessException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
