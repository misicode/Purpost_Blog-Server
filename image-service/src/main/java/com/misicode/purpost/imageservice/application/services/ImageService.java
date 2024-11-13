package com.misicode.purpost.imageservice.application.services;

import com.misicode.purpost.imageservice.application.ports.in.CloudinaryServicePort;
import com.misicode.purpost.imageservice.application.ports.in.ImageServicePort;
import com.misicode.purpost.imageservice.application.ports.out.ImagePersistencePort;
import com.misicode.purpost.imageservice.application.exceptions.ApplicationException;
import com.misicode.purpost.imageservice.application.exceptions.errors.ErrorCatalog;
import com.misicode.purpost.imageservice.domain.model.Image;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.UUID;

@Service
public class ImageService implements ImageServicePort {
    private final ImagePersistencePort imagePersistencePort;
    private final CloudinaryServicePort cloudinaryServicePort;

    public ImageService(ImagePersistencePort imagePersistencePort, CloudinaryServicePort cloudinaryServicePort) {
        this.imagePersistencePort = imagePersistencePort;
        this.cloudinaryServicePort = cloudinaryServicePort;
    }

    @Override
    public Mono<Image> findById(String id) {
        return imagePersistencePort
                .findById(id)
                .switchIfEmpty(Mono.error(
                        new ApplicationException(
                                ErrorCatalog.IMAGE_NOT_FOUND,
                                Map.of("id", id)
                        )
                ));
    }

    @Override
    public Mono<Image> save(Image image) {
        image.setName(UUID.randomUUID().toString().substring(0, 10) + "_" + LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));

        return cloudinaryServicePort
                .uploadFile(image.getImage(), "Purpost/posts")
                .flatMap(url -> {
                    image.setUrl(url);

                    return imagePersistencePort.save(image);
                });
    }

    @Override
    public Mono<Image> update(Image image) {
        return findById(image.getIdImage())
                .flatMap(newImage -> cloudinaryServicePort
                        .uploadFile(image.getImage(), "Purpost/posts")
                        .flatMap(url -> {
                            newImage.setUrl(url);

                            return imagePersistencePort.save(newImage);
                        }));
    }
}
