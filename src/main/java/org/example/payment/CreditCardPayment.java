package org.example.payment;

import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements PaymentMethod{
    @Override
    public void processPayment(double amount) {
        System.out.println("CreditCard processing payment of $: " + amount);
    }
}
