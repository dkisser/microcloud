package org.wc.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.wc.gateway.db.pojo.CUser;

import java.util.Arrays;

/**
 * Created by WenChen on 2019/6/21.
 * 登录身份认证
 */
@Service(value = "userDetailService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

//    @Autowired
//    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String uname) throws UsernameNotFoundException {
        CUser user = userService.getUserByUname(uname);
        if (user == null){
            throw new UsernameNotFoundException(uname);
        }
        User userDTO = new User(user.getUname(),user.getUpwd(), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        return userDTO;
    }
}
