package com.misicode.purpost.userservice.infrastructure.adapters.out.persistence;

import com.misicode.purpost.userservice.application.ports.out.UserPersistencePort;
import com.misicode.purpost.userservice.domain.model.User;
import com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.mappers.UserPersistenceMapper;
import com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.repositories.UserRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UserPersistenceAdapter implements UserPersistencePort {
    private final UserRepository userRepository;

    public UserPersistenceAdapter(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> findById(String id) {
        return userRepository
                .findById(id)
                .map(UserPersistenceMapper::toUser);
    }

    @Override
    public Mono<User> findByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .map(UserPersistenceMapper::toUser);
    }

    @Override
    public Mono<User> findByUsernameOrEmail(String username, String email) {
        return userRepository
                .findByUsernameOrEmail(username, email)
                .map(UserPersistenceMapper::toUser);
    }

    @Override
    public Mono<Boolean> existsByEmail(String email) {
        return userRepository
                .existsByEmail(email);
    }

    @Override
    public Mono<Boolean> existsByUsername(String username) {
        return userRepository
                .existsByUsername(username);
    }

    @Override
    public Mono<User> save(User user) {
        return userRepository
                .save(UserPersistenceMapper.toUserEntity(user))
                .map(UserPersistenceMapper::toUser);
    }
}
