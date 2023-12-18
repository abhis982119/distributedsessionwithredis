package com.distributed.session.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/save/user")
    public String saveUserName(@RequestParam String firstName, @RequestParam String lastName, HttpSession httpSession) {
        String userName = firstName + " " + lastName;
        httpSession.setAttribute("userName",userName );
        return "user details saved!";
    }

    @GetMapping
    public String greetUser(HttpSession httpSession){
        return "Hello, Mr." + httpSession.getAttribute("userName");
    }
}
