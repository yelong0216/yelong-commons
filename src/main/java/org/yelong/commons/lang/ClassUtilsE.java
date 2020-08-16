/**
 * 
 */
package org.yelong.commons.lang;

import java.util.Objects;

import org.apache.commons.lang3.ClassUtils;

/**
 * 类工具拓展
 * 
 * @see ClassUtils
 * @since 2.0
 */
public final class ClassUtilsE {

	private ClassUtilsE() {
	}

	/**
	 * 获取首字符小写的类名
	 * 
	 * @param clazz class
	 * @return 首字符小写的类名
	 */
	public static String getNamePrefixLowerCase(Class<?> clazz) {
		Objects.requireNonNull(clazz);
		String name = clazz.getSimpleName();
		return name.substring(0, 1).toLowerCase() + name.substring(1);
	}

}
