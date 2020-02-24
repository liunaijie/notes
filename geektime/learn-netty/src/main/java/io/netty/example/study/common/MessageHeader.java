package io.netty.example.study.common;

import lombok.Data;

/**
 * @author ：LiuNaiJie
 * @date ：2020-02-23
 */
@Data
public class MessageHeader {

	private int version = 1;
	private int opCode;
	private long streamId;

}
