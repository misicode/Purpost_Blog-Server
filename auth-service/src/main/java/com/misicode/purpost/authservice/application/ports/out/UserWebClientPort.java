package com.misicode.purpost.authservice.application.ports.out;

import com.misicode.purpost.authservice.domain.model.UserData;
import reactor.core.publisher.Mono;

public interface UserWebClientPort {
    Mono<UserData> findByUsernameOrEmail(String account);
}
