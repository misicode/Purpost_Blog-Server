package com.misicode.purpost.authservice.application.services;

import com.misicode.purpost.authservice.application.ports.out.UserClientPort;
import com.misicode.purpost.authservice.domain.model.UserData;
import com.misicode.purpost.authservice.domain.model.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserClientPort userClientPort;

    public UserDetailsServiceImpl(UserClientPort userClientPort) {
        this.userClientPort = userClientPort;
    }

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        UserData user = userClientPort.getUserDataByUsernameOrEmail(account);

        if(user == null) {
            throw new UsernameNotFoundException("El nombre de usuario o correo " + account + " no existe");
        }

        return UserDetailsImpl.build(user);
    }
}