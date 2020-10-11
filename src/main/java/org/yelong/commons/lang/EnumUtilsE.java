/**
 * 
 */
package org.yelong.commons.lang;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 枚举工具类拓展
 * 
 * @since 2.0
 * @see EnumUtils
 */
public final class EnumUtilsE {

	private EnumUtilsE() {
	}

	/**
	 * 根据枚举的名称获取枚举实例
	 * 
	 * @param <E>       enum type
	 * @param enumClass enum class
	 * @param name      enum name
	 * @return the enum
	 */
	public static <E extends Enum<E>> E valueOf(Class<E> enumClass, String name) {
		if (StringUtils.isBlank(name)) {
			return null;
		}
		E[] enumConstants = enumClass.getEnumConstants();
		for (E e : enumConstants) {
			if (e.name().equals(name)) {
				return e;
			}
		}
		return null;
	}

	/**
	 * 根据唯一性编码获取枚举实例<br/>
	 * 
	 * 该枚举应该实现 {@link Codeable}接口。否则该方法总是返回 <code>null</code> <br/>
	 * 
	 * <pre>
	 * public enum Sex implements Codeable<String> {
	 * 	MAN("01"), GIRL("02");
	 * 
	 * 	public final String CODE;
	 * 
	 * 	private Sex(String code) {
	 * 		this.CODE = code;
	 * 	}
	 * 
	 * 	&#64;Override
	 * 	public String getCode() {
	 * 		return CODE;
	 * 	}
	 * }
	 * 
	 * Sex sex = EnumUtilsE.valueOfByCode(Sex.class, "01");
	 * System.out.println(sex);//MAN
	 * </pre>
	 * 
	 * @param <E>       enum type
	 * @param <T>       code type
	 * @param enumClass enum class
	 * @param code      code value
	 * @return enum
	 */
	@SuppressWarnings("unchecked")
	public static <E extends Enum<E>, T> E valueOfByCode(Class<E> enumClass, T code) {
		if (!Codeable.class.isAssignableFrom(enumClass)) {
			return null;
		}
		E[] enumConstants = enumClass.getEnumConstants();
		for (E e : enumConstants) {
			if (null == e) {
				continue;
			}
			T enumCode = ((Codeable<T>) e).getCode();
			if (code == null && enumCode == null) {
				return e;
			}
			if( null == enumCode ) {
				return null;
			}
			if (enumCode.equals(code)) {
				return e;
			}
		}
		return null;
	}

	/**
	 * 支持唯一标识性的枚举<br/>
	 * 
	 * 枚举实现此接口并提供一个唯一标识的属性值<br/>
	 * 
	 * @param <T> code type
	 * @see EnumUtilsE#valueOfByCode(Class, Object)
	 */
	public static interface Codeable<T> {

		/**
		 * @return 唯一的编码
		 */
		T getCode();

	}

}
