package com.infotech.exceptionhandlerdemo.controller;

import com.infotech.exceptionhandlerdemo.model.User;
import com.infotech.exceptionhandlerdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User registerUser(@Valid @RequestBody User user) {

        return userService.registerUser(user);
    }

}
