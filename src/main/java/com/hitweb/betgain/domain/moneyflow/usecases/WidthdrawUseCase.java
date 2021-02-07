package com.hitweb.betgain.domain.moneyflow.usecases;

import com.hitweb.betgain.domain.moneyflow.model.EMoneyFlowState;
import com.hitweb.betgain.domain.moneyflow.model.MoneyFlow;
import com.hitweb.betgain.domain.moneyflow.model.MoneyFlowState;
import com.hitweb.betgain.domain.moneyflow.ports.MoneyFlowRepository;
import com.hitweb.betgain.domain.moneyflow.ports.MoneyFlowStateRepository;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.request.DepositRequest;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.request.WidthDrawRequest;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.response.EMoneyFlowResponseCode;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.response.MoneyFlowResponse;
import com.hitweb.betgain.domain.user.model.Client;
import com.hitweb.betgain.domain.user.ports.UserRepository;

import java.util.Date;

public class WidthdrawUseCase {
    private final MoneyFlowRepository moneyFlowRepository;
    private final MoneyFlowStateRepository moneyFlowStateRepository;
    private final UserRepository userRepository;

    public WidthdrawUseCase(MoneyFlowRepository moneyFlowRepository, MoneyFlowStateRepository moneyFlowStateRepository, UserRepository userRepository) {
        this.moneyFlowRepository = moneyFlowRepository;
        this.moneyFlowStateRepository = moneyFlowStateRepository;
        this.userRepository = userRepository;

    }

    public MoneyFlowResponse widthdraw(WidthDrawRequest widthDrawRequest) {
        MoneyFlowResponse moneyFlowResponse = new MoneyFlowResponse();

        if (widthDrawRequest.getLoggedUser().getId() != widthDrawRequest.getUserId()) {
            moneyFlowResponse.setCodeResponse(EMoneyFlowResponseCode.INNAPROPRIATE_USER);
            moneyFlowResponse.setMessage("vous ne pouvez pas retirer de l'argent pour un autre compte que le votre");
            return moneyFlowResponse;
        }

        if (new Float(widthDrawRequest.getAmount()) == null) {
            moneyFlowResponse.setCodeResponse(EMoneyFlowResponseCode.INNAPROPRIATE_FIELDS);
            moneyFlowResponse.setMessage("Informations insuffisantes pour effectuer un dépôt");
            return moneyFlowResponse;
        }

        Client client = (Client) userRepository.findUser(widthDrawRequest.getUserId());

        if (!client.isValidated() || client.isStrikeOff()) {
            moneyFlowResponse.setCodeResponse(EMoneyFlowResponseCode.INNAPROPRIATE_USER);
            moneyFlowResponse.setMessage("Le client ne peut effectuer de retrait il doit être validé et ne pas être banni");
            return moneyFlowResponse;
        }

        if(client.getCapital() < widthDrawRequest.getAmount()){
            moneyFlowResponse.setCodeResponse(EMoneyFlowResponseCode.INSUFFICIENT_FOUND);
            moneyFlowResponse.setMessage("Le client n'a pas assez d'argent pour retirer");
            return moneyFlowResponse;
        }

        if ((client.getExpirationDate() == null || client.getCardNumber() == null || client.getVisualCryptogram() == null) &&
                (widthDrawRequest.getCardNumber() == null && widthDrawRequest.getExpirationDate() == null && widthDrawRequest.getVisualCryptogram() == null)) {
            moneyFlowResponse.setCodeResponse(EMoneyFlowResponseCode.MISSING_BANK_INFORMATIONS);
            moneyFlowResponse.setMessage("Informations bancaires non présentes, enregistrez les sur votre profil ou entrez les avant le dépot");
            return moneyFlowResponse;
        }

        MoneyFlowState moneyFlowState = moneyFlowStateRepository.findMoneyFlowState(EMoneyFlowState.WIDTHDRAW);

        //creer une aciton money flow enregistrée
        MoneyFlow moneyFlow = new MoneyFlow();
        moneyFlow.setAmount(widthDrawRequest.getAmount());
        moneyFlow.setDate(new Date());
        moneyFlow.setMoneyFlowState(moneyFlowState);
        moneyFlow.setClient(client);

        MoneyFlow moneyFlowSaved = moneyFlowRepository.save(moneyFlow);

        //Maj le capital de l'utilisateur
        float currentCapital = client.getCapital();
        client.setCapital(currentCapital - moneyFlowSaved.getAmount());

        if (widthDrawRequest.isSaveBankDetails()) {
            client.setVisualCryptogram(widthDrawRequest.getVisualCryptogram());
            client.setExpirationDate(widthDrawRequest.getExpirationDate());
            client.setCardNumber(widthDrawRequest.getCardNumber());
        }

        Client clientSaved = (Client) userRepository.save(client);

        moneyFlowResponse.setMoneyFlow(moneyFlow);
        moneyFlowResponse.setClient(clientSaved);
        moneyFlowResponse.setMessage("Le retrait de " + moneyFlowSaved.getAmount() + " pour l'utilisateur " + clientSaved.getUsername() + " a bien été validé.");

        return moneyFlowResponse;
    }

}
