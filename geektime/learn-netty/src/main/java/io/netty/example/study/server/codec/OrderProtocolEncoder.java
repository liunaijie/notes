package io.netty.example.study.server.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.example.study.common.ResponseMessage;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * 将业务完成后返回的ResponseMessage转换为ByteBuf
 *
 * @author ：LiuNaiJie
 * @date ：2020-02-24
 */
public class OrderProtocolEncoder extends MessageToMessageEncoder<ResponseMessage> {

	@Override
	protected void encode(ChannelHandlerContext channelHandlerContext, ResponseMessage responseMessage, List<Object> list) throws Exception {
		ByteBuf byteBuf = channelHandlerContext.alloc().buffer();
		responseMessage.encode(byteBuf);
		list.add(byteBuf);
	}
}
