package io.netty.example.study.server.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.example.study.common.RequestMessage;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * 为了给业务层做处理
 * 将ByteBuf转换为RequestMessage
 *
 * @author ：LiuNaiJie
 * @date ：2020-02-23
 */
public class OrderProtocolDecoder extends MessageToMessageDecoder<ByteBuf> {
	@Override
	protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
		RequestMessage requestMessage = new RequestMessage();
		requestMessage.decode(byteBuf);
		list.add(requestMessage);
	}
}
