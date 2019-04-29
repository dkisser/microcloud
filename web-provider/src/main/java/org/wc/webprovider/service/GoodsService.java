package org.wc.webprovider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wc.webprovider.db.dao.GoodsMapper;
import org.wc.webprovider.db.pojo.Goods;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> findGoodsList (Goods goods){
        return goodsMapper.selectAll(goods);
    }
}
