package com.hitweb.betgain.domain.match.usecases.payload.request;

import com.hitweb.betgain.domain.match.model.Opponent;

public class MatchResultsRequest {
    private Opponent awayTeam;
    private Opponent homeTeam;
    private String codeMatch;

    public Opponent getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Opponent awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Opponent getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Opponent homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getCodeMatch() {
        return codeMatch;
    }

    public void setCodeMatch(String codeMatch) {
        this.codeMatch = codeMatch;
    }
}
