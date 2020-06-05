package com.wentry.listener;

import com.wentry.netty.server.EchoServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class WebListener implements ApplicationListener<ContextRefreshedEvent> {

    private transient Logger LOGGER = LoggerFactory.getLogger(WebListener.class);


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null){
            LOGGER.info("prepare to startServer");
            new EchoServer().start();
            LOGGER.info("success to startServer");
        }
    }
}
