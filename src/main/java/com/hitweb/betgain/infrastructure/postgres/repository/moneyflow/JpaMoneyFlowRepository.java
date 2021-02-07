package com.hitweb.betgain.infrastructure.postgres.repository.moneyflow;

import com.hitweb.betgain.infrastructure.postgres.entities.MoneyFlowEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaMoneyFlowRepository extends JpaRepository<MoneyFlowEntity, Long> {
    List<MoneyFlowEntity> findByUserId(long id);
}
