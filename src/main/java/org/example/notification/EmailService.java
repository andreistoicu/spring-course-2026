package org.example.notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("USING ------ Sending EMAIL: " + message);
    }
}
