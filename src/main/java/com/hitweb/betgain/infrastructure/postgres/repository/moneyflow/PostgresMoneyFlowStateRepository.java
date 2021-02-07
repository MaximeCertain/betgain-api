package com.hitweb.betgain.infrastructure.postgres.repository.moneyflow;

import com.hitweb.betgain.domain.moneyflow.model.EMoneyFlowState;
import com.hitweb.betgain.domain.moneyflow.model.MoneyFlowState;
import com.hitweb.betgain.domain.moneyflow.ports.MoneyFlowStateRepository;
import com.hitweb.betgain.infrastructure.postgres.adapters.MoneyFlowStateAdapter;
import org.springframework.stereotype.Component;

@Component
public class PostgresMoneyFlowStateRepository implements MoneyFlowStateRepository {

    private final JpaMoneyFlowStateRepository jpaMoneyFlowStateRepository;

    public PostgresMoneyFlowStateRepository(JpaMoneyFlowStateRepository jpaMoneyFlowStateRepository) {
        this.jpaMoneyFlowStateRepository = jpaMoneyFlowStateRepository;
    }

    @Override
    public MoneyFlowState findMoneyFlowState(EMoneyFlowState code) {
        MoneyFlowState moneyFlowState = MoneyFlowStateAdapter.reverse(jpaMoneyFlowStateRepository.findByCode(code.toString()));

        return moneyFlowState;
    }

}
