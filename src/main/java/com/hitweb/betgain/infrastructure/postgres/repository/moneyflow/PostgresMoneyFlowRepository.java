package com.hitweb.betgain.infrastructure.postgres.repository.moneyflow;

import com.hitweb.betgain.domain.moneyflow.model.MoneyFlow;
import com.hitweb.betgain.domain.moneyflow.ports.MoneyFlowRepository;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.infrastructure.postgres.adapters.MoneyFlowAdapter;
import com.hitweb.betgain.infrastructure.postgres.adapters.UserAdapter;
import com.hitweb.betgain.infrastructure.postgres.entities.MoneyFlowEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostgresMoneyFlowRepository implements MoneyFlowRepository {
    private final JpaMoneyFlowRepository jpaMoneyFlowRepository;

    public PostgresMoneyFlowRepository(JpaMoneyFlowRepository jpaMoneyFlowRepository) {
        this.jpaMoneyFlowRepository = jpaMoneyFlowRepository;
    }

    @Override
    public MoneyFlow save(MoneyFlow moneyFlow) {
        MoneyFlowEntity moneyFlowStateEntity = MoneyFlowAdapter.adapt(moneyFlow);
        MoneyFlowEntity newMoneyFlowENtity = jpaMoneyFlowRepository.save(moneyFlowStateEntity);
        return MoneyFlowAdapter.reverse(newMoneyFlowENtity);
    }

    @Override
    public List<MoneyFlow> list(long id) {
        List<MoneyFlow> moneyFlows = jpaMoneyFlowRepository.findByUserId(id).stream().map(moneyFlowEntity -> MoneyFlowAdapter.reverse(moneyFlowEntity)).collect(Collectors.toList());
        return moneyFlows;
    }
}
