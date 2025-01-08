package com.vinay.nagisetty.spring.security.learning.controller;

import com.vinay.nagisetty.spring.security.learning.model.Users;
import com.vinay.nagisetty.spring.security.learning.serivce.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegisterController {
    private UserService userService;

    public UserRegisterController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public Users regiserUser(@RequestBody Users user){
        return  userService.regiserUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Users user){
//        System.out.println(user);
        return userService.verify(user);
    }

}
