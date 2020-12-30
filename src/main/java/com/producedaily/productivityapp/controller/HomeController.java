package com.producedaily.productivityapp.controller;

import com.producedaily.productivityapp.security.model.User;
import com.producedaily.productivityapp.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("")
    public String viewIndex(){
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "register-form";
    }

    @PostMapping("/process-register")
    public  String processRegistration(User user) {

        user.setId(0);

        String password= user.getPassword();

        String encryptedPwd = passwordEncoder.encode(password);

        user.setPassword(encryptedPwd);

        user.setRole("ROLE_USER");

        userService.save(user);

        return "register-success";
    }
}
