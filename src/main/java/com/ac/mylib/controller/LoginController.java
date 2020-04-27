package com.ac.mylib.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Value("${spring.jpa.database}")
    public String name;

    @RequestMapping("/user")
    public String thym(){
        return "login";
    }

}
