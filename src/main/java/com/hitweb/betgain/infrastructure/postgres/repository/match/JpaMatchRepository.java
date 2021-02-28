package com.hitweb.betgain.infrastructure.postgres.repository.match;

import com.hitweb.betgain.infrastructure.postgres.entities.MatchEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.MoneyFlowStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMatchRepository extends JpaRepository<MatchEntity, Long> {
    <Optional> MatchEntity findByCode(String code);

}
