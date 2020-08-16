/**
 * 
 */
package org.yelong.commons.util.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 便捷的map <br/>
 * 
 * 提供返回本身的put等方法
 * 
 * @since 2.0
 */
public class ConvenientMap<K, V> extends MapWrapper<K, V> {

	public ConvenientMap() {
		this(HashMap::new);
	}

	public ConvenientMap(Map<K, V> sourceMap) {
		super(sourceMap);
	}

	public ConvenientMap(Supplier<Map<K, V>> mapFactory) {
		super(mapFactory.get());
	}

	public ConvenientMap<K, V> put_(K key, V value) {
		put(key, value);
		return this;
	}

	public ConvenientMap<K, V> putAll_(Map<? extends K, ? extends V> m) {
		putAll(m);
		return this;
	}

}
