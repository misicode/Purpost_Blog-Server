package com.misicode.purpost.userservice.services.user;

import com.misicode.purpost.userservice.domain.User;
import com.misicode.purpost.userservice.dto.UserCreateRequest;
import com.misicode.purpost.userservice.dto.UserUpdateRequest;
import reactor.core.publisher.Mono;

public interface IUserService {
    Mono<User> getUserById(String id);

    Mono<User> getUserByEmail(String email);

    Mono<User> getUserByUsername(String username);

    Mono<User> getUserByUsernameOrEmail(String account);

    Mono<User> createUser(UserCreateRequest userRequest);

    Mono<User> updateUser(UserUpdateRequest userRequest);
}
