package com.misicode.purpost.postservice.infrastructure.adapters.out.webclient;

import com.misicode.purpost.postservice.application.ports.out.ImageWebClientPort;
import com.misicode.purpost.postservice.domain.model.Image;
import com.misicode.purpost.postservice.infrastructure.adapters.out.webclient.dtos.response.ImageWebClientResponse;
import com.misicode.purpost.postservice.infrastructure.adapters.out.webclient.mappers.ImageWebClientMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ImageWebClientAdapter implements ImageWebClientPort {
    private final WebClient webClient;

    public ImageWebClientAdapter(WebClient.Builder webClientBuilder,
                                 @Value("${IMAGE_HOST:http://localhost:9090}") String host) {
        this.webClient = webClientBuilder.baseUrl(host + "/api/v1/image").build();
    }

    @Override
    public Mono<Image> findById(String id) {
        return webClient
                .get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(ImageWebClientResponse.class)
                .flatMap(ImageWebClientMapper::toImage);
    }

    @Override
    public Mono<Image> save(FilePart image) {
        return webClient
                .post()
                .uri("/private")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData("image", image))
                .retrieve()
                .bodyToMono(ImageWebClientResponse.class)
                .flatMap(ImageWebClientMapper::toImage);
    }

    @Override
    public Mono<Image> update(String id, FilePart image) {
        return webClient
                .put()
                .uri("/private")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters
                        .fromMultipartData("idImage", id)
                        .with("image", image))
                .retrieve()
                .bodyToMono(ImageWebClientResponse.class)
                .flatMap(ImageWebClientMapper::toImage);
    }
}
