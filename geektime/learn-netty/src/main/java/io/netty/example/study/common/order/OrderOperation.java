package io.netty.example.study.common.order;

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
public class OrderOperation extends Operation {

	private int tableId;

	private String dish;

	public OrderOperation(int tableId, String dish) {
		this.tableId = tableId;
		this.dish = dish;
	}


	@Override
	public OperationResult execute() {
		log.info("order's executing startup with orderRequest:" + toString());
		log.info("order's executing complete");
		OrderOperationResult orderResponse = new OrderOperationResult(tableId, dish, true);
		return orderResponse;
	}
}
