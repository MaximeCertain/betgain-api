package com.hitweb.betgain.application.controller;

import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("hello")
    String getHelloWorld() {
        return "ça marche de fou";
    }

}
