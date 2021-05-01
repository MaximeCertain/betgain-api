package com.hitweb.betgain.domain.bet.service;

import com.hitweb.betgain.domain.bet.ports.*;
import com.hitweb.betgain.domain.bet.service.payload.request.BetRequest;
import com.hitweb.betgain.domain.bet.service.payload.request.ListBetRequest;
import com.hitweb.betgain.domain.bet.service.payload.response.BetResponse;
import com.hitweb.betgain.domain.bet.service.payload.response.ListBetResponse;
import com.hitweb.betgain.domain.bet.usecases.BetHistoryUseCase;
import com.hitweb.betgain.domain.bet.usecases.BetUseCase;
import com.hitweb.betgain.domain.user.ports.UserRepository;

public class DomainBetService implements BetService {

    private final BetRepository betRepository;
    private final BetStateRepository betStateRepository;
    private final OddTypeRepository oddTypeRepository;
    private final OddRepository oddRepository;
    private final UserRepository userRepository;
    private final CommunityBetRepository communityBetRepository;

    public DomainBetService(BetRepository betRepository, BetStateRepository betStateRepository, OddTypeRepository oddTypeRepository, OddRepository oddRepository, UserRepository userRepository, CommunityBetRepository communityBetRepository) {
        this.betRepository = betRepository;
        this.betStateRepository = betStateRepository;
        this.oddTypeRepository = oddTypeRepository;
        this.oddRepository = oddRepository;
        this.userRepository = userRepository;
        this.communityBetRepository = communityBetRepository;

    }

    public BetResponse bet(BetRequest betRequest) {
        return (new BetUseCase(betRepository, betStateRepository, oddTypeRepository, oddRepository, userRepository, communityBetRepository)).bet(betRequest);
    }

    public ListBetResponse getHistory(ListBetRequest listBetRequest) {
        return (new BetHistoryUseCase(betRepository, betStateRepository, oddTypeRepository, oddRepository, userRepository)).getBets(listBetRequest);

    }

}
