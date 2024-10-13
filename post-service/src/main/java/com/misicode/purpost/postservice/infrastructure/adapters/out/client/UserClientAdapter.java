package com.misicode.purpost.postservice.infrastructure.adapters.out.client;

import com.misicode.purpost.postservice.application.ports.out.UserClientPort;
import com.misicode.purpost.postservice.domain.model.User;
import com.misicode.purpost.postservice.infrastructure.adapters.out.client.feign.UserFeignClient;
import com.misicode.purpost.postservice.infrastructure.adapters.out.client.mappers.UserClientMapper;
import org.springframework.stereotype.Component;

@Component
public class UserClientAdapter implements UserClientPort {
    private final UserFeignClient userFeignClient;

    public UserClientAdapter(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    @Override
    public User findById(String id) {
        return UserClientMapper.toUser(
                userFeignClient.getUserById(id)
        );
    }

    @Override
    public User findByUsername(String username) {
        return UserClientMapper.toUser(
                userFeignClient.getUserByUsername(username)
        );
    }
}
