package org.example.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {
    private final NotificationService notificationService;

    //example with @Qualifier("smsService")
    /*@Autowired
    public NotificationController(@Qualifier("smsService") NotificationService notificationService) {
        this.notificationService = notificationService;
        notificationService.send("startup message");
    }*/

    //example with @Primary
    //in cazul in care folosimi si @Qualifier, atunci acesta din urma are prioritate
    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
        notificationService.send("startup message");
    }

}
