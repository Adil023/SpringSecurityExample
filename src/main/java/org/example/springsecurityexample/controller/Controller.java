package org.example.springsecurityexample.controller;

import org.example.springsecurityexample.modle.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller { // in memory bank.az hacksnation.com

    List<User> users = new ArrayList<>(List.of(
            new User(1,"adil","adil123","adil@gmail.com"),
            new User(2,"nadir","nadir123","nadir@gmail.com"),
            new User(3,"taleh","taleh123","taleh@gmail.com")
    ));

    @GetMapping("/students") // csrf token
    public List<User> getAllUsers(){
        return users;
    }

    @PostMapping("/students")
    public String createStudent(@RequestBody User user){
        users.add(user);
        return "Success";
    }

}
