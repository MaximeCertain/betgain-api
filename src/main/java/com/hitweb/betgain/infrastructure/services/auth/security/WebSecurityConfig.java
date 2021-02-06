package com.hitweb.betgain.infrastructure.services.auth.security;

import com.hitweb.betgain.domain.user.model.ERole;
import com.hitweb.betgain.domain.user.model.Role;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.infrastructure.postgres.adapters.RoleAdapter;
import com.hitweb.betgain.infrastructure.services.auth.security.jwt.AuthEntryPointJwt;
import com.hitweb.betgain.infrastructure.services.auth.security.jwt.AuthTokenFilter;
import com.hitweb.betgain.infrastructure.services.auth.security.services.UserDetailsImpl;
import com.hitweb.betgain.infrastructure.services.auth.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebSecurity //spring va avoir accès à cette classe
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        //https://bezkoder.com/spring-boot-jwt-authentication/#Create_JWT_Utility_class
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Indique à spring comment configurer CORS and CSRF, le moment ou les users doivent s'authentifier ou non et quand il ne doivent pas
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //https://www.codeflow.site/fr/article/java-config-spring-security
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/users/*").access("hasRole('ADMINISTRATOR')")
                .antMatchers("/api/profile/*").access("hasRole('USER')")
                .anyRequest().authenticated();
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * Recupère les rôles de l'user connecté
     * @return
     */
    public static Collection<SimpleGrantedAuthority> getRoles() {
        if (SecurityContextHolder.getContext() == null || SecurityContextHolder.getContext().getAuthentication() == null) {
            return null;
        }

        return (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

    /**
     * Recupère l'utilisateur connecté, son id, username et roles
     * @return
     */
    public static User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken && authentication.getPrincipal() != null)) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            User userDomain = new User();
            userDomain.setId(userDetails.getId());
            userDomain.setEmail(userDetails.getEmail());
            userDomain.setUsername(userDetails.getUsername());
            Set<Role> roles = new HashSet<Role>();
            for (GrantedAuthority simpleGrantedAuthority : authentication.getAuthorities()) {
                Role role = new Role();
                role.setName(ERole.valueOf(simpleGrantedAuthority.getAuthority()));
                roles.add(role);
            }
            userDomain.setRoles(roles);
            return userDomain;

        }
        return null;
    }
}
