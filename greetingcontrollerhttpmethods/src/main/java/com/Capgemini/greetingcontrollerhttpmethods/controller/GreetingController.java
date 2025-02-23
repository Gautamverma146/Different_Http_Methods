package com.Capgemini.greetingcontrollerhttpmethods.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public String getGreeting(){
        //hello from Get
        return "hello";
    }
    @PostMapping
    public String postGreeting(){
        //hello from post
        return "hello from post"; 
    }
    @PutMapping
    public String putGreeting(){
        return "{\"message\": \"Hello from PUT!\"}";
    }
    @DeleteMapping
    public String deleteMapping(){
        return "{\"message\": \"Hello from DELETE!\"}";
    }

}
