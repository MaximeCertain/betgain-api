package com.hitweb.betgain.application.controller;

import com.hitweb.betgain.domain.match.service.MatchService;
import com.hitweb.betgain.domain.match.usecases.payload.response.ListMatchsResponse;
import com.hitweb.betgain.domain.user.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/competitions")
public class MatchController {
    private final MatchService matchService;


    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("matchs")
    public ListMatchsResponse getAllMatchs() {
        return matchService.listNextMatchs();
    }
}
