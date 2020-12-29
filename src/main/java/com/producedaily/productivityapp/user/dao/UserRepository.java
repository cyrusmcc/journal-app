package com.producedaily.productivityapp.user.dao;

import com.producedaily.productivityapp.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
