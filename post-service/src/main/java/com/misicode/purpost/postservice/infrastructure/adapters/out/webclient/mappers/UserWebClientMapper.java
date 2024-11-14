package com.misicode.purpost.postservice.infrastructure.adapters.out.webclient.mappers;

import com.misicode.purpost.postservice.domain.model.User;
import com.misicode.purpost.postservice.infrastructure.adapters.out.webclient.dtos.response.UserWebClientResponse;
import reactor.core.publisher.Mono;

public class UserWebClientMapper {
    public UserWebClientMapper() {
        throw new UnsupportedOperationException();
    }

    public static Mono<User> toUser(UserWebClientResponse userWebClientResponse) {
        return Mono.just(new User(
                userWebClientResponse.getIdUser(),
                userWebClientResponse.getUsername(),
                userWebClientResponse.getNames(),
                userWebClientResponse.getSurnames()
        ));
    }
}
