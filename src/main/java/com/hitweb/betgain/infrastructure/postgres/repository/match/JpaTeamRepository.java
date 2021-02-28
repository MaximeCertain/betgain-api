package com.hitweb.betgain.infrastructure.postgres.repository.match;

import com.hitweb.betgain.infrastructure.postgres.entities.MatchEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTeamRepository extends JpaRepository<TeamEntity, Long> {
    <Optional> TeamEntity findByCode(String code);


}
