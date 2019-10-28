package com.wentry.natrual.server;

import java.io.IOException;

import org.springframework.context.event.ContextRefreshedEvent;

public class InitServer

{
    private Server server;
    public void init()
    {
        server = new Server();
        try
        {
            server.startServer();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            server.stopServer();
        }
        
    }
    
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        if (event.getApplicationContext().getParent() == null)
        {
            init(); 
            // TODO accept()方法阻塞了tomcat的启动流程，需要设置线程来启动socket  
        }
        
    }
}
