package org.wc.webprovider.db.dao;

import java.util.List;

public interface BaseQueryMapper {

    <T> List<T> selectAll(T record);

    <T> T selectOne(T record);

    <T> int countAll (T record);
}
