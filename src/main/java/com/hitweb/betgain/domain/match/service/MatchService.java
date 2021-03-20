package com.hitweb.betgain.domain.match.service;

import com.hitweb.betgain.domain.match.usecases.payload.request.MatchResultsRequest;
import com.hitweb.betgain.domain.match.usecases.payload.response.ListMatchsResponse;
import com.hitweb.betgain.domain.match.usecases.payload.response.MatchResultsResponse;

public interface MatchService {
    public ListMatchsResponse listNextMatchs();

    public MatchResultsResponse postResultsForMatchs(MatchResultsRequest matchResultsRequest);
}
