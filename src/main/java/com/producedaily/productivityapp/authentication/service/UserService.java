package com.producedaily.productivityapp.authentication.service;

import com.producedaily.productivityapp.authentication.model.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(int id);

    public void save(User theUser);

    public void deleteById(int id);
}
