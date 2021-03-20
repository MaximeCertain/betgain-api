package com.hitweb.betgain.domain.match.usecases.payload.response;

import com.hitweb.betgain.domain.core.Response;

public class MatchResultsResponse extends Response {
    private int nbBetsTreated = 0;

    public int getNbBets() {
        return nbBetsTreated;
    }

    public void setNbBets(int nbBets) {
        this.nbBetsTreated = nbBets;
    }

    public void incrementNbBetsTreated() {
        this.nbBetsTreated++;
    }
}
