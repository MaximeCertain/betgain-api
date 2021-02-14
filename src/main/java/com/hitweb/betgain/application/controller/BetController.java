package com.hitweb.betgain.application.controller;

import com.hitweb.betgain.domain.bet.service.BetService;
import com.hitweb.betgain.domain.bet.service.payload.request.BetRequest;
import com.hitweb.betgain.domain.bet.service.payload.response.BetResponse;
import com.hitweb.betgain.infrastructure.services.auth.security.WebSecurityConfig;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/bets")
public class BetController {

    private final BetService betService;

    public BetController(BetService betService) {
        this.betService = betService;
    }

    @PostMapping("{id}")
    public BetResponse bet(@PathVariable("id") int id, @Valid @RequestBody BetRequest betRequest) {
        betRequest.setUserId(id);
        betRequest.setLoggedClient(WebSecurityConfig.getUser());
        return betService.bet(betRequest);
    }
}
