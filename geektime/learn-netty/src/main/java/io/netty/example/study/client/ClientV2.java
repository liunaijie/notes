package io.netty.example.study.client;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.example.study.client.codec.*;
import io.netty.example.study.client.codec.dispatcher.OperationResultFuture;
import io.netty.example.study.client.codec.dispatcher.RequestPendingCenter;
import io.netty.example.study.client.codec.dispatcher.ResponseDispatcherHandler;
import io.netty.example.study.common.OperationResult;
import io.netty.example.study.common.RequestMessage;
import io.netty.example.study.common.order.OrderOperation;
import io.netty.example.study.util.IdUtil;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author ：LiuNaiJie
 * @date ：2020-02-24
 */
public class ClientV2 {

	public static void main(String[] args) throws Exception {
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.channel(NioSocketChannel.class);

		bootstrap.group(new NioEventLoopGroup());

		RequestPendingCenter requestPendingCenter = new RequestPendingCenter();

		bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
			@Override
			protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
				ChannelPipeline pipeline = nioSocketChannel.pipeline();
				pipeline.addLast(new OrderFrameDecoder());
				pipeline.addLast(new OrderFrameEncoder());
				pipeline.addLast(new OrderProtocolEncoder());
				pipeline.addLast(new OrderProtocolDecoder());
				//获得服务端响应后，将响应信息设置到future中
				pipeline.addLast(new ResponseDispatcherHandler(requestPendingCenter));

				pipeline.addLast(new LoggingHandler(LogLevel.INFO));
			}
		});
		//连接
		ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8090);
		//由于是异步，所以下面发送消息时不一定已经连接了，所以先同步等待连接
		channelFuture.sync();
		//构建并发送消息
		long streamId = IdUtil.nextId();
		RequestMessage requestMessage = new RequestMessage(streamId, new OrderOperation(1001, "水饺"));
		//设置一个future
		OperationResultFuture operationResultFuture = new OperationResultFuture();
		//创建一个map容器，key为streamId，value为future
		requestPendingCenter.add(streamId, operationResultFuture);
		//发送消息
		channelFuture.channel().writeAndFlush(requestMessage);
		//获取响应信息
		OperationResult operationResult = operationResultFuture.get();
		System.out.println(operationResult);
		channelFuture.channel().closeFuture().get();

	}

}

