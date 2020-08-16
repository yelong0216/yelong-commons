/**
 * 
 */
package org.yelong.commons.pojo;

import java.util.Objects;

/**
 * POJO包装器
 * 
 * @param <P> POJO type
 */
public class POJOWrapper<P> {

	private final P pojo;

	public POJOWrapper(P pojo) {
		this.pojo = Objects.requireNonNull(pojo);
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
	 * @param fieldName 被获取值的字段名称
	 * @return 对象指定字段名称的值
	 * @throws IllegalArgumentException if {@code target} is {@code null}, or the
	 *                                  field name is blank or empty or could not be
	 *                                  found
	 * @throws IllegalAccessException   if the named field is not made accessible
	 * @see POJOUtils#getValue(Object, String)
	 */
	public <T> T getValue(String fieldName) throws IllegalAccessException {
		return POJOUtils.getValue(pojo, fieldName);
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
	 * @param fieldName    被获取值的字段名称
	 * @param defaultValue 值不存在时返回的默认值
	 * @return 对象指定字段名称的值。如果这个值为<code>null</code>则返回默认值
	 * @throws IllegalArgumentException if {@code target} is {@code null}, or the
	 *                                  field name is blank or empty or could not be
	 *                                  found
	 * @throws IllegalAccessException   if the named field is not made accessible
	 * @see POJOUtils#getValue(Object, String, Object)
	 */
	public <T> T getValue(String fieldName, T defaultValue) throws IllegalAccessException {
		return POJOUtils.getValue(pojo, fieldName, defaultValue);
	}

	/**
	 * 通过以下顺序设置对象字段的值
	 * 
	 * <pre>
	 *  1、对象字段的set方法
	 *  2、反射
	 * </pre>
	 * 
	 * @param fieldName 被设置值的字段名称
	 * @param value     设置的值
	 * @throws IllegalArgumentException if {@code target} is {@code null},
	 *                                  {@code fieldName} is blank or empty or could
	 *                                  not be found, or {@code value} is not
	 *                                  assignable
	 * @throws IllegalAccessException   if the field is not made accessible
	 * @see POJOUtils#setValue(Object, String, Object)
	 */
	public void setValue(String fieldName, Object value) throws IllegalAccessException {
		POJOUtils.setValue(pojo, fieldName, value);
	}

	/**
	 * @return 包装的POJO对象
	 */
	public P getPojo() {
		return pojo;
	}

}
