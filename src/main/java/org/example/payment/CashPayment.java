package org.example.payment;

import org.springframework.stereotype.Component;

@Component
public class CashPayment implements PaymentMethod{
    @Override
    public void processPayment(double amount) {
        System.out.println("CASH processing payment of $: " + amount);
    }
}
