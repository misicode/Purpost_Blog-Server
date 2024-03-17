package com.misicode.purpost.imageservice.controller;

import com.misicode.purpost.imageservice.dto.ImageCreateRequest;
import com.misicode.purpost.imageservice.dto.ImageResponse;
import com.misicode.purpost.imageservice.dto.ImageUpdateRequest;
import com.misicode.purpost.imageservice.mapper.ImageMapper;
import com.misicode.purpost.imageservice.services.image.IImageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController {
    private final IImageService imageService;

    public ImageController(IImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<ImageResponse> saveImage(@ModelAttribute @Valid ImageCreateRequest imageRequest) {
        return ResponseEntity.ok(
                ImageMapper.mapToImageResponse(imageService.saveImage(imageRequest))
        );
    }

    @PutMapping(consumes = "multipart/form-data")
    public ResponseEntity<ImageResponse> updateImage(@ModelAttribute @Valid ImageUpdateRequest imageRequest) {
        return ResponseEntity.ok(
                ImageMapper.mapToImageResponse(imageService.updateImage(imageRequest))
        );
    }
}
