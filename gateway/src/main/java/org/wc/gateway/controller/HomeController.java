package org.wc.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wc.gateway.TestEvent;
import org.wc.gateway.db.pojo.CUser;

/**
 * Created by WenChen on 2019/6/13.
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/testListener")
    public String testListener (){
        TestEvent testEvent = new TestEvent(111);
        testEvent.setAge(1);
        publisher.publishEvent(testEvent);
        return "success";
    }

    @RequestMapping("/login")
    public String login(CUser user){
        return "sucess";
    }



}
