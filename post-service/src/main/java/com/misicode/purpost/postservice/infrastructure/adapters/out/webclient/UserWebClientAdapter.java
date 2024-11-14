package com.misicode.purpost.postservice.infrastructure.adapters.out.webclient;

import com.misicode.purpost.postservice.application.ports.out.UserWebClientPort;
import com.misicode.purpost.postservice.domain.model.User;
import com.misicode.purpost.postservice.infrastructure.adapters.out.webclient.dtos.response.UserWebClientResponse;
import com.misicode.purpost.postservice.infrastructure.adapters.out.webclient.mappers.UserWebClientMapper;
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
    public Mono<User> findById(String id) {
        return webClient
                .get()
                .uri("/id/{id}", id)
                .retrieve()
                .bodyToMono(UserWebClientResponse.class)
                .flatMap(UserWebClientMapper::toUser);
    }

    @Override
    public Mono<User> findByUsername(String username) {
        return webClient
                .get()
                .uri("/username/{username}", username)
                .retrieve()
                .bodyToMono(UserWebClientResponse.class)
                .flatMap(UserWebClientMapper::toUser);
    }
}
