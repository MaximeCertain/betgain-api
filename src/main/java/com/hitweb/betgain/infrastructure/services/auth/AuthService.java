package com.hitweb.betgain.infrastructure.services.auth;

import com.hitweb.betgain.domain.mail.EmailRequest;
import com.hitweb.betgain.domain.user.model.ERole;
import com.hitweb.betgain.infrastructure.postgres.entities.RoleEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.UserEntity;
import com.hitweb.betgain.infrastructure.postgres.repository.user.JpaRoleRepository;
import com.hitweb.betgain.infrastructure.postgres.repository.user.JpaUserRepository;
import com.hitweb.betgain.infrastructure.services.auth.payload.request.LoginRequest;
import com.hitweb.betgain.infrastructure.services.auth.payload.request.SignUpRequest;
import com.hitweb.betgain.infrastructure.services.auth.payload.response.JwtResponse;
import com.hitweb.betgain.infrastructure.services.auth.payload.response.MessageResponse;
import com.hitweb.betgain.infrastructure.services.auth.security.jwt.JwtUtils;
import com.hitweb.betgain.infrastructure.services.auth.security.services.UserDetailsImpl;
import com.hitweb.betgain.infrastructure.services.mail.EmailServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService implements AuthInterface {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JpaUserRepository userRepository;

    @Autowired
    JpaRoleRepository roleRepository;

    @Qualifier("passwordEncoder")
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    JwtUtils jwtUtils;

    public ResponseEntity<?> authenticate(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    public ResponseEntity<?> register(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        UserEntity user = new UserEntity();
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        user.setFirstname(signUpRequest.getFirstname());
        user.setLastname(signUpRequest.getLastname());

        Set<RoleEntity> roles = new HashSet<>();
        if (signUpRequest.getRoles().size() == 0) {
            RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER);
            //    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            for (RoleEntity role : signUpRequest.getRoles()) {
                RoleEntity existedRole = roleRepository.findByName(role.getName());
                //   .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(existedRole);
            }
        }

        user.setRoles(roles);

        String generatedString = RandomStringUtils.randomAlphabetic(10);
        user.setConfirmationCode(generatedString);

       userRepository.save(user);

        EmailRequest emailRequest = new EmailRequest(user.getEmail(), "amaury@support.fr", "votre code", "<html><body><h5>Inscription L'Equipe Bet & Gain</h5> <p> Bonjour, voici votre code d'inscription "+generatedString+" cordialement <br> L'équipe bet & gain</p></body></html>");
        emailService.sendSimpleMessage(emailRequest);

        return ResponseEntity.ok(new MessageResponse("User " + user.getUsername() + " registered successfully!"));
    }
}

