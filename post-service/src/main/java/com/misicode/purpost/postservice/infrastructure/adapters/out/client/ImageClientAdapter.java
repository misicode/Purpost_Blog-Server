package com.misicode.purpost.postservice.infrastructure.adapters.out.client;

import com.misicode.purpost.postservice.application.ports.out.ImageClientPort;
import com.misicode.purpost.postservice.domain.model.Image;
import com.misicode.purpost.postservice.infrastructure.adapters.out.client.feign.ImageFeignClient;
import com.misicode.purpost.postservice.infrastructure.adapters.out.client.mappers.ImageClientMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageClientAdapter implements ImageClientPort {
    private final ImageFeignClient imageFeignClient;

    public ImageClientAdapter(ImageFeignClient imageFeignClient) {
        this.imageFeignClient = imageFeignClient;
    }

    @Override
    public Image findById(String id) {
        return ImageClientMapper.toImage(
                imageFeignClient.getImageById(id)
        );
    }

    @Override
    public Image save(MultipartFile image) {
        return ImageClientMapper.toImage(
                imageFeignClient.saveImage(image)
        );
    }

    @Override
    public Image update(String id, MultipartFile image) {
        return ImageClientMapper.toImage(
                imageFeignClient.updateImage(id, image)
        );
    }
}
