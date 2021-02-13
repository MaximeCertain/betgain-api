package com.hitweb.betgain.domain.match.usecases;

import com.hitweb.betgain.domain.match.model.Competition;
import com.hitweb.betgain.domain.match.ports.CompetitionRepository;
import com.hitweb.betgain.domain.match.usecases.payload.response.ListMatchsResponse;

import java.util.List;

public class ListMatchsUseCase {
    private final CompetitionRepository competitionRepository;


    public ListMatchsUseCase(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public ListMatchsResponse list() {
        ListMatchsResponse listMatchsResponse = new ListMatchsResponse();
        listMatchsResponse.setMessage("Liste des compétitions et de leurs prochains matchs");
        List<Competition> competitions = this.competitionRepository.getNextMatchsSinceCompetition();
        listMatchsResponse.setCompetitions(competitions);
        return listMatchsResponse;

    }
}
