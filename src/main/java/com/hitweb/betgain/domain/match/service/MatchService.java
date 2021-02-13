package com.hitweb.betgain.domain.match.service;

import com.hitweb.betgain.domain.match.usecases.payload.response.ListMatchsResponse;

public interface MatchService {
    public ListMatchsResponse listNextMatchs();
}
