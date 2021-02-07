package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.moneyflow.model.MoneyFlow;
import com.hitweb.betgain.domain.moneyflow.model.MoneyFlowState;
import com.hitweb.betgain.domain.user.model.Role;
import com.hitweb.betgain.infrastructure.postgres.entities.MoneyFlowStateEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.RoleEntity;

public class MoneyFlowStateAdapter {

    public static MoneyFlowStateEntity adapt(MoneyFlowState moneyFlowState) {

        MoneyFlowStateEntity moneyFlowStateEntity = new MoneyFlowStateEntity();
        moneyFlowStateEntity.setId(moneyFlowState.getId());
        moneyFlowStateEntity.setCode(moneyFlowState.getCode());
        moneyFlowStateEntity.setLabel(moneyFlowState.getLabel());

        return moneyFlowStateEntity;
    }

    public static MoneyFlowState reverse(MoneyFlowStateEntity moneyFlowStateEntity) {

        MoneyFlowState moneyFlowState = new MoneyFlowState();
        moneyFlowState.setId(moneyFlowStateEntity.getId());
        moneyFlowState.setCode(moneyFlowStateEntity.getCode());
        moneyFlowState.setLabel(moneyFlowStateEntity.getLabel());

        return moneyFlowState;
    }
}
