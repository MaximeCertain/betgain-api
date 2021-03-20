package com.hitweb.betgain.application.controller;

import com.hitweb.betgain.domain.bet.service.payload.request.BetRequest;
import com.hitweb.betgain.domain.match.service.MatchService;
import com.hitweb.betgain.domain.match.usecases.payload.request.MatchResultsRequest;
import com.hitweb.betgain.domain.match.usecases.payload.response.ListMatchsResponse;
import com.hitweb.betgain.domain.match.usecases.payload.response.MatchResultsResponse;
import com.hitweb.betgain.domain.user.model.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    /**
     * Depuis API scrapping :
     * awayTeam: {
     * code: "MAR",
     * goalsNumber: 2,
     * yellowCardNumber: 5,
     * redCardNumber: 1
     * },
     * homeTeam: {
     * code: "PSG",
     * goalsNumber: 3,
     * yellowCardNumber: 2,
     * redCardNumber 0
     * }
     *
     * @return
     */
    @PostMapping("matchs/{code}/results")
    public MatchResultsResponse postResultsForMatch(@PathVariable String code, @Valid @RequestBody MatchResultsRequest matchResultsRequest) {
        matchResultsRequest.setCodeMatch(code);
        return matchService.postResultsForMatchs(matchResultsRequest);
    }
}
