package org.wc.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wc.gateway.route.PropertiesRouter;

/**
 * Created by WenChen on 2019/6/14.
 */
@Configuration
public class ZuulConfig {

    @Autowired
    private ZuulProperties zuulProperties;

    @Bean
    public PropertiesRouter getPropRouter (){
        return new PropertiesRouter("/",zuulProperties);
    }

}
