package com.misicode.purpost.postservice.application.ports.out;

import com.misicode.purpost.postservice.domain.model.User;
import reactor.core.publisher.Mono;

public interface UserWebClientPort {
    Mono<User> findById(String id);

    Mono<User> findByUsername(String username);
}
