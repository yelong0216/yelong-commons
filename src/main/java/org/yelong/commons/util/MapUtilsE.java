/**
 * 
 */
package org.yelong.commons.util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.apache.commons.collections4.MapUtils;

/**
 * map工具拓展
 * 
 * @since 1.3
 */
public final class MapUtilsE {

	private MapUtilsE() {
	}

	/**
	 * 验证字符串是否是空字符
	 * 
	 * @param c 需要验证的字符串
	 * @return c
	 */
	public static <K, V> Map<K, V> requireNonEmpty(Map<K, V> map) {
		if (MapUtils.isEmpty(map)) {
			throw new MapEmptyException();
		}
		return map;
	}

	/**
	 * 验证字符串是否是空字符
	 * 
	 * @param c       需要验证的字符串
	 * @param message 异常消息
	 * @return c
	 */
	public static <K, V> Map<K, V> requireNonEmpty(Map<K, V> map, String message) {
		if (MapUtils.isEmpty(map)) {
			throw new MapEmptyException(message);
		}
		return map;
	}

	/**
	 * 创建HashMap，并将key、value键值对放入map中
	 * 
	 * @param <K>   key type
	 * @param <V>   value type
	 * @param key   key
	 * @param value value
	 * @return a map
	 * @see HashMap
	 */
	public static <K, V> Map<K, V> asMap(K key, V value) {
		return asMap(HashMap::new, key, value);
	}

	/**
	 * 根据map工厂创建map对象，并将key、value键值对放入map中
	 * 
	 * @param <K>        key type
	 * @param <V>        value type
	 * @param mapFactory map工厂
	 * @param key        key
	 * @param value      value
	 * @return a map
	 */
	public static <K, V> Map<K, V> asMap(Supplier<Map<K, V>> mapFactory, K key, V value) {
		Map<K, V> map = mapFactory.get();
		map.put(key, value);
		return map;
	}

	/**
	 * Map为空异常
	 */
	public static class MapEmptyException extends RuntimeException {

		private static final long serialVersionUID = -1273859542034146573L;

		public MapEmptyException() {
		}

		public MapEmptyException(String message) {
			super(message);
		}

	}

}
