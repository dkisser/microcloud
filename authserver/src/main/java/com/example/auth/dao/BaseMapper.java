package com.example.auth.dao;

import java.util.List;

/**
 * Created by WenChen on 2019/6/21.
 */
public interface BaseMapper {

    <T> T selectOne (T record);

    <T> List<T> selectList (T record);

}
