package org.wc.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by WenChen on 2019/7/16.
 */
@Controller
public class MainController {

    @RequestMapping("/loginUI")
    public String loginUI(){
        return "loginUI";
    }
}
