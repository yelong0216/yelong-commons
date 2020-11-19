/**
 * 
 */
package org.yelong.commons.lang.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.commons.lang3.AnnotationUtils;
import org.apache.commons.lang3.ClassUtils;
import org.yelong.commons.support.Entry;

/**
 * 注解工具类拓展
 * 
 * @see AnnotationUtils
 * @since 2.0
 */
public final class AnnotationUtilsE {

	private AnnotationUtilsE() {
	}

	/**
	 * <pre>
	 * 获取class标注的指定类型的注解
	 * 父类递归：如果class不存在该注解，将在class的父类中进行查找直到Object类
	 * 如果注解不存在返回 <code>null</code>
	 * </pre>
	 * 
	 * @param <A>                 annotation type
	 * @param cls                 需要获取注解的类型
	 * @param annotationClass     获取的注解类型
	 * @param superClassRecursive 是否递归父类
	 * @return the annotation
	 * @see Class#getAnnotation(Class)
	 * @see ClassUtils#getAllSuperclasses(Class)
	 */
	public static <A extends Annotation> A getAnnotation(Class<?> cls, Class<A> annotationClass,
			boolean superClassRecursive) {
		return getAnnotation(cls, annotationClass, superClassRecursive, false);
	}

	/**
	 * <pre>
	 * 获取class标注的指定类型的注解
	 * 父类递归：如果class不存在该注解，将在class的父类中进行查找直到Object类
	 * 接口递归：如果父类不需要递归或者递归父类后仍未找到指定类型注解则从所实现的所有接口上寻找
	 * 如果注解不存在返回 <code>null</code>
	 * </pre>
	 * 
	 * @param <A>                 annotation type
	 * @param cls                 需要获取注解的类型
	 * @param annotationClass     获取的注解类型
	 * @param superClassRecursive 是否递归父类
	 * @param interfacesRecursive 是否递归实现的所有接口，获取顺序在父类下面
	 * @return the annotation
	 * @see Class#getAnnotation(Class)
	 * @see ClassUtils#getAllSuperclasses(Class)
	 * @see ClassUtils#getAllInterfaces(Class)
	 */
	public static <A extends Annotation> A getAnnotation(Class<?> cls, Class<A> annotationClass,
			boolean superClassRecursive, boolean interfacesRecursive) {
		return getAnnotation(cls, annotationClass, superClassRecursive, interfacesRecursive, 0);
	}

	/**
	 * <pre>
	 * 获取class标注的指定类型的注解
	 * 如果class不存在该注解则从以下规则中查找
	 * 父类递归：将在class的父类中进行查找直到Object类
	 * 接口递归：从所实现的所有接口上寻找
	 * 顺序：superClassAndInterfacesOrder >= 0 父类优先。否则接口优先
	 * 如果注解不存在返回 <code>null</code>
	 * </pre>
	 * 
	 * @param <A>                          annotation type
	 * @param cls                          需要获取注解的类型
	 * @param annotationClass              获取的注解类型
	 * @param superClassRecursive          是否递归父类
	 * @param interfacesRecursive          是否递归实现的所有接口，获取顺序在父类下面
	 * @param superClassAndInterfacesOrder 递归父类和接口的顺序。 大于等于0 则接口在后否则在前
	 * @return the annotation
	 * @see Class#getAnnotation(Class)
	 * @see ClassUtils#getAllSuperclasses(Class)
	 * @see ClassUtils#getAllInterfaces(Class)
	 */
	public static <A extends Annotation> A getAnnotation(Class<?> cls, Class<A> annotationClass,
			boolean superClassRecursive, boolean interfacesRecursive, int superClassAndInterfacesOrder) {
		if (cls.isAnnotationPresent(annotationClass)) {
			return cls.getAnnotation(annotationClass);
		}
		ArrayList<Class<?>> classes = new ArrayList<>();
		if (superClassRecursive) {
			classes.addAll(ClassUtils.getAllSuperclasses(cls));
		}
		if (interfacesRecursive) {
			if (superClassAndInterfacesOrder >= 0) {
				classes.addAll(ClassUtils.getAllInterfaces(cls));
			} else {
				classes.addAll(0, ClassUtils.getAllInterfaces(cls));
			}
		}
		if (classes.isEmpty()) {
			return null;
		}
		for (Class<?> clazz : classes) {
			if (clazz.isAnnotationPresent(annotationClass)) {
				return clazz.getAnnotation(annotationClass);
			}
		}
		return null;
	}

	/**
	 * <pre>
	 * 获取class标注的指定类型的注解
	 * 父类递归：如果class不存在该注解，将在class的父类中进行查找直至Object类
	 * 如果注解不存在返回 <code>null</code>
	 * </pre>
	 * 
	 * @param <A>                 annotation type
	 * @param cls                 需要获取注解的类型
	 * @param annotationClass     获取的注解类型
	 * @param superClassRecursive 是否递归父类
	 * @return 标注注解的类与注解对象的 {@link Entry}
	 * @see Class#getAnnotation(Class)
	 * @see ClassUtils#getAllSuperclasses(Class)
	 */
	public static <A extends Annotation> Entry<Class<?>, A> getAnnotationEntry(Class<?> cls, Class<A> annotationClass,
			boolean superClassRecursive) {
		return getAnnotationEntry(cls, annotationClass, superClassRecursive, false);
	}

	/**
	 * <pre>
	 * 获取class标注的指定类型的注解
	 * 父类递归：如果class不存在该注解，将在class的父类中进行查找直至Object类
	 * 接口递归：如果父类不需要递归或者递归父类后仍未找到指定类型注解则从所实现的所有接口上寻找
	 * 如果注解不存在返回 <code>null</code>
	 * </pre>
	 * 
	 * @param <A>                 annotation type
	 * @param cls                 需要获取注解的类型
	 * @param annotationClass     获取的注解类型
	 * @param superClassRecursive 是否递归父类
	 * @param interfacesRecursive 是否递归实现的所有接口，获取顺序在父类下面
	 * @return 标注注解的类与注解对象的 {@link Entry}
	 * @see Class#getAnnotation(Class)
	 * @see ClassUtils#getAllSuperclasses(Class)
	 * @see ClassUtils#getAllInterfaces(Class)
	 */
	public static <A extends Annotation> Entry<Class<?>, A> getAnnotationEntry(Class<?> cls, Class<A> annotationClass,
			boolean superClassRecursive, boolean interfacesRecursive) {
		return getAnnotationEntry(cls, annotationClass, superClassRecursive, interfacesRecursive, 0);
	}

	/**
	 * <pre>
	 * 获取 class 标注的指定类型的注解
	 * 如果 class 不存在该注解则从以下规则中查找
	 * 父类递归：将在 class 的父类中进行查找直至Object类
	 * 接口递归：从所实现的所有接口上寻找
	 * 顺序：superClassAndInterfacesOrder >= 0 父类优先。否则接口优先 
	 * 如果注解不存在返回 <code>null</code>
	 * </pre>
	 * 
	 * @param <A>                          annotation type
	 * @param cls                          需要获取注解的类型
	 * @param annotationClass              获取的注解类型
	 * @param superClassRecursive          是否递归父类
	 * @param interfacesRecursive          是否递归实现的所有接口，获取顺序在父类下面
	 * @param superClassAndInterfacesOrder 递归父类和接口的顺序。 大于等于0 则接口在后否则在前
	 * @return 标注注解的类与注解对象的 {@link Entry}
	 * @see Class#getAnnotation(Class)
	 * @see ClassUtils#getAllSuperclasses(Class)
	 * @see ClassUtils#getAllInterfaces(Class)
	 */
	public static <A extends Annotation> Entry<Class<?>, A> getAnnotationEntry(Class<?> cls, Class<A> annotationClass,
			boolean superClassRecursive, boolean interfacesRecursive, int superClassAndInterfacesOrder) {
		if (cls.isAnnotationPresent(annotationClass)) {
			return new Entry<>(cls, cls.getAnnotation(annotationClass));
		}
		ArrayList<Class<?>> classes = new ArrayList<>();
		if (superClassRecursive) {
			classes.addAll(ClassUtils.getAllSuperclasses(cls));
		}
		if (interfacesRecursive) {
			if (superClassAndInterfacesOrder >= 0) {
				classes.addAll(ClassUtils.getAllInterfaces(cls));
			} else {
				classes.addAll(0, ClassUtils.getAllInterfaces(cls));
			}
		}
		if (classes.isEmpty()) {
			return null;
		}
		for (Class<?> clazz : classes) {
			if (clazz.isAnnotationPresent(annotationClass)) {
				return new Entry<>(clazz, clazz.getAnnotation(annotationClass));
			}
		}
		return null;
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

	/**
	 * <p>
	 * 获取方法上面的注解
	 * </p>
	 * 
	 * 如果方法未标注该类型的注解则返回 <code>null</code>
	 * 
	 * @param <A>        annotation type
	 * @param method     方法
	 * @param annotation 注解类型
	 * @return 字段存在annotation类型的注解则返回 annotation ，否则返回 <code>null</code>
	 * @since 2.2
	 */
	public static <A extends Annotation> A getAnnotation(Method method, Class<A> annotation) {
		if (method.isAnnotationPresent(annotation)) {
			return method.getAnnotation(annotation);
		}
		return null;
	}

}
