package com.hitweb.betgain.domain.moneyflow.usecases;

import com.hitweb.betgain.domain.moneyflow.model.MoneyFlow;
import com.hitweb.betgain.domain.moneyflow.ports.MoneyFlowRepository;
import com.hitweb.betgain.domain.moneyflow.ports.MoneyFlowStateRepository;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.request.ListMoneyFlowsRequest;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.response.ListMoneyFlowsResponse;
import com.hitweb.betgain.domain.user.ports.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class ListUserMoneyFlowsUseCase {

    private final MoneyFlowRepository moneyFlowRepository;

    public ListUserMoneyFlowsUseCase(MoneyFlowRepository moneyFlowRepository) {
        this.moneyFlowRepository = moneyFlowRepository;
    }

    public ListMoneyFlowsResponse list(ListMoneyFlowsRequest listMoneyFlowsRequest) {

        ListMoneyFlowsResponse listMoneyFlowsResponse = new ListMoneyFlowsResponse();

        if (listMoneyFlowsRequest.getLoggedUser().getId() != listMoneyFlowsRequest.getUserId()) {
            listMoneyFlowsResponse.setMessage("L'utilisateur souhaitant consulter son historique de dépot/retrait n'est pas le bon");
            return listMoneyFlowsResponse;
        }

        List<MoneyFlow> moneyFlows = moneyFlowRepository.list(listMoneyFlowsRequest.getUserId());

        listMoneyFlowsResponse.setMoneyFlows(moneyFlows);
        listMoneyFlowsResponse.setMessage("Historique de compte pour l'utilisateur " + listMoneyFlowsRequest.getLoggedUser().getUsername());

        return listMoneyFlowsResponse;

    }
}
