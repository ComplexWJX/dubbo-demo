package com.wentry.netty.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoServerBaseHandler extends ChannelInboundHandlerAdapter
{
    @Override
    public void channelActive(ChannelHandlerContext ctx)
        throws Exception
    {
        
    }
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
        throws Exception
    {
        //super.channelRead(ctx, msg);
        ctx.write(msg);
    }
    
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx)
        throws Exception
    {
        super.channelReadComplete(ctx);
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
        throws Exception
    {
        //super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
