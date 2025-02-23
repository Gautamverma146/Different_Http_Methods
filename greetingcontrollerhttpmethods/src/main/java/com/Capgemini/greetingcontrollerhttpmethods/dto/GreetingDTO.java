package com.Capgemini.greetingcontrollerhttpmethods.dto;

public class GreetingDTO {
    String firstName;
    String lastName;
    public GreetingDTO(){}
    public GreetingDTO(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
