package com.hitweb.betgain.infrastructure.postgres.repository.moneyflow;

import com.hitweb.betgain.domain.moneyflow.model.EMoneyFlowState;
import com.hitweb.betgain.domain.user.model.ERole;
import com.hitweb.betgain.infrastructure.postgres.entities.MoneyFlowStateEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMoneyFlowStateRepository extends JpaRepository<MoneyFlowStateEntity, Long> {
    <Optional> MoneyFlowStateEntity findByCode(String code);
}
