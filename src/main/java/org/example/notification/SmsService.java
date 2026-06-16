package org.example.notification;

import org.springframework.stereotype.Service;

@Service
public class SmsService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("USING ------  Sending SMS: " + message);
    }
}
