package com.misicode.purpost.authservice.infrastructure.adapters.out.webclient.mappers;

import com.misicode.purpost.authservice.domain.model.UserData;
import com.misicode.purpost.authservice.infrastructure.adapters.out.webclient.dtos.response.UserDataWebClientResponse;
import reactor.core.publisher.Mono;

public class UserDataWebClientMapper {
    public UserDataWebClientMapper() {
        throw new UnsupportedOperationException();
    }

    public static Mono<UserData> toUserData(UserDataWebClientResponse userWebClientResponse) {
        return Mono.just(new UserData(
                userWebClientResponse.getUsername(),
                userWebClientResponse.getPassword(),
                userWebClientResponse.getIdRole()
        ));
    }
}
