package com.misicode.purpost.authservice.application.ports.out;

import reactor.core.publisher.Mono;

public interface JwtServicePort {
    Mono<String> generateJwtToken(String username);

    Boolean isValidJwtToken(String token);

    Mono<String> extractUsername(String token);
}
