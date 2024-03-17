package com.misicode.purpost.userservice.services.user;

import com.misicode.purpost.userservice.domain.RoleEnum;
import com.misicode.purpost.userservice.domain.User;
import com.misicode.purpost.userservice.dto.UserCreateRequest;
import com.misicode.purpost.userservice.dto.UserUpdateRequest;
import com.misicode.purpost.userservice.repositories.UserRepository;
import com.misicode.purpost.userservice.services.role.IRoleService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public User createUser(UserCreateRequest userRequest) {
        if(userRepository.existsByEmail(userRequest.getEmail())) {
            throw new RuntimeException("Usuario ya existe");
        }

        User user = new User();
        user.setNames(userRequest.getNames());
        user.setSurnames(userRequest.getSurnames());
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