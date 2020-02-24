package io.netty.example.study.util;

import com.google.gson.Gson;

/**
 * @author ：LiuNaiJie
 * @date ：2020-02-23
 */
public final class JsonUtil {

	private static final Gson GSON = new Gson();

	private JsonUtil() {
	}

	public static <T> T fromJson(String jsonstr, Class<T> clazz) {
		return GSON.fromJson(jsonstr, clazz);
	}

	public static String toJson(Object object) {
		return GSON.toJson(object);
	}

}
