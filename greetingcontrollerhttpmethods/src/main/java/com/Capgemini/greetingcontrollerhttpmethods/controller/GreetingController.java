package com.Capgemini.greetingcontrollerhttpmethods.controller;

import com.Capgemini.greetingcontrollerhttpmethods.entity.GreetingEntity;
import com.Capgemini.greetingcontrollerhttpmethods.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/{id}")
    public Optional<GreetingEntity> getGreetingById(@PathVariable Long id) {
        Optional<GreetingEntity> greeting = greetingService.findById(id);
        if (greeting == null) {
            return Optional.of(new GreetingEntity("Greeting not found"));

        }
        return greeting;
    }
    @GetMapping("/all")
    public List<GreetingEntity> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
    //uscase 7
    @PutMapping("/update/{id}")
    public GreetingEntity updateGreeting(@PathVariable Long id, String newMessage){
        return greetingService.updateGreeting(id,newMessage);
    }
    //Use case 8
    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id){
        return greetingService.deleteGreeting(id);
    }

}
