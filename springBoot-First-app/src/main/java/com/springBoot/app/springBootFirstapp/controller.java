package com.springBoot.app.springBootFirstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/hello-world")
    public String hello(){
        return "hello World !";
    }

}
