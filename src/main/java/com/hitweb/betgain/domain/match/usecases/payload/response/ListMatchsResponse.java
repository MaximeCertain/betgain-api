package com.hitweb.betgain.domain.match.usecases.payload.response;

import com.hitweb.betgain.domain.core.Response;
import com.hitweb.betgain.domain.match.model.Competition;

import java.util.List;

public class ListMatchsResponse extends Response {
    private List<Competition> competitions;

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }
}
