package com.hitweb.betgain.infrastructure.postgres.repository.match;

import com.hitweb.betgain.infrastructure.postgres.entities.CompetitionEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCompetitionRepository extends JpaRepository<CompetitionEntity, Long> {
    <Optional> CompetitionEntity findByCode(String code);
}
