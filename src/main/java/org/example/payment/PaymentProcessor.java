package org.example.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class PaymentProcessor {

    private List<PaymentMethod> paymentMethods;

    @Autowired
    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @PostConstruct
    public void displayAndProcessAll() {
        double amount = 100;
        System.out.println("Available payment methods : " + paymentMethods.size());

        for(PaymentMethod paymentMethod : paymentMethods) {
            paymentMethod.processPayment(amount);
        }
    }
}
