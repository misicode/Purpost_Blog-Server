package com.misicode.purpost.authservice.application.ports.in;

import com.misicode.purpost.authservice.domain.model.Credentials;
import reactor.core.publisher.Mono;

public interface AuthServicePort {
    Mono<String> login(Credentials credentials);

    Mono<String> checkToken(String token);
}
