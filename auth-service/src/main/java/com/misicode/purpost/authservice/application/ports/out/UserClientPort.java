package com.misicode.purpost.authservice.application.ports.out;

import com.misicode.purpost.authservice.domain.model.UserData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-user", url = "${USER_HOST:localhost}:11090/api/v1/user")
public interface UserClientPort {
    @GetMapping("/private/{account}")
    UserData getUserDataByUsernameOrEmail(@PathVariable String account);
}
