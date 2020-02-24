package io.netty.example.study.server.codec;

import io.netty.handler.codec.LengthFieldPrepender;

/**
 * 解决tcp客户端的粘包、半包问题
 *
 * @author ：LiuNaiJie
 * @date ：2020-02-24
 */
public class OrderFrameEncoder extends LengthFieldPrepender {

	public OrderFrameEncoder() {
		super(2);
	}
}
