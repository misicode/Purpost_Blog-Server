package com.misicode.eggnews.services.user;

import com.misicode.eggnews.domain.RoleEnum;
import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.dto.UserDto;
import com.misicode.eggnews.exception.ApplicationException;
import com.misicode.eggnews.exception.error.ErrorResponseEnum;
import com.misicode.eggnews.repositories.UserRepository;
import com.misicode.eggnews.services.IRoleService;
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
    public Boolean registerUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            System.out.println("ERROR: Usuario ya registrado");
            return false;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleService.getRoleByName(RoleEnum.ROLE_USER));

        userRepository.save(user);

        return true;
    }

    @Override
    public User updateUser(UserDto user, String email) {
        User newUser = getUserByEmail(email);

        newUser.setNames(user.getNames());
        newUser.setSurnames(user.getSurnames());

        return userRepository.save(newUser);
    }
}
