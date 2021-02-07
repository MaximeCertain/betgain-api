package com.hitweb.betgain.domain.moneyflow.service;

import com.hitweb.betgain.domain.moneyflow.ports.MoneyFlowRepository;
import com.hitweb.betgain.domain.moneyflow.ports.MoneyFlowStateRepository;
import com.hitweb.betgain.domain.moneyflow.usecases.DepositUseCase;
import com.hitweb.betgain.domain.moneyflow.usecases.ListUserMoneyFlowsUseCase;
import com.hitweb.betgain.domain.moneyflow.usecases.WidthdrawUseCase;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.request.DepositRequest;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.request.ListMoneyFlowsRequest;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.request.MoneyFlowRequest;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.request.WidthDrawRequest;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.response.ListMoneyFlowsResponse;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.response.MoneyFlowResponse;
import com.hitweb.betgain.domain.user.ports.UserRepository;

public class DomainMoneyFlowService implements MoneyFlowService {

    private final MoneyFlowRepository moneyFlowRepository;
    private final MoneyFlowStateRepository moneyFlowStateRepository;
    private final UserRepository userRepository;

    public DomainMoneyFlowService(MoneyFlowRepository moneyFlowRepository, MoneyFlowStateRepository moneyFlowStateRepository, UserRepository userRepository) {
        this.moneyFlowRepository = moneyFlowRepository;
        this.moneyFlowStateRepository = moneyFlowStateRepository;
        this.userRepository = userRepository;
    }

    public MoneyFlowResponse makeMoneyFlow(MoneyFlowRequest moneyFlowRequest) {
        if (moneyFlowRequest instanceof DepositRequest) {
            return new DepositUseCase(moneyFlowRepository, moneyFlowStateRepository, userRepository).deposit((DepositRequest) moneyFlowRequest);
        } else if (moneyFlowRequest instanceof WidthDrawRequest) {
            return new WidthdrawUseCase(moneyFlowRepository, moneyFlowStateRepository, userRepository).widthdraw((WidthDrawRequest) moneyFlowRequest);
        }
        return null;
    }

    @Override
    public ListMoneyFlowsResponse listMoneyFlows(ListMoneyFlowsRequest listMoneyFlowsRequest) {
        return new ListUserMoneyFlowsUseCase(moneyFlowRepository).list(listMoneyFlowsRequest);
    }

}
