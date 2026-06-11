package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@ComponentScan(basePackages ="org.example")
//@ComponentScan(basePackages ={"org.example" , "org.not_visible"})
@PropertySource("classpath:application.properties")
@ImportResource("classpath:applicationContext.xml")
public class AppConfig {

    @Value("${database.url}")
    private String databaseUrl;

    @Value("${database.user}")
    private String user;

    @Value("${database.password}")
    private String password;

    public AppConfig() {
        System.out.println("AppConfig constructor: " +
                databaseUrl + " " +
                user + " " +
                password );
    }

    @PostConstruct
    void init(){
        System.out.println("AppConfig postConstruct: " + databaseUrl + " " + user + " " + password );
    }

    @PreDestroy
    void destroy(){
        System.out.println("AppConfig destroy");
    }

    @Bean
    public Bean2 bean2() {
        return new Bean2();
    }

}
