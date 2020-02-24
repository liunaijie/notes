package io.netty.example.study.server.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 将网络请求信息转换为 ByteBuf
 * 解决tcp协议中的粘包和半包问题
 * 如果不是也可以不用写
 *
 * @author ：LiuNaiJie
 * @date ：2020-02-23
 */
public class OrderFrameDecoder extends LengthFieldBasedFrameDecoder {

	public OrderFrameDecoder() {
		super(Integer.MAX_VALUE, 0, 2, 0, 2);
	}
}
