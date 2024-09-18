package com.misicode.purpost.userservice.application.ports.out;

import com.misicode.purpost.userservice.domain.model.User;
import reactor.core.publisher.Mono;

public interface UserPersistencePort {
    Mono<User> findById(String id);

    Mono<User> findByUsername(String username);

    Mono<User> findByUsernameOrEmail(String username, String email);

    Mono<Boolean> existsByEmail(String email);

    Mono<Boolean> existsByUsername(String username);

    Mono<User> save(User user);
}
