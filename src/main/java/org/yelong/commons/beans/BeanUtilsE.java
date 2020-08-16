/**
 * 
 */
package org.yelong.commons.beans;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * bean 工具类
 * 
 * @see org.apache.commons.beanutils.BeanUtils
 * @since 1.0
 */
public class BeanUtilsE {

	/**
	 * 通过标准的get/is方法获取获取bean属性属性值
	 * 
	 * @param <T> 返回的结果类型
	 * @param bean         被获取值的bean实例
	 * @param propertyName 属性名称
	 * @return 通过bean的get/is方法获取的值
	 * @throws NoSuchMethodException 没有对应的get/is方法
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getProperty(Object bean, String propertyName) throws NoSuchMethodException {
		Objects.requireNonNull(bean);
		Objects.requireNonNull(propertyName);
		try {
			PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, bean.getClass());
			Method readMethod = propertyDescriptor.getReadMethod();
			return (T) readMethod.invoke(bean);
		} catch (Exception e) {
			throw new NoSuchMethodException(bean.getClass() + " not found get or is " + propertyName + " method ");
		}
	}

	/**
	 * 通过标准的get/is方法获取获取bean属性属性值。如果属性值为 <code>null</code> 则返回默认值
	 * 
	 * @param <T> 返回的结果类型
	 * @param bean         被获取值的bean实例
	 * @param propertyName 属性名称
	 * @param defaultValue 属性值为 <code>null</code>时的默认值
	 * @return 通过bean的get/is方法获取的值
	 * @throws NoSuchMethodException 没有对应的get/is方法
	 */
	public static <T> T getProperty(Object bean, String propertyName, T defaultValue) throws NoSuchMethodException {
		T value = getProperty(bean, propertyName);
		return null != value ? value : defaultValue;
	}

	/**
	 * 通过标准的set方法设置bean的属性值
	 * 
	 * @param bean         被设置值的bean实例
	 * @param propertyName 属性名称
	 * @param value        设置的值
	 * @throws NoSuchMethodException 没有对应的set方法
	 */
	public static void setProperty(Object bean, String propertyName, Object value) throws NoSuchMethodException {
		Objects.requireNonNull(bean);
		Objects.requireNonNull(propertyName);
		try {
			PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, bean.getClass());
			Method writeMethod = propertyDescriptor.getWriteMethod();
			writeMethod.invoke(bean, value);
		} catch (Exception e) {
			throw new NoSuchMethodException(bean.getClass() + " not found set " + propertyName + " method ");
		}
	}

}
