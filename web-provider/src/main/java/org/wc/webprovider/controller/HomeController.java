package org.wc.webprovider.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by WenChen on 2019/7/12.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    public String home(){
        return "loginUI";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(CUser user){
        System.out.println(user);
        return "";
    }
}
