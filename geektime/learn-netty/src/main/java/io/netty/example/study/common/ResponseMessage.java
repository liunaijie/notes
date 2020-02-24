package io.netty.example.study.common;

/**
 * @author ：LiuNaiJie
 * @date ：2020-02-23
 */
public class ResponseMessage extends Message <OperationResult>{
	@Override
	public Class getMessageBodyDecodeClass(int opcode) {
		return OperationType.fromOpCode(opcode).getOperationResultClazz();
	}
}
