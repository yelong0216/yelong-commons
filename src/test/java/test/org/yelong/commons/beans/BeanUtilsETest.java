package test.org.yelong.commons.beans;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;
import org.yelong.commons.beans.BeanUtilsE;

import test.org.yelong.Student;

/**
 * 
 * @see BeanUtilsE
 */
public class BeanUtilsETest {

	private Student student = new Student() {
		{
			setName("123");
		}
	};

	@Test
	public void getProperty_2() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
//		BeanUtilsE.getProperty(null, null);
//		BeanUtilsE.getProperty(student, null);
//		BeanUtilsE.getProperty(student, "name1");
		Object property = BeanUtilsE.getProperty(student, "name");

		System.out.println(property);
	}

	@Test
	public void getProperty_3() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
//		BeanUtilsE.getProperty(null, null, null);
//		BeanUtilsE.getProperty(student, null, null);
//		BeanUtilsE.getProperty(student, "name1", null);
		Object property = BeanUtilsE.getProperty(student, "age", "456");
		System.out.println(property);
	}

	@Test
	public void setProperty_3() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
//		BeanUtilsE.setProperty(null, null, null);
//		BeanUtilsE.setProperty(student, null, null);
//		BeanUtilsE.setProperty(student, "name1", null);
		BeanUtilsE.setProperty(student, "name", null);
		System.out.println(student.getName());
	}

}
