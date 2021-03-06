package com.hitweb.betgain.infrastructure.configuration;

import com.hitweb.betgain.domain.bet.ports.*;
import com.hitweb.betgain.domain.bet.service.BetService;
import com.hitweb.betgain.domain.bet.service.DomainBetService;
import com.hitweb.betgain.domain.match.ports.CompetitionRepository;
import com.hitweb.betgain.domain.match.ports.MatchRepository;
import com.hitweb.betgain.domain.match.ports.OpponentRepository;
import com.hitweb.betgain.domain.match.service.DomainMatchService;
import com.hitweb.betgain.domain.match.service.MatchService;
import com.hitweb.betgain.domain.moneyflow.ports.MoneyFlowRepository;
import com.hitweb.betgain.domain.moneyflow.ports.MoneyFlowStateRepository;
import com.hitweb.betgain.domain.moneyflow.service.DomainMoneyFlowService;
import com.hitweb.betgain.domain.moneyflow.service.MoneyFlowService;
import com.hitweb.betgain.domain.user.ports.UserRepository;
import com.hitweb.betgain.domain.user.service.DomainUserService;
import com.hitweb.betgain.domain.user.service.UserService;
import com.hitweb.betgain.infrastructure.services.mail.EmailServiceImpl;
import com.hitweb.betgain.infrastructure.services.security.PasswordSecurityEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    UserService userService(UserRepository userRepository, PasswordSecurityEncoder passwordEncoder, EmailServiceImpl emailService) {
        return new DomainUserService(userRepository, passwordEncoder, emailService);
    }

    @Bean
    MoneyFlowService moneyFlowService(MoneyFlowRepository moneyFlowRepository, MoneyFlowStateRepository moneyFlowStateRepository, UserRepository userRepository) {
        return new DomainMoneyFlowService(moneyFlowRepository, moneyFlowStateRepository, userRepository);
    }

    @Bean
    MatchService matchService(CompetitionRepository competitionRepository, MatchRepository matchRepository, OpponentRepository opponentRepository, BetRepository betRepository, OddRepository oddRepository, BetStateRepository betStateRepository, UserRepository userRepository) {
        return new DomainMatchService(competitionRepository, matchRepository, opponentRepository, betRepository, oddRepository, betStateRepository, userRepository);
    }

    @Bean
    BetService betService(BetRepository betRepository, BetStateRepository betStateRepository, OddTypeRepository oddTypeRepository, OddRepository oddRepository, UserRepository userRepository, CommunityBetRepository communityBetRepository) {
        return new DomainBetService(betRepository, betStateRepository, oddTypeRepository, oddRepository, userRepository, communityBetRepository);
    }
}