package com.misicode.purpost.postservice.infrastructure.adapters.out.client.feign;

import com.misicode.purpost.postservice.infrastructure.adapters.out.client.dtos.response.UserClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-user", url = "${USER_HOST:localhost}:11090/api/v1/user")
public interface UserFeignClient {
    @GetMapping("/id/{id}")
    UserClientResponse getUserById(@PathVariable String id);

    @GetMapping("/username/{username}")
    UserClientResponse getUserByUsername(@PathVariable String username);
}
