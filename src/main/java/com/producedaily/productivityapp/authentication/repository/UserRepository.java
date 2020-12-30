package com.producedaily.productivityapp.authentication.repository;

import com.producedaily.productivityapp.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

     User findByUsername(String username);
}
