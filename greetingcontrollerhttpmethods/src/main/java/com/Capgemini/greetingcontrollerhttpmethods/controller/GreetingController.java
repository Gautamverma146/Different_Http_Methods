package com.Capgemini.greetingcontrollerhttpmethods.controller;

import com.Capgemini.greetingcontrollerhttpmethods.entity.GreetingEntity;
import com.Capgemini.greetingcontrollerhttpmethods.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Autowired
    GreetingService greetingService;

    @GetMapping("/service")
    public String getServiceHello() {
        return greetingService.getHelloService();
    }

    @GetMapping
    public String getGreeting() {
        //hello from Get
        return "hello";
    }

    @PostMapping
    public String postGreeting() {
        //hello from post
        return "hello from post";
    }

    @PutMapping
    public String putGreeting() {
        return "{\"message\": \"Hello from PUT!\"}";
    }

    @DeleteMapping
    public String deleteMapping() {
        return "{\"message\": \"Hello from DELETE!\"}";
    }

    @GetMapping("/personalized")
    public String getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }

    @PostMapping("/save/{message}")
    public ResponseEntity<GreetingEntity> saveMessage(@PathVariable("message") String message) {
        GreetingEntity saveMsg = greetingService.saveGreetingRepo(message);
        return new ResponseEntity<>(saveMsg, HttpStatus.OK);
    }
}
