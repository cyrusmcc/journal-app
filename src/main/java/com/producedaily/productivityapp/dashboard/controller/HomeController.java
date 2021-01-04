package com.producedaily.productivityapp.dashboard.controller;

import com.producedaily.productivityapp.event.model.Event;
import com.producedaily.productivityapp.event.service.EventService;
import com.producedaily.productivityapp.user.model.User;
import com.producedaily.productivityapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

        @RequestMapping(method = RequestMethod.GET)
        public Model getActiveUserData( Principal principal, Model model) {

            model.addAttribute("username", principal.getName());

            model.addAttribute("userLocalDate",
                userService.findLocalDate(principal));

            model.addAttribute("month",
                userService.findMonth(principal));

            model.addAttribute("dayOfMonth",
                userService.findDayOfMonth(principal));

            model.addAttribute("daysInMonth",
                userService.findDaysInMonth(principal));

            model.addAttribute("userEvents",
                    userService.findByUsername(principal.getName()).getId());

        return model;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void addEvent(@RequestBody Event theEvent) {

            theEvent.setId(0);

            eventService.save(theEvent);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteEvent(@RequestParam int id) {
            eventService.deleteById(id);
    }

}
