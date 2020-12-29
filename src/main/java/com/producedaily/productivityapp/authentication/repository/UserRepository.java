package com.producedaily.productivityapp.authentication.repository;

import com.producedaily.productivityapp.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
