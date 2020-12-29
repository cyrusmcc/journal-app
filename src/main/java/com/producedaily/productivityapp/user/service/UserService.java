package com.producedaily.productivityapp.user.service;

import com.producedaily.productivityapp.user.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(int id);

    public void save(User theUser);

    public void deleteById(int id);
}
