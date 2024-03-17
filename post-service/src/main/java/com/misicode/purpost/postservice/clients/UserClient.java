package com.misicode.purpost.postservice.clients;

import com.misicode.purpost.postservice.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-user", url = "localhost:11090/api/v1/user")
public interface UserClient {
    @GetMapping("/{id}")
    UserResponse getUserById(@PathVariable String id);

    @GetMapping("/{email}")
    UserResponse getUserByEmail(@PathVariable String email);
}
