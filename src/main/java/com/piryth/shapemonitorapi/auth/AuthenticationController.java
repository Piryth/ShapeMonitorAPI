package com.piryth.shapemonitorapi.auth;

import com.piryth.shapemonitorapi.appUser.AppUserDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("shape-monitor/api/auth/")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final static Logger logger = Logger.getLogger(AuthenticationService.class.getName());

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody AppUserDto appUserDto
    ) throws Exception {
        return ResponseEntity.ok(authenticationService.register(appUserDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest
    ) {
        logger.log( Level.INFO,"Appel du service en cours " + authenticationRequest.getUsername());

        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
}
