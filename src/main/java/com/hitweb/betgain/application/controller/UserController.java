package com.hitweb.betgain.application.controller;

import com.hitweb.betgain.domain.user.model.ERole;
import com.hitweb.betgain.domain.user.model.Role;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.usecases.payload.request.UserRequest;
import com.hitweb.betgain.domain.user.usecases.payload.response.UserResponse;
import com.hitweb.betgain.domain.user.service.UserService;
import com.hitweb.betgain.infrastructure.services.auth.security.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public Iterable<User> getAllUsers() {
        /*User currentUser = WebSecurityConfig.getUser();
        for (Role role : currentUser.getRoles()){
            System.out.println(role.getName());
        }
        System.out.println(currentUser.hasRole(ERole.ROLE_ADMINISTRATOR));
        System.out.println(currentUser.hasRole(ERole.ROLE_OPERATOR));
        System.out.println(currentUser.hasRole(ERole.ROLE_USER));*/

        return userService.findAll();
    }

    @PostMapping("users")
    public UserResponse saveUser(@Valid @RequestBody UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

    @PutMapping("users/{id}")
    public UserResponse editUser(@PathVariable("id") int id, @Valid @RequestBody UserRequest userRequest) {
        userRequest.setId(id);
        return userService.editUser(userRequest);
    }

    @GetMapping("hello")
    String getHelloWorld() {
        return "ça marche de fou";
    }

}
