package io.netty.example.study.common.keepalive;

import io.netty.example.study.common.Operation;
import io.netty.example.study.common.OperationResult;
import lombok.Data;
import lombok.extern.java.Log;

/**
 * @author ：LiuNaiJie
 * @date ：2020-02-23
 */
@Data
@Log
public class KeepaliveOperation extends Operation {

	private long time;

	public KeepaliveOperation() {
		this.time = System.nanoTime();
	}

	@Override
	public OperationResult execute() {
		KeepaliveOperationResult orderResponse = new KeepaliveOperationResult(time);
		return orderResponse;
	}
}
