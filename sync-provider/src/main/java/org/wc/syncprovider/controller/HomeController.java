package org.wc.syncprovider.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(value = "postTest")
    public String postTest (String value){
        return "sucess accept:" + value;
    }
}
