package com.misicode.purpost.postservice.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "msvc-image", url = "localhost:9090/api/v1/image")
public interface ImageClient {
}
