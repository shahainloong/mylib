package com.ac.mylib.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/con")
public class DemoController {
    
    @RequestMapping("/save")
    public String save(){
    	
        return "save ok.";
    }

}
