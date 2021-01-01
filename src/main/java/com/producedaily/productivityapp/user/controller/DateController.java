package com.producedaily.productivityapp.user.controller;

import com.producedaily.productivityapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class DateController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/home", method = RequestMethod.GET)
    @ResponseBody
    public Model getActiveUser(Principal principal, Model model) {

        model.addAttribute("username", principal.getName());

        return model;
    }


}
