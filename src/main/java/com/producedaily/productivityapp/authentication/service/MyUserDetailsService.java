package com.producedaily.productivityapp.authentication.service;

import com.producedaily.productivityapp.authentication.model.MyUserDetails;
import com.producedaily.productivityapp.authentication.model.User;
import com.producedaily.productivityapp.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        MyUserDetails myUserDetails = null;

        if(user != null) {

            myUserDetails = new MyUserDetails();

            myUserDetails.setUser(user);

        } else {
            throw new UsernameNotFoundException("User " + username + " does not exist");
        }
        return null;
    }
}
