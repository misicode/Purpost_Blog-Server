package com.misicode.purpost.userservice.application.services;

import com.misicode.purpost.userservice.application.ports.in.UserServicePort;
import com.misicode.purpost.userservice.application.ports.out.UserPersistencePort;
import com.misicode.purpost.userservice.application.exceptions.ApplicationException;
import com.misicode.purpost.userservice.application.exceptions.errors.ErrorCatalog;
import com.misicode.purpost.userservice.domain.model.RoleEnum;
import com.misicode.purpost.userservice.domain.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class UserService implements UserServicePort {
    private final UserPersistencePort userPersistencePort;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserPersistencePort userPersistencePort, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userPersistencePort = userPersistencePort;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Mono<User> findById(String id) {
        return userPersistencePort
                .findById(id)
                .switchIfEmpty(Mono.error(
                        new ApplicationException(
                                ErrorCatalog.USER_NOT_FOUND,
                                Map.of("id", "usuario con ID", "value", id)
                        )
                ));
    }

    @Override
    public Mono<User> findByUsername(String username) {
        return userPersistencePort
                .findByUsername(username)
                .switchIfEmpty(Mono.error(
                        new ApplicationException(
                                ErrorCatalog.USER_NOT_FOUND,
                                Map.of("id", "usuario", "value", username)
                        )
                ));
    }

    @Override
    public Mono<User> findByUsernameOrEmail(String account) {
        return userPersistencePort
                .findByUsernameOrEmail(account, account)
                .switchIfEmpty(Mono.error(
                        new ApplicationException(
                                ErrorCatalog.USER_NOT_FOUND,
                                Map.of("id", "nombre de usuario o correo", "value", account)
                        )
                ));
    }

    @Override
    public Mono<User> create(User user) {
        return Mono.zip(
                userPersistencePort.existsByEmail(user.getEmail()),
                userPersistencePort.existsByUsername(user.getUsername())
        ).flatMap(exists -> {
            if (exists.getT1()) {
                return Mono.error(new ApplicationException(
                        ErrorCatalog.USER_EXISTS,
                        Map.of("id", "correo", "value", user.getEmail())
                ));
            }

            if (exists.getT2()) {
                return Mono.error(new ApplicationException(
                        ErrorCatalog.USER_EXISTS,
                        Map.of("id", "usuario", "value", user.getUsername())
                ));
            }

            return roleService.findByName(RoleEnum.ROLE_USER)
                    .flatMap(role -> {
                        user.setPassword(passwordEncoder.encode(user.getPassword()));
                        user.setActive(true);
                        user.setIdRole(role.getIdRole());

                        return userPersistencePort.save(user);
                    });
        });
    }

    @Override
    public Mono<User> update(User user) {
        return findByUsername(user.getUsername())
                .flatMap(newUser -> {
                    newUser.setNames(user.getNames());
                    newUser.setSurnames(user.getSurnames());

                    return userPersistencePort.save(newUser);
                });
    }
}
