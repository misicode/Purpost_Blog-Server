package com.misicode.purpost.imageservice.controller;

import com.misicode.purpost.imageservice.dto.ImageRequest;
import com.misicode.purpost.imageservice.dto.ImageResponse;
import com.misicode.purpost.imageservice.mapper.ImageMapper;
import com.misicode.purpost.imageservice.services.image.IImageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {
    private IImageService imageService;

    public ImageController(IImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<ImageResponse> createNews(@ModelAttribute @Valid ImageRequest image) {
        return ResponseEntity.ok(
                ImageMapper.mapToImageResponse(imageService.saveImage(image.getImage()))
        );
    }
}
