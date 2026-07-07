package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        SpringApplication.run(Main.class, args);
    }
}