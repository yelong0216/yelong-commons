/**
 * 
 */
package org.yelong.commons.support;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 英文字母
 * 
 * @since 2.0
 */
public final class EnglishLetters {

	private static final List<Character> lowerCaseLetters = Collections
			.unmodifiableList(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
					'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

	private static final List<Character> upperCaseLetters = Collections
			.unmodifiableList(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
					'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));

	public static final Integer lettersNum = 26;

	private EnglishLetters() {
	}

	/**
	 * 获取字母表中指定位置的小写字母字符
	 * 
	 * @param index 字母在字母表中的位置。这个位置从1开始到26结束
	 * @return 字母表中指定位置的小写字母字符
	 */
	public static char getLowerCase(int index) {
		if (index < 1 || index > 26) {
			throw new IndexOutOfBoundsException("索引不能小于1且不能大于26");
		}
		return lowerCaseLetters.get(index - 1);
	}

	/**
	 * 获取字母表中指定位置的大写字母字符
	 * 
	 * @param index 字母在字母表中的位置。这个位置从1开始到26结束
	 * @return 字母表中指定位置的大写字母字符
	 */
	public static char getUpperCase(int index) {
		if (index < 1 || index > 26) {
			throw new IndexOutOfBoundsException("索引不能小于1且不能大于26");
		}
		return upperCaseLetters.get(index - 1);
	}

}
