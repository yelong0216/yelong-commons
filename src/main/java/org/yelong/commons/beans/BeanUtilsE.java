/**
 * 
 */
package org.yelong.commons.beans;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * bean 工具类
 * 
 * @author PengFei
 * @see org.apache.commons.beanutils.BeanUtils
 */
public class BeanUtilsE {

	/**
	 * 获取bean属性propertyName的值。
	 * 通过标准的get/is方法获取
	 * 
	 * @param bean 被获取值的bean实例
	 * @param propertyName 属性名称
	 * @return 通过bean的get/is方法获取的值
	 * @throws NoSuchMethodException 没有对应的get/is方法
	 */
	public static Object getProperty(Object bean , String propertyName) throws NoSuchMethodException {
		try {
			PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, bean.getClass());
			Method readMethod = propertyDescriptor.getReadMethod();
			return readMethod.invoke(bean);
		} catch (Exception e) {
			throw new NoSuchMethodException(bean.getClass() + " not found get or is " + propertyName + " method ");
		}
	}

	/**
	 * 设置bean属性propertyName的值。
	 * 通过标准的set方法设置值
	 * 
	 * @param bean 被设置值的bean实例
	 * @param propertyName 属性名称
	 * @param value 需要设置的值
	 * @throws NoSuchMethodException 没有对应的set方法
	 */
	public static void setProperty(Object bean , String propertyName , Object value) throws NoSuchMethodException {
		try {
			PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, bean.getClass());
			Method writeMethod = propertyDescriptor.getWriteMethod();
			writeMethod.invoke(bean,value);
		} catch (Exception e) {
			throw new NoSuchMethodException(bean.getClass() + " not found set " + propertyName + " method ");
		}
	}

}
