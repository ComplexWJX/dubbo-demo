package com.wentry.netty.server;

import com.wentry.netty.spi.ProcessorBootstrapper;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class EchoServer{

    private transient static Logger logger = LoggerFactory.getLogger(EchoServer.class);

    public void start(){
        ProcessorBootstrapper processerBootstrapper = new ProcessorBootstrapper();
        processerBootstrapper.start("127.0.0.1",1887);
    }

    public static void main(String[] args) {
        init();
        new EchoServer().start();
        logger.info("系统启动完成");
    }

    private static void init(){
        ClassPathResource classPathResource = new ClassPathResource("config/log4j.properties");
        try {
            PropertyConfigurator.configure(classPathResource.getURL());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
