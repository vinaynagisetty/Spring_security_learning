package com.vinay.nagisetty.spring.security.learning.serivce;

import com.vinay.nagisetty.spring.security.learning.model.UserPrincipal;
import com.vinay.nagisetty.spring.security.learning.model.Users;
import com.vinay.nagisetty.spring.security.learning.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUSerDetailsService  implements UserDetailsService {

    private UserRepo repo;

    public MyUSerDetailsService(UserRepo repo) {
        this.repo = repo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);

        System.out.println(username);
        System.out.println(user);
        if(user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user);
    }
}
