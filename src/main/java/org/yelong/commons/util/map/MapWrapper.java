/**
 * 
 */
package org.yelong.commons.util.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * map 包装器
 * 
 * @since 1.1
 */
public class MapWrapper<K, V> implements Map<K, V> {

	private final Map<K, V> sourceMap;

	public MapWrapper(Map<K, V> sourceMap) {
		this.sourceMap = sourceMap;
	}

	@Override
	public int size() {
		return sourceMap.size();
	}

	@Override
	public boolean isEmpty() {
		return sourceMap.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return sourceMap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return sourceMap.containsValue(value);
	}

	@Override
	public V get(Object key) {
		return sourceMap.get(key);
	}

	@Override
	public V put(K key, V value) {
		return sourceMap.put(key, value);
	}

	@Override
	public V remove(Object key) {
		return sourceMap.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		sourceMap.putAll(m);
	}

	@Override
	public void clear() {
		sourceMap.clear();
	}

	@Override
	public Set<K> keySet() {
		return sourceMap.keySet();
	}

	@Override
	public Collection<V> values() {
		return sourceMap.values();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return sourceMap.entrySet();
	}

	/**
	 * @return 源 map
	 */
	public Map<K, V> getMap() {
		return sourceMap;
	}

	@Override
	public int hashCode() {
		return sourceMap.hashCode();
	}

	@Override
	public String toString() {
		return sourceMap.toString();
	}

}
