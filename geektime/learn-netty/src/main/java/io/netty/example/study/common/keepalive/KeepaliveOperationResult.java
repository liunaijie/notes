package io.netty.example.study.common.keepalive;

import io.netty.example.study.common.OperationResult;
import lombok.Data;

/**
 * @author ：LiuNaiJie
 * @date ：2020-02-23
 */
@Data
public class KeepaliveOperationResult extends OperationResult {

	private final long time;

}
