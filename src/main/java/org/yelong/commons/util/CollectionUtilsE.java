/**
 * 
 */
package org.yelong.commons.util;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

/**
 * 集合工具类拓展
 * 
 * @author PengFei
 * @since 1.3.0
 */
public final class CollectionUtilsE {

	private CollectionUtilsE() {
	}

	/**
	 * 验证字符串是否是空字符
	 * 
	 * @param c 需要验证的字符串
	 * @return c
	 */
	public static <T> List<T> requireNonEmpty(List<T> coll) {
		if (CollectionUtils.isEmpty(coll)) {
			throw new CollectionEmptyException();
		}
		return coll;
	}

	/**
	 * 验证字符串是否是空字符
	 * 
	 * @param c 需要验证的字符串
	 * @return c
	 */
	public static <T> List<T> requireNonEmpty(List<T> coll, String message) {
		if (CollectionUtils.isEmpty(coll)) {
			throw new CollectionEmptyException(message);
		}
		return coll;
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
