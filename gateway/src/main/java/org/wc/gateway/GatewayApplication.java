package org.wc.gateway;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@EnableAsync
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication implements CommandLineRunner {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private RouteLocator routeLocator;

    private ScheduledExecutorService executorService;

    private Long lastModified = 0L;

    private boolean instance = true;

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        executorService = Executors.newSingleThreadScheduledExecutor(
            new ThreadFactoryBuilder().setNameFormat("properties.").build());
        executorService.scheduleAtFixedRate(()->publish(),10,30, TimeUnit.SECONDS);
    }

    private void publish(){
        if (isPropModified()){
            publisher.publishEvent(new RoutesRefreshedEvent(routeLocator));
        }
    }

    private boolean isPropModified (){
        File file = new File(
            GatewayApplication.class.getClassLoader().getResource(Constants.DYNAMIC_ROUTE_FILE_PATH).getPath()
        );
        //程序启动第一次不加载
        if (instance){
            instance = false;
            return false;
        }
        if (file.lastModified()>lastModified){
            lastModified = file.lastModified();
            return true;
        }
        return true;
    }

}
