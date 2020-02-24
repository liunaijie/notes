package io.netty.example.study.client.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 *
 * @author ：LiuNaiJie
 * @date ：2020-02-23
 */
public class OrderFrameDecoder extends LengthFieldBasedFrameDecoder {

	public OrderFrameDecoder() {
		super(Integer.MAX_VALUE, 0, 2, 0, 2);
	}
}
