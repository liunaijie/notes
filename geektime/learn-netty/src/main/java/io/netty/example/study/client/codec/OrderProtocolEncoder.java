package io.netty.example.study.client.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.example.study.common.RequestMessage;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * 客户端过程为：
 * ProtocolEncoder->FrameEncoder->FrameDecoder->ProtocolEncoder
 * 1.发出请求，将RequestMessage转换为ByteBuf
 * 2.解决tcp的粘包、半包问题，添加长度字段
 * 3.接收到服务端响应，解决粘包、半包问题
 * 4.将ByteBuf转换为ResponseMessage进行业务处理
 * @author ：LiuNaiJie
 * @date ：2020-02-24
 */
public class OrderProtocolEncoder extends MessageToMessageEncoder<RequestMessage> {

	@Override
	protected void encode(ChannelHandlerContext channelHandlerContext, RequestMessage requestMessage, List<Object> list) throws Exception {
		ByteBuf byteBuf = channelHandlerContext.alloc().buffer();
		requestMessage.encode(byteBuf);
		list.add(byteBuf);
	}
}
