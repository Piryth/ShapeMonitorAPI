package com.piryth.shapemonitorapi.auth;

import com.piryth.shapemonitorapi.appUser.AppUser;
import com.piryth.shapemonitorapi.appUser.AppUserRepository;
import com.piryth.shapemonitorapi.appUser.RoleRepository;
import com.piryth.shapemonitorapi.config.JWTService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;

    public AuthenticationResponse register(RegistrationRequest registrationRequest) throws Exception {
        //Création de l'utilisateur
        AppUser user = AppUser.builder()
                .username(registrationRequest.getUsername())
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .role(roleRepository.getRoleByName("USER").orElseThrow(() -> new EntityNotFoundException("Role non trouvé mdr")))
                .build();
        //Sauvegarde de l'utilisateur
        appUserRepository.save(user);
        //Génération du token
        String jwtToken = jwtService.generateToken(user);
        //Génération de la réponse
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        AppUser user = appUserRepository.getReferenceById(authenticationRequest.getUsername());
        //Génération du token
        String jwtToken = jwtService.generateToken(user);
        //Génération de la réponse
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
