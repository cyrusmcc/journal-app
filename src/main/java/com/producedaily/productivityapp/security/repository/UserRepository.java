package com.producedaily.productivityapp.security.repository;

import com.producedaily.productivityapp.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

     User findByUsername(String username);
}