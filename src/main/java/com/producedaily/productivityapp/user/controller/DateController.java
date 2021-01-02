package com.producedaily.productivityapp.user.controller;

import com.producedaily.productivityapp.user.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/home")
public class DateController {

    @Autowired
    private DateService dateService;

    @RequestMapping(method = RequestMethod.GET)
    public Model getActiveUserDate(Principal principal, Model model) {

        model.addAttribute("username", principal.getName());

        model.addAttribute("userLocalDate",
                dateService.getLocalDate(principal));

        model.addAttribute("month",
                dateService.getMonth(principal));

        model.addAttribute("dayOfMonth",
                dateService.getDayOfMonth(principal));

        model.addAttribute("daysInMonth",
                dateService.getDaysInMonth(principal));

        return model;
    }


}
