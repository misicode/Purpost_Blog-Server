package com.misicode.purpost.authservice.services.user;

import com.misicode.purpost.authservice.domain.RoleEnum;
import com.misicode.purpost.authservice.domain.User;
import com.misicode.purpost.authservice.dto.UserCreateRequest;
import com.misicode.purpost.authservice.dto.UserUpdateRequest;
import com.misicode.purpost.authservice.repositories.UserRepository;
import com.misicode.purpost.authservice.services.role.IRoleService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    private PasswordEncoder passwordEncoder;
    private IRoleService roleService;
    private UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, IRoleService roleService, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.userRepository = userRepository;
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
    public User updateUser(UserUpdateRequest userRequest, String email) {
        User user = getUserByEmail(email);

        user.setNames(userRequest.getNames());
        user.setSurnames(userRequest.getSurnames());

        return userRepository.save(user);
    }
}