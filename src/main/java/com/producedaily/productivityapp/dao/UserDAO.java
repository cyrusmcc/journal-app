package com.producedaily.productivityapp.dao;


import com.producedaily.productivityapp.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> findAll();

    public User findById(int id);

    public void save(User theUser);

    public void deleteById(int id);

}
