package com.example.auth.service;

import com.example.auth.dao.CUserMapper;
import com.example.auth.pojo.CUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by WenChen on 2019/6/21.
 */
@Service
public class UserService {

    @Autowired
    private CUserMapper cUserMapper;

    public CUser getUserByUname (String uname){
        return cUserMapper.selectOne(new CUser(){{setUname(uname);}});
    }

}
