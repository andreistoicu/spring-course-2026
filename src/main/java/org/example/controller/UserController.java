package org.example.controller;

import jakarta.annotation.PostConstruct;
import org.example.dao.entity.User;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init(){
        User user = new User();
        user.setUsername("admin");

        System.out.println("saving user: " + user);
        userService.createUser(user);
    }
}
