package com.hitweb.betgain.infrastructure.configuration;

import com.hitweb.betgain.domain.bet.ports.BetRepository;
import com.hitweb.betgain.domain.bet.ports.BetStateRepository;
import com.hitweb.betgain.domain.bet.ports.OddRepository;
import com.hitweb.betgain.domain.bet.ports.OddTypeRepository;
import com.hitweb.betgain.domain.bet.service.BetService;
import com.hitweb.betgain.domain.bet.service.DomainBetService;
import com.hitweb.betgain.domain.match.ports.CompetitionRepository;
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
    MatchService matchService(CompetitionRepository competitionRepository) {
        return new DomainMatchService(competitionRepository);
    }

    @Bean
    BetService betService(BetRepository betRepository, BetStateRepository betStateRepository, OddTypeRepository oddTypeRepository, OddRepository oddRepository, UserRepository userRepository) {
        return new DomainBetService(betRepository, betStateRepository, oddTypeRepository, oddRepository, userRepository);
    }
}