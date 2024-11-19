package com.misicode.purpost.authservice.infrastructure.adapters.out.webclient;

import com.misicode.purpost.authservice.application.ports.out.UserWebClientPort;
import com.misicode.purpost.authservice.domain.model.UserData;
import com.misicode.purpost.authservice.infrastructure.adapters.out.webclient.dtos.response.UserDataWebClientResponse;
import com.misicode.purpost.authservice.infrastructure.adapters.out.webclient.mappers.UserDataWebClientMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class UserWebClientAdapter implements UserWebClientPort {
    private final WebClient webClient;

    public UserWebClientAdapter(WebClient.Builder webClientBuilder,
                                @Value("${USER_HOST:http://localhost:11090}") String host) {
        this.webClient = webClientBuilder.baseUrl(host + "/api/v1/user").build();
    }

    @Override
    public Mono<UserData> findByUsernameOrEmail(String account) {
        return webClient
                .get()
                .uri("/private/{account}", account)
                .retrieve()
                .bodyToMono(UserDataWebClientResponse.class)
                .flatMap(UserDataWebClientMapper::toUserData);
    }
}
