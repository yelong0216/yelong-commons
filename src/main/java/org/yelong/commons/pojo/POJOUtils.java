/**
 * 
 */
package org.yelong.commons.pojo;

import java.util.Objects;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.yelong.commons.beans.BeanUtilsE;

/**
 * POJO工具类
 * 
 * @since 2.0
 */
public final class POJOUtils {

	private POJOUtils() {
	}

	/**
	 * 通过以下顺序获取对象字段的值
	 * 
	 * <pre>
	 *  1、对象字段的get/is方法
	 *  2、反射
	 * </pre>
	 * 
	 * @param <T>       返回值的类型
	 * @param obj       需要获取值的对象
	 * @param fieldName 被获取值的字段名称
	 * @return 对象指定字段名称的值
	 * @throws IllegalArgumentException if {@code target} is {@code null}, or the
	 *                                  field name is blank or empty or could not be
	 *                                  found
	 * @throws IllegalAccessException   if the named field is not made accessible
	 * @see BeanUtilsE#getProperty(Object, String)
	 * @see FieldUtils#readField(java.lang.reflect.Field, Object, boolean)
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getValue(Object obj, String fieldName) throws IllegalAccessException {
		Objects.requireNonNull(obj);
		Objects.requireNonNull(fieldName);
		try {
			return (T) BeanUtilsE.getProperty(obj, fieldName);
		} catch (NoSuchMethodException e) {
			return (T) FieldUtils.readField(obj, fieldName, true);
		}
	}

	/**
	 * 通过以下顺序获取对象字段的值。如果值为<code>null</code>时则返回默认值
	 * 
	 * <pre>
	 *  1、对象字段的get/is方法
	 *  2、反射
	 * </pre>
	 * 
	 * @param <T>          返回值的类型
	 * @param obj          需要获取值的对象
	 * @param fieldName    被获取值的字段名称
	 * @param defaultValue 值不存在时返回的默认值
	 * @return 对象指定字段名称的值。如果这个值为<code>null</code>则返回默认值
	 * @throws IllegalArgumentException if {@code target} is {@code null}, or the
	 *                                  field name is blank or empty or could not be
	 *                                  found
	 * @throws IllegalAccessException   if the named field is not made accessible
	 * @see POJOUtils#getValue(Object, String)
	 */
	public static <T> T getValue(Object obj, String fieldName, T defaultValue) throws IllegalAccessException {
		T value = getValue(obj, fieldName);
		return value != null ? value : defaultValue;
	}

	/**
	 * 通过以下顺序设置对象字段的值
	 * 
	 * <pre>
	 *  1、对象字段的set方法
	 *  2、反射
	 * </pre>
	 * 
	 * @param obj       需要设置值的对象
	 * @param fieldName 被设置值的字段名称
	 * @param value     设置的值
	 * @throws IllegalArgumentException if {@code target} is {@code null},
	 *                                  {@code fieldName} is blank or empty or could
	 *                                  not be found, or {@code value} is not
	 *                                  assignable
	 * @throws IllegalAccessException   if the field is not made accessible
	 * @see BeanUtilsE#setProperty(Object, String, Object)
	 * @see FieldUtils#writeField(java.lang.reflect.Field, Object, Object, boolean)
	 */
	public static void setValue(Object obj, String fieldName, Object value) throws IllegalAccessException {
		Objects.requireNonNull(obj);
		Objects.requireNonNull(fieldName);
		try {
			BeanUtilsE.setProperty(obj, fieldName, value);
		} catch (NoSuchMethodException e) {
			FieldUtils.writeField(obj, fieldName, value, true);
		}
	}

}
