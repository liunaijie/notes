package io.netty.example.study.common.order;

import io.netty.example.study.common.OperationResult;
import lombok.Data;

/**
 * @author ：LiuNaiJie
 * @date ：2020-02-23
 */
@Data
public class OrderOperationResult extends OperationResult {

	private final int tableId;
	private final String dish;
	private final boolean complete;

}
