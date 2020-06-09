package com.wentry.netty.codec;

import com.wq.util.CodeUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author Koala
 * @description
 * @date 2020/1/9 0009
 */
public class Decoder extends ReplayingDecoder<Decoder.DecoderState> {

    private int fixedLength =4;

    public Decoder() {
        super(DecoderState.READ_FIXED_HEADER);
    }

    enum DecoderState {
        READ_FIXED_HEADER, READ_PAYLOAD,
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {

        switch(state()){
            case READ_FIXED_HEADER:
                byte[] header = new byte[fixedLength];
                buf.readBytes(header);
                String headMsg = CodeUtil.hexStringToString(CodeUtil.bytes2HexString(header));
                System.out.println("headMsg:"+headMsg);
                checkpoint(DecoderState.READ_PAYLOAD);
//                out.add(headMsg);
                break;
            case READ_PAYLOAD:
                //TODO 怎么读取？？？
                byte[] bytes = new byte[12];
                buf.readBytes(bytes);
                checkpoint(DecoderState.READ_FIXED_HEADER);

                String hexString = CodeUtil.bytes2HexString(bytes);
                String message = CodeUtil.hexStringToString(hexString);
                System.out.println("content:"+message);
                out.add(message);
                break;
            default:
                break;
        }
    }
}
