package com.hitweb.betgain.domain.bet.usecases;

import com.hitweb.betgain.domain.bet.model.Bet;
import com.hitweb.betgain.domain.bet.ports.BetRepository;
import com.hitweb.betgain.domain.bet.ports.BetStateRepository;
import com.hitweb.betgain.domain.bet.ports.OddRepository;
import com.hitweb.betgain.domain.bet.ports.OddTypeRepository;
import com.hitweb.betgain.domain.bet.service.payload.request.BetRequest;
import com.hitweb.betgain.domain.bet.service.payload.request.ListBetRequest;
import com.hitweb.betgain.domain.bet.service.payload.response.EBetResponseCode;
import com.hitweb.betgain.domain.bet.service.payload.response.ListBetResponse;
import com.hitweb.betgain.domain.user.model.ERole;
import com.hitweb.betgain.domain.user.ports.UserRepository;

import java.util.List;

public class BetHistoryUseCase {
    private final BetRepository betRepository;
    private final BetStateRepository betStateRepository;
    private final OddTypeRepository oddTypeRepository;
    private final OddRepository oddRepository;
    private final UserRepository userRepository;

    public BetHistoryUseCase(BetRepository betRepository, BetStateRepository betStateRepository, OddTypeRepository oddTypeRepository, OddRepository oddRepository, UserRepository userRepository) {
        this.betRepository = betRepository;
        this.betStateRepository = betStateRepository;
        this.oddTypeRepository = oddTypeRepository;
        this.oddRepository = oddRepository;
        this.userRepository = userRepository;
    }

    public ListBetResponse getBets(ListBetRequest listBetRequest) {

        ListBetResponse listBetResponse = new ListBetResponse();

        if (listBetRequest.getUserId() != listBetRequest.getLoggedUser().getId() && listBetRequest.getLoggedUser().hasRole(ERole.ROLE_USER)) {
            listBetResponse.setResponseCode(EBetResponseCode.INNAPROPRIATE_USER);
            listBetResponse.setMessage("vous ne pouvez pas visualiser cet histoirque de compte");
        }

        List<Bet> bets = betRepository.getBetsHistoric(listBetRequest.getUserId());

        listBetResponse.setBets(bets);

        return listBetResponse;
    }
}
