package com.misicode.purpost.authservice.clients;

import com.misicode.purpost.authservice.dto.UserDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-user", url = "${USER_HOST:localhost}:11090/api/v1/user")
public interface UserClient {
    @GetMapping("/private/{account}")
    UserDataResponse getUserDataByUsernameOrEmail(@PathVariable String account);
}
