package com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.controllers;

import com.misicode.purpost.imageservice.application.ports.in.ImageServicePort;
import com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.dtos.request.ImageCreateRequest;
import com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.dtos.response.ImageResponse;
import com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.dtos.request.ImageUpdateRequest;
import com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.mappers.ImageRestMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController {
    private final ImageServicePort imageServicePort;

    public ImageController(ImageServicePort imageServicePort) {
        this.imageServicePort = imageServicePort;
    }

    @GetMapping("/{id}")
    public Mono<ImageResponse> getImageById(@PathVariable String id) {
        return imageServicePort
                .findById(id)
                .map(ImageRestMapper::toImageResponse);
    }

    @PostMapping(value = "/private", consumes = "multipart/form-data")
    public Mono<ImageResponse> saveImage(@ModelAttribute @Valid ImageCreateRequest imageRequest) {
        return imageServicePort
                .save(ImageRestMapper.toImage(imageRequest))
                .map(ImageRestMapper::toImageResponse);
    }

    @PutMapping(value = "/private", consumes = "multipart/form-data")
    public Mono<ImageResponse> updateImage(@ModelAttribute @Valid ImageUpdateRequest imageRequest) {
        return imageServicePort
                .update(ImageRestMapper.toImage(imageRequest))
                .map(ImageRestMapper::toImageResponse);
    }
}
