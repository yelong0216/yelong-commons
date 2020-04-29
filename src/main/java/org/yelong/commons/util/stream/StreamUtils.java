/**
 * 
 */
package org.yelong.commons.util.stream;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author PengFei
 * @since 1.0.3
 */
public final class StreamUtils {

	private StreamUtils() {}
	
	/**
	 * 根据key去重
	 * 		list.stream().filter(CollectorUtils.distinctByKey(item -> item.getName())); 
	 * 		list.stream().filter(CollectorUtils.distinctByKey(item::getName)); 
	 * @param <T>
	 * @param keyExtractor
	 * @return
	 */
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	
}
