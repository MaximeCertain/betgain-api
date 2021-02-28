package com.hitweb.betgain.domain.bet.service;

import com.hitweb.betgain.domain.bet.service.payload.request.BetRequest;
import com.hitweb.betgain.domain.bet.service.payload.request.ListBetRequest;
import com.hitweb.betgain.domain.bet.service.payload.response.BetResponse;
import com.hitweb.betgain.domain.bet.service.payload.response.ListBetResponse;

public interface BetService {
    public BetResponse bet(BetRequest betRequest);
    public ListBetResponse getHistory(ListBetRequest listBetRequest);
}
