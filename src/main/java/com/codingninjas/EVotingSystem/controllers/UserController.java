package com.codingninjas.EVotingSystem.controllers;


import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    @ResponseStatus(HttpStatus.OK)
    public void addVoter(@RequestBody User user){
        userService.addVoter(user);
    }

    @GetMapping("/user/all")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

}
