package com.producedaily.productivityapp.security.service;

import com.producedaily.productivityapp.security.model.User;
import com.producedaily.productivityapp.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {

        Optional<User> result = userRepository.findById(id);

        User theUser = null;

        if (result.isPresent()) {
            theUser = result.get();
        } else {
            throw new RuntimeException("User " + id + " not found");
        }

        return theUser;
    }

    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
