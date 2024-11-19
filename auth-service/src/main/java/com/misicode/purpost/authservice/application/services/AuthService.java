package com.misicode.purpost.authservice.application.services;

import com.misicode.purpost.authservice.application.ports.in.AuthServicePort;
import com.misicode.purpost.authservice.application.exceptions.ApplicationException;
import com.misicode.purpost.authservice.application.exceptions.errors.ErrorCatalog;
import com.misicode.purpost.authservice.application.ports.out.JwtServicePort;
import com.misicode.purpost.authservice.domain.model.Credentials;
import com.misicode.purpost.authservice.domain.model.UserDetailsImpl;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class AuthService implements AuthServicePort {
    private final ReactiveAuthenticationManager authenticationManager;
    private final JwtServicePort jwtServicePort;

    public AuthService(ReactiveAuthenticationManager authenticationManager, JwtServicePort jwtServicePort) {
        this.authenticationManager = authenticationManager;
        this.jwtServicePort = jwtServicePort;
    }

    @Override
    public Mono<String> login(Credentials credentials) {
        return authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                credentials.getAccount(),
                                credentials.getPassword()
                        )
                )
                .flatMap(auth -> {
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();

                    return jwtServicePort.generateJwtToken(userDetails.getUsername());
                })
                .onErrorMap(AuthenticationException.class, e ->
                        new ApplicationException(ErrorCatalog.AUTH_FAILED, Map.of("message", e.getMessage()))
                );
    }

    @Override
    public Mono<String> checkToken(String token) {
        if(token.startsWith("Bearer ")){
            String splitToken = token.substring(7);

            if (jwtServicePort.isValidJwtToken(splitToken)) {
                return Mono.just(splitToken);
            }
        }

        return Mono.error(new ApplicationException(ErrorCatalog.INVALID_TOKEN));
    }
}
