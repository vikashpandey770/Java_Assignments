package com.example;

public class OrderService {

    private PaymentGatewat paymentGateway;

    public void setPaymentGateway(PaymentGatewat paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void placeOrder() {

        System.out.println("Order placed");

        paymentGateway.makePayment();
    }
}