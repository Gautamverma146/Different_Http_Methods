package com.Capgemini.greetingcontrollerhttpmethods.controller;

import com.Capgemini.greetingcontrollerhttpmethods.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Autowired
    GreetingService greetingService;
    @GetMapping("/service")
    public String getServiceHello(){
        return greetingService.getHelloService();
    }

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
