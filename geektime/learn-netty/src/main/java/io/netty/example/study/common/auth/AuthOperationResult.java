package io.netty.example.study.common.auth;

import io.netty.example.study.common.OperationResult;
import lombok.Data;

/**
 * @author ：LiuNaiJie
 * @date ：2020-02-23
 */
@Data
public class AuthOperationResult extends OperationResult {

	private final boolean passAuth;

}
