package org.wc.webprovider.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wc.webprovider.db.pojo.Goods;
import org.wc.webprovider.service.GoodsService;

import java.util.List;

@RestController
@RequestMapping("/web/test/")
public class TestController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("findAllGoods")
    public List<Goods> findAllGoods (Goods goods){
        return goodsService.findGoodsList(goods);
    }

}
