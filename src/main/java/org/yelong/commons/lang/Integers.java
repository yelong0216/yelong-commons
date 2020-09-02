/**
 * 
 */
package org.yelong.commons.lang;

/**
 * {@link Integer}工具类
 * 
 * @since 2.1
 */
public final class Integers {

	private Integers() {
	}

	/**
	 * 将字符串解析为整数值，如果解析失败了则返回 <code>null</code>，这不会抛出 {@link NumberFormatException}
	 * 
	 * @param str 被解析的字符串
	 * @return 字符串解析为的整数，如果不能解析则返回 <code>null</code>
	 * @see Integer#valueOf(String)
	 */
	public static Integer valueOf(String str) {
		try {
			return Integer.valueOf(str);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * 将字符串解析为整数值，如果解析失败了则返回默认值，这不会抛出 {@link NumberFormatException}
	 * 
	 * @param str          被解析的字符串
	 * @param defaultValue 解析失败后返回的默认值
	 * @return 字符串解析为的整数，如果不能解析则返回默认值
	 * @see Integer#valueOf(String)
	 */
	public static Integer valueOf(String str, Integer defaultValue) {
		Integer value = valueOf(str);
		return null != value ? value : defaultValue;
	}

}
