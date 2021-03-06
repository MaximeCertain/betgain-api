package com.hitweb.betgain.infrastructure.postgres.repository.match;

import com.hitweb.betgain.domain.match.model.Team;
import com.hitweb.betgain.domain.match.ports.TeamRepository;
import com.hitweb.betgain.infrastructure.postgres.adapters.TeamAdapter;
import com.hitweb.betgain.infrastructure.postgres.entities.TeamEntity;
import org.springframework.stereotype.Component;

@Component
public class PostgresTeamRepository implements TeamRepository {


    private final JpaTeamRepository jpaTeamRepository;

    public PostgresTeamRepository(JpaTeamRepository jpaTeamRepository) {
        this.jpaTeamRepository = jpaTeamRepository;
    }


    public Team getMatch(String code) {
        TeamEntity matchEntity = jpaTeamRepository.findByCode(code);

        if (matchEntity == null) {
            return null;
        }

        return TeamAdapter.reverse(matchEntity);
    }

    public Team save(Team team) {
        TeamEntity teamEntity = TeamAdapter.adapt(team);
        TeamEntity teamEntitySaved = jpaTeamRepository.save(teamEntity);
        return TeamAdapter.reverse(teamEntitySaved);

    }

}
