package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WenChen on 2019/6/5.
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/tests")
    public String test(){
        return "ssss";
    }
}
