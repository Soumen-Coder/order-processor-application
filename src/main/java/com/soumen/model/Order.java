package com.soumen.model;

//Lombok to be used later
public class Order {
    private String OrderId;
    private String emailId;
    private String phoneNumber;
    private Double parcelWeight;

    public Order(String orderId, String emailId, String phoneNumber, Double parcelWeight) {
        OrderId = orderId;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.parcelWeight = parcelWeight;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getParcelWeight() {
        return parcelWeight;
    }

    public void setParcelWeight(Double parcelWeight) {
        this.parcelWeight = parcelWeight;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderId='" + OrderId + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", parcelWeight=" + parcelWeight +
                '}';
    }
}
