package com.hitweb.betgain.domain.match.ports;

import com.hitweb.betgain.domain.match.model.Competition;

import java.util.List;

public interface CompetitionRepository {
    public List<Competition> getNextMatchsSinceCompetition();
}
