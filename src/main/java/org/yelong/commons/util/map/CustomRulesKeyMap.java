/**
 * 
 */
package org.yelong.commons.util.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 * 自定义规则的Key Map
 * 
 * 可以对一个key尝试多种方式获取value。多种方式都可以获取情况下以添加key规则的顺序靠前的为准。
 * 源key值拥有最高顺序。
 * 
 * @author PengFei
 * @since
 */
public class CustomRulesKeyMap <K,V> implements Map<K, V>{

	private final Map<K,V> map;
	
	private final List<KeyRule<K>> keyRules = new ArrayList<KeyRule<K>>();
	
	public CustomRulesKeyMap(final Map<K, V> map) {
		this.map = map;
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return null != get(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(Object key) {
		List<K> keys = getCustomRuleKeys((K)key);
		for (K k : keys) {
			V v = map.get(k);
			if( null != v ) {
				return v;
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		return map.put(key, value);
	}

	@Override
	public V remove(Object key) {
		return map.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		map.putAll(m);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Set<K> keySet() {
		return map.keySet();
	}

	@Override
	public Collection<V> values() {
		return map.values();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return map.entrySet();
	}
	
	/**
	 * 获取自定义规则后的key 。 且集合的第一个永远是源key
	 * @param key
	 * @return 获取所有自定义规则的key
	 */
	public List<K> getCustomRuleKeys(K key) {
		return getCustomRuleKeys(key, true);
	}
	
	/**
	 * 获取自定义规则后的key 。 且数组的第一个永远是源key
	 * @param key
	 * @param sourceKey 是否包含源key。包含源key时，源key永远是集合中的第一个元素
	 * @return 获取所有自定义规则的key
	 */
	public List<K> getCustomRuleKeys(K key , boolean sourceKey){
		if(CollectionUtils.isEmpty(keyRules)) {
			if(sourceKey) {
				return Arrays.asList(key);
			} else {
				return Collections.emptyList();
			}
		}
		List<K> keys = new ArrayList<>(keyRules.size()+1);
		keys.add(key);
		for (KeyRule<K> keyRule : keyRules) {
			//如果已经包含了key则不会在添加。伪Set。
			K k = keyRule.custom(key);
			if(!keys.contains(k)) {
				keys.add(k);
			}
		}
		if(!sourceKey) {
			keys.remove(0);
		}
		return Collections.unmodifiableList(keys);
	}
	
	
	/**
	 * 更换key。对符合自定义规则的key全部删除，且新增key其值为符合规则的第一个值。如果符合规则的值，则值为null
	 * @param key 需要更换key的值
	 * @return 更换后key对应的value
	 */
	public V replacementKey(K key) {
		List<K> keys = getCustomRuleKeys(key,false);
		V value = sourceGet(key);
		if( value != null ) {//源key存在值时，执行清空所有自定义规则的key
			keys.forEach(x->remove(x));
		} else {
			for (K k : keys) {
				V v = sourceGet(k);
				if( null != v && null == value ) {
					value = v;
				}
				remove(k);
			}
			put(key, value);
		}
		return value;
	}
	
	/**
	 * 添加 key 规则
	 * @param keyRule key 规则
	 * @return this
	 */
	public CustomRulesKeyMap<K,V> addKeyRule(KeyRule<K> keyRule) {
		this.keyRules.add(keyRule);
		return this;
	}
	
	/**
	 * @return keyRule all
	 */
	public List<KeyRule<K>> getKeyRules() {
		return keyRules;
	}
	
	/**
	 * @return source map
	 */
	public Map<K, V> getSourceMap() {
		return map;
	}
	
	protected V sourceGet(K key) {
		return map.get(key);
	}
	
	@Override
	public String toString() {
		return map.toString();
	}
	
	/**
	 * map key rule
	 * @author PengFei
	 */
	@FunctionalInterface
	public static interface KeyRule <K> {
		
		/**
		 * 定制key
		 * @param key 源key
		 * @return 定制规则后的key。
		 */
		K custom(K key);
		
	}
	
}
