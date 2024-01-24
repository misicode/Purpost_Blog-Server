package com.misicode.eggnews.services.user;

import com.misicode.eggnews.domain.RoleEnum;
import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.dto.UserUpdateRequest;
import com.misicode.eggnews.exception.ApplicationException;
import com.misicode.eggnews.exception.error.ErrorResponseEnum;
import com.misicode.eggnews.dto.UserCreateRequest;
import com.misicode.eggnews.repositories.UserRepository;
import com.misicode.eggnews.services.role.IRoleService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

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
                .orElseThrow(() -> new ApplicationException(ErrorResponseEnum.USER_NOT_FOUND, Map.of("email", email)));
    }

    @Override
    public User createUser(UserCreateRequest userRequest) {
        if(userRepository.existsByEmail(userRequest.getEmail())) {
            throw new ApplicationException(ErrorResponseEnum.USER_EXISTS);
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
