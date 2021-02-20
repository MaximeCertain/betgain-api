package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.match.model.Competition;
import com.hitweb.betgain.domain.user.model.Client;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.infrastructure.postgres.entities.CompetitionEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.UserEntity;

public class CompetitionAdapter {

    public static CompetitionEntity adapt(Competition competition) {
        CompetitionEntity competitionEntity = new CompetitionEntity();

        competitionEntity.setCode(competition.getCode());
        competitionEntity.setEndDate(competition.getEndDate());
        competitionEntity.setId(competition.getId());
        competitionEntity.setName(competition.getName());
        competitionEntity.setStartDate(competition.getStartDate());

        return competitionEntity;
    }

    public static Competition reverse(CompetitionEntity competitionEntity) {

        Competition competition = new Competition(competitionEntity.getId(), competitionEntity.getName(),
                competitionEntity.getStartDate(), competitionEntity.getEndDate(), competitionEntity.getCode());

        return competition;
    }
}
