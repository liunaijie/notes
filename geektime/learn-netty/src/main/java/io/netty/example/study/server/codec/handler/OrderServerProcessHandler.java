package io.netty.example.study.server.codec.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.example.study.common.Operation;
import io.netty.example.study.common.OperationResult;
import io.netty.example.study.common.RequestMessage;
import io.netty.example.study.common.ResponseMessage;

/**
 * 进行业务处理
 * 接收到RequestMessage进行处理得到结果后封装成ResponseMessage然后进行返回
 *
 * @author ：LiuNaiJie
 * @date ：2020-02-24
 */
public class OrderServerProcessHandler extends SimpleChannelInboundHandler<RequestMessage> {

	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, RequestMessage requestMessage) throws Exception {
		//进行处理，并得到处理结果
		Operation operation = requestMessage.getMessageBody();
		OperationResult operationResult = operation.execute();
		//封装成ResponseMessage
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setMessageHeader(requestMessage.getMessageHeader());
		responseMessage.setMessageBody(operationResult);
		//发送回去
		channelHandlerContext.writeAndFlush(responseMessage);
	}
}
