package com.vinay.nagisetty.spring.security.learning.serivce;

import com.vinay.nagisetty.spring.security.learning.model.Users;
import com.vinay.nagisetty.spring.security.learning.repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public Users regiserUser(Users user){

        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
