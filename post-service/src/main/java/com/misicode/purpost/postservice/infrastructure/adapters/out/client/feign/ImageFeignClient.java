package com.misicode.purpost.postservice.infrastructure.adapters.out.client.feign;

import com.misicode.purpost.postservice.infrastructure.adapters.out.client.dtos.response.ImageClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "msvc-image", url = "${IMAGE_HOST:localhost}:9090/api/v1/image")
public interface ImageFeignClient {
    @GetMapping("/{id}")
    ImageClientResponse getImageById(@PathVariable String id);

    @PostMapping(value = "/private", consumes = "multipart/form-data")
    ImageClientResponse saveImage(@RequestPart(name = "image") MultipartFile image);

    @PutMapping(value = "/private", consumes = "multipart/form-data")
    ImageClientResponse updateImage(@RequestPart(name = "idImage") String idImage,
                                    @RequestPart(name = "image") MultipartFile image);
}
