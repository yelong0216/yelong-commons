/**
 * 
 */
package org.yelong.commons.util.map;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.yelong.commons.beans.BeanUtilsE;

/**
 * map bean 之间的互相转换
 * 
 * @author PengFei
 * @since 1.0.2
 */
public class MapBeanConverter {

	/**
	 * <pre>
	 * 将Bean中所有的字段在map中进行获取并赋值
	 * 注意：
	 * 		1、bean在设置值时使用set方法设置。不使用反射
	 * </pre>
	 * 
	 * @param <T>       bean type
	 * @param map       map
	 * @param beanClass 被转换后的bean的类
	 * @return 赋值后的bean
	 * @throws InstantiationException bean 实例化异常
	 * @throws IllegalAccessException bean 实例化异常
	 */
	public <T> T mapConvertBean(Map<String, Object> map, Class<T> beanClass)
			throws InstantiationException, IllegalAccessException {
		return mapConvertBean(map, beanClass.newInstance());
	}

	/**
	 * <pre>
	 * 将Bean中所有的字段在map中进行获取并赋值 
	 * 注意：
	 * 		1、bean在设置值时使用set方法设置。不使用反射
	 * </pre>
	 * 
	 * @param <T>         bean type
	 * @param map         map
	 * @param beanFactory bean factory 被映射的bean
	 * @return 赋值后的bean
	 */
	public <T> T mapConvertBean(Map<String, Object> map, Supplier<T> beanFactory) {
		return mapConvertBean(map, beanFactory.get());
	}

	/**
	 * <pre>
	 * 将Bean中所有的字段在map中进行获取并赋值 
	 * 注意：
	 * 		1、bean在设置值时使用set方法设置。不使用反射
	 * </pre>
	 * 
	 * @param <T>  bean type
	 * @param map  map
	 * @param bean bean
	 * @return 赋值后的bean
	 */
	public <T> T mapConvertBean(Map<String, Object> map, T bean) {
		List<Field> fields = FieldUtils.getAllFieldsList(bean.getClass());
		for (Field field : fields) {
			String propertyName = field.getName();
			Object value = map.get(propertyName);
			if (null != value) {
				try {
					BeanUtilsE.setProperty(bean, propertyName, value);
				} catch (NoSuchMethodException e) {
					// 对于标准方法设置不了的将不进行设置值
				}
			}
		}
		return bean;
	}

	/**
	 * <pre>
	 * 将bean中所有的字段与值设置到map中
	 * 注意：
	 * 		1、取值通过标准的get/is方法取值。不使用反射
	 * </pre>
	 * 
	 * @param bean 需要映射为map的bean
	 * @return 映射后的map
	 */
	public Map<String, Object> beanConvertMap(Object bean) {
		return beanConvertMap(bean, HashMap::new);
	}

	/**
	 * <pre>
	 * 将bean中所有的字段与值设置到map中
	 * 注意：
	 * 		1、取值通过标准的get/is方法取值。不使用反射
	 * </pre>
	 * 
	 * @param <M>        map type
	 * @param bean       需要映射为map的bean
	 * @param mapFactory map factory
	 * @return 映射后的map
	 */
	public <M extends Map<String, Object>> M beanConvertMap(Object bean, Supplier<M> mapFactory) {
		M map = mapFactory.get();
		List<Field> fields = FieldUtils.getAllFieldsList(bean.getClass());
		for (Field field : fields) {
			String propertyName = field.getName();
			Object value = null;
			try {
				value = BeanUtilsE.getProperty(bean, propertyName);
			} catch (NoSuchMethodException e) {
				// 对于标准方法取不到的默认为null
			} finally {
				map.put(propertyName, value);
			}
		}
		return map;
	}

}
