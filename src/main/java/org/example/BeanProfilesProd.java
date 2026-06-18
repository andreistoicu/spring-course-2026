package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class BeanProfilesProd {

    @Value("${app.message}")
    private String message;


    @PostConstruct
    void init(){
        System.out.println(message);
    }
}
