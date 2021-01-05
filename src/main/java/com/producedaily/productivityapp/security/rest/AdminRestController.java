package com.producedaily.productivityapp.security.rest;

import com.producedaily.productivityapp.event.model.Event;
import com.producedaily.productivityapp.user.model.User;
import com.producedaily.productivityapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AdminRestController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {

        User theUser = userService.findById(userId);

        if (theUser == null) {
            throw new RuntimeException("User not found - " + userId);
        }
        return theUser;
    }

    @GetMapping("/users/username/{username}")
    public User getUserbyUsername(@PathVariable String username) {

        User theUser = userService.findByUsername(username);

        if (theUser == null) {
            throw new RuntimeException("User not found - " + username);
        }
        return theUser;
    }

    @GetMapping("/users/{userId}/events")
    public List<Event> getUserEventsById(@PathVariable int userId) {

        User theUser = userService.findById(userId);

        List<Event> events = theUser.getEvents();

        if (theUser == null) {
            throw new RuntimeException("User not found - " + userId);
        }
        return events;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User theUser) {

        theUser.setId(0);

        String password= theUser.getPassword();

        String encryptedPwd = passwordEncoder.encode(password);

        theUser.setPassword(encryptedPwd);

        userService.save(theUser);

        return theUser;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser) {

        userService.save(theUser);

        return theUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {

        User tempUser = userService.findById(userId);

        if(tempUser == null) {
            throw new RuntimeException("User not found - " + userId);
        }
        return "deleted user " + userId;
    }


}
