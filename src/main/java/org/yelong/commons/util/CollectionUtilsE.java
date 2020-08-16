/**
 * 
 */
package org.yelong.commons.util;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;

/**
 * 集合工具类拓展
 * 
 * @since 1.3
 */
public final class CollectionUtilsE {

	private CollectionUtilsE() {
	}

	/**
	 * 返回列表中指定位置的元素。如果指定位置不存在元素则返回 <code>null</code>
	 * 
	 * @param <T>        {@link Collection}的对象类型
	 * @param collection 获取值的 {@link Collection} 允许为 <code>null</code>
	 * @param index      获取的索引
	 * @return 位于指定索引处的对象，如果不存在则为 <code>null</code>
	 */
	public static <T> T get(Collection<T> collection, int index) {
		if (CollectionUtils.isEmpty(collection)) {
			return null;
		}
		if (index < 0 || index >= collection.size()) {
			return null;
		}
		return IteratorUtils.get(collection.iterator(), index);
	}

	/**
	 * 返回列表中指定位置的元素。如果指定位置不存在元素则返回默认值
	 * 
	 * @param <T>          {@link Collection}的对象类型
	 * @param collection   获取值的 {@link Collection} 允许为 <code>null</code>
	 * @param index        获取的索引
	 * @param defaultValue 默认值
	 * @return 位于指定索引处的对象，如果不存在则为 defaultValue
	 */
	public static <T> T get(Collection<T> collection, int index, T defaultValue) {
		T value = get(collection, index);
		return null != value ? value : defaultValue;
	}

	/**
	 * 验证集合是否为空
	 * 
	 * @param collection 需要验证的集合
	 * @return collection
	 */
	public static <T> Collection<T> requireNonEmpty(Collection<T> collection) {
		if (CollectionUtils.isEmpty(collection)) {
			throw new CollectionEmptyException();
		}
		return collection;
	}

	/**
	 * 验证集合是否为空
	 * 
	 * @param collection 需要验证的集合
	 * @param message    异常消息
	 * @return collection
	 */
	public static <T> Collection<T> requireNonEmpty(Collection<T> collection, String message) {
		if (CollectionUtils.isEmpty(collection)) {
			throw new CollectionEmptyException(message);
		}
		return collection;
	}

	/**
	 * 集合为空异常
	 */
	public static class CollectionEmptyException extends RuntimeException {

		private static final long serialVersionUID = -1273859542034146573L;

		public CollectionEmptyException() {
		}

		public CollectionEmptyException(String message) {
			super(message);
		}

	}

}
