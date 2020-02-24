package io.netty.example.study.client.codec.dispatcher;

import io.netty.example.study.common.OperationResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：LiuNaiJie
 * @date ：2020-02-24
 */
public class RequestPendingCenter {

	private Map<Long, OperationResultFuture> map = new ConcurrentHashMap<>();


	public void add(Long streamId, OperationResultFuture future) {
		this.map.put(streamId, future);
	}

	public void set(Long streamId, OperationResult operationResult) {
		OperationResultFuture operationResultFuture = this.map.get(streamId);
		if (operationResultFuture != null) {
			operationResultFuture.setSuccess(operationResult);
			this.map.remove(streamId);
		}
	}

}
