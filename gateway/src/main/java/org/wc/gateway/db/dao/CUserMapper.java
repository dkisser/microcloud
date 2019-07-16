package org.wc.gateway.db.dao;

import org.springframework.stereotype.Repository;
import org.wc.gateway.db.pojo.CUser;

@Repository
public interface CUserMapper extends BaseMapper{
    int insert(CUser record);

    int insertSelective(CUser record);
}