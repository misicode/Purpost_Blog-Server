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
    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(
                        ErrorResponseEnum.USER_NOT_FOUND,
                        Map.of("id", "usuario con ID", "value", id)
                ));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ApplicationException(
                        ErrorResponseEnum.USER_NOT_FOUND,
                        Map.of("id", "usuario con correo", "value", email)
                ));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ApplicationException(
                        ErrorResponseEnum.USER_NOT_FOUND,
                        Map.of("id", "usuario", "value", username)
                ));
    }

    @Override
    public User getUserByUsernameOrEmail(String account) {
        return userRepository.findByUsernameOrEmail(account, account)
                .orElseThrow(() -> new ApplicationException(
                        ErrorResponseEnum.USER_NOT_FOUND,
                        Map.of("id", "nombre de usuario o correo", "value", account)
                ));
    }

    @Override
    public User createUser(UserCreateRequest userRequest) {
        if(userRepository.existsByEmail(userRequest.getEmail())) {
            throw new ApplicationException(
                    ErrorResponseEnum.USER_EXISTS,
                    Map.of("id", "correo", "value", userRequest.getEmail())
            );
        }

        if(userRepository.existsByUsername(userRequest.getUsername())) {
            throw new ApplicationException(
                    ErrorResponseEnum.USER_EXISTS,
                    Map.of("id", "usuario", "value", userRequest.getUsername())
            );
        }

        User user = new User();

        user.setNames(userRequest.getNames());
        user.setSurnames(userRequest.getSurnames());
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setRole(roleService.getRoleByName(RoleEnum.ROLE_USER));

        return userRepository.save(user);
    }

    @Override
    public User updateUser(UserUpdateRequest userRequest) {
        User user = getUserByEmail(userRequest.getEmail());

        user.setNames(userRequest.getNames());
        user.setSurnames(userRequest.getSurnames());

        return userRepository.save(user);
    }
}