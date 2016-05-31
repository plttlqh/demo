package com.example.pattern.stategy.payment;

public class PaypayStrategy implements PaymentStrategy {
    private String emailId;
    private String password;

    public PaypayStrategy(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Paypal.");
    }
}
