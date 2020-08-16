/**
 * 
 */
package org.yelong.commons.util.stream;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * java.util.stream 工具类
 * 
 * @since 1.1
 */
public final class StreamUtils {

	private StreamUtils() {
	}

	/**
	 * <pre>
	 * 根据key去重
	 * 		list.stream().filter(StreamUtils.distinctByKey(item -> item.getName())); 
	 * 		list.stream().filter(StreamUtils.distinctByKey(item::getName));
	 * </pre>
	 * 
	 * @param <T>          key type
	 * @param keyExtractor key 提取
	 * @return 去重key的Predicate
	 */
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

}
