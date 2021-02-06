package com.hitweb.betgain.application.controller;

import com.hitweb.betgain.domain.user.service.UserService;
import com.hitweb.betgain.domain.user.usecases.payload.request.ProfileRequest;
import com.hitweb.betgain.domain.user.usecases.payload.response.ClientResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("edit/{id}")
    public ClientResponse editProfile(@PathVariable("id") int id, @Valid @RequestBody ProfileRequest profileRequest) {
        System.out.println(profileRequest.getVisualCryptogram());
        profileRequest.setId(id);
        return userService.editProfile(profileRequest);
    }
}
