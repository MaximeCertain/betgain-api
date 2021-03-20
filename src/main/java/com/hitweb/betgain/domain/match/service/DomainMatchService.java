package com.hitweb.betgain.domain.match.service;

import com.hitweb.betgain.domain.bet.ports.BetRepository;
import com.hitweb.betgain.domain.bet.ports.BetStateRepository;
import com.hitweb.betgain.domain.bet.ports.OddRepository;
import com.hitweb.betgain.domain.match.ports.CompetitionRepository;
import com.hitweb.betgain.domain.match.ports.MatchRepository;
import com.hitweb.betgain.domain.match.ports.OpponentRepository;
import com.hitweb.betgain.domain.match.usecases.ListMatchsUseCase;
import com.hitweb.betgain.domain.match.usecases.TreatMatchResultsUseCase;
import com.hitweb.betgain.domain.match.usecases.payload.request.MatchResultsRequest;
import com.hitweb.betgain.domain.match.usecases.payload.response.ListMatchsResponse;
import com.hitweb.betgain.domain.match.usecases.payload.response.MatchResultsResponse;
import com.hitweb.betgain.domain.user.ports.UserRepository;

public class DomainMatchService implements MatchService {
    private final CompetitionRepository competitionRepository;
    private final MatchRepository matchRepository;
    private final OpponentRepository opponentRepository;
    private final BetRepository betRepository;
    private final OddRepository oddRepository;
    private final BetStateRepository betStateRepository;
    private final UserRepository userRepository;


    public DomainMatchService(CompetitionRepository competitionRepository, MatchRepository matchRepository, OpponentRepository opponentRepository, BetRepository betRepository, OddRepository oddRepository, BetStateRepository betStateRepository, UserRepository userRepository) {
        this.competitionRepository = competitionRepository;
        this.matchRepository = matchRepository;
        this.opponentRepository = opponentRepository;
        this.betRepository = betRepository;
        this.oddRepository = oddRepository;
        this.betStateRepository = betStateRepository;
        this.userRepository = userRepository;
    }

    public ListMatchsResponse listNextMatchs() {
        return new ListMatchsUseCase(competitionRepository).list();
    }

    public MatchResultsResponse postResultsForMatchs(MatchResultsRequest matchResultsRequest) {
        return new TreatMatchResultsUseCase(matchRepository, opponentRepository, oddRepository, betRepository, betStateRepository, userRepository).treat(matchResultsRequest);
    }
}
