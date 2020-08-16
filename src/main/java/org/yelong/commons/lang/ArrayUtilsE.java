/**
 * 
 */
package org.yelong.commons.lang;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 数组工具类
 * 
 * @since 1.3
 * @see ArrayUtils
 */
public final class ArrayUtilsE {

	private ArrayUtilsE() {
	}

	/**
	 * 验证数组是否为空
	 * 
	 * @param array 需要验证的字符串
	 * @return array
	 * @throws ArrayEmptyException 数组为空
	 */
	public static <T> T[] requireNonEmpty(T[] array) {
		if (ArrayUtils.isEmpty(array)) {
			throw new ArrayEmptyException();
		}
		return array;
	}

	/**
	 * 数组为空异常
	 */
	public static class ArrayEmptyException extends RuntimeException {

		private static final long serialVersionUID = -2034225815001398060L;

		public ArrayEmptyException() {
		}

		public ArrayEmptyException(String message) {
			super(message);
		}

	}

}
