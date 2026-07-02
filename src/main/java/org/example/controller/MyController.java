package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    //@RequestMapping(value="/users/{userId}", method=RequestMethod.GET)
    @GetMapping("/users/{userId}")
    public String getUser(@PathVariable String userId, Model model){
        System.out.println("getUser: "  +  userId);
        model.addAttribute("userId", userId);

        return "users";
    }

    //@RequestMapping(value="/submitCredit", method=RequestMethod.POST)
    @PostMapping("/submitCredit")
    public String submitForm(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             Model model){

        model.addAttribute("name", name);
        System.out.println("The name is: "  +  name);
        System.out.println("The email is: "  +  email);

        return "success";
    }

}
