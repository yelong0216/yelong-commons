/**
 * 
 */
package org.yelong.commons.util.map;

import java.util.Map;

import org.apache.commons.collections4.map.AbstractHashedMap;
import org.apache.commons.collections4.map.CaseInsensitiveMap;

/**
 * 忽略大写Map工具类
 * 
 * @author PengFei
 * @since 1.1.0
 */
public final class CaseInsensitiveMapUtils {

	//不允许实例化
	private CaseInsensitiveMapUtils() {}
	
	 /**
     * @see KeyStoreMode
     * @see CaseInsensitiveMap#CaseInsensitiveMap()
     */
	public static <K,V> CaseInsensitiveMap<K,V> createCaseInsensitiveMap(final KeyStoreMode keyStoreMode) {
		if( keyStoreMode == KeyStoreMode.UPPER ) {
			return new CaseInsensitiveMapKeyUpper<K,V>();
		}
		return new CaseInsensitiveMap<K, V>();
	}
	
	 /**
     * @see KeyStoreMode
     * @see CaseInsensitiveMap#CaseInsensitiveMap(int)
     */
    public static <K,V> CaseInsensitiveMap<K,V>  createCaseInsensitiveMap(final int initialCapacity,final KeyStoreMode keyStoreMode) {
    	if( keyStoreMode == KeyStoreMode.UPPER ) {
			return new CaseInsensitiveMapKeyUpper<K,V>(initialCapacity);
		}
		return new CaseInsensitiveMap<K, V>(initialCapacity);
    }

    /**
     * @see KeyStoreMode
     * @see CaseInsensitiveMap#CaseInsensitiveMap(int, float)
     */
    public static <K,V> CaseInsensitiveMap<K,V>  createCaseInsensitiveMap(final int initialCapacity, final float loadFactor,final KeyStoreMode keyStoreMode) {
    	if( keyStoreMode == KeyStoreMode.UPPER ) {
			return new CaseInsensitiveMapKeyUpper<K,V>(initialCapacity,loadFactor);
		}
		return new CaseInsensitiveMap<K, V>(initialCapacity,loadFactor);
    }

    /**
     * @see KeyStoreMode
     * @see CaseInsensitiveMap#CaseInsensitiveMap(Map)
     */
    public static <K,V> CaseInsensitiveMap<K,V>  createCaseInsensitiveMap(final Map<? extends K, ? extends V> map,final KeyStoreMode keyStoreMode) {
    	if( keyStoreMode == KeyStoreMode.UPPER ) {
			return new CaseInsensitiveMapKeyUpper<K,V>(map);
		}
		return new CaseInsensitiveMap<K, V>(map);
    }
	
    /**
     * key 存储的类型
     * @author PengFei
     */
	public static enum KeyStoreMode {
		
		/**CaseInsensitiveMap key 存储大写*/
		UPPER,
		/**CaseInsensitiveMap key 存储小写*/
		LOWER
		
	}
	
	/**
	 * Key 大写的 忽略大小写的Map
	 * @author PengFei
	 * @param <K> this key type
	 * @param <V> this value type
	 */
	public static class CaseInsensitiveMapKeyUpper<K,V> extends CaseInsensitiveMap<K,V>{

		private static final long serialVersionUID = 4240507943940805742L;
		
		public CaseInsensitiveMapKeyUpper() {}
		
	    public CaseInsensitiveMapKeyUpper(final int initialCapacity) {
	        super(initialCapacity);
	    }

	    public CaseInsensitiveMapKeyUpper(final int initialCapacity, final float loadFactor) {
	        super(initialCapacity, loadFactor);
	    }

	    public CaseInsensitiveMapKeyUpper(final Map<? extends K, ? extends V> map) {
	        super(map);
	    }
		
		@Override
		protected Object convertKey(Object key) {
	        if (key != null) {
	            final char[] chars = key.toString().toCharArray();
	            for (int i = chars.length - 1; i >= 0; i--) {
	            	 chars[i] = Character.toUpperCase(Character.toLowerCase(chars[i]));
	            }
	            return new String(chars);
	        }
	        return AbstractHashedMap.NULL;
	    }
		
	}
	
}
