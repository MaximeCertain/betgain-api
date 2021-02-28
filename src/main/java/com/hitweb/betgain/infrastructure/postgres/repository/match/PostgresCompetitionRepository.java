package com.hitweb.betgain.infrastructure.postgres.repository.match;

import com.hitweb.betgain.domain.bet.model.EOddType;
import com.hitweb.betgain.domain.bet.model.Odd;
import com.hitweb.betgain.domain.bet.model.OddType;
import com.hitweb.betgain.domain.match.model.*;
import com.hitweb.betgain.domain.match.ports.CompetitionRepository;
import com.hitweb.betgain.infrastructure.postgres.adapters.CompetitionAdapter;
import com.hitweb.betgain.infrastructure.postgres.adapters.MatchAdapter;
import com.hitweb.betgain.infrastructure.postgres.entities.CompetitionEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.OpponentEntity;
import com.hitweb.betgain.infrastructure.postgres.repository.bet.PostgresOddRepository;
import com.hitweb.betgain.infrastructure.postgres.repository.bet.PostgresOddTypeRepository;
import com.hitweb.betgain.infrastructure.postgres.repository.moneyflow.JpaMoneyFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PostgresCompetitionRepository implements CompetitionRepository {

    @Autowired
    PostgresMatchRepository postgresMatchRepository;

    @Autowired
    PostgresTeamRepository postgresTeamRepository;

    @Autowired
    PostgresOpponentRepository postgresOpponentRepository;

    @Autowired
    PostgresOddRepository postgresOddRepository;

    @Autowired
    PostgresOddTypeRepository postgresOddTypeRepository;

    private final JpaCompetitionRepository jpaCompetitionRepository;

    public PostgresCompetitionRepository(JpaCompetitionRepository jpaCompetitionRepository) {
        this.jpaCompetitionRepository = jpaCompetitionRepository;
    }

    public Competition getCompetition(String code) {
        CompetitionEntity competitionExisted = jpaCompetitionRepository.findByCode(code);
        System.out.println(competitionExisted.getCode());
        if (competitionExisted == null) return null;

        return CompetitionAdapter.reverse(competitionExisted);
    }

    @Override
    public List<Competition> getNextMatchsSinceCompetition() {
        /**
         * TODO Adapteur Scrapping <==> API pour manipuler objets du domaine
         //gérer un adapteur scrapping <==> API ici
         //requêter api scrapping; en attendant =>
         */

        /**
         * FOrmat attendu :
         *
         competitions : [
          {
         "code": "L1", matchs: [
         {
         "date": "2021-02-28T11:23:43.535+00:00",
         "odds": [
         {
         "oddType": {
         "code": "HOME_TEAM_WON",
         },
         "value": 77.3,
         },
         {
         "oddType": {
         "code": "AWAY_TEAM_WON",
         },
         "value": 8.4442,
         }
         ]
         "homeTeam": {
         "name": "Olympique de marseille",
         "logo": "marseille.jpg",
         "code": "MAR"
         },
         "awayTeam": {
         "name": "Paris Saint Germain",
         "logo": "psg.png",
         "code": "PSG",
         }
         }
         ] },
         { "code": "PL", matchs: [] }
         ]
         *
         */

        Competition competition = new Competition(1, "Ligue 1", new Date(), new Date(), "L1");
        Opponent opponentHome = new Opponent(EOpponent.HOME, 1, "Olympique de marseille", "marseille.jpg", "MAR", 0, 0, 0);
        Opponent opponentAway = new Opponent(EOpponent.AWAY, 2, "Paris Saint Germain", "psg.png", "PSG", 0, 0, 0);
        Match match = new Match(1, new Date(), opponentHome, opponentAway, "MARPSG");
        OddType oddType = new OddType(1, EOddType.HOME_TEAM_WON, "Victoire domicile");
        OddType oddType2 = new OddType(2, EOddType.AWAY_TEAM_WON, "Victoire extérieur");
        Odd odd = new Odd(oddType, 77.30f, 1,  new Date());
        Odd odd2 = new Odd(oddType2, 8.4442f, 2,  new Date());
        match.addOdd(odd);
        match.addOdd(odd2);
        competition.addMatch(match);
        List<Competition> competitionsScrapping = new ArrayList<Competition>();
        competitionsScrapping.add(competition);

        List<Competition> competitions = new ArrayList<Competition>();

        //checker si un match n'est pas enregistré en base
        for (Competition competitionFromScrapping : competitionsScrapping) {

            Competition competitionExisted = getCompetition("L1");
            if (competitionExisted == null) continue;

            for (Match matchFromScrapping : competitionFromScrapping.getMatchs()) {

                //away et home team existed ?
                Team homeTeamExisted = postgresTeamRepository.getMatch(matchFromScrapping.getHomeTeam().getCode());

                if (homeTeamExisted == null) {
                    homeTeamExisted = postgresTeamRepository.save(matchFromScrapping.getHomeTeam());
                }

                Team awayTeamExisted = postgresTeamRepository.getMatch(matchFromScrapping.getAwayTeam().getCode());

                if (awayTeamExisted == null) {
                    awayTeamExisted = postgresTeamRepository.save(matchFromScrapping.getAwayTeam());
                }


                Match matchExisted = postgresMatchRepository.getMatch(matchFromScrapping.getCode());

                if (matchExisted == null) {

                    Opponent AddHomeOpponent = matchFromScrapping.getHomeTeam();
                    AddHomeOpponent.setTeam(homeTeamExisted);

                    Opponent AddAwayOpponent = matchFromScrapping.getAwayTeam();
                    AddAwayOpponent.setTeam(awayTeamExisted);

                    Opponent homeTeam = postgresOpponentRepository.save(AddHomeOpponent);
                    Opponent awayTeam = postgresOpponentRepository.save(AddAwayOpponent);

                    matchFromScrapping.setAwayTeam(awayTeam);
                    matchFromScrapping.setHomeTeam(homeTeam);
                    matchFromScrapping.setCompetition(competitionExisted);
                    //pas enregistré => on l'enregistre
                    matchExisted = postgresMatchRepository.save(matchFromScrapping);
                    matchExisted.setHomeTeam(homeTeam);
                    matchExisted.setAwayTeam(awayTeam);

                }

                for (Odd odd1 : matchFromScrapping.getOdds()) {

                    OddType oddTypeFromOddScrapping = postgresOddTypeRepository.findOddType(odd1.getOddType().getCode().toString());

                    Odd alreadyExistedOdd = postgresOddRepository.getLastOddForOddTypeAndMatch(oddTypeFromOddScrapping, matchExisted);

                    if(alreadyExistedOdd == null  ||  (odd1.getValue() != alreadyExistedOdd.getValue())){
                      //  System.out.println(odd1.getValue());
                       // System.out.println(alreadyExistedOdd.getValue());
                        //System.out.println(odd1.getValue() != alreadyExistedOdd.getValue());

                        odd1.setOddType(oddTypeFromOddScrapping);
                        odd1.setMatch(matchExisted);
                        alreadyExistedOdd = postgresOddRepository.save(odd1);
                    }
                    matchExisted.addOdd(alreadyExistedOdd);

                }

                competitionExisted.addMatch(matchExisted);
            }
            competitions.add(competitionExisted);
        }

        //retourne la liste des matchs en models
        return competitions;
    }
}
