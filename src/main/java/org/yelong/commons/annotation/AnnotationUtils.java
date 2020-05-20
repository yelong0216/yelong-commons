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
	 * 获取c 类标注的注解 如果recursive 为 true 将进行递归获取annotation注解
	 * 递归：如果c类不存在annotation注解，将在c的父类中进行查找直至Object类
	 * 注意：此方法不会抛出注解存在异常，如果注解不存在将返回 null
	 * @param <A>
	 * @param c class
	 * @param annotation 获取的注解类型
	 * @param recursive 是否递归
	 */
	public static <A extends Annotation> A getAnnotation(Class<?> c , Class<A> annotation , boolean recursive){
		if( c.isAnnotationPresent(annotation) ) {
			return c.getAnnotation(annotation);
		}
		if(!recursive) {
			return null;
		}
		Class<?> superClass = c.getSuperclass();
		while(true) {
			if( superClass == Object.class ) {
				return null;
			}
			if( superClass.isAnnotationPresent(annotation) ) {
				return superClass.getAnnotation(annotation);
			}
			superClass = superClass.getSuperclass();
		}
	}
	
	/**
	 * 获取字段上面的注解
	 * 如果字段上面不存在该注解类型则返回 <code>null</code>
	 * @param <A>
	 * @param field 字段
	 * @param annotation 注解类型
	 * @return 字段存在annotation类型的注解则返回 annotation ，否则返回 <code>null</code>
	 */
	public static <A extends Annotation> A getAnnotation(Field field , Class<A> annotation) {
		if(field.isAnnotationPresent(annotation)) {
			return field.getAnnotation(annotation);
		}
		return null;
	}
	
	
}
