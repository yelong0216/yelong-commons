/**
 * 
 */
package org.yelong.commons.lang;

import java.util.Arrays;
import java.util.List;

/**
 * 基础数据类型工具类
 * 
 * @since 1.1
 */
public final class BaseDataTypeUtils {

	private BaseDataTypeUtils() {
	}

	/**
	 * 基础数据类型
	 */
	private static final List<String> BASE_DATA_TYPE = Arrays.asList("byte", "short", "int", "long", "float", "double",
			"boolean", "char");

	/**
	 * 包装数据类型
	 */
	private static final List<Class<?>> BASE_DATA_WRAPPER_TYPE = Arrays.asList(Byte.class, Short.class, Integer.class,
			Long.class, Float.class, Double.class, Boolean.class, Character.class);

	/**
	 * 获取基础数据类型对应的包装数据类型
	 * 
	 * @param baseDataType 基础数据类型
	 * @return 包装数据类型。如果不存在这个基础数据类型则返回null
	 */
	public static final Class<?> getWrapperType(String baseDataType) {
		int i = BASE_DATA_TYPE.indexOf(baseDataType);
		return i == -1 ? null : BASE_DATA_WRAPPER_TYPE.get(i);
	}

	/**
	 * 获取包装数据类型对应的基础数据类型
	 * 
	 * @param wrapperType 包装数据类型
	 * @return 基础数据类型。如果不存在这个包装数据类型则返回null
	 */
	public static final String getBaseDataType(Class<?> wrapperType) {
		int i = BASE_DATA_WRAPPER_TYPE.indexOf(wrapperType);
		return i == -1 ? null : BASE_DATA_TYPE.get(i);
	}

	/**
	 * 是否是基础数据类型
	 * 
	 * @param type 数据类型字符串
	 * @return <tt>true</tt> 是基础数据类型
	 */
	public static final boolean isBaseDataType(String type) {
		return BASE_DATA_TYPE.contains(type);
	}

	/**
	 * 是否是包装数据类型
	 * 
	 * @param type 类型
	 * @return <tt>true</tt> 是包装数据类型
	 */
	public static final boolean isWrapperType(Class<?> type) {
		return BASE_DATA_WRAPPER_TYPE.contains(type);
	}

}
