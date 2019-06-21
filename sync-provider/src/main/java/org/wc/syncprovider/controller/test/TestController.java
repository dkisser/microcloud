package org.wc.syncprovider.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WenChen on 2019/6/18.
 */
@RestController
@RequestMapping("/web/test")
public class TestController {

    @GetMapping(value = "testLB")
    public String testLoadBalance(){
        return "sync-provider";
    }
}
