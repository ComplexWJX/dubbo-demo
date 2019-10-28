package com.wentry.netty.spi;

import java.net.InetSocketAddress;

import com.wentry.netty.handle.EchoServerBaseHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ProcesserBootstrapper
{
    /*
     * 1.Channel---->Socket
     * 2.EventLoop--->控制流、多线程处理、并发
     * 3.ChannelFuture--->异步通知
     */
    
    public void start(final String host,final int port){
        //创建事件处理
        final EchoServerBaseHandler handler = new EchoServerBaseHandler();
        //创建EventLoopGroup
        EventLoopGroup boss_group = new NioEventLoopGroup();
        EventLoopGroup work_group = new NioEventLoopGroup();
        //创建ServerBootstrap
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss_group,work_group)
                 .channel(NioServerSocketChannel.class) //指定所使用的NIO传输Channel
                 //.localAddress(new InetSocketAddress(port)) //指定端口设置套接字地址
                 .childHandler(new ChannelInitializer<SocketChannel>()
                {

                    @Override
                    protected void initChannel(SocketChannel ch)
                        throws Exception
                    {
                        ch.pipeline().addLast("echoServerHandler", handler);
                    }
                });
        try
        {
            ChannelFuture f = bootstrap.bind(host, port);
            //异步地绑定服务器
            f.sync();       
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }finally{
            boss_group.shutdownGracefully();
            work_group.shutdownGracefully();
        }
    }
}
