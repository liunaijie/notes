package io.netty.example.study.client.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.example.study.common.ResponseMessage;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @author ：LiuNaiJie
 * @date ：2020-02-23
 */
public class OrderProtocolDecoder extends MessageToMessageDecoder<ByteBuf> {
	@Override
	protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.decode(byteBuf);
		list.add(responseMessage);
	}
}
