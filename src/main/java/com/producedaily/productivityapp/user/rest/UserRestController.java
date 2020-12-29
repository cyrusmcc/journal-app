package com.producedaily.productivityapp.rest;

import com.producedaily.productivityapp.user.entity.User;
import com.producedaily.productivityapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService) {
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

    @PostMapping("/users")
    public User addUser(@RequestBody User theUser) {

        theUser.setId(0);

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
