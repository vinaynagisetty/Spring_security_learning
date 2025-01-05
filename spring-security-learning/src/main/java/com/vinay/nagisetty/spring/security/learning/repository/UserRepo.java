package com.vinay.nagisetty.spring.security.learning.repository;

import com.vinay.nagisetty.spring.security.learning.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
