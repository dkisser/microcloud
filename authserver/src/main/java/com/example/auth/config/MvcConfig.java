package com.example.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by WenChen on 2019/6/27.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/login").setViewName("login"); //自定义的登陆页面
        registry.addViewController("/oauth/confirm_access").setViewName("oauth_approval"); //自定义的授权页面
        registry.addViewController("/oauth_error").setViewName("oauth_error");
    }
}
