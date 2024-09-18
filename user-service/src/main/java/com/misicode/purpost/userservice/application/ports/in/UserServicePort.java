package com.misicode.purpost.userservice.application.ports.in;

import com.misicode.purpost.userservice.domain.model.User;
import reactor.core.publisher.Mono;

public interface UserServicePort {
    Mono<User> findById(String id);

    Mono<User> findByUsername(String username);

    Mono<User> findByUsernameOrEmail(String account);

    Mono<User> create(User user);

    Mono<User> update(User user);
}
