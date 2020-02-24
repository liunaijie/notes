package io.netty.example.study.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.example.study.client.codec.OrderFrameDecoder;
import io.netty.example.study.client.codec.OrderFrameEncoder;
import io.netty.example.study.client.codec.OrderProtocolDecoder;
import io.netty.example.study.client.codec.OrderProtocolEncoder;
import io.netty.example.study.common.RequestMessage;
import io.netty.example.study.common.order.OrderOperation;
import io.netty.example.study.util.IdUtil;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author ：LiuNaiJie
 * @date ：2020-02-24
 */
public class Client {

	public static void main(String[] args) throws Exception {
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.channel(NioSocketChannel.class);

		bootstrap.group(new NioEventLoopGroup());

		bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
			@Override
			protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
				ChannelPipeline pipeline = nioSocketChannel.pipeline();
				pipeline.addLast(new OrderFrameDecoder());
				pipeline.addLast(new OrderFrameEncoder());
				pipeline.addLast(new OrderProtocolEncoder());
				pipeline.addLast(new OrderProtocolDecoder());
				pipeline.addLast(new LoggingHandler(LogLevel.INFO));
			}
		});
		//连接
		ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8090);
		//由于是异步，所以下面发送消息时不一定已经连接了，所以先同步等待连接
		channelFuture.sync();
		//构建并发送消息
		RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(), new OrderOperation(1001, "水饺"));
		channelFuture.channel().writeAndFlush(requestMessage);


		channelFuture.channel().closeFuture().get();

	}

}
