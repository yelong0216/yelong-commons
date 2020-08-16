/**
 * 
 */
package org.yelong.commons.util;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

/**
 * List集合工具类
 * 
 * @since 2.0
 */
public final class ListUtilsE {

	private ListUtilsE() {
	}

	/**
	 * 返回列表中指定位置的元素。如果指定位置不存在元素则返回 <code>null</code>
	 * 
	 * @param <T>   {@link List}的对象类型
	 * @param list  获取值的 {@link List} 允许为 <code>null</code>
	 * @param index 获取的索引
	 * @return 位于指定索引处的对象，如果不存在则为 <code>null</code>
	 */
	public static <T> T get(List<T> list, int index) {
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		if (index < 0 || index >= list.size()) {
			return null;
		}
		return list.get(index);
	}

	/**
	 * 返回列表中指定位置的元素。如果指定位置不存在元素则返回默认值
	 * 
	 * @param <T>          {@link List}的对象类型
	 * @param list         获取值的 {@link List} 允许为 <code>null</code>
	 * @param index        获取的索引
	 * @param defaultValue 默认值
	 * @return 位于指定索引处的对象，如果不存在则为 defaultValue
	 */
	public static <T> T get(List<T> list, int index, T defaultValue) {
		T value = get(list, index);
		return null != value ? value : defaultValue;
	}

}
