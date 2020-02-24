package io.netty.example.study.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ：LiuNaiJie
 * @date ：2020-02-23
 */
public final class IdUtil {

	private static final AtomicLong IDX = new AtomicLong();

	private IdUtil() {
	}

	public static long nextId() {
		return IDX.incrementAndGet();
	}

}
