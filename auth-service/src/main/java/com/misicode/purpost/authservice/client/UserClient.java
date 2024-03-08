package com.misicode.purpost.authservice.client;

import com.misicode.purpost.authservice.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-user", url = "localhost:10090/api/v1/user")
public interface UserClient {
    @GetMapping("/{email}")
    UserResponse getUserByEmail(@PathVariable String email);
}
