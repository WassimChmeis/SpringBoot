package com.example.tatata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = "/")
    public String greeting(){
        return "Hello there, this is a SpringBoot App!!";
    }

    @GetMapping(value = "/{name}")
    public String greetWithName(@PathVariable String name){
        return String.format("Welcome %s to our SpringBoot App!",name);
    }
}
