package com.hitweb.betgain.domain.bet.service;

import com.hitweb.betgain.domain.bet.ports.BetRepository;
import com.hitweb.betgain.domain.bet.ports.BetStateRepository;
import com.hitweb.betgain.domain.bet.ports.OddRepository;
import com.hitweb.betgain.domain.bet.ports.OddTypeRepository;
import com.hitweb.betgain.domain.bet.service.payload.request.BetRequest;
import com.hitweb.betgain.domain.bet.service.payload.response.BetResponse;
import com.hitweb.betgain.domain.bet.usecases.BetUseCase;
import com.hitweb.betgain.domain.user.ports.UserRepository;

public class DomainBetService implements BetService {

    private final BetRepository betRepository;
    private final BetStateRepository betStateRepository;
    private final OddTypeRepository oddTypeRepository;
    private final OddRepository oddRepository;
    private final UserRepository userRepository;

    public DomainBetService(BetRepository betRepository, BetStateRepository betStateRepository, OddTypeRepository oddTypeRepository, OddRepository oddRepository, UserRepository userRepository) {
        this.betRepository = betRepository;
        this.betStateRepository = betStateRepository;
        this.oddTypeRepository = oddTypeRepository;
        this.oddRepository = oddRepository;
        this.userRepository = userRepository;
    }

    public BetResponse bet(BetRequest betRequest) {
        return (new BetUseCase(betRepository, betStateRepository, oddTypeRepository, oddRepository, userRepository)).bet(betRequest);
    }
}
