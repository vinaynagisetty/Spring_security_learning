package com.vinay.nagisetty.spring.security.learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/")
    public String greet() {
        return "Hello from vinay nagisetty";
    }
}
