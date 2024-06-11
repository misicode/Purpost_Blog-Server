package com.misicode.purpost.postservice.clients;

import com.misicode.purpost.postservice.dto.ImageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "msvc-image", url = "localhost:9090/api/v1/image")
public interface ImageClient {
    @GetMapping("/{id}")
    ImageResponse getImageById(@PathVariable String id);

    @PostMapping(value = "/private", consumes = "multipart/form-data")
    ImageResponse saveImage(@RequestPart(name = "image") MultipartFile image);

    @PutMapping(value = "/private", consumes = "multipart/form-data")
    ImageResponse updateImage(@RequestPart(name = "idImage") String idImage,
                                @RequestPart(name = "image") MultipartFile image);
}
