package com.ac.mylib.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;

@RestController
@RequestMapping("/con")
public class DemoController {
    @Value("${spring.jpa.database}")
    public String name;

    @RequestMapping("/save")
    public String save(){
        return "save ok.";
    }

    @RequestMapping("/thym")
    public String thym(){
        return "login";
    }

}
