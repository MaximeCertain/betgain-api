package com.hitweb.betgain.infrastructure.postgres.repository.bet;

import com.hitweb.betgain.infrastructure.postgres.entities.BetStateEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.OddTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOddTypeRepository extends JpaRepository<OddTypeEntity, Long> {
    <Optional> OddTypeEntity findByCode(String code);

}
