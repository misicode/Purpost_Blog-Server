package com.misicode.purpost.authservice.application.services;

import com.misicode.purpost.authservice.application.ports.in.AuthServicePort;
import com.misicode.purpost.authservice.application.exceptions.ApplicationException;
import com.misicode.purpost.authservice.application.exceptions.errors.ErrorCatalog;
import com.misicode.purpost.authservice.application.ports.out.JwtServicePort;
import com.misicode.purpost.authservice.domain.model.Credentials;
import com.misicode.purpost.authservice.domain.model.UserDetailsImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService implements AuthServicePort {
    private final AuthenticationManager authenticationManager;
    private final JwtServicePort jwtServicePort;

    public AuthService(AuthenticationManager authenticationManager, JwtServicePort jwtServicePort) {
        this.authenticationManager = authenticationManager;
        this.jwtServicePort = jwtServicePort;
    }

    @Override
    public String login(Credentials credentials) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getAccount(),
                            credentials.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            return jwtServicePort.generateJwtToken(userDetails.getUsername());
        } catch(AuthenticationException e) {
            throw new ApplicationException(ErrorCatalog.AUTH_FAILED, Map.of("message", e.getMessage()));
        }
    }

    @Override
    public String checkToken(String token) {
        if(token.startsWith("Bearer ")){
            String splitToken = token.substring(7);

            if(jwtServicePort.isValidJwtToken(splitToken)) {
                return splitToken;
            }
        }

        throw new ApplicationException(ErrorCatalog.INVALID_TOKEN);
    }
}
