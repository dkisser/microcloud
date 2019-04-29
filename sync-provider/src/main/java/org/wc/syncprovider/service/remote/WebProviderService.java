package org.wc.syncprovider.service.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wc.syncprovider.db.pojo.Goods;

import java.util.List;

@FeignClient("web-provider")
public interface WebProviderService {

    @RequestMapping(value = "/web/test/findAllGoods",method = RequestMethod.POST)
    List<Goods> findAllGoods(Goods goods);
}
