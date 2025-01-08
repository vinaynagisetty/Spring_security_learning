package com.vinay.nagisetty.spring.security.learning.serivce;

import com.vinay.nagisetty.spring.security.learning.model.Users;
import com.vinay.nagisetty.spring.security.learning.repository.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private UserRepo userRepo;
    private  AuthenticationManager authManager;
    private JWTService jwtService;

    public UserService(UserRepo userRepo, AuthenticationManager authManager, JWTService jwtService) {
        this.userRepo = userRepo;
        this.authManager = authManager;
        this.jwtService = jwtService;
    }


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public Users regiserUser(Users user){

        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken()  ;
        } else {
            return "fail";
        }
    }
}
