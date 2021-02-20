package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.match.model.Team;
import com.hitweb.betgain.infrastructure.postgres.entities.TeamEntity;

public class TeamAdapter {
    public static TeamEntity adapt(Team team) {

        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setId(team.getId());
        teamEntity.setCode(team.getCode());
        teamEntity.setLogoPath(team.getLogo());
        teamEntity.setName(team.getName());

        return teamEntity;
    }

    public static Team reverse(TeamEntity teamEntity) {

        Team team = new Team(teamEntity.getId(), teamEntity.getName(), teamEntity.getLogoPath(), teamEntity.getCode());

        return team;
    }
}
