package com.wentry.netty.server;

import com.wentry.netty.spi.ProcesserBootstrapper;

public class EchoServer
{

    public void start(){
        ProcesserBootstrapper processerBootstrapper = new ProcesserBootstrapper();
        processerBootstrapper.start("127.0.0.1",1887);
    }
}
