package com.Ex;

public class FoodOrder {

    private String orderId;
    private DeliveryDetails deliveryDetails;

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setDeliveryDetails(DeliveryDetails deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public DeliveryDetails getDeliveryDetails() {
        return deliveryDetails;
    }
}