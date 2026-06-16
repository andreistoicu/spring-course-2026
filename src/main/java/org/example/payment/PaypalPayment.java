package org.example.payment;

import org.springframework.stereotype.Component;

@Component
public class PaypalPayment implements PaymentMethod{
    @Override
    public void processPayment(double amount) {
        System.out.println("PaypalPayment processing payment of $: " + amount);
    }
}
