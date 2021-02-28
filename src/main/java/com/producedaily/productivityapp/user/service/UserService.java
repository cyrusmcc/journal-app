package com.producedaily.productivityapp.user.service;

import com.producedaily.productivityapp.goal.model.Goal;
import com.producedaily.productivityapp.user.model.User;

import java.security.Principal;
import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(long id);

    User findByUsername(String username);

    void save(User theUser);

    void deleteById(long id);

    String findLocalDate(Principal principal);

    String findMonth(Principal principal);

    int findDayOfMonth(Principal principal);

    int findDaysInMonth(Principal principal);

    List<Goal> findgoals(Principal principal);

}
