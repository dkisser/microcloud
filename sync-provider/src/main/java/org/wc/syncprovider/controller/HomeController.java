package org.wc.syncprovider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wc.syncprovider.db.pojo.Goods;
import org.wc.syncprovider.service.remote.WebProviderService;

import java.util.List;

@RestController
@RequestMapping("/sync/")
public class HomeController {

    @Autowired
    private WebProviderService webProviderService;

    @GetMapping("findAllGoods")
    public List<Goods> findAllGoods(Goods goods){
        return webProviderService.findAllGoods(goods);
    }

}
