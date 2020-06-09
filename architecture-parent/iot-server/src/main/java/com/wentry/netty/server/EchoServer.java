package com.wentry.netty.server;

import com.wentry.netty.spi.ProcessorBootstrapper;

public class EchoServer
{

    public void start(){
        ProcessorBootstrapper processerBootstrapper = new ProcessorBootstrapper();
        processerBootstrapper.start("127.0.0.1",1887);
    }

    public static void main(String[] args) {
        new EchoServer().start();
    }
}
