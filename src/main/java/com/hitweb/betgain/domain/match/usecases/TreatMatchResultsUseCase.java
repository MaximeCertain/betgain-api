package com.hitweb.betgain.domain.match.usecases;

import com.hitweb.betgain.domain.bet.model.Bet;
import com.hitweb.betgain.domain.bet.model.BetState;
import com.hitweb.betgain.domain.bet.model.EBetState;
import com.hitweb.betgain.domain.bet.model.Odd;
import com.hitweb.betgain.domain.bet.ports.BetRepository;
import com.hitweb.betgain.domain.bet.ports.BetStateRepository;
import com.hitweb.betgain.domain.bet.ports.OddRepository;
import com.hitweb.betgain.domain.match.model.Match;
import com.hitweb.betgain.domain.match.model.Opponent;
import com.hitweb.betgain.domain.match.ports.MatchRepository;
import com.hitweb.betgain.domain.match.ports.OpponentRepository;
import com.hitweb.betgain.domain.match.usecases.payload.request.MatchResultsRequest;
import com.hitweb.betgain.domain.match.usecases.payload.response.MatchResultsResponse;
import com.hitweb.betgain.domain.user.model.Client;
import com.hitweb.betgain.domain.user.ports.UserRepository;

import java.util.List;

public class TreatMatchResultsUseCase {
    //un match s'est déroulé

    //je veux que les côtes soient validés ou non

    //afin de mettre à jour le statut des paris qui ont été joués (réussi, paerdu ...)


    //1 MAJ les deux opponent d'un match avc le nb de buts

    //2 récupérer les odds d'un match

    //3 pour chaque odd setter la colonne value pour savoir si elle estr validée ou non

    //4 pour chaque paris d'une odd changer le statut en fonction du résultat de la colonne odd

    private final MatchRepository matchRepository;
    private final OpponentRepository opponentRepository;
    private final OddRepository oddRepository;
    private final BetRepository betRepository;
    private final BetStateRepository betStateRepository;
    private final UserRepository userRepository;

    public TreatMatchResultsUseCase(MatchRepository matchRepository, OpponentRepository opponentRepository, OddRepository oddRepository, BetRepository betRepository, BetStateRepository betStateRepository, UserRepository userRepository) {
        this.matchRepository = matchRepository;
        this.opponentRepository = opponentRepository;
        this.oddRepository = oddRepository;
        this.betRepository = betRepository;
        this.betStateRepository = betStateRepository;
        this.userRepository = userRepository;
    }

    /**
     * Depuis API Scrapping : on reçoit deux matchs
     *
     * @return
     */
    public MatchResultsResponse treat(MatchResultsRequest matchResultsRequest) {

        MatchResultsResponse response = new MatchResultsResponse();

        Match match = matchRepository.getMatch(matchResultsRequest.getCodeMatch());

        if (match == null) {
            response.setMessage("Le match n'a pas été trouvé, impossible de traiter les résultats");
            return response;
        }

        Opponent awayTeamScrapped = matchResultsRequest.getAwayTeam();
        Opponent awayHomeScrapped = matchResultsRequest.getHomeTeam();

        Opponent awayTeam = opponentRepository.getOpponent(match.getId(), matchResultsRequest.getAwayTeam().getCode());
        Opponent homeTeam = opponentRepository.getOpponent(match.getId(), matchResultsRequest.getHomeTeam().getCode());


        awayTeam.setGoalsNumber(awayTeamScrapped.getGoalsNumber());
        awayTeam.setYellowCardNumber(awayTeamScrapped.getYellowCardNumber());
        awayTeam.setRedCardNumber(awayTeamScrapped.getRedCardNumber());

        homeTeam.setGoalsNumber(awayHomeScrapped.getGoalsNumber());
        homeTeam.setYellowCardNumber(awayHomeScrapped.getYellowCardNumber());
        homeTeam.setRedCardNumber(awayHomeScrapped.getRedCardNumber());

        opponentRepository.save(homeTeam);
        opponentRepository.save(awayTeam);

        for (Odd odd : match.getOdds()) {
            //valide ou non la côte de ce match.
            odd.validateResult(homeTeam, awayTeam);
            oddRepository.save(odd);
            List<Bet> bets = betRepository.getBetsSinceOdd(odd.getId());

            boolean success = odd.isValidated();
            EBetState code = success ? EBetState.WON : EBetState.FAILED;
            BetState finalBetState = betStateRepository.findBetStateByCode(code);
System.out.println(success);
            for (Bet bet : bets) {
                bet.setBetState(finalBetState);
                betRepository.save(bet);
                if (success) {
                    Client client = bet.getUser();
                    float gain = bet.getAmount() * odd.getValue();
                    client.setCapital(client.getCapital() + gain);
                    userRepository.save(client);
                    response.incrementNbBetsTreated();
                }
            }
        }

        response.setMessage("Le match " + homeTeam.getTeam().getName() + " contre " + awayTeam.getTeam().getName() + " a bien été traité");
        System.out.println(response.getMessage());
        System.out.println(response.getNbBets() + "  paris traités");

        return response;
    }
}
