package com.example.auth.dao;

import com.example.auth.pojo.CUser;
import org.springframework.stereotype.Repository;

@Repository
public interface CUserMapper extends BaseMapper{
    int insert(CUser record);

    int insertSelective(CUser record);
}