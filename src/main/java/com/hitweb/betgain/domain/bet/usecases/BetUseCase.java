package com.hitweb.betgain.domain.bet.usecases;

import com.hitweb.betgain.domain.bet.model.Bet;
import com.hitweb.betgain.domain.bet.model.BetState;
import com.hitweb.betgain.domain.bet.model.CommunityBet;
import com.hitweb.betgain.domain.bet.model.EBetState;
import com.hitweb.betgain.domain.bet.ports.*;
import com.hitweb.betgain.domain.bet.service.payload.request.BetRequest;
import com.hitweb.betgain.domain.bet.service.payload.request.CommunityBetRequest;
import com.hitweb.betgain.domain.bet.service.payload.response.BetResponse;
import com.hitweb.betgain.domain.bet.service.payload.response.EBetResponseCode;
import com.hitweb.betgain.domain.user.model.Client;
import com.hitweb.betgain.domain.user.ports.UserRepository;

import java.util.Date;

public class BetUseCase {
    private final BetRepository betRepository;
    private final BetStateRepository betStateRepository;
    private final OddTypeRepository oddTypeRepository;
    private final OddRepository oddRepository;
    private final UserRepository userRepository;
    private final CommunityBetRepository communityBetRepository;

    public BetUseCase(BetRepository betRepository, BetStateRepository betStateRepository, OddTypeRepository oddTypeRepository, OddRepository oddRepository, UserRepository userRepository, CommunityBetRepository communityBetRepository) {
        this.betRepository = betRepository;
        this.betStateRepository = betStateRepository;
        this.oddTypeRepository = oddTypeRepository;
        this.oddRepository = oddRepository;
        this.userRepository = userRepository;
        this.communityBetRepository = communityBetRepository;
    }

    public BetResponse bet(BetRequest betRequest) {
        BetResponse betResponse = new BetResponse();
        //client souhaitant parier
        if (betRequest.getUserId() != betRequest.getLoggedClient().getId()) {
            betResponse.setMessage("Le client ne peut pas parier que pour lui même");
            betResponse.setResponseCode(EBetResponseCode.INNAPROPRIATE_USER);
            return betResponse;
        }
        Client client = (Client) userRepository.findUser(betRequest.getUserId());

        if (client.isStrikeOff()) {
            betResponse.setMessage("Le client est banni et ne peut plus jouer");
            betResponse.setResponseCode(EBetResponseCode.INNAPROPRIATE_USER);
            return betResponse;
        }
        if (client.getCapital() < betRequest.getAmount() || betRequest.getAmount() <= 0) {
            betResponse.setMessage("Le client n'a pas le capital suffisant pour parier");
            betResponse.setResponseCode(EBetResponseCode.INSUFFICIENT_FOUND);
            return betResponse;
        }



        BetState betState = betStateRepository.findBetStateByCode(EBetState.ISSUED);

        Bet bet = new Bet();
        bet.setAmount(betRequest.getAmount());
        bet.setDate(new Date());
        bet.setBetState(betState);
        bet.setOdd(betRequest.getOdd());
        bet.setUser(client);

        if(betRequest instanceof CommunityBetRequest){
            //traitement community bet ici
            CommunityBet communityBet = new CommunityBet(0, ((CommunityBetRequest) betRequest).getTreshold());
            CommunityBet communityBetSaved = communityBetRepository.save(communityBet);
            bet.setCommunityBet(communityBetSaved);
        }


        Bet betSaved = betRepository.save(bet);
        betResponse.setBet(betSaved);
        betResponse.setResponseCode(EBetResponseCode.SUCCESS);

        System.out.println(bet.getAmount());
        System.out.println("------------------------------------");
        System.out.println(bet.getOdd().getValue());

        //MAJ du capital de l'utilisateur
        client.setCapital(client.getCapital() - bet.getAmount());
        userRepository.save(client);

        return betResponse;
    }
}
