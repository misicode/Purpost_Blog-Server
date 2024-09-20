package com.misicode.purpost.imageservice.application.services;

import com.misicode.purpost.imageservice.application.ports.in.CloudinaryServicePort;
import com.misicode.purpost.imageservice.application.ports.in.ImageServicePort;
import com.misicode.purpost.imageservice.application.ports.out.ImagePersistencePort;
import com.misicode.purpost.imageservice.application.exceptions.ApplicationException;
import com.misicode.purpost.imageservice.application.exceptions.errors.ErrorCatalog;
import com.misicode.purpost.imageservice.domain.model.Image;
import org.springframework.stereotype.Service;

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
    public Image findById(String id) {
        return imagePersistencePort
                .findById(id)
                .orElseThrow(
                        () -> new ApplicationException(ErrorCatalog.IMAGE_NOT_FOUND, Map.of("id", id))
                );
    }

    @Override
    public Image save(Image image) {
        image.setName(UUID.randomUUID().toString().substring(0, 10) + "_" + LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
        image.setUrl(cloudinaryServicePort.uploadFile(image.getImage(), "Purpost/posts"));

        return imagePersistencePort.save(image);
    }

    @Override
    public Image update(Image image) {
        Image newImage = findById(image.getIdImage());

        newImage.setUrl(cloudinaryServicePort.uploadFile(image.getImage(), "Purpost/posts"));

        return imagePersistencePort.save(newImage);
    }
}
