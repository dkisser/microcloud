package com.example.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by WenChen on 2019/6/24.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/test")
    public String test(){
        return "test";
    }

    @RequestMapping(value = "/loginUI")
    public String login (){
        return "login";
    }

}
