package com.hitweb.betgain.infrastructure.postgres.repository.match;

import com.hitweb.betgain.domain.bet.model.EOddType;
import com.hitweb.betgain.domain.bet.model.Odd;
import com.hitweb.betgain.domain.bet.model.OddType;
import com.hitweb.betgain.domain.match.model.Competition;
import com.hitweb.betgain.domain.match.model.EOpponent;
import com.hitweb.betgain.domain.match.model.Match;
import com.hitweb.betgain.domain.match.model.Opponent;
import com.hitweb.betgain.domain.match.ports.CompetitionRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PostgresCompetitionRepository implements CompetitionRepository {
    @Override
    public List<Competition> getNextMatchsSinceCompetition() {
        //requêter api scrapping

        Competition competition = new Competition(1, "Ligue 1", new Date(), new Date(), "L1");
        Opponent opponentHome = new Opponent(EOpponent.HOME, 1, "Olympique de marseille", "marseille.jpg", "MAR", 0, 0, 0);
        Opponent opponentAway = new Opponent(EOpponent.AWAY, 2, "Paris Saint Germain", "psg.png", "PSG", 0, 0, 0);
        Match match = new Match(1, new Date(), opponentHome, opponentAway);
        OddType oddType = new OddType(1, EOddType.HOME_TEAM_WON, "Victoire domicile");
        OddType oddType2 = new OddType(1, EOddType.HOME_TEAM_WON, "Victoire domicile");
        Odd odd = new Odd(oddType, 3.2f,1);
        Odd odd2 = new Odd(oddType2, 1.2f,2);

        match.addOdd(odd);
        match.addOdd(odd2);

        competition.addMatch(match);
        List<Competition> competitions = new ArrayList<Competition>();
        competitions.add(competition);

        //checker si un match n'est pas enregistré en base
        //pas enregistré => on l'enregistre
        //non enregistrable => on skip

        //retourne la liste des matchs en models


        return competitions;
    }
}
