package com.spring.RentABook.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.RentABook.service.userServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.spring.RentABook.entity.User;
@Validated
@RestController
@Tag(name = "Users")
public class user {
    @Autowired
    private userServiceImpl userService;

    @GetMapping("/user/{id}")
    public User getUserByID(@PathVariable("id") String userID){
        return userService.getUserByID(userID);
    }
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping("/user")
    public User newUser(@jakarta.validation.Valid@RequestBody User user){
        System.out.print(user);
        return userService.createNewUser(user);
    }
    @GetMapping("/ok")
    public void demo(){
        System.out.println("HELLO");
    }
}
