package io.netty.example.study.common;

import io.netty.buffer.ByteBuf;
import io.netty.example.study.util.JsonUtil;
import lombok.Data;

import java.nio.charset.Charset;

/**
 * @author ：LiuNaiJie
 * @date ：2020-02-23
 */
@Data
public abstract class Message<T extends MessageBody> {

	private MessageHeader messageHeader;

	private T messageBody;

	public T getMessageBody() {
		return messageBody;
	}

	public void encode(ByteBuf byteBuf) {
		byteBuf.writeInt(messageHeader.getVersion());
		byteBuf.writeLong(messageHeader.getStreamId());
		byteBuf.writeInt(messageHeader.getOpCode());
		byteBuf.writeBytes(JsonUtil.toJson(messageBody).getBytes());
	}

	public abstract Class<T> getMessageBodyDecodeClass(int opcode);

	public void decode(ByteBuf msg) {
		int version = msg.readInt();
		long streamId = msg.readLong();
		int opcode = msg.readInt();
		MessageHeader messageHeader = new MessageHeader();
		messageHeader.setVersion(version);
		messageHeader.setOpCode(opcode);
		messageHeader.setStreamId(streamId);
		this.messageHeader = messageHeader;
		Class<T> bodyClazz = getMessageBodyDecodeClass(opcode);
		T body = JsonUtil.fromJson(msg.toString(Charset.forName("UTF-8")), bodyClazz);
		this.messageBody = body;
	}

}
