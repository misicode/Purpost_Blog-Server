package com.misicode.purpost.authservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "msvc-user", url = "localhost:10090")
public interface UserClient {

}
