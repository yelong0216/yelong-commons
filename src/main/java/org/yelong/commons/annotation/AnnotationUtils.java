/**
 * 
 */
package org.yelong.commons.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author PengFei
 */
public class AnnotationUtils {

	/**
	 * <pre>
	 * 获取 class 标注的指定类型的注解
	 * 递归：如果 class 不存在该注解，将在 class 的父类中进行查找直至Object类
	 * 注意：如果注解不存在将返回 <code>null</code>
	 * </pre>
	 * 
	 * @param <A>        annotation type
	 * @param c          class
	 * @param annotation 获取的注解类型
	 * @param recursive  是否递归
	 * @see Class#getAnnotation(Class)
	 */
	public static <A extends Annotation> A getAnnotation(Class<?> c, Class<A> annotation, boolean recursive) {
		if (c.isAnnotationPresent(annotation)) {
			return c.getAnnotation(annotation);
		}
		if (!recursive) {
			return null;
		}
		Class<?> superClass = c.getSuperclass();
		while (true) {
			if (superClass == Object.class) {
				return null;
			}
			if (superClass.isAnnotationPresent(annotation)) {
				return superClass.getAnnotation(annotation);
			}
			superClass = superClass.getSuperclass();
		}
	}

	/**
	 * <p>
	 * 获取字段上面的注解
	 * </p>
	 * 
	 * 如果字段未标注该类型的注解则返回 <code>null</code>
	 * 
	 * @param <A>        annotation type
	 * @param field      字段
	 * @param annotation 注解类型
	 * @return 字段存在annotation类型的注解则返回 annotation ，否则返回 <code>null</code>
	 */
	public static <A extends Annotation> A getAnnotation(Field field, Class<A> annotation) {
		if (field.isAnnotationPresent(annotation)) {
			return field.getAnnotation(annotation);
		}
		return null;
	}

}
