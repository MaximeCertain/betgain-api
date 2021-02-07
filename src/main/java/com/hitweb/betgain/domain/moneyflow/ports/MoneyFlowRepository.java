package com.hitweb.betgain.domain.moneyflow.ports;

import com.hitweb.betgain.domain.moneyflow.model.MoneyFlow;
import com.hitweb.betgain.domain.user.model.User;

import java.util.ArrayList;
import java.util.List;

public interface MoneyFlowRepository {
    MoneyFlow save(MoneyFlow moneyFlow);
    List<MoneyFlow> list(long id);

}
