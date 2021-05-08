package com.hitweb.betgain.application.controller;

import com.hitweb.betgain.domain.bet.service.BetService;
import com.hitweb.betgain.domain.bet.service.payload.request.AddBetOnCommunityBetRequest;
import com.hitweb.betgain.domain.bet.service.payload.request.BetRequest;
import com.hitweb.betgain.domain.bet.service.payload.request.CommunityBetRequest;
import com.hitweb.betgain.domain.bet.service.payload.request.ListBetRequest;
import com.hitweb.betgain.domain.bet.service.payload.response.BetResponse;
import com.hitweb.betgain.domain.bet.service.payload.response.ListBetResponse;
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

    @GetMapping("history/{id}")
    public ListBetResponse getHistory(@PathVariable("id") int id) {
        ListBetRequest listBetRequest = new ListBetRequest(id, WebSecurityConfig.getUser());
        return betService.getHistory(listBetRequest);
    }

    @PostMapping("communityBet/{id}")
    public BetResponse createCommunityBet(@PathVariable("id") int id, @Valid @RequestBody CommunityBetRequest betRequest) {
        betRequest.setUserId(id);
        betRequest.setLoggedClient(WebSecurityConfig.getUser());
        return betService.bet(betRequest);
    }

    @PostMapping("communityBet/{id}/follow/{userId}")
    public BetResponse addBetOnCommnunityBet(@PathVariable("id") int id, @PathVariable("userId") int userId,
                                             @Valid @RequestBody AddBetOnCommunityBetRequest betRequest) {
        betRequest.setUserId(userId);
        betRequest.setCommunityBetId(id);
        betRequest.setLoggedClient(WebSecurityConfig.getUser());
        return betService.bet(betRequest);
    }
}
