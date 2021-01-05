package com.producedaily.productivityapp.user.controller;

import com.producedaily.productivityapp.user.model.User;
import com.producedaily.productivityapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login-form";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {

        model.addAttribute("user", new User());

        return "register-form";
    }

    @PostMapping("/process-register")
    public String processRegistration(User user) {

        userService.save(user);

        return "register-success";
    }

}
