package com.vinay.nagisetty.spring.security.learning.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        System.out.println("inside the controller");
        return "Hello from vinay nagisetty" + " "+request.getSession().getId();
    }
}
