package com.Capgemini.greetingcontrollerhttpmethods.service;

import com.Capgemini.greetingcontrollerhttpmethods.entity.GreetingEntity;
import com.Capgemini.greetingcontrollerhttpmethods.repsitory.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {
@Autowired
    private GreetingRepository greetingRepository;
    public String getHelloService(){
        return "Hello World!";
    }
    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello World!";
        }
    }
    public GreetingEntity saveGreetingRepo(String message){
        GreetingEntity greetingEntity = new GreetingEntity(message);
        return greetingRepository.save(greetingEntity);
    }
    public Optional<GreetingEntity> findById(Long id){
        return Optional.ofNullable(greetingRepository.findById(id).orElse(null));
    }
    public List<GreetingEntity> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public GreetingEntity updateGreeting(Long id, String newMessage){
        GreetingEntity greeting = greetingRepository.findById(id).orElse(null);
        if(greeting != null){
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        }
        return new GreetingEntity("Greeting Not Found");
    }
    public String deleteGreeting(Long id){
        if(greetingRepository.existsById(id)){
            greetingRepository.deleteById(id);
            return "Greeting deleted successfully";
        }
        return "Greeting not found";
    }

}
