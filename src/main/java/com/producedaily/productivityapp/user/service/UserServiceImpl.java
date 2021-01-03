package com.producedaily.productivityapp.user.service;

import com.producedaily.productivityapp.user.model.User;
import com.producedaily.productivityapp.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class  UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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
    public User findByUsername(String username) {

        User user = null;

        if(userRepository.findByUsername(username) != null) {

            user = userRepository.findByUsername(username);

        } else {
            throw new UsernameNotFoundException("User " + username + " Not found.");
        }

        return user;
    }

    @Override
    public void save(User user) {

        user.setId(0);

        String password= user.getPassword();

        String encryptedPwd = passwordEncoder.encode(password);

        user.setPassword(encryptedPwd);

        user.setRole("ROLE_USER");

        user.setLocalDate(LocalDate.now().toString());

        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
