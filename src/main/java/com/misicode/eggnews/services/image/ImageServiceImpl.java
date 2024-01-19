package com.misicode.eggnews.services.image;

import com.misicode.eggnews.domain.Image;
import com.misicode.eggnews.repositories.ImageRepository;
import com.misicode.eggnews.services.cloudinary.ICloudinaryService;
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
    public Image saveImage(String base64File) {
        Image image = new Image();

        image.setName(UUID.randomUUID().toString().substring(0, 10) + "_" + LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
        image.setUrl(cloudinaryService.uploadFile(base64File, "EggNews/news"));

        if(image.getUrl() == null) {
            System.out.println("Error al guardar la imagen");
            return null;
        }

        return imageRepository.save(image);
    }
}
