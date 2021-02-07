package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.moneyflow.model.MoneyFlow;
import com.hitweb.betgain.domain.moneyflow.model.MoneyFlowState;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.infrastructure.postgres.entities.MoneyFlowEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.MoneyFlowEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.MoneyFlowStateEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.UserEntity;

public class MoneyFlowAdapter {

    public static MoneyFlowEntity adapt(MoneyFlow moneyFlow) {

        MoneyFlowEntity moneyFlowEntity = new MoneyFlowEntity();
        moneyFlowEntity.setId(moneyFlow.getId());
        moneyFlowEntity.setAmount(moneyFlow.getAmount());
        moneyFlowEntity.setDate(moneyFlow.getDate());

        if (moneyFlow.getMoneyFlowState() != null) {
            MoneyFlowStateEntity moneyFlowState = MoneyFlowStateAdapter.adapt(moneyFlow.getMoneyFlowState());
            moneyFlowEntity.setMoneyFlowState(moneyFlowState);
        }
        if (moneyFlow.getClient() != null) {
            UserEntity userEntity = UserAdapter.adapt(moneyFlow.getClient());
            moneyFlowEntity.setUser(userEntity);
        }

        return moneyFlowEntity;
    }

    public static MoneyFlow reverse(MoneyFlowEntity moneyFlowEntity) {

        MoneyFlow moneyFlow = new MoneyFlow();
        moneyFlow.setId(moneyFlowEntity.getId());
        moneyFlow.setDate(moneyFlowEntity.getDate());
        moneyFlow.setAmount(moneyFlowEntity.getAmount());

        if (moneyFlowEntity.getMoneyFlowState() != null) {
            MoneyFlowState moneyFlowState = MoneyFlowStateAdapter.reverse(moneyFlowEntity.getMoneyFlowState());
            moneyFlow.setMoneyFlowState(moneyFlowState);
        }

        return moneyFlow;
    }
}
