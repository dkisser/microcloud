package com.example.auth.controller;

import com.example.auth.pojo.CUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by WenChen on 2019/6/24.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/loginUI")
    public String loginUI(){
        return "loginUI";
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(CUser user){
        return "sucess";
    }
}
