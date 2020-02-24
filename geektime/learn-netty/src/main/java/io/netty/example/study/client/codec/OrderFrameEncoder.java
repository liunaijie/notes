package io.netty.example.study.client.codec;

import io.netty.handler.codec.LengthFieldPrepender;

/**
 *
 * @author ：LiuNaiJie
 * @date ：2020-02-24
 */
public class OrderFrameEncoder extends LengthFieldPrepender {

	public OrderFrameEncoder() {
		super(2);
	}
}
