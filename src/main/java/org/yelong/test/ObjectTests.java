/**
 * 
 */
package org.yelong.test;

import java.lang.reflect.Field;
import java.util.function.Consumer;

import org.apache.commons.lang3.reflect.FieldUtils;

/**
 * 对象测试工具类
 * 
 * @since 2.0
 */
public final class ObjectTests {

	private ObjectTests() {
	}

	/**
	 * 通过控制台打印对象所有字段与其值
	 * 
	 * @param obj obj
	 * @see FieldUtils#getAllFields(Class)
	 * @see FieldUtils#readField(Field, Object)
	 */
	public static void printAllField(Object obj) {
		printAllField(obj, System.out::println);
	}

	/**
	 * 通过指定的打印方式，打印对象所有字段与其值
	 * 
	 * @param obj   obj
	 * @param print 打印方式
	 */
	public static void printAllField(Object obj, TestInfoPrint print) {
		print.accept("--------------------------------------------------");
		print.accept("-----obj:" + obj);
		if (null == obj) {
			return;
		}
		Field[] fields = FieldUtils.getAllFields(obj.getClass());
		for (Field field : fields) {
			try {
				Object fieldValue = FieldUtils.readField(field, obj, true);
				print.accept("-----" + field.getName() + ":" + fieldValue);
			} catch (IllegalAccessException e) {
				print.accept("获取字段值异常");
				e.printStackTrace();
			}
		}
		print.accept("--------------------------------------------------");
	}

	/**
	 * 测试信息打印方式
	 */
	@FunctionalInterface
	public static interface TestInfoPrint extends Consumer<String> {

	}

}
