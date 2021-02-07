package com.hitweb.betgain.domain.moneyflow;

import com.hitweb.betgain.domain.moneyflow.model.EMoneyFlowState;
import com.hitweb.betgain.domain.moneyflow.model.MoneyFlow;
import com.hitweb.betgain.domain.moneyflow.model.MoneyFlowState;
import com.hitweb.betgain.domain.moneyflow.ports.MoneyFlowRepository;
import com.hitweb.betgain.domain.moneyflow.ports.MoneyFlowStateRepository;
import com.hitweb.betgain.domain.moneyflow.usecases.DepositUseCase;
import com.hitweb.betgain.domain.moneyflow.usecases.WidthdrawUseCase;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.request.DepositRequest;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.request.WidthDrawRequest;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.response.EMoneyFlowResponseCode;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.response.MoneyFlowResponse;
import com.hitweb.betgain.domain.user.model.Client;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.ports.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.logging.LoggerGroup;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DomainMoneyFlowServiceTest {
    @MockBean
    MoneyFlowRepository moneyFlowRepository;

    @MockBean
    MoneyFlowStateRepository moneyFlowStateRepository;

    @MockBean
    UserRepository userRepository;

    @Test
    public void testDepositUseCase() {
        DepositRequest depositRequest = new DepositRequest();

        User loggedUser = new User();
        loggedUser.setId(2);

        depositRequest.setUserId(2);
        depositRequest.setAmount(256.3f);
        depositRequest.setLoggedUser(loggedUser);

        Client client = new Client();
        client.setId(2);
        client.setCapital(2550.6f);
        client.setValidated(true);
        client.setExpirationDate("afffff");
        client.setCardNumber("afffff");
        client.setVisualCryptogram("afffff");


        Mockito.when(userRepository.findUser(any(Long.class))).thenReturn(client);
        MoneyFlowState moneyFlowState = new MoneyFlowState();
        moneyFlowState.setCode(EMoneyFlowState.DEPOSIT.toString());
        Mockito.when(moneyFlowStateRepository.findMoneyFlowState(any())).thenReturn(moneyFlowState);
        MoneyFlow moneyFlow = new MoneyFlow();
        moneyFlow.setMoneyFlowState(moneyFlowState);
        moneyFlow.setAmount(depositRequest.getAmount());
        Mockito.when(moneyFlowRepository.save(any())).thenReturn(moneyFlow);

        Mockito.when(userRepository.save(any())).thenReturn(client);

        MoneyFlowResponse moneyFlowResponse = new DepositUseCase(moneyFlowRepository, moneyFlowStateRepository, userRepository).deposit(depositRequest);
        assertEquals(moneyFlowResponse.getCodeResponse(), EMoneyFlowResponseCode.INSUFFICIENT_FOUND);
    }

    @Test
    public void testWithdrawUseCase() {
        WidthDrawRequest withdrawRequest = new WidthDrawRequest();

        User loggedUser = new User();
        loggedUser.setId(2);

        withdrawRequest.setUserId(2);
        withdrawRequest.setAmount(256.3f);
        withdrawRequest.setLoggedUser(loggedUser);

        Client client = new Client();
        client.setId(2);
        client.setCapital(25.6f);
        client.setValidated(true);

        Mockito.when(userRepository.findUser(any(Long.class))).thenReturn(client);
        MoneyFlowState moneyFlowState = new MoneyFlowState();
        moneyFlowState.setCode(EMoneyFlowState.DEPOSIT.toString());
        Mockito.when(moneyFlowStateRepository.findMoneyFlowState(any())).thenReturn(moneyFlowState);
        MoneyFlow moneyFlow = new MoneyFlow();
        moneyFlow.setMoneyFlowState(moneyFlowState);
        moneyFlow.setAmount(withdrawRequest.getAmount());
        Mockito.when(moneyFlowRepository.save(any())).thenReturn(moneyFlow);

        Mockito.when(userRepository.save(any())).thenReturn(client);

        MoneyFlowResponse moneyFlowResponse = new WidthdrawUseCase(moneyFlowRepository, moneyFlowStateRepository, userRepository).widthdraw(withdrawRequest);
        assertEquals(moneyFlowResponse.getCodeResponse(), EMoneyFlowResponseCode.INSUFFICIENT_FOUND);
    }
}
