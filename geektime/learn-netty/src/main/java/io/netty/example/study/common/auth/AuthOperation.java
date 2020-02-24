package io.netty.example.study.common.auth;

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
public class AuthOperation extends Operation {

	private final String userName;

	private final String password;

	@Override
	public OperationResult execute() {
		if ("admin".equalsIgnoreCase(this.userName)) {
			return new AuthOperationResult(true);
		}
		return new AuthOperationResult(false);
	}
}
