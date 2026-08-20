package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class LibraryApp {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        SpringApplication.run(LibraryApp.class, args);
    }
}