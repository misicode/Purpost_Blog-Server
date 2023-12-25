package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.ERole;
import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    @Transactional
    public Boolean saveUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            System.out.println("ERROR: Usuario ya registrado");
            return false;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleService.getRoleByName(ERole.ROLE_USER));

        userRepository.save(user);

        return true;
    }
}
