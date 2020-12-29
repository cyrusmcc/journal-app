package com.producedaily.productivityapp;

import com.producedaily.productivityapp.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeRestController {

    @GetMapping("/home/wip")
    public String tempMethod() {
        return "Page WIP";
    }


}
