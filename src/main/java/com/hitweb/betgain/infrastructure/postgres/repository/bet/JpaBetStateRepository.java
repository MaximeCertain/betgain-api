package com.hitweb.betgain.infrastructure.postgres.repository.bet;

import com.hitweb.betgain.infrastructure.postgres.entities.BetStateEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.MoneyFlowStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBetStateRepository extends JpaRepository<BetStateEntity, Long> {
    <Optional> BetStateEntity findByCode(String code);
}
