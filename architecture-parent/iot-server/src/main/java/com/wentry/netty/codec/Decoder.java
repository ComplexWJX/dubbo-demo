package com.wentry.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author Koala
 * @description
 * @date 2020/1/9 0009
 */
public class Decoder extends ReplayingDecoder<String> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {
        out.add(buf.readBytes(buf.readInt()));
    }
}
