package org.wc.webprovider.db.dao;

import org.springframework.stereotype.Repository;
import org.wc.webprovider.db.pojo.Goods;

@Repository
public interface GoodsMapper extends BaseQueryMapper {
    int insert(Goods record);

    int insertSelective(Goods record);
}