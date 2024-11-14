package com.misicode.purpost.postservice.infrastructure.adapters.out.webclient.mappers;

import com.misicode.purpost.postservice.domain.model.Image;
import com.misicode.purpost.postservice.infrastructure.adapters.out.webclient.dtos.response.ImageWebClientResponse;
import reactor.core.publisher.Mono;

public class ImageWebClientMapper {
    public ImageWebClientMapper() {
        throw new UnsupportedOperationException();
    }

    public static Mono<Image> toImage(ImageWebClientResponse imageWebClientResponse) {
        return Mono.just(new Image(
                imageWebClientResponse.getIdImage(),
                imageWebClientResponse.getName(),
                imageWebClientResponse.getUrl(),
                null
        ));
    }
}
