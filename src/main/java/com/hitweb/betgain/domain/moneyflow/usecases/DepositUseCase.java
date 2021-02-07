package com.hitweb.betgain.domain.moneyflow.usecases;

import com.hitweb.betgain.domain.moneyflow.model.EMoneyFlowState;
import com.hitweb.betgain.domain.moneyflow.model.MoneyFlow;
import com.hitweb.betgain.domain.moneyflow.model.MoneyFlowState;
import com.hitweb.betgain.domain.moneyflow.ports.MoneyFlowRepository;
import com.hitweb.betgain.domain.moneyflow.ports.MoneyFlowStateRepository;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.request.DepositRequest;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.response.EMoneyFlowResponseCode;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.response.MoneyFlowResponse;
import com.hitweb.betgain.domain.user.model.Client;
import com.hitweb.betgain.domain.user.ports.UserRepository;

import java.util.Date;

public class DepositUseCase {
    private final MoneyFlowRepository moneyFlowRepository;
    private final MoneyFlowStateRepository moneyFlowStateRepository;
    private final UserRepository userRepository;


    public DepositUseCase(MoneyFlowRepository moneyFlowRepository, MoneyFlowStateRepository moneyFlowStateRepository, UserRepository userRepository) {
        this.moneyFlowRepository = moneyFlowRepository;
        this.moneyFlowStateRepository = moneyFlowStateRepository;
        this.userRepository = userRepository;
    }

    public MoneyFlowResponse deposit(DepositRequest depositRequest) {

        MoneyFlowResponse moneyFlowResponse = new MoneyFlowResponse();

        if (depositRequest.getLoggedUser().getId() != depositRequest.getUserId()) {
            moneyFlowResponse.setMessage("vous ne pouvez pas retirer de l'argent pour un autre compte que le votre");
            moneyFlowResponse.setCodeResponse(EMoneyFlowResponseCode.INNAPROPRIATE_USER);
            return moneyFlowResponse;
        }

        if (new Float(depositRequest.getAmount()) == null) {
            moneyFlowResponse.setCodeResponse(EMoneyFlowResponseCode.INNAPROPRIATE_FIELDS);
            moneyFlowResponse.setMessage("Informations insuffisantes pour effectuer un dépôt, le montant doit être positif");
            return moneyFlowResponse;
        }

        Client client = (Client) userRepository.findUser(depositRequest.getUserId());

        if (!client.isValidated()) {
            moneyFlowResponse.setCodeResponse(EMoneyFlowResponseCode.INNAPROPRIATE_USER);
            moneyFlowResponse.setMessage("Le client ne peut effectuer de depôt il ne doit pas être banni");
            return moneyFlowResponse;
        }

        if ((client.getExpirationDate() == null || client.getCardNumber() == null || client.getVisualCryptogram() == null) &&
                (depositRequest.getCardNumber() == null || depositRequest.getExpirationDate() == null || depositRequest.getVisualCryptogram() == null)) {
            moneyFlowResponse.setCodeResponse(EMoneyFlowResponseCode.MISSING_BANK_INFORMATIONS);
            moneyFlowResponse.setMessage("Informations bancaires non présentes, enregistrez les sur votre profil ou entrez les avant le dépot");
            return moneyFlowResponse;
        }

        MoneyFlowState moneyFlowState = moneyFlowStateRepository.findMoneyFlowState(EMoneyFlowState.DEPOSIT);

        //creer une aciton money flow enregsité
        MoneyFlow moneyFlow = new MoneyFlow();
        moneyFlow.setAmount(depositRequest.getAmount());
        moneyFlow.setDate(new Date());
        moneyFlow.setMoneyFlowState(moneyFlowState);
        moneyFlow.setClient(client);

        MoneyFlow moneyFlowSaved = moneyFlowRepository.save(moneyFlow);

        //Maj le capital de l'utilisateur
        float currentCapital = client.getCapital();
        client.setCapital(currentCapital + moneyFlowSaved.getAmount());

        if (depositRequest.isSaveBankDetails()) {
            client.setVisualCryptogram(depositRequest.getVisualCryptogram());
            client.setExpirationDate(depositRequest.getExpirationDate());
            client.setCardNumber(depositRequest.getCardNumber());
        }

        Client clientSaved = (Client) userRepository.save(client);

        moneyFlowResponse.setMoneyFlow(moneyFlow);
        moneyFlowResponse.setClient(clientSaved);
        moneyFlowResponse.setMessage("Le dépôt de " + moneyFlowSaved.getAmount() + " pour l'utilisateur " + clientSaved.getUsername() + " a bien été validé.");

        return moneyFlowResponse;
    }
}
