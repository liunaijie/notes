package io.netty.example.study.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.example.study.server.codec.OrderFrameDecoder;
import io.netty.example.study.server.codec.OrderFrameEncoder;
import io.netty.example.study.server.codec.OrderProtocolDecoder;
import io.netty.example.study.server.codec.OrderProtocolEncoder;
import io.netty.example.study.server.codec.handler.OrderServerProcessHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author ：LiuNaiJie
 * @date ：2020-02-24
 */
public class Server {

	public static void main(String[] args) throws Exception {
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		serverBootstrap.channel(NioServerSocketChannel.class);
		serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));
		serverBootstrap.group(new NioEventLoopGroup());

		serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
			@Override
			protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
				ChannelPipeline pipeline = nioSocketChannel.pipeline();
				pipeline.addLast(new OrderFrameDecoder());
				pipeline.addLast(new OrderFrameEncoder());
				pipeline.addLast(new OrderProtocolEncoder());
				pipeline.addLast(new OrderProtocolDecoder());
				pipeline.addLast(new LoggingHandler(LogLevel.INFO));

				pipeline.addLast(new OrderServerProcessHandler());

			}
		});

		ChannelFuture channelFuture = serverBootstrap.bind(8090).sync();
		channelFuture.channel().closeFuture().get();
	}

}
