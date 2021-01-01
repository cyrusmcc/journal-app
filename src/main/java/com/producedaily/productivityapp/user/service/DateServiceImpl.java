package com.producedaily.productivityapp.user.service;

import com.producedaily.productivityapp.user.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;

@Service
public class DateServiceImpl implements DateService {

    @Autowired
    private UserService userService;

    public DateServiceImpl() {
    }

    @Override
    public String getLocalDate(Principal principal) {
        User user = userService.findByUsername(principal.getName());

        return user.getLocal_date();
    }

    @Override
    public String getMonth(Principal principal) {

        LocalDate date = LocalDate.parse(getLocalDate(principal));

        return date.getMonth().toString();
    }

    @Override
    public int getDayOfMonth(Principal principal) {

        LocalDate date = LocalDate.parse(getLocalDate(principal));

        return date.getDayOfMonth();
    }

    @Override
    public int getDaysInMonth(Principal principal) {

        LocalDate date = LocalDate.parse(getLocalDate(principal));

        return date.lengthOfMonth();
    }
}
