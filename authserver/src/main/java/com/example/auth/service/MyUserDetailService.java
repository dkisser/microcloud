package com.example.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by WenChen on 2019/6/21.
 */
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

//    @Autowired
//    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String uname) throws UsernameNotFoundException {

        return null;
    }
}
