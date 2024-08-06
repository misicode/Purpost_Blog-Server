package com.misicode.purpost.userservice.services.user;

import com.misicode.purpost.userservice.domain.RoleEnum;
import com.misicode.purpost.userservice.domain.User;
import com.misicode.purpost.userservice.dto.UserCreateRequest;
import com.misicode.purpost.userservice.dto.UserUpdateRequest;
import com.misicode.purpost.userservice.exception.ApplicationException;
import com.misicode.purpost.userservice.exception.error.ErrorResponseEnum;
import com.misicode.purpost.userservice.repositories.UserRepository;
import com.misicode.purpost.userservice.services.role.IRoleService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    private final PasswordEncoder passwordEncoder;
    private final IRoleService roleService;
    private final UserRepository userRepository;

    public UserServiceImpl(IRoleService roleService, UserRepository userRepository) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.roleService = roleService;
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> getUserById(String id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new ApplicationException(
                        ErrorResponseEnum.USER_NOT_FOUND,
                        Map.of("id", "usuario con ID", "value", id)
                )));
    }

    @Override
    public Mono<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .switchIfEmpty(Mono.error(new ApplicationException(
                        ErrorResponseEnum.USER_NOT_FOUND,
                        Map.of("id", "usuario con correo", "value", email)
                )));
    }

    @Override
    public Mono<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .switchIfEmpty(Mono.error(new ApplicationException(
                        ErrorResponseEnum.USER_NOT_FOUND,
                        Map.of("id", "usuario", "value", username)
                )));
    }

    @Override
    public Mono<User> getUserByUsernameOrEmail(String account) {
        return userRepository.findByUsernameOrEmail(account, account)
                .switchIfEmpty(Mono.error(new ApplicationException(
                        ErrorResponseEnum.USER_NOT_FOUND,
                        Map.of("id", "nombre de usuario o correo", "value", account)
                )));
    }

    @Override
    public Mono<User> createUser(UserCreateRequest userRequest) {
        return Mono.zip(
                userRepository.existsByEmail(userRequest.getEmail()),
                userRepository.existsByUsername(userRequest.getUsername())
        ).flatMap(exists -> {
            if (exists.getT1()) {
                return Mono.error(new ApplicationException(
                        ErrorResponseEnum.USER_EXISTS,
                        Map.of("id", "correo", "value", userRequest.getEmail())
                ));
            }

            if (exists.getT2()) {
                return Mono.error(new ApplicationException(
                        ErrorResponseEnum.USER_EXISTS,
                        Map.of("id", "usuario", "value", userRequest.getUsername())
                ));
            }

            return roleService.getRoleByName(RoleEnum.ROLE_USER)
                    .flatMap(role -> {
                        User user = new User();

                        user.setNames(userRequest.getNames());
                        user.setSurnames(userRequest.getSurnames());
                        user.setUsername(userRequest.getUsername());
                        user.setEmail(userRequest.getEmail());
                        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
                        user.setIdRole(role.getIdRole());

                        return userRepository.save(user);
                    });
        });
    }

    @Override
    public Mono<User> updateUser(UserUpdateRequest userRequest) {
        return getUserByUsername(userRequest.getUsername())
                .flatMap(user -> {
                    user.setNames(userRequest.getNames());
                    user.setSurnames(userRequest.getSurnames());

                    return userRepository.save(user);
                });
    }
}