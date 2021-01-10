package com.hitweb.betgain.infrastructure.services.auth.security.services;

import com.hitweb.betgain.infrastructure.postgres.entities.UserEntity;
import com.hitweb.betgain.infrastructure.postgres.repository.user.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    JpaUserRepository userRepository;

    /**
     * Va retourner un UserDetails que Spring pourra utiliser pour l'authentification
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        //construit l'user details pour ensuite le retourner
        return UserDetailsImpl.build(user);
    }

}
