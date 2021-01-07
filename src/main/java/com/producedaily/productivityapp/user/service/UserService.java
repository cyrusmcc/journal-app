package com.producedaily.productivityapp.user.service;

import com.producedaily.productivityapp.user.model.User;

import java.security.Principal;
import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(long id);

    public User findByUsername(String username);

    public void save(User theUser);

    public void deleteById(long id);

    public String findLocalDate(Principal principal);

    public String findMonth(Principal principal);

    public int findDayOfMonth(Principal principal);

    public int findDaysInMonth(Principal principal);

}
