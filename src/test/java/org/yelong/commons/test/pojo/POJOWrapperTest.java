/**
 * 
 */
package org.yelong.commons.test.pojo;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.yelong.Student;
import org.yelong.commons.pojo.POJOWrapper;

/**
 *
 */
public class POJOWrapperTest {

	Student student = new Student();
	{
		student.setId("123456");
		student.setCreateTime(new Date());
		student.setName("鵬飛");
		student.setAge(10);
	}

	POJOWrapper<Student> pojo = new POJOWrapper<Student>(student);

	@Test
	public void getValue() throws IllegalAccessException {
		Object value = pojo.getValue("id");
		System.out.println(value);
		Object value1 = pojo.getValue("aAb");
		System.out.println(value1);
		String value2 = pojo.getValue("aAb", "456");
		System.out.println(value2);
	}

	@Test
	public void setValue() throws IllegalAccessException {
		pojo.setValue("id", "asdfdsf");
		Object value = pojo.getValue("id");
		System.out.println(value);
	}

}
