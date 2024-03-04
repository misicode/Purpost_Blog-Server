package com.misicode.purpost.imageservice.services.image;

import com.misicode.purpost.imageservice.domain.Image;
import com.misicode.purpost.imageservice.repositories.ImageRepository;
import com.misicode.purpost.imageservice.services.cloudinary.ICloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class ImageServiceImpl implements IImageService {
    private ICloudinaryService cloudinaryService;
    private ImageRepository imageRepository;

    public ImageServiceImpl(ICloudinaryService cloudinaryService, ImageRepository imageRepository) {
        this.cloudinaryService = cloudinaryService;
        this.imageRepository = imageRepository;
    }

    @Override
    public Image saveImage(MultipartFile file) {
        Image image = new Image();

        image.setName(UUID.randomUUID().toString().substring(0, 10) + "_" + LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
        image.setUrl(cloudinaryService.uploadFile(file, "EggNews/news"));

        if(image.getUrl() == null) {
            System.out.println("El URL de la imagen no se creó correctamente");
            return null;
        }

        return imageRepository.save(image);
    }
}