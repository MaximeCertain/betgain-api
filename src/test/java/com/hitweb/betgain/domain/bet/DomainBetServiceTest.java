package com.hitweb.betgain.domain.bet;

import com.hitweb.betgain.domain.bet.model.*;
import com.hitweb.betgain.domain.bet.ports.BetRepository;
import com.hitweb.betgain.domain.bet.ports.BetStateRepository;
import com.hitweb.betgain.domain.bet.ports.OddRepository;
import com.hitweb.betgain.domain.bet.ports.OddTypeRepository;
import com.hitweb.betgain.domain.bet.service.payload.request.BetRequest;
import com.hitweb.betgain.domain.bet.service.payload.response.BetResponse;
import com.hitweb.betgain.domain.bet.service.payload.response.EBetResponseCode;
import com.hitweb.betgain.domain.bet.usecases.BetUseCase;
import com.hitweb.betgain.domain.user.model.Client;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.ports.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DomainBetServiceTest {

    @MockBean
    BetRepository betRepository;
    @MockBean
    BetStateRepository betStateRepository;
    @MockBean
    OddRepository oddRepository;
    @MockBean
    OddTypeRepository oddTypeRepository;
    @MockBean
    UserRepository userRepository;

    @Test
    public void testBet() {

        BetState betState = new BetState();
        betState.setId(1);
        betState.setCode(EBetState.ISSUED.toString());
        betState.setLabel("Paris émis");
        User user = new User();
        user.setId(5);

        Client client = new Client();
        client.setId(5);
        client.setCapital(569.36F);

        Mockito.when(betStateRepository.findBetStateByCode(EBetState.ISSUED)).thenReturn(betState);
        Mockito.when(userRepository.findUser(5)).thenReturn(client);

        OddType oddType = new OddType(1, EOddType.HOME_TEAM_WON, "Equipe domicile gagne");
        Odd odd = new Odd(oddType, 12.63f, 3);


        BetRequest betRequest = new BetRequest();
        betRequest.setUserId(5);
        betRequest.setAmount(12.69f);
        betRequest.setOdd(odd);
        betRequest.setLoggedClient(user);

        Bet bet = new Bet();
        bet.setOdd(betRequest.getOdd());
        bet.setUser(client);
        bet.setDate(new Date());
        bet.setAmount(betRequest.getAmount());

        Mockito.when(betRepository.save(any())).thenReturn(bet);

        BetResponse betResponse = new BetUseCase(betRepository, betStateRepository, oddTypeRepository, oddRepository, userRepository).bet(betRequest);
        assertEquals(EBetResponseCode.SUCCESS, betResponse.getResponseCode());
    }
}
