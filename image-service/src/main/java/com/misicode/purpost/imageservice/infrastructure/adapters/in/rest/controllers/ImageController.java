package com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.controllers;

import com.misicode.purpost.imageservice.application.ports.in.ImageServicePort;
import com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.dtos.request.ImageCreateRequest;
import com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.dtos.response.ImageResponse;
import com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.dtos.request.ImageUpdateRequest;
import com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.mappers.ImageRestMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController {
    private final ImageServicePort imageServicePort;

    public ImageController(ImageServicePort imageServicePort) {
        this.imageServicePort = imageServicePort;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageResponse> getImageById(@PathVariable String id) {
        return ResponseEntity.ok(
                ImageRestMapper.toImageResponse(
                        imageServicePort.findById(id)
                )
        );
    }

    @PostMapping(value = "/private", consumes = "multipart/form-data")
    public ResponseEntity<ImageResponse> saveImage(@ModelAttribute @Valid ImageCreateRequest imageRequest) {
        return ResponseEntity.ok(
                ImageRestMapper.toImageResponse(
                        imageServicePort.save(ImageRestMapper.toImage(imageRequest))
                )
        );
    }

    @PutMapping(value = "/private", consumes = "multipart/form-data")
    public ResponseEntity<ImageResponse> updateImage(@ModelAttribute @Valid ImageUpdateRequest imageRequest) {
        return ResponseEntity.ok(
                ImageRestMapper.toImageResponse(
                        imageServicePort.update(ImageRestMapper.toImage(imageRequest))
                )
        );
    }
}
