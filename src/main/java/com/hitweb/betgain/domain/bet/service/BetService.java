package com.hitweb.betgain.domain.bet.service;

import com.hitweb.betgain.domain.bet.service.payload.request.BetRequest;
import com.hitweb.betgain.domain.bet.service.payload.response.BetResponse;

public interface BetService {
    public BetResponse bet(BetRequest betRequest);
}
