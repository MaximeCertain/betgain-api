package com.hitweb.betgain.domain.match.service;

import com.hitweb.betgain.domain.match.ports.CompetitionRepository;
import com.hitweb.betgain.domain.match.usecases.ListMatchsUseCase;
import com.hitweb.betgain.domain.match.usecases.payload.response.ListMatchsResponse;

public class DomainMatchService implements MatchService {
    private final CompetitionRepository competitionRepository;

    public DomainMatchService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public ListMatchsResponse listNextMatchs() {
        return new ListMatchsUseCase(competitionRepository).list();
    }
}
