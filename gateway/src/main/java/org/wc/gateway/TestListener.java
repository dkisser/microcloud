package org.wc.gateway;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by WenChen on 2019/6/20.
 */
@Component
public class TestListener {

    @Async
    @EventListener
    public void doListener (TestEvent event){
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(event);
    }
}
