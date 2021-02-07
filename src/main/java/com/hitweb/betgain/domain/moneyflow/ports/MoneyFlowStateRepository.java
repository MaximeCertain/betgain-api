package com.hitweb.betgain.domain.moneyflow.ports;

import com.hitweb.betgain.domain.moneyflow.model.EMoneyFlowState;
import com.hitweb.betgain.domain.moneyflow.model.MoneyFlowState;
import com.hitweb.betgain.domain.user.model.User;

public interface MoneyFlowStateRepository {
    public MoneyFlowState findMoneyFlowState(EMoneyFlowState code);

}
