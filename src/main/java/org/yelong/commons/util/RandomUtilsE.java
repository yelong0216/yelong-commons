/**
 * 
 */
package org.yelong.commons.util;

import java.util.Random;

/**
 * 随机数工具类拓展
 */
public final class RandomUtilsE {

	/**
	 * 随机方法使用的随机对象。这必须不是随机方法的本地值，以避免在相同的毫秒内返回相同的值。
	 */
	private static final Random RANDOM = new Random();

	private RandomUtilsE() {
	}

	/**
	 * 取一个范围内的一个随机数
	 * 
	 * @param minValue 最小值
	 * @param maxValue 最大值
	 * @return 最小值与最大值之间的一个随机数。这个随机数包含最大值和最小值
	 */
	public static int nextInt(final int minValue, final int maxValue) {
		if (minValue > maxValue) {
			throw new IllegalArgumentException("起始值必须小于或等于结束值。");
		}
		if (minValue < 0) {
			throw new IllegalArgumentException("两个范围值都必须是非负的。");
		}
		if (minValue == maxValue) {
			return minValue;
		}
		return minValue + RANDOM.nextInt(maxValue - minValue + 1);
	}
}
